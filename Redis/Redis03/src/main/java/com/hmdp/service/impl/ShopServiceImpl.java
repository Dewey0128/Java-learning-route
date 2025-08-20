package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.hmdp.dto.Result;
import com.hmdp.entity.Shop;
import com.hmdp.mapper.ShopMapper;
import com.hmdp.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.hmdp.utils.RedisConstants.CACHE_NULL_TTL;
import static com.hmdp.utils.RedisConstants.CACHE_SHOP_KEY;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Slf4j
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryById(Long id) {

        // 存储空标记
        Map<String, Object> emptyMarker = new HashMap<>();
        emptyMarker.put("empty", "true");

        // 1.从redis查询商铺缓存
        Map<Object, Object> shopMap = stringRedisTemplate.opsForHash().entries(CACHE_SHOP_KEY + id.toString());

        // 2.判断是否存在
        if(!shopMap.isEmpty()){
            // 3. 存在
            // 3.1 存在但是 是空map 返回 Result.fail("")
            if (shopMap.containsKey("empty")) {
                log.debug("非初次访问不存在id:{}", id);
                return Result.fail("商铺不存在");
            }
            // 3.2 存在且不是空map 返回商铺信息
            log.debug("在redis中获取id:{}的商铺信息", id);
            Shop shop = BeanUtil.fillBeanWithMap(shopMap, new Shop(), false);
            return Result.ok(shop);
        }

        // 4. 不存在，根据id查询数据库
        Shop shop = query().getBaseMapper().selectById(id);
        // 5. 不存在，返回结果
        if (shop == null){
            log.debug("数据库中不存在id：{}，将空值写入redis, 防止缓存穿透", id);
            // 将空值写入redis, 防止缓存穿透
            stringRedisTemplate.opsForHash().putAll(CACHE_SHOP_KEY + id, emptyMarker);
            // 空值不应该保存过长时间
            stringRedisTemplate.expire(CACHE_SHOP_KEY + id, Duration.ofMinutes(CACHE_NULL_TTL));
            return Result.fail("商铺不存在");
        }
        // 6. 存在，写入redis
        // 6.1 Shop 转为 HashMap（修复空指针问题）
        Map<String, Object> map = BeanUtil.beanToMap(shop, new HashMap<>(), CopyOptions.create()
                .setIgnoreNullValue(true)
                // 先判断fieldValue是否为null，再调用toString()
                .setFieldValueEditor((fieldName, fieldValue) ->
                        fieldValue != null ? fieldValue.toString() : null)
        );
        // 6.2 存入redis
        stringRedisTemplate.opsForHash().putAll(CACHE_SHOP_KEY + id, map);
        stringRedisTemplate.expire(CACHE_SHOP_KEY + id, Duration.ofMinutes(10));
        log.debug("数据库中存在id：{}，将值已经写入redis中", id);
        // 7. 返回
        return Result.ok(map);
    }

    @Override
    @Transactional
    public Result update(Shop shop) {

        Long id = shop.getId();

        if(id == null){
            //id不能为空
            log.debug("传入商铺id为空！");
            return Result.fail("传入商铺id为空！");
        }

        // 更新数据库
        updateById(shop);

        // 删除缓存
        stringRedisTemplate.delete(CACHE_SHOP_KEY + shop.getId());
        log.debug("更新数据库，删除缓存~~~");
        return Result.ok();
    }
}
