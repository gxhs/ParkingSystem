<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: GengXiaohu
  Date: 2018/4/27
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="10">
    <tr>
        <td>选择</td>
        <td>操作员编号</td>
        <td>车牌号</td>
        <td>进入时间</td>
        <td>出去时间</td>
        <td>总时间</td>
        <td>金额</td>
    </tr>
    <c:forEach items="${parkrecordAllList}" var="parkrecord">
    <tr>
        <td><input type="checkbox" name="prrkrecord_id" value="${parkrecord.id}"/></td>
        <td>${parkrecord.oId}</td>
        <td>${parkrecord.platenumber}</td>
        <td><fmt:formatDate value="${parkrecord.intime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td><fmt:formatDate value="${parkrecord.outtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td>${parkrecord.time}</td>
        <td>${parkrecord.money}</td>
        <td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id}">修改</a></td>
    </tr>
    </c:forEach>
</body>
</html>
