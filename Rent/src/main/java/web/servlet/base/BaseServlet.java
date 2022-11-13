package web.servlet.base;

import org.apache.catalina.filters.ExpiresFilter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet", value = "/BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //获取名称
            String mName=request.getParameter("method");

            //1.1
//            判断是否为空,若为空,默认
            if(mName==null||mName.trim().length()==0){
                mName="index";
            }
            //获取对象方法
            Method method =this.getClass().getMethod(mName, HttpServletRequest.class, HttpServletResponse.class);
            //默认方法
            //执行方法获取返回
            String path=(String)method.invoke(this,request,response);
            //判断
            if(path!=null){
                request.getRequestDispatcher(path).forward(request,response);
            }
        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public String index(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("不要捣乱");
        return null;
    }
}
