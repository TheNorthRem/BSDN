package com.bupt.bsdn.config;

import com.bupt.bsdn.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * Redis配置
 */
@Configuration
@EnableCaching
@Slf4j
public class RedisConfig {
    @Bean(name = "jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //控制一个pool可分配多少个jedis实例
        jedisPoolConfig.setMaxTotal(500);
        //最大空闲数
        jedisPoolConfig.setMaxIdle(200);
        //每次释放连接的最大数目，默认是3
        jedisPoolConfig.setNumTestsPerEvictionRun(1024);
        //逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
        jedisPoolConfig.setTimeBetweenEvictionRuns(Duration.ofMillis(30000));
        //连接的最小空闲时间 默认1800000毫秒(30分钟)
        jedisPoolConfig.setMinEvictableIdleTime(Duration.ofMillis(1800000));
        jedisPoolConfig.setSoftMinEvictableIdleTime(Duration.ofMillis(10000));
        //最大建立连接等待时间。如果超过此时间将接到异常。设为-1表示无限制。
        jedisPoolConfig.setMaxWait(Duration.ofMillis(1500));
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPoolConfig.setTestOnReturn(false);
        jedisPoolConfig.setJmxEnabled(true);
        jedisPoolConfig.setBlockWhenExhausted(false);
        return jedisPoolConfig;
    }

    @Bean("connectionFactory")
    public JedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("82.157.75.213");
        redisStandaloneConfiguration.setDatabase(0);
        redisStandaloneConfiguration.setPassword(RedisPassword.of("yy123456!"));
        redisStandaloneConfiguration.setPort(6379);
        //获得默认的连接池构造器
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jedisPoolingClientConfigurationBuilder =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        jedisPoolingClientConfigurationBuilder.poolConfig(jedisPoolConfig());
        //通过构造器来构造jedis客户端配置
        JedisClientConfiguration jedisClientConfiguration = jedisPoolingClientConfigurationBuilder.build();
        //单机配置 + 客户端配置 = jedis连接工厂
        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(JedisConnectionFactory connectionFactory) {
        log.info("Redis init");
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        //初始化参数和初始化工作
        redisTemplate.afterPropertiesSet();
        log.info("Redis init success");
        System.out.println("""
        \u001B[31m
                                _._
                           _.-``__ ''-._
                      _.-``    `.  `_.  ''-._           Redis
                  .-`` .-```.  ```\\/    _.,_ ''-._
                 (    '      ,       .-`  | `,    )     Running in standalone mode
                 |`-._`-...-` __...-.``-._|'` _.-'|
                 |    `-._   `._    /     _.-'    |
                  `-._    `-._  `-./  _.-'    _.-'
                 |`-._`-._    `-.__.-'    _.-'_.-'|
                 |    `-._`-._        _.-'_.-'    |           http://redis.io
                  `-._    `-._`-.__.-'_.-'    _.-'
                 |`-._`-._    `-.__.-'    _.-'_.-'|
                 |    `-._`-._        _.-'_.-'    |
                  `-._    `-._`-.__.-'_.-'    _.-'
                      `-._    `-.__.-'    _.-'
                          `-._        _.-'
                              `-.__.-'\u001B[0m
                """);
        log.info("Redis information: \n" +
                "host: " + Utils.getParamSettings("spring.data.redis.host") + "\n" +
                "port: " + Utils.getParamSettings("spring.data.redis.port"));
        return redisTemplate;
    }
}