package web.servlet;

import domain.Category;
import domain.Products;
import service.CategoryService;
import service.ProductsService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductsServiceImpl;
import web.servlet.base.BaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends BaseServlet {
@Override
    public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //查询分类

        try {
            ProductsService ps=new ProductsServiceImpl();
            List<Products> NewList = ps.findNew();
            request.setAttribute("nList",NewList);//传到前端,命名为nList
        } catch (Exception e) {

        }

        //2放入

        return "/jsp/index.jsp";

    }
}
