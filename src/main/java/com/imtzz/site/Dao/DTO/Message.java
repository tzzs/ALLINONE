package com.imtzz.site.Dao.DTO;

import java.util.HashMap;
import java.util.Map;

public class Message {
    private int code;
    private String msg;
    private Map<Object, Object> data = new HashMap<>();

    public Message() {

    }

    public Message(int code, String msg, Map<Object, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<Object, Object> getData() {
        return data;
    }

    public void setData(Map<Object, Object> data) {
        this.data = data;
    }
}
