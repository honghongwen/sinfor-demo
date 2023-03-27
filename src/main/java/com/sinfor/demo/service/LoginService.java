package com.sinfor.demo.service;

import com.sinfor.demo.param.LoginParam;
import com.sinfor.scanner.annotation.XfCommand;
import com.sinfor.scanner.annotation.XfModule;
import com.sinfor.scanner.annotation.validator.XfValid;
import com.sinfor.scanner.eun.XfModuleType;
import com.sinfor.scanner.result.Result;

@XfModule(module = 99000001, parentId = 0, moduleName = "登陆模块", moduleType = XfModuleType.xmtCommon)
public interface LoginService {

    @XfCommand(cmd = 1001, cmdName = "登陆接口", version = "1.2")
    Result<String> login(@XfValid LoginParam param);

}
