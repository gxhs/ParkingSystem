<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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