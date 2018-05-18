<%--
  Created by IntelliJ IDEA.
  User: GengXiaohu
  Date: 2018/4/24
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>进校</h1>
<form action="${pageContext.request.contextPath }/ps/inSchool.action " method="post">
    <input type="text" name="platenumber" >
    <input type="submit" value="入校"/>
</form>
<h1>出校</h1>
<form action="${pageContext.request.contextPath }/ps/outSchool.action " method="post">
    <input type="text" name="platenumber" >
    <input type="submit" value="出校"/>
</form>
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
<c:forEach items="${parkrecordList}" var="prrkrecord">
    <tr>
        <td><input type="checkbox" name="prrkrecord_id" value="${prrkrecord.id}"/></td>
        <td>${prrkrecord.oId}</td>
        <td>${prrkrecord.platenumber}</td>
        <td><fmt:formatDate value="${prrkrecord.intime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td><fmt:formatDate value="${prrkrecord.outtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td>${prrkrecord.time}</td>
        <td>${prrkrecord.money}</td>
        <%--<td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id}">修改</a></td>--%>
    </tr>
</c:forEach>
</table>
</body>
</html>
