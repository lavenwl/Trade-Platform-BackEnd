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

    ;

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
