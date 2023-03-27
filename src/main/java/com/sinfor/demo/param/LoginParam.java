package com.sinfor.demo.param;

import com.sinfor.scanner.annotation.validator.XfNotBlank;
import lombok.Data;

/**
 * @author fengwen
 * @date 2022/5/4
 * @description TODO
 **/
@Data
public class LoginParam {

    /**
     * 用户账号
     */
    @XfNotBlank(message = "账号不能为空")
    private String userId;
    /**
     * 用户密码
     */
    @XfNotBlank(message = "用户密码不能为空")
    private String password;
    /**
     * 登陆平台
     */
    private int platform;
    /**
     * 设备mac地址
     */
    @XfNotBlank(message = "设备编号不能为空")
    private String machmac;
    /**
     * 计算机名
     */
    @XfNotBlank(message = "计算机名不能为空")
    private String machname;
    /**
     * cpu-id,具体含义和老系统保持一致
     */
    private String machcpu;

    private double clientVersion;
    /**
     * 是否追踪执行的SQL
     */
    private boolean accountTrace;
    /**
     * 授权类别
     */
    private Integer righttype;
}
