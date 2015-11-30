package de.phantasien.sudoku.redis;

import de.phantasien.sudoku.model.Game;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author Jennifer Schulz, jennykroete.gmx.de
 */
@Configuration
public class RedisConfig {


    @Bean(name="redisTemplate")
    public RedisTemplate<String, Game> redisTemplate() throws Exception {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    @Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory cf = new JedisConnectionFactory();
        cf.setHostName("localhost");
        cf.setPort(6379);
        return cf;
    }

}
