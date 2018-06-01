<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>

</head>
<body>
<h1>进校</h1><link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
<!-- 引入jQuery核心js文件 -->
<script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<form action="${pageContext.request.contextPath }/ps/inSchool.action " method="post">
    <input type="text" name="platenumber">
    <input type="submit" value="入校"/>
</form>
<div class="container" >
    <div class="row">
        <div class="col-sm-10">
<table class="table table-hover table table-striped">
    <tr>
        <td>操作员编号</td>
        <td>车牌号</td>
        <td>进入时间</td>
    </tr>
    <c:forEach items="${parkrecordList1}" var="parkrecord">
        <tr>
            <td>${parkrecord.oId}</td>
            <td>${parkrecord.platenumber}</td>
            <td><fmt:formatDate value="${parkrecord.intime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
    </c:forEach>
</table>
        </div>
    </div>
</div>
</body>
</html>