<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

校内车辆信息
<table width="100%" border=1>
    <tr>
        <td>选择</td>
        <td>编号</td>
        <td>车牌号</td>
        <td>车主</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${schoolcarList }" var="schoolcarList">
        <tr>
            <td><input type="checkbox" name="platenumber" value="${schoolcarList.id}"/></td>
            <td>${schoolcarList.id}</td>
            <td>${schoolcarList.platenumber}</td>
            <td>${schoolcarList.name}</td>
            <td>
                <a href="${pageContext.request.contextPath }/schoolcar/selectByid.action?id=${schoolcarList.id}">修改</a>
                <a href="${pageContext.request.contextPath }/schoolcar/delete.action?id=${schoolcarList.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="${pageContext.request.contextPath }//WebContent/insertSchoolcar.jsp" >增加</a></td>
    </tr>
</table>
</body>
</html>
