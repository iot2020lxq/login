package com.iot.login.dao;

import com.iot.login.entity.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author lxq
 * @version 2020/5/10 - 18:23
 */
@Repository
@Mapper
public interface UserLoginMapper {

    @Select("select id,username,password,login_date from user_login where username=#{username} limit 1")
    UserLogin queryUserByUserName(String username);

    int updateLoginDate(UserLogin user);
}
