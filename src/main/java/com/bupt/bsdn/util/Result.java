package com.bupt.bsdn.util;

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

    private JSONObject result;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public Result() {
        result = new JSONObject();
    }

    /**
     * 直接返回消息和状态码
     * 用于返回修改操作的执行结果
     */
    public JSONObject success(String message) {
        Result r = new Result();
        r.Put(true, 200, message);
        return r.getResult();
    }

    /**
     * 直接返回状态码 不返回消息
     */
    public static JSONObject Resultok() {
        Result r = new Result();
        r.Put(true, 200);
        return r.getResult();
    }

    /**
     * 返回结果 + 状态码
     */

    public static JSONObject ok(String msg) {
        Result r = new Result();
        r.Put(true, 200, msg);
        return r.getResult();
    }

    /**
     * 返回执行结果内容+状态码
     */

    public static JSONObject ok(Object data) {
        Result r = new Result();
        r.Put(true, 200, data);
        return r.getResult();
    }

    /**
     * 返回错误结果和错误信息内容
     */

    public static JSONObject error(String msg, Object data) {
        Result r = new Result();
        r.Put(false, 500, msg, data);
        return r.getResult();
    }

    /**
     * 返回错误结果和错误信息
     */
    public static JSONObject error(String msg) {
        Result r = new Result();
        r.Put(false, 500, msg);
        return r.getResult();
    }

    /**
     * 无权限访问返回结果
     */
    public static JSONObject noauth(String msg) {
        Result r = new Result();
        r.Put(false, 403, msg);
        return r.getResult();
    }

    public void Put(boolean success, Integer code) {
        this.result.put("code", code);
        this.result.put("success", success);
    }

    public void Put(boolean success, Integer code, String message) {
        Put(success, code);
        this.result.put("message", message);
    }

    public void Put(boolean success, Integer code, Object data) {
        Put(success, code);
        this.result.put("data", data);
    }

    public void Put(boolean success, Integer code, String message, Object data) {
        Put(success, code, message);
        this.result.put("data", data);
    }
}
