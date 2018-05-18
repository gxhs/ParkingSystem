<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="100%" border=1>
    <tr>
        <td>编号</td>
        <td>密码</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${operatorList }" var="operatorList">
        <tr>
            <td><input type="checkbox" name="items_id" value="${item.id}"/></td>
            <td>${operatorList.opNumber}</td>
            <td>${operatorList.password}</td>
            <td><a href="Webcontent/updateOperator.jsp?id=${operatorList.opNumber}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
