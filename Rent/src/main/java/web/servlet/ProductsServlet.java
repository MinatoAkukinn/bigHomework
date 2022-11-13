package web.servlet;

import domain.Products;
import service.ProductsService;
import service.impl.ProductsServiceImpl;
import web.servlet.base.BaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductsServlet", value = "/product")
public class ProductsServlet extends BaseServlet {
/*商品模块*/

    public String getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取pid

        try {
            String objectId=request.getParameter("ObjectID");
            //2.调用service获取商品 return product
            ProductsService ps=new ProductsServiceImpl();
            Products pro = ps.getById(objectId);
            request.setAttribute("bean",pro);

        } catch (Exception e) {
            request.setAttribute("msg","查询单个商品失败");
            return   "/jsp/msg.jsp";
        }

        //3.product放入其中



        return "/jsp/product_info.jsp";
    }
}
