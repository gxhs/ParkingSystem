<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form>

</form>


操作员
<table width="100%" border=1>
    <tr>
        <td>选择</td>
        <td>编号</td>
        <td>密码</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${operatorList }" var="operatorList">
        <tr>
            <td><input type="checkbox" name="operatorNumber" value="${operatorList.opNumber}"/></td>
            <td>${operatorList.opNumber}</td>
            <td>${operatorList.password}</td>
            <td>
                <a href="${pageContext.request.contextPath }/operator/selectByNumber.action?id=${operatorList.opNumber}">修改</a>
                <a href="${pageContext.request.contextPath }/operator/delete.action?id=${operatorList.opNumber}">删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="${pageContext.request.contextPath }//WebContent/insertOperator.jsp" >增加</a></td>
    </tr>
</table>
</body>
</html>
