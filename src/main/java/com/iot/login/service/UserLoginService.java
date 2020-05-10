package com.iot.login.service;

import com.iot.login.common.ResultVo;
import com.iot.login.request.UserLoginRequest;

/**
 * @author lxq
 * @version 2020/5/10 - 18:25
 */
public interface UserLoginService {
    ResultVo list(UserLoginRequest userLoginRequest);
}
