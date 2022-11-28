package com.example;

import com.example.entity.Objects;
import com.example.entity.Objects;
import com.example.mapper.ObjectsMapper;
import com.example.service.IObjectsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ObjectApplicationTests {
    @Autowired
    private ObjectsMapper objectMapper;

    @Autowired
    private IObjectsService objectService;
    @Test
    //测试获取商品列表 四个
    public void findNewListByTypes(){
        List<Objects> list=objectService.findNewListByObjectType("电脑","手机");
        for (Object a:
             list) {
            System.out.println(a);
        }
    }
    @Test
    //测试mapper
    public void findNewListByTypes2(){
        List<Objects> list=objectMapper.findNewListByObjectType("电脑","电脑");
        for (Object a:
                list) {
            System.out.println(a);
        }
    }
    @Test
    //测试详细信息
    public void findOneById(){
        System.out.println(objectService.findObjectsByObjectId(2));
    }
    @Test
    public void findComments(){
        System.out.println(objectMapper.findCommentsByObjectId(2));

    }

    @Test
    public void create(){
        try{
            Objects objects = new Objects();
            objects.setUserId(1);
            objects.setObjectName("ipad 99");
            objects.setObjectPhoto("123");
            objects.setObjectIntro("这是测试123");
            objects.setObjectType("手机");
            objectService.Insert(objects);
        }catch (Exception e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void FindFENLEILIST(){
        System.out.println( objectMapper.findObjectListByObjectType("手机"));

    }
}
