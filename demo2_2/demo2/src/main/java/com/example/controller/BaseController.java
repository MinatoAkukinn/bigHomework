package com.example.controller;

import com.example.service.ex.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;



public class BaseController {
    public static final int OK=200;
    public static final int NOT_FOUND=4040;
    public static final int ERROR=501;
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result=new JsonResult<>();
        ;//以下为注册异常
        if(e instanceof UsernameDuplicatedException ){
            result.setState(3001);
            result.setMessage("用户名被占用");
        }else if(e instanceof InsertException ){
            result.setState(5001);
            result.setMessage("产生未知异常");
            //以下为登录异常
        }else if(e instanceof UsernameNotFoundException){
            result.setState(4041);
            result.setMessage("用户不存在");
        }else if(e instanceof PasswordNotMatchException){
            result.setState(5011);
            result.setMessage("密码错误");
        }else if(e instanceof UpdateException){
            result.setState(5012);
            result.setMessage("更新数据产生未知异常");
        }else if(e instanceof FileEmptyException){
            result.setState(6001);
            result.setMessage("文件为空");
        }else if(e instanceof FileSizeException){
            result.setState(6002);
            result.setMessage("文件过大");
        }else if(e instanceof FileTypeException){
            result.setState(6003);
            result.setMessage("文件类型错误");
        }else if(e instanceof FileStateException){
            result.setState(6004);
            result.setMessage("文件状态");
        }else if(e instanceof FileUploadIOException){
            result.setState(6005);
            result.setMessage("上传错误");
        }else if (e instanceof ObjectsNotFoundException){
            result.setState(7001);
            result.setMessage("列表为空");
        }

        return result;
    }


    public final Integer getUserIdFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("userId").toString());

    }
    public final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("userName").toString();
    }
}
