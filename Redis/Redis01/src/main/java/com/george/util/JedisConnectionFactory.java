package com.george.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @author George
 * @description 创建Jedis连接工厂
 * @date 2025/8/17 18:07
 */
public class JedisConnectionFactory {
    private static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(8);
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMinIdle(0);
        jedisPoolConfig.setMaxWait(Duration.ofMillis(1000));

        jedisPool = new JedisPool(jedisPoolConfig,
                "117.72.64.21", 6379, 1000, "@Poole0128");
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
