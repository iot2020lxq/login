package com.iot.login.service.impl;

import com.iot.login.common.ResultVo;
import com.iot.login.dao.UserLoginMapper;
import com.iot.login.entity.UserLogin;
import com.iot.login.request.UserLoginRequest;
import com.iot.login.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lxq
 * @version 2020/5/10 - 18:25
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public ResultVo list(UserLoginRequest userLoginRequest) {
        ResultVo result = new ResultVo();
        try{
            UserLogin userLogin = userLoginMapper.queryUserByUserName(userLoginRequest.getUsername());
            //判断用户名是否为空
            if(userLogin != null){
                //判断密码是否相等
                if(userLoginRequest.getPassword().equals(userLogin.getPassword())){
                    //时间转为字符串
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String loginDateToStr = sdf.format(userLogin.getLoginDate());

                    //返回成功
                    result.setCode(1);
                    result.setMessage("登录成功！上次登录时间为："+loginDateToStr);

                    //跟新登录时间
                    UserLogin user = new UserLogin();
                    user.setId(userLogin.getId());
                    user.setLoginDate(new Date());

                    userLoginMapper.updateLoginDate(user);
                }else{
                    result.setCode(0);
                    result.setMessage("密码错误！");
                }
            }else {
                result.setCode(0);
                result.setMessage("该用户不存在！");
            }
        }catch (Exception e){
            result.setCode(0);
            result.setMessage("数据异常！");
        }

        return result;
    }
}
