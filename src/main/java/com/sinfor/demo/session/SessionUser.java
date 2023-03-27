package com.sinfor.demo.session;

import lombok.Data;
import lombok.ToString;

/**
 * @author fengwen
 * @date 2022/5/10
 * @description TODO
 **/
@Data
@ToString(callSuper = true)
public class SessionUser extends XfUser {

    /**
     * 当前登陆平台
     */
    private int platform;
    /**
     * 全局数据;如上次公告提醒时间
     */
    private Object data;
    /**
     * 客户端版本
     */
    private double clientVersion;

}
