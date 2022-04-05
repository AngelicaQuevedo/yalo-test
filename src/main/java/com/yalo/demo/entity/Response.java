package com.yalo.demo.entity;

import java.io.Serializable;

public class Response implements Serializable {
    String id;
    public Response() {
    }
    public Response(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
