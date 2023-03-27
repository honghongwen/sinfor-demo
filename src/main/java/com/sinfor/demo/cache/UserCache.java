package com.sinfor.demo.cache;

import com.sinfor.demo.mapper.TsUserMapper;
import com.sinfor.demo.session.XfUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fengwen
 * @date 2022/5/9
 * @description TODO
 **/
@Slf4j
@Service
public class UserCache {

    @Resource
    private TsUserMapper userMapper;

    /**
     * 将结果缓存，当参数相同时，不会执行方法，从缓存中取
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#id", value = "user", unless = "#result == null")
    public XfUser findUserById(String id) {
        log.info("======db查询user=====");
        XfUser user = userMapper.loadXfUserByUserId(id);
        return user;
    }

    /**
     * 将结果缓存，并且该方法不管缓存是否存在，每次都会执行
     *
     * @param user
     * @return
     */
    @CachePut(key = "#user.id", value = "user")
    public XfUser update(XfUser user) {
        return user;
    }

    /**
     * 移除缓存，根据指定key
     *
     * @param id
     */
    @CacheEvict(value = "user")
    public void deleteById(String id) {
    }

}