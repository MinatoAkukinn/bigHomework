<%--
  Created by IntelliJ IDEA.
  User: JT
  Date: 13/11/2022
  Time: 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form  action="${pageContext.request.contextPath }/user?method=login">
    <input type="hidden" name="method" value="login">
    <div class="form-group">
        <label for="UserName" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="UserName" placeholder="请输入用户名" name="userName">
        </div>
    </div>
    <div class="form-group">
        <label for="UserPass" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-6">
            <input type="password" class="form-control" id="UserPass" placeholder="请输入密码" name="userPass">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit"  width="100" value="登录" name="submit" border="0" >
        </div>
    </div>
</form>
</body>
</html>
