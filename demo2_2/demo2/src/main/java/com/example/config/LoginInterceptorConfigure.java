package com.example.config;

import com.example.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class LoginInterceptorConfigure implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor=new LoginInterceptor();
        List<String> patterns=new ArrayList<>();
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("js/**");
        //暂定
        patterns.add("/");
        patterns.add("web/login.html");
        patterns.add("web/register.html");
        patterns.add("web/index.html");
        patterns.add("/index.html");
        patterns.add("/login.html");
        patterns.add("/register.html");
        patterns.add("/users/login");
        patterns.add("/users/reg");
        patterns.add("/object/new_list");
        patterns.add("/show/**");

        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);


    }
    private String resourceHandler="/show/**"; //匹配url 中的资源映射
    private String location="D:/uploads/"; //上传文件保存的本地目录

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourceHandler).addResourceLocations("file:///"+location);
    }
}
