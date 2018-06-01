<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <!-- 引入Bootstrap核心样式文件 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入jQuery核心js文件 -->
    <script src="js/jquery-1.11.3.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" >
    <div class="row">
        <div class="col-sm-10">
            <table class="table table-hover ">
    <tr>
        <td>操作员编号</td>
        <td>车牌号</td>
        <td>进入时间</td>
        <td>出去时间</td>
        <td>总时间</td>
        <td>金额</td>
    </tr>
    <c:forEach items="${parkrecordList}" var="prrkrecord">
        <tr>
            <td>${prrkrecord.oId}</td>
            <td>${prrkrecord.platenumber}</td>
            <td><fmt:formatDate value="${prrkrecord.intime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td><fmt:formatDate value="${prrkrecord.outtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${prrkrecord.time}</td>
            <td>${prrkrecord.money}</td>
        </tr>
    </c:forEach>
</table>
        </div>
    </div>
</div>
</body>
</html>