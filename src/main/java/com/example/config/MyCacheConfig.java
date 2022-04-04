package com.example.config;

import com.example.domain.book;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
@EnableAutoConfiguration
public class MyCacheConfig {
    @Bean
    public RedisTemplate<Object, book> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object, book> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<book> ser = new Jackson2JsonRedisSerializer<>(book.class);
        template.setDefaultSerializer(ser);
        return template;
    }
}