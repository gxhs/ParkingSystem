<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

根据车牌号查询
<form action="${pageContext.request.contextPath }/ps/selectByPlatenumber.action">
    <input type="text" name="platenumber">
    <input type="submit" value="提交">
</form>

停车记录
<table width="100%" border=1>
    <tr>
    </tr>
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
</table>
</body>
</html>

