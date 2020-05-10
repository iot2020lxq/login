package com.iot.login.request;

import javax.validation.constraints.NotNull;

/**
 * @author lxq
 * @version 2020/5/10 - 18:32
 */
public class UserLoginRequest {

    @NotNull(message = "用户名不能为空！")
    private String username;

    @NotNull(message = "密码不能为空!")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
