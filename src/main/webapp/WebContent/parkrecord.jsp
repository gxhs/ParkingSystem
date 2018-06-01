<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入jQuery核心js文件 -->
    <script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</head>
<body>
<center>根据车牌号查询</center>
<center><form action="${pageContext.request.contextPath }/ps/selectByPlatenumber.action">
    <input type="text" name="platenumber">
    <input type="submit" value="提交">
</form>
</center>
<center>停车记录</center>
<%--总行数${pageParams.totalPage}--%>
<div class="container">
    <div class="row">
        <div class="col-sm-10">
<table class="table table-hover ">
    <tr>
        <td>选择</td>
        <td>编号</td>
        <td>操作员</td>
        <td>车牌号</td>
        <td>入校时间</td>
        <td>出校时间</td>
        <td>总时间</td>
        <td>金额</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${parkrecordList}" var="parkrecordList">
        <tr>
            <td><input type="checkbox" name="parkrecordList" value="${parkrecordList.id}"/></td>
            <td>${parkrecordList.id}</td>
            <td>${parkrecordList.oId}</td>
            <td>${parkrecordList.platenumber}</td>
            <td><fmt:formatDate value="${parkrecordList.intime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td><fmt:formatDate value="${parkrecordList.outtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${parkrecordList.time}</td>
            <td>${parkrecordList.money}</td>
            <td>
                <a href="${pageContext.request.contextPath }/ps/deletedById?id=${parkrecordList.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr align="center">
        <td colspan="9">
            <a href="${pageContext.request.contextPath }/ps/showAllList/${page-1}" target="f2">上一页</a>
            <a href="${pageContext.request.contextPath }/ps/showAllList/${page+1}" target="f2">下一页</a>
        </td>
    </tr>
</table>
    </div>
    </div>
</div>
<form action="${pageContext.request.contextPath }/ps/download" method="get">
    <center><input type="submit" value="下载"></center>
</form>
</body>
</html>

