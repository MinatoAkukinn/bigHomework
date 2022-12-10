package com.example.controller;

import com.example.entity.Objects;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.beans.Transient;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class SearchControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private MockHttpSession session;
    @Before
    public void setUp() throws Exception{
        mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
    session=new MockHttpSession();
    }
    @Test
    void search() {

    }
    @Transactional
    @Test
    @Rollback(value = true)

    public void searchByType() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.get("/search/searchByType")
                        .sessionAttr("userId","1")
                .param("type","手机")
                .param("page","1")
                ).andDo(print());
//不存在分类
        mockMvc.perform(MockMvcRequestBuilders.get("/search/searchByType")
                .sessionAttr("userId","1")
                .param("type","试试")
                .param("page","1")
        ).andDo(print());
//不存在页数
        mockMvc.perform(MockMvcRequestBuilders.get("/search/searchByType")
                .sessionAttr("userId","1")
                .param("type","手机")
                .param("page","20")
        ).andDo(print());

    }
    @Transactional
    @Test
    @Rollback(value = true)
    public void searchByPage() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/search/searchByPage")
                .sessionAttr("userId","1")
                .param("search","IPAD")
                .param("page","1")
        ).andDo(print());
        mockMvc.perform(MockMvcRequestBuilders.get("/search/searchByPage")
                .sessionAttr("userId","1")
                .param("search","XIAOMI")
                .param("page","1")
        ).andDo(print());
        mockMvc.perform(MockMvcRequestBuilders.get("/search/searchByPage")
                .sessionAttr("userId","1")
                .param("search","IPAD")
                .param("page","10")
        ).andDo(print());
    }
}