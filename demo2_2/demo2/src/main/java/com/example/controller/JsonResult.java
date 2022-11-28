package com.example.controller;

import lombok.Data;

import java.io.Serializable;
//用json格式响应
@Data
public class JsonResult<E> implements Serializable {
    //状态码
    private Integer state;
    //描述
    private String message;
    //E泛型
    private E data;
    public JsonResult(){}
    //不同构造方式:
    //只有状态码
    public JsonResult(Integer state){
        this.state=state;
    }
    //获取状态码和数据
    public JsonResult(Integer state,E date){
        this.state=state;
        this.data=date;
    }
    //获取描述信息
    public JsonResult(Throwable e){

        this.message=e.getMessage();
    }
}
