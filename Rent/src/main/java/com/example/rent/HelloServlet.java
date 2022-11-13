package com.example.rent;

import web.servlet.base.BaseServlet;

import java.io.*;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet("/hello-servlet")
public class HelloServlet extends BaseServlet {
    private String message;

    public String test(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        return "jsp/test.jsp";
    }
    public void test2(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "^_^嘻嘻" + "</h1>");
        out.println("</body></html>");

    }
}