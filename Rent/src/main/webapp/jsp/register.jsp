<%--
  Created by IntelliJ IDEA.
  User: JT
  Date: 12/11/2022
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

    <title>Title</title>
    <script src="webjars/jquery/3.5.1/jquery.min.js"></script>

    <script type="text/javascript" >
        // 判断用户名是否注册的js
        $(function(){
            $("#username").blur(function (){

                var val=$(this).val();

                if(val!==""){
                    var url="${pageContext.request.contextPath }/user?method=checkUsername";
                    var params = {"userName":val};
                    $.post(url,params,function (data) {
                        if(data==1){
                            $("#s1").html("用户名可以使用").css("color","#0f0");

                        }else if(data==2){
                            $("#s1").html("用户名已被注册").css("color","#f00");

                        }

                    })
                }
            })
        })
    </script>
</head>
<body>

    <form  action="${pageContext.request.contextPath }/user?method=regist">
        <input type="hidden" name="method" value="regist">
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="username" placeholder="请输入用户名" name="userName">
                <span id="s1"></span>
            </div>
        </div>
        <div class="form-group">
            <label for="UserPass" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="UserPass" placeholder="请输入密码" name="userPass">
            </div>
        </div>
        <div class="form-group">
            <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="confirmpwd" placeholder="请输入确认密码">
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-6">
                <input type="email" class="form-control" id="inputEmail3" placeholder="Email" name="email">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" id="regBut" width="100" value="注册" name="submit" border="0" >
            </div>
        </div>
    </form>

</body>
</html>
