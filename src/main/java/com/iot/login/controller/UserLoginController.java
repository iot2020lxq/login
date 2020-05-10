package com.iot.login.controller;

import com.iot.login.common.ResultVo;
import com.iot.login.request.UserLoginRequest;
import com.iot.login.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lxq
 * @version 2020/5/10 - 18:26
 */
@RestController
@RequestMapping(value = {"/user/"},produces = "application/json;charset=UTF-8")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = "login")
    public ResultVo login(@Valid UserLoginRequest userLoginRequest, BindingResult bindingResult){
        ResultVo result = new ResultVo();
        try {
            //数据的校验
            if(bindingResult.hasErrors()){
                result.setCode(0);
                result.setMessage(bindingResult.getAllErrors().get(0).getDefaultMessage());
                return result;
            }
            //查询用户
            return userLoginService.list(userLoginRequest);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(0);
            result.setMessage("数据异常！");
        }
        return result;
    }
}
