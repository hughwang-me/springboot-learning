package www.hughwang.me.springbootlearning.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author hughwang
 * @date 2017/12/4 17:06
 */
@Configuration
public class RedisConfiguration {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Bean
    public CacheManager cacheManager() {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return cacheManager;
    }

}
