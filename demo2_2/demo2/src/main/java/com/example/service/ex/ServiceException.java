package com.example.service.ex;


public class ServiceException extends RuntimeException{
    public ServiceException(){
        super();
    }
    //返回异常信息
    public ServiceException(String message){
        super(message);
    }
//    返回异常信息和对象
    public ServiceException(String message,Throwable cause){
        super(message,cause);
    }
//    只返回对象
    public ServiceException(Throwable cause){
        super(cause);
    }
    protected  ServiceException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }
}
