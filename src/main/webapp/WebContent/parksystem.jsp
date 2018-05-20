<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/parksystem/update" method="post">
    编号
    <input type="text" name="id" value="${parksystem.id}">
    金额
    <input type="text" name="feesscale" value="${parksystem.feesscale}">
    <input type="submit" value="修改">
</form>
</body>
</html>
