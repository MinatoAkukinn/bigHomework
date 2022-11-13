<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${empty user}">
    <a href="${pageContext.request.contextPath }/user?method=registerUI">注册</a>
    <br/>
    <a href="${pageContext.request.contextPath }/user?method=loginUI">登录</a>
    <br>


</c:if>
<c:if test="${not empty user}">
    ${user.userName }:你好!
    <a href="${pageContext.request.contextPath }/user?method=myInforUI&userName=${user.userName }">我的信息</a>
    <a href="${pageContext.request.contextPath }/user?method=logout">退出</a>
    <br>

</c:if>

<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav" id="c_ul">
    </ul>

</div>
<script>

</script>
<script>
    $(function (){
        //发送请求
        $.post("${pageContext.request.contextPath}/category",{"method":"findAll"},function (obj) {
            //alert(obj);
            //遍历,获取全部分类
            $(obj).each(function () {
                $("#c_ul").append("<li><a href='${pageContext.request.contextPath}/product?method=findByPage&pageNumber=1&cid="+this.cid+"'>"+this.type+"</a></li>");
            })
        },"json");
    })
</script>