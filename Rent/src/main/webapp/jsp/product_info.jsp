<%--
  Created by IntelliJ IDEA.
  User: JT
  Date: 13/11/2022
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="margin:0 auto;width:950px;">
    <div class="col-md-6">
        <img style="opacity: 1;width:400px;height:350px;" title="" class="medium" src="${pageContext.request.contextPath}/products/c_0001.jpg">
    </div>

    <div class="col-md-6">
        <div><strong>${bean.objectName }</strong></div>
        <div style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
            <div>编号：${bean.objectID }</div>
        </div>

        <div style="margin:10px 0 10px 0;">商城价: <strong style="color:#ef0101;">￥：${bean.price }元</strong>
        </div>
        <a href="${pageContext.request.contextPath}/jsp/index.jsp">
            <input style="background: url('${pageContext.request.contextPath}/images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0);height:36px;width:127px;" value="下单" type="button">
        </a>



    </div>
</div>
<div class="clear"></div>
<div style="width:950px;margin:0 auto;">
    <div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
        <strong>商品介绍</strong>
    </div>



    <div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
        <strong>${bean.objectIntro }</strong>
    </div>


</div>
</div>
</body>
</html>
