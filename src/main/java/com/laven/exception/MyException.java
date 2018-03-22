package com.laven.exception;

import com.laven.enums.ResultEnum;

/**
 * @Description:
 * @Author: laven
 * @Date: 2018/3/13 下午11:21
 */
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
