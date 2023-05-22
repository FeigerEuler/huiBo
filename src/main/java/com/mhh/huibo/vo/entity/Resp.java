package com.mhh.huibo.vo.entity;

import lombok.Data;

@Data
public class Resp<T> {

    String code;
    String msg;

    T data;

    public   Resp<T> buildSuccess(T data){
        this.code = "200";
        this.msg="success";
        this.data = data;
        return this;
    }

    public  Resp<T> buildFail(String msg){
        this.code = "100";
        this.msg=msg;

        return this;
    }
    public  Resp<T> buildFail(String code,String msg){
        this.code = code;
        this.msg=msg;

        return this;
    }

}
