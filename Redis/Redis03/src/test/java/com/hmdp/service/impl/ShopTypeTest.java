package com.hmdp.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.assist.ISqlRunner;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hmdp.dto.Result;
import com.hmdp.entity.ShopType;
import com.hmdp.mapper.ShopTypeMapper;
import com.hmdp.service.IShopTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.*;

import static com.hmdp.utils.RedisConstants.CACHE_SHOP_TYPE_KEY;

/**
 * @author George
 * @description
 * @date 2025/8/20 18:33
 */
@SpringBootTest
public class ShopTypeTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private IShopTypeService typeService;

    @Test
    public void queryAll() {
        // 1. 从Redis查询缓存（直接存储整个List的JSON）
        String key = CACHE_SHOP_TYPE_KEY;
        String cachedJson = stringRedisTemplate.opsForValue().get(key);

        if (StrUtil.isNotBlank(cachedJson)) {
            List<ShopType> typeList = JSONUtil.toList(JSONUtil.parseArray(cachedJson), ShopType.class);
            System.out.println(typeList);
            return ;
        }

        // 2. 缓存不存在，查询数据库
        List<ShopType> typeList = typeService.query().orderByAsc("sort").list();
        if (CollUtil.isEmpty(typeList)) {
            return ;
        }

        // 3. 序列化并存储整个List到Redis
        String jsonStr = JSONUtil.toJsonStr(typeList);
        stringRedisTemplate.opsForValue().set(key, jsonStr, Duration.ofMinutes(2));

        System.out.println(typeList);
    }
}
