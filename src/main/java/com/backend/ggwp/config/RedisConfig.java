package com.backend.ggwp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair.fromSerializer;

@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String redisHost;
    @Value("${spring.redis.port}")
    private int redisPort;
    public static final String CACHE_KEY_ROTATION = "ROTATION";

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(redisHost, redisPort);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
        stringRedisTemplate.setValueSerializer(new StringRedisSerializer());
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory());
        return stringRedisTemplate;
    }

    /*
     Redis Cache 적용을 위한 RedisCacheManager 설정
    */
    @Bean(name = "redisCacheManager")
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(defaultConf())
                .withInitialCacheConfigurations(confMap())
                .build();
    }

    // 기본 TTL : 1분
    private RedisCacheConfiguration defaultConf() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(fromSerializer(new GenericJackson2JsonRedisSerializer()))
                .entryTtl(Duration.ofMinutes(1));
    }

    // ROTATION 관련 TTL : 1H
    private Map<String, RedisCacheConfiguration> confMap() {
        Map<String, RedisCacheConfiguration> cacheConfigurations = new HashMap<>();
        cacheConfigurations.put(CACHE_KEY_ROTATION, defaultConf().entryTtl(Duration.ofHours(1L)));
        return cacheConfigurations;
    }
}
