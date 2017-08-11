package org.glenlivet.sakura.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

@Configuration
public class RedisAtomicBeansConfig {

    @Bean(name="productIdGenerator")
    public RedisAtomicLong productIdGenerator(RedisConnectionFactory connectionFactory) {
         return new RedisAtomicLong("sakura:id-generators:product", connectionFactory);
    }
}
