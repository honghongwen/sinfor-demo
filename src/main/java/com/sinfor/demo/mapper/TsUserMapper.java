package com.sinfor.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinfor.demo.domain.TSUser;
import com.sinfor.demo.session.XfUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fengwen
 * @date 2022/5/9
 * @description TODO
 **/
@Mapper
public interface TsUserMapper extends BaseMapper<TSUser> {

    /**
     * @author fengwen
     * @date 12:00 2022/5/10
     * @description 根据用户id查询登陆用户
     * @param userId 用户id
     * @return com.sinfor.demo.session.XfUser
     **/
    XfUser loadXfUserByUserId(String userId);
}
