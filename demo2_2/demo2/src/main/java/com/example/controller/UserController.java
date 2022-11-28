package com.example.controller;

import com.example.entity.Purchase;
import com.example.entity.Users;
import com.example.service.IUserService;
import com.example.service.ex.*;
import io.swagger.annotations.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController

@RequestMapping("/users")
@Api(tags= "用户操作",description = "")


public class UserController extends BaseController{
    public static final ArrayList<String> PHOTO_TYPE = new ArrayList<>();
    static {
        PHOTO_TYPE.add("image/jpeg");
        PHOTO_TYPE.add("image/png");
        PHOTO_TYPE.add("image/bmp");
        PHOTO_TYPE.add("image/gif");
    }
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    @ApiOperation("用户注册")
    @ApiResponses({
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=3001,message = "用户名被占用"),
            @ApiResponse(code=4001,message = "产生未知异常"),
            @ApiResponse(code=5012,message = "更新数据产生未知异常")
    })

    public JsonResult<Void> reg(  Users user){
        user.setRealName("Al2x");
        user.setStuNo("20201513063");
        userService.reg(user);
        return new JsonResult<>(OK);
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ApiOperation(value = "用户登录")
    @ApiResponses({
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=4041,message = "用户名不存在"),
            @ApiResponse(code=5011,message = "密码错误")
    })
    public JsonResult<Void> login( String userName, String password, HttpSession session){
        Users u=userService.login(userName,password);
        session.setAttribute("userId",u.getUserId());
        session.setAttribute("username",u.getUserName());
        return new JsonResult<>(OK);
    }
    @RequestMapping(value = "/change_userPass",method = RequestMethod.PUT)
    @ApiOperation("用户改密码")
    @ApiResponses({
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=4041,message = "用户名不存在"),
            @ApiResponse(code=5011,message = "密码错误"),
            @ApiResponse(code=5012,message = "更新数据产生未知异常")
    })
    public JsonResult<Void> changePassword(String oldPassword, String newPassword,  HttpSession session){
        Integer uid= getUserIdFromSession(session);

        userService.changePass(uid,oldPassword,newPassword);
        return new JsonResult<>(OK);
    }
    @RequestMapping(value = "/get_by_id",method = RequestMethod.GET)
    @ApiOperation("获取用户个人信息")
    @ApiResponses({
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=4041,message = "用户名不存在"),
    })
    public JsonResult<Users> getByUserId(HttpSession session){
        Integer userId=getUserIdFromSession(session);
        Users data=userService.getByUid(userId);
        return new JsonResult<Users>(OK,data);
    }
    @RequestMapping(value = "/change_info",method = RequestMethod.PUT)
    @ApiOperation("修改个人信息")
    @ApiResponses({
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=4041,message = "用户名不存在"),
            @ApiResponse(code=5012,message = "更新数据产生未知异常")
    })

    public JsonResult<Void> changeInfo( Users user,  HttpSession session){
        Integer userId=getUserIdFromSession(session);

        userService.changeInfo(userId,user);
        return new JsonResult<>(OK);

    }
    @RequestMapping(value="change_photo",method=RequestMethod.PUT)
    @ApiResponses({
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=4041,message = "用户名不存在"),
            @ApiResponse(code=5012,message = "更新数据产生未知异常"),
            @ApiResponse(code=6001,message = "文件为空"),
            @ApiResponse(code=6002,message = "文件过大"),
            @ApiResponse(code=6003,message = "文件类型错误"),
            @ApiResponse(code=6004,message = "文件状态"),
            @ApiResponse(code=6005,message = "上传错误")
    })
    @ApiOperation("修改头像,上传头像")

    public JsonResult<String> changePhoto( HttpSession session, @RequestPart("file") MultipartFile file){
        if(file.isEmpty()) throw new FileEmptyException();
        //最大尺寸10MB
        if(file.getSize()>10*1024*1024) throw new FileSizeException();
        String contentType=file.getContentType();
        if(!PHOTO_TYPE.contains(contentType)) throw new FileTypeException();
        ApplicationHome applicationHome=new ApplicationHome(this.getClass());
        //后续需要修改
        //输入文件
        String p="D:\\uploads";
        System.out.println("1"+p);
//创建文件夹
        File dir=new File(p);
        if(!dir.exists()) dir.mkdir();
//修改名字
        String FileName=file.getOriginalFilename();
        System.out.println("fn="+FileName);
        int index=FileName.lastIndexOf(".");
        String suffix=FileName.substring(index);
        String newFileName= UUID.randomUUID().toString().toUpperCase()+suffix;
        //创建图片,此时为空文件
        File dest=new File(dir,newFileName);
//改名字)真)
        try{
            file.transferTo(dest);
        } catch (FileStateException e) {
            throw new FileStateException();
        } catch (IOException e){
            throw new FileUploadIOException();
        }
        Integer userId= getUserIdFromSession(session);
        //插入数据库中的图片路径
        String photo="show/"+newFileName;
        System.out.println("p:"+photo);
        userService.updatePhotoByUserId(userId,photo);
        return new JsonResult<>(OK,photo);


    }

//    public JsonResult<Void> reg(Users user){
//        JsonResult<Void> result=new JsonResult<>();
//        try{
//            userService.reg(user);
//            result.setState(200);
//            result.setMessage("恭喜!注册成功!");
//        }catch(UsernameDuplicatedException e){
//            result.setState(301);
//            result.setMessage("用户名被占用");
//        }catch(InsertException e){
//            result.setState(501);
//            result.setMessage("产生未知异常");
//        }
//        return result;
//    }

}
