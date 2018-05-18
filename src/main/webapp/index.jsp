<%--
  Created by IntelliJ IDEA.
  User: GengXiaohu
  Date: 2018/4/22
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>登录</h1>
<form action="${pageContext.request.contextPath }/operator/login.action " method="post">
    <input type="text" name="opNumber" >
    <input type="password" name="password">
    <input type="submit" value="登陆"/>
</form>
</body>
</html>
