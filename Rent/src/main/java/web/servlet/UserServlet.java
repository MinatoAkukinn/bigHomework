package web.servlet;



import constant.Constant;
import domain.Products;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.ProductsService;
import service.UserService;
import service.impl.ProductsServiceImpl;
import service.impl.UserServiceImpl;
import web.servlet.base.BaseServlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends BaseServlet {


    //
    // 获取个人:



    public String myInforUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取个人
            String userName=request.getParameter("userName");
            System.out.println("Servlet-checkName"+userName);
            //2.用userService调用方法查找用户
            UserService userService=new UserServiceImpl();
            User existUser=userService.findByUsername(userName);
            request.setAttribute("ur",existUser);
        } catch (Exception e) {

        }

        //3.product放入其中



        return "/jsp/myInfor.jsp";
    }

    /*
* 判断是否存在用户
* */
    public void checkUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
      //1.获取用户名从输入中
       String userName=request.getParameter("userName");
        System.out.println("Servlet-checkName"+userName);
       //2.用userService调用方法查找是否存在用户
       UserService userService=new UserServiceImpl();
       User existUser=userService.findByUsername(userName);
        System.out.println(existUser);
       if(existUser==null) response.getWriter().println(1);
       else response.getWriter().println(2);

    }

    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
        return null;
    }




    /*
*
*
* 用户登录
*
*
* */



    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        try {

            //1获取用户名 密码
            String userName = request.getParameter("userName");
            String userPass =request.getParameter("userPass");
            //2调用service,返回user
            UserService us=new UserServiceImpl();
            User user= null;
            user = us.login(userName,userPass);
            if(user==null){
                //用户名和密码不匹配
                request.setAttribute("msg","用户名不存在或者密码错误");
                return "/jsp/msg.jsp";
            }
//        若不为空,则保存登录状态
            request.getSession().setAttribute("user",user);
            //跳转到首页
            response.sendRedirect(request.getContextPath());


        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","用户登录失败");
            return "/jsp/msg.jsp";
        }

        //判断user,根据结果生成

        return null;

    }

    public String loginUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "jsp/login.jsp";
    }
/*
* 注册页面
* */
    public String registerUI(HttpServletRequest request, HttpServletResponse response) throws IOException{
        return "jsp/register.jsp";
    }
    public String regist(HttpServletRequest request, HttpServletResponse response) throws IOException{
//  1.封装对象

        try {
            User user=new User();
            BeanUtils.populate(user,request.getParameterMap());
            //1.1手动封装,看情况?
            System.out.println(user);;
            //2调用service
            UserService us= (UserService) new UserServiceImpl();
            us.regist(user);
            //3转发对象+msg
            request.setAttribute("msg","恭喜恭喜恭喜你,注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            //转发到页面msg.jsp
            request.setAttribute("msg","用户注册失败");
            return "/jsp/msg.jsp";
        }


        return "/jsp/msg.jsp";
    }
}
