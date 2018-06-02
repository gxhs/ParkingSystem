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

<form>

</form>


<center><h3>操作员</h3></center>
<div class="container" >
    <div class="row">
        <div class="col-sm-10">
<table class="table table-hover">
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
        <td colspan="4"><a href="${pageContext.request.contextPath }/WebContent/insertOperator.jsp" >增加</a></td>
    </tr>
</table>
        </div>
            </div>
</div>
</body>
</html>
