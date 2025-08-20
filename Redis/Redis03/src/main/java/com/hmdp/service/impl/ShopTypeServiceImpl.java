package com.hmdp.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.ShopType;
import com.hmdp.mapper.ShopTypeMapper;
import com.hmdp.service.IShopTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.List;

import static com.hmdp.utils.RedisConstants.CACHE_SHOP_TYPE_KEY;

@Slf4j
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryAll() {
        // 1. 从Redis查询缓存
        String cachedJson = stringRedisTemplate.opsForValue().get(CACHE_SHOP_TYPE_KEY);

        // 2. 判断是否存在
        if (StrUtil.isNotBlank(cachedJson)) {
            // 2.1 存在直接返回
            List<ShopType> typeList = JSONUtil.toList(JSONUtil.parseArray(cachedJson), ShopType.class);
            log.debug("在Redis中查到数据：{}", typeList);
            return Result.ok(typeList);
        }

        // 2.2 缓存不存在，查询数据库
        List<ShopType> typeList = query().orderByAsc("sort").list();
        log.debug("在MySQL中查到数据：{}", typeList);
        if (CollUtil.isEmpty(typeList)) {
            return Result.fail("商铺种类为空！");
        }

        // 3. 序列化并存储整个List到Redis
        String jsonStr = JSONUtil.toJsonStr(typeList);
        stringRedisTemplate.opsForValue().set(CACHE_SHOP_TYPE_KEY, jsonStr, Duration.ofMinutes(2));

        return Result.ok(typeList);
    }
}