package web.servlet;

import service.CategoryService;
import service.impl.CategoryServiceImpl;
import web.servlet.base.BaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends BaseServlet {

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应编码

        try {
            response.setContentType("text/html;charset=utf-8");
            //1.调用service,返回json字符串


            CategoryService categoryService = new CategoryServiceImpl();
            String value= null;
            value = categoryService.finALL();
            response.getWriter().println(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //2.写回

        return null;
    }
}
