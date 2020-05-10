package com.iot.login.common;

/**
 * @author lxq
 * @version 2020/5/10 - 18:29
 */
public class ResultVo {

    private Integer code;   //返回码

    private String message; //提示信息

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
