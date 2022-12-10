package com.example.controller;

import com.example.entity.Objects;
import com.example.entity.comments;
import com.example.service.IObjectsService;
import com.example.service.ex.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.example.controller.UserController.PHOTO_TYPE;

@RestController
@Api(tags= "商品操作")
@RequestMapping(value = "/object" )
public class ObjectsController extends BaseController{
    @Autowired
    private IObjectsService objectService;
    @ApiResponses({
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=7001,message = "商品名不存在"),
    })
    @ApiOperation("获取商品列表")
    @RequestMapping(value = "/new_list",method = RequestMethod.GET)
    public JsonResult<List<Objects>> findNewListByObjectType( String objectType,  String objectType2){
        System.out.println(objectType+objectType2);
        List<Objects> data=objectService.findNewListByObjectType(objectType,objectType2);
        return new JsonResult<List<Objects>> (OK,data);
    }
    @RequestMapping(value="{id}/details",method = RequestMethod.GET)
    @ApiOperation("获取详细信息")
    @ApiResponses({
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=7001,message = "商品名不存在"),
    })
    //将id映射到下面这条中
    public JsonResult<Objects> findObjectsByObjectId( @PathVariable("id")  Integer id){
        Objects data=objectService.findObjectsByObjectId(id);
        return new JsonResult<Objects>(OK,data);

    }

    @RequestMapping(value="{id}/get_Comment",method = RequestMethod.GET)
    @ApiOperation("获取评论")
    @ApiResponses({
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=4041,message = "用户不存在"),
    })
    public JsonResult<List<comments>> getCommentByObjectId(@PathVariable("id") Integer id) {
        List<comments> list=objectService.findCommentsByObjectId(id);
        return new JsonResult<List<comments>>(OK,list);
        ////
    }
    @RequestMapping(value="update_object",method = RequestMethod.POST)
    @ApiOperation("上传物品")
    @ApiResponses({
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=3001,message = "用户名不匹配"),
            @ApiResponse(code=6001,message = "文件为空"),
            @ApiResponse(code=6002,message = "文件过大"),
            @ApiResponse(code=6003,message = "文件类型错误"),
            @ApiResponse(code=6004,message = "文件状态"),
            @ApiResponse(code=6005,message = "上传错误")
    })
    public JsonResult<Void> createObjects( @RequestPart("file") MultipartFile file,Objects object,HttpSession session){
        if(file.isEmpty()) throw new FileEmptyException();
        //最大尺寸10MB
        if(file.getSize()>10*1024*1024) throw new FileSizeException();
        String contentType=file.getContentType();
        if(!PHOTO_TYPE.contains(contentType)) throw new FileTypeException();
        System.out.println(object);
        //后续需要修改
        //输入文件
        String p="D:\\uploads";
        System.out.println(p);
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
        System.out.println(newFileName);
        File dest=new File(dir,newFileName);

        try{
            file.transferTo(dest);
        } catch (FileStateException e) {
            throw new FileStateException();
        } catch (IOException e){
            throw new FileUploadIOException();
        }
        Integer userId= getUserIdFromSession(session);
        object.setUserId(userId);
        String photo="show/"+newFileName;
        object.setShelfTime(new Date());
        object.setObjectPhoto(photo);
        //后续服务,还未编写
        objectService.Insert(object);

        return new JsonResult<Void>(OK);
    }
    @RequestMapping(value="category",method = RequestMethod.GET)
    @ApiOperation("获取分类物品")
    public JsonResult<List<Objects>> getCategory(String objectType){
        List<Objects> list=objectService.findObjectListByObjectType(objectType);
        return new JsonResult<>(OK,list);

    }
    @RequestMapping(value="myObjects",method =RequestMethod.GET)
    @ApiOperation("获取我的物品")
    public JsonResult<List<Objects>> getMyObjects(HttpSession session){
        Integer userId=getUserIdFromSession(session);
        List<Objects> list=objectService.findObjectListByUserId(userId);
        if(list.isEmpty()||list==null) throw new ObjectsNotFoundException();
        return new JsonResult<>(OK,list);
    }

    @RequestMapping(value="changeObjectInfor")
    @ApiOperation(value = "修改物品信息")
    @ApiResponses({
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=3001,message = "用户名不匹配"),
            @ApiResponse(code=5012,message = "更新数据产生未知异常"),
            @ApiResponse(code=6001,message = "文件为空"),
            @ApiResponse(code=6002,message = "文件过大"),
            @ApiResponse(code=6003,message = "文件类型错误"),
            @ApiResponse(code=6004,message = "文件状态"),
            @ApiResponse(code=6005,message = "上传错误")
    })
    public JsonResult<Objects> changeObjectInfor(HttpSession session, @RequestPart("file") MultipartFile file,Objects objects){
        if(file.isEmpty()) throw new FileEmptyException();
        //最大尺寸10MB
        if(file.getSize()>10*1024*1024) throw new FileSizeException();
        String contentType=file.getContentType();
        if(!PHOTO_TYPE.contains(contentType)) throw new FileTypeException();
        Integer userId= getUserIdFromSession(session);

        Integer getId= objectService.findUserIdByObjectId(objects.getObjectId());
        if(userId!=getId) throw new UsernameDuplicatedException();
        //后续需要修改
        //输入文件
        String p="D:\\uploads";
        System.out.println(p);
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
        System.out.println(newFileName);
        File dest=new File(dir,newFileName);

        try{
            file.transferTo(dest);
        } catch (FileStateException e) {
            throw new FileStateException();
        } catch (IOException e){
            throw new FileUploadIOException();
        }
        String photo="show/"+newFileName;
        objects.setShelfTime(new Date());
        objects.setObjectPhoto(photo);
        objectService.updateObject(objects);
        return new JsonResult<>(OK);
    }
}
