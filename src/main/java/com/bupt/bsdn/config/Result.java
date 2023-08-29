package com.bupt.bsdn.config;


import com.alibaba.fastjson2.JSONObject;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 接口返回数据格式
 */
@Data
public class Result implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success = true;

    /**
     * 返回处理消息
     */
    private String message = "";

    /**
     * 返回代码
     */
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    private JSONObject result;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public Result() {
    }

    /**
     * 兼容VUE3版token失效不跳转登录页面
     */
    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    /**
     * 直接返回消息和状态码
     * 用于返回修改操作的执行结果
     */
    public Result success(String message) {
        this.message = message;
        this.code = 200;
        this.success = true;
        return this;
    }

    /**
     * 直接返回状态码 不返回消息
     */
    public static Result Resultok() {
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(200);
        return r;
    }

    /**
     * 返回结果 + 状态码
     */

    public static Result ok(String msg) {
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(200);
        r.setMessage(msg);
        return r;
    }

    /**
     * 返回执行结果内容+状态码
     */

    public static Result ok(JSONObject data) {
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(200);
        r.setResult(data);
        return r;
    }

    /**
     * 返回错误结果和错误信息内容
     */

    public static Result error(String msg, JSONObject data) {
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(500);
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }

    /**
     * 返回错误结果和错误信息
     */
    public static Result error(String msg) {
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(500);
        r.setMessage(msg);
        ;
        return r;
    }

    /**
     * 无权限访问返回结果
     */
    public static Result noauth(String msg) {
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(403);
        r.setMessage(msg);
        ;
        return r;
    }

}
