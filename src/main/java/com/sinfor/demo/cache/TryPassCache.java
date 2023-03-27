package com.sinfor.demo.cache;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * @author fengwen
 * @date 2022/5/9
 * @description TODO
 **/
@Component
public class TryPassCache {

    @Resource
    private RedisTemplate<String, Integer> redisTemplate;

    private static String TRY_COUNT = "tryPassCount::%s";


    public Integer findTryPassCount(String userId) {
        String key = String.format(TRY_COUNT, userId);
        Integer count = redisTemplate.opsForValue().get(key);
        if (count == null) {
            return 0;
        }
        return count;
    }

    public void count(String userId) {
        String key = String.format(TRY_COUNT, userId);
        Integer userCount = findTryPassCount(userId);
        redisTemplate.opsForValue().set(key, userCount + 1, Duration.ofMinutes(3));
    }

}
