package com.sinfor.demo.session;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.sinfor.demo.constant.ConstPlatform;
import com.sinfor.demo.constant.ConstSiteType;
import com.sinfor.demo.param.LoginParam;
import com.sinfor.scanner.eun.XfSiteTypeDefine;
import com.sinfor.stater.net.exports.service.BizService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fengwen
 * @date 2022/5/10
 * @description TODO
 **/
@Slf4j
@Service
public class SessionService implements BizService {

    public static Map<String, SessionUser> sessionUserMap = new ConcurrentHashMap<>();

    private ChannelHandlerContext ctx = null;

    public void writeIn(XfUser user, LoginParam param) {
        if (ctx != null) {
            SessionUser sessionUser = new SessionUser();
            BeanUtil.copyProperties(user, sessionUser);

            int platform = getDefaultPlatform(user);
            sessionUser.setPlatform(platform);
            sessionUser.setClientVersion(param.getClientVersion());
            log.debug("将sessionUser写入内存{}", JSONUtil.toJsonStr(sessionUser));
            sessionUserMap.put(ctx.channel().id().toString(), sessionUser);
        }
    }

    private int getDefaultPlatform(XfUser xfUser) {
        int platform;
        int siteType = xfUser.getSiteTypeId() == null ? ConstSiteType.XF_INVENTED_SITE : xfUser.getSiteTypeId();
        switch (siteType) {
            case XfSiteTypeDefine.XF_HQ:
            case XfSiteTypeDefine.XF_PAY_CENTER:
            case XfSiteTypeDefine.XF_SCAN_CENTER:
                platform = ConstPlatform.CENTER_PLATFORM;
                break;
            case XfSiteTypeDefine.XF_CALL_CENTER:
                platform = ConstPlatform.CALL_CENTER_PLATFORM;
                break;
            default:
                platform = ConstPlatform.SITE_PLATFORM;
                break;
        }
        return platform;
    }


    @Override
    public void initChannel(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void destroyChannel(ChannelHandlerContext ctx) {
        // clean current session
        if (ctx != null) {
            ChannelId channelId = ctx.channel().id();
            String sessionId = channelId.toString();
            log.debug("清除会话session{}", sessionUserMap.get(sessionId));
            sessionUserMap.remove(sessionId);
        }
        this.ctx = null;
    }
}
