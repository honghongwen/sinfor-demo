package com.sinfor.demo.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author fengwen
 * @date 2022/5/9
 * @description TODO
 **/
@Data
@TableName("ts_user")
public class TSUser {

    /**
     * 用户帐号
     */
    @TableId
    private String userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 网点编号
     */
    private String siteId;
    /**
     * 部门编号
     */
    private String deptid;
    /**
     * 是否启用
     */
    private Boolean enabled;

    private String enterUser;

    private Date createDate;

    private String memo;

    private String employId;

    private String wbCode;

    private String pyCode;

    private Boolean useFlag;

    private String modifyUser;

    private Date modifyTime;

    private String contDept;

    private Boolean hardBind;

    private Boolean lockFlag;

    private Integer updVersion;

}
