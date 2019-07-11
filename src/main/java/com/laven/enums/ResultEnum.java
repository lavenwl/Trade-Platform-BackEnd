package com.laven.enums;

/**
 * @Description:
 * @Author: laven
 * @Date: 2018/3/13 下午11:24
 */
public enum ResultEnum {
    SUCCESS(0, "成功"),
    UNKOWN_ERROR(-1, "未知错误"),
    LOW_STOCKS(1, "库存不足"),
    UNKOWN_ACCOUNT(2, "没有此用户"),
    INCORRECT_PASSWORD(3, "密码不正确"),
    ACCOUNT_LOCKED(4, "用户被锁定"),
    LOGIN_OVERTIME(5, "用户上次登陆后未正常退出, 请重新登录"),
    UNLOGIN(6, "用户未登录");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
