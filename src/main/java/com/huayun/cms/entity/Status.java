package com.huayun.cms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum Status {
    SUCCESS(0,"SUSSESS"),
    ERROR(30000,"ERROR");
    private Integer code;
    private String message;

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
