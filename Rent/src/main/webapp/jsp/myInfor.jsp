<%--
  Created by IntelliJ IDEA.
  User: JT
  Date: 13/11/2022
  Time: 3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <script>

    </script>
</head>
<body>
<table>
    <tr>
        <td align="left">用户名</td>
        <td align="right" id="username1">${ur.userName }</td>
    </tr>
    <tr>
        <td align="left">邮箱</td>
        <td align="right" id="email1">${ur.email }</td>
    </tr>
    <tr>
        <td align="left">用学号</td>
        <td align="right" id="stuID1">${ur.stuNo }</td>
    </tr>
    <tr>
        <td align="left">手机</td>
        <td align="right" id="phone1">${ur.phone }</td>
    </tr>
</table>

</body>
</html>
