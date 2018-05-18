<%--
  Created by IntelliJ IDEA.
  User: GengXiaohu
  Date: 2018/5/4
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/operator/insert.action" method="post">
    <%--<input type="hidden" name="id" value="${operator.opNumber }"/>--%>
    增加操作员：
    <table width="100%" border=1>
        <tr>
            <td>编号</td>
            <td><input type="text" name="opNumber"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
