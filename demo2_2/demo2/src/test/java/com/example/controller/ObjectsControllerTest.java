package com.example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
@SpringBootTest
class ObjectsControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private MockHttpSession session;
    @BeforeEach
    void setUp() {
        mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
        session=new MockHttpSession();
    }

    @Test
    void findNewListByObjectType() {
    }

    @Test
    void findObjectsByObjectId() {
    }

    @Test
    void getCommentByObjectId() {
    }

    @Test
    void createObjects() {

    }

    @Test
    void getCategory() {

    }

    @Test
    void getMyObjects() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/object/myObjects")
                .sessionAttr("userId","1")
        ).andDo(print());
        mockMvc.perform(MockMvcRequestBuilders.get("/object/myObjects")
                .sessionAttr("userId","10")
        ).andDo(print());

    }

    @Test
    void changeObjectInfor() throws Exception {
        //正常成功!
//        mockMvc.perform(MockMvcRequestBuilders.multipart("/object/changeObjectInfor")
//                        .file(new MockMultipartFile("file","1.png","image/png",new FileInputStream("D:\\uploads\\1.png")))
//                .sessionAttr("userId","1")
//                .param("objectId","302")
//                .param("objectName","Iphone")
//                .param("objectType","test")
//                .param("status","1")
//                .param("userId","1")
//
//        ).andDo(print());
        //文件过大
//        mockMvc.perform(MockMvcRequestBuilders.multipart("/object/changeObjectInfor")
//                .file(new MockMultipartFile("file","3.png","image/png",new FileInputStream("D:\\uploads\\3.png")))
//                .sessionAttr("userId","1")
//                .param("objectId","302")
//                .param("objectName","Iphone")
//                .param("objectType","test")
//                .param("status","1")
//                .param("userId","1")
//
//        ).andDo(print());
        ///文件类型错误 6003
//        mockMvc.perform(MockMvcRequestBuilders.multipart("/object/changeObjectInfor")
//                .file(new MockMultipartFile("file","2.jpg","excel",new FileInputStream("D:\\uploads\\2.jpg")))
//                .sessionAttr("userId","1")
//                .param("objectId","302")
//                .param("objectName","Iphone")
//                .param("objectType","test")
//                .param("status","1")
//                .param("userId","1")
//
//        ).andDo(print());
        //用户名不匹配
//        mockMvc.perform(MockMvcRequestBuilders.multipart("/object/changeObjectInfor")
//                .file(new MockMultipartFile("file","2.jpg","image/jpeg",new FileInputStream("D:\\uploads\\2.jpg")))
//                .sessionAttr("userId","3")
//                .param("objectId","302")
//                .param("objectName","Iphone")
//                .param("objectType","test")
//                .param("status","1")
//                .param("userId","1")
//
//        ).andDo(print());

    }
}