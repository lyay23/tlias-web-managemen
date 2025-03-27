package com.itheima.pojo;

import lombok.Data;

/**
 * 后端统一返回结果
 * @author 李阳
 */
@Data
public class Result {

    //编码：1成功，0为失败
    private Integer code;
    //错误信息
    private String msg;
    //数据
    private Object data;

    public static Result success() {
        Result result = new Result();
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static Result success(Object object) {
        Result result = new Result();
        result.data = object;
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }

}
