package de.phantasien.sudoku.redis;

import de.phantasien.sudoku.model.Game;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.data.redis.support.collections.DefaultRedisList;
import org.springframework.data.redis.support.collections.RedisList;
import org.springframework.stereotype.Repository;

/**
 * @author jschulz
 */
@Repository
public class GamesQueue {

    private final RedisTemplate<String, Game> redisTemplate;

    private final ValueOperations<String, Game> valueOperations;

    private final RedisAtomicLong gameIdCounter;

    private final RedisList<Game> games;

    @Inject
    public GamesQueue(RedisTemplate<String, Game> template) {
        this.redisTemplate = template;
        valueOperations = redisTemplate.opsForValue();

        games = new DefaultRedisList<>("games", redisTemplate);
        gameIdCounter = new RedisAtomicLong("global:gid", redisTemplate.getConnectionFactory());
    }

    public String addGame(final Game game) {
        String gid = String.valueOf(gameIdCounter.incrementAndGet());

        valueOperations.set(gid, game, 30, TimeUnit.DAYS);

        games.addFirst(game);
        return gid;
    }

    public Game getGameById(final String gid) {

        return valueOperations.get(gid);
    }

    public Game updateGame(final Game game, final String gid) {

        return valueOperations.getAndSet(gid, game);
    }

}
