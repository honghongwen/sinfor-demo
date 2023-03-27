package com.sinfor.demo.service.impl;

import com.sinfor.demo.cache.TryPassCache;
import com.sinfor.demo.cache.UserCache;
import com.sinfor.demo.param.LoginParam;
import com.sinfor.demo.service.LoginService;
import com.sinfor.demo.service.WriteAndFlushService;
import com.sinfor.demo.session.SessionService;
import com.sinfor.demo.session.XfUser;
import com.sinfor.scanner.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fengwen
 * @date 2022/5/4
 * @description TODO
 **/
@Service
@Slf4j
public class LoginServiceImpl implements LoginService, WriteAndFlushService {

    @Resource
    private UserCache userCache;

    @Resource
    private TryPassCache tryPassCache;

    @Resource
    private SessionService sessionService;

    @Override
    public Result<String> login(LoginParam param) {
        // TODO 查询客户端数量，判断是否负载

        // TODO 五次密码校验

        // TODO 客户端最低版本

        //redis 中取用户
        String userId = param.getUserId();
        XfUser user = userCache.findUserById(userId);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error("", e);
        }
        if (user == null) {
            log.warn("登陆失败，{}账号不存在", userId);
            return Result.fail("用户账号或密码不正确");
        }
        if (!user.getEnabled()) {
            return Result.fail("您的账号已停用");
        }
        if (!user.getPassword().equals(param.getPassword())) {
            tryPassCache.count(userId);
            log.warn("登陆失败，{}密码输入错误", userId);
            return Result.fail("用户账号或密码不正确");
        }
        // TODO 判断机器是否授权

        // 向内存中写入sessionUser
        sessionService.writeIn(user, param);

        // 判断是否有余额



        writeOk((short) 1, user);
        // 写回数据包
        writeOk("登陆到了一半");
        return Result.ok("登陆成功");
    }


}
