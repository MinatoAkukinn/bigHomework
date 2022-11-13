<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

    <script src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js" ></script>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" type="text/css">
</head>
<body>
<%@include file="/jsp/header.jsp"%>
<%--<%--%>
<%--    request.getRequestDispatcher("/index").forward(request,response);--%>
<div>
<c:forEach items="${nList }" var="p">
    <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">

        <a href="${pageContext.request.contextPath }/product?method=getById&ObjectID=${p.objectID }">
            <img src="${pageContext.request.contextPath }/products/c_0001.jpg" id=${p.objectID } width="130" height="130" style="display: inline-block;">
        </a>




        <p><a href="${pageContext.request.contextPath }/product?method=getById&ObjectID=${p.objectID }" style='color:#666'>${fn:substring(p.objectName,0,16) }..</a></p>
        <p><font color="#E4393C" style="font-size:16px">&yen;${p.price }</font></p>
    </div>
</c:forEach>



<%--    格式要求 列表后边需要有空格,每个元素的属性需要小驼峰--%>
<%--    <c:forEach items="${nList }" var="pr">--%>
<%--        <div>--%>
<%--            <p>${pr.objectName}</p>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>

</div>
</body>
</html>