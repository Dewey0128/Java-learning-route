package com.george.springboot.mergeconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MergeConfig {
    @Value("${spring.datasource.username}")
    private String mysqlUsername;

    @Value("${spring.datasource.password}")
    private String mysqlPassword;

    @Value("${spring.data.redis.host}")
    private String redisHost;

    @Value("${spring.data.redis.port}")
    private String redisPort;


    public MergeConfig() {
    }

    public MergeConfig(String mysqlUsername, String mysqlPassword, String redisHost, String redisPort) {
        this.mysqlUsername = mysqlUsername;
        this.mysqlPassword = mysqlPassword;
        this.redisHost = redisHost;
        this.redisPort = redisPort;
    }


    public String toString() {
        return "Merge config: {mysqlUsername = " + mysqlUsername + ", mysqlPassword = " + mysqlPassword + ", redisHost = " + redisHost + ", redisPort = " + redisPort + "}";
    }

}

