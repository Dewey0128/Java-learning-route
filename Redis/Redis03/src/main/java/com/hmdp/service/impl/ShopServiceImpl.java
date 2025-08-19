package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.hmdp.dto.Result;
import com.hmdp.entity.Shop;
import com.hmdp.mapper.ShopMapper;
import com.hmdp.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryById(Long id) {

        // 1.从redis查询商铺缓存
        Map<Object, Object> shopMap = stringRedisTemplate.opsForHash().entries(id.toString());

        // 2.判断是否存在
        if( !shopMap.isEmpty()){
            // 3. 存在，直接返回
            Shop shop = BeanUtil.fillBeanWithMap(shopMap, new Shop(), false);
            return Result.ok(shop);
        }

        // 4. 不存在，根据id查询数据库
        Shop shop = query().getBaseMapper().selectById(id);
        // 5. 不存在，返回结果
        if (shop == null){
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
        stringRedisTemplate.opsForHash().putAll(id.toString(), map);

        // 7. 返回
        return Result.ok(map);
    }
}
