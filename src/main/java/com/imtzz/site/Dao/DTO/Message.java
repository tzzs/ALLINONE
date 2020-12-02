package com.imtzz.site.Dao.DTO;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Message {
    private int code;
    private String msg;
    private Map<String, String> data = new HashMap<>();

    public Message(int code, String msg, Map<String, String> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
