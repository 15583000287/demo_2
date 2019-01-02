package cn.tedu.demo_1.config.redis;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * cache配置类
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

}
