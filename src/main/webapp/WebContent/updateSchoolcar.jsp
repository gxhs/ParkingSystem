<%--
  Created by IntelliJ IDEA.
  User: GengXiaohu
  Date: 2018/5/4
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
<form action="${pageContext.request.contextPath }/schoolcar/update.action" method="post">
    <%--<input type="hidden" name="id" value="${operator.opNumber }"/>--%>
    <center><h3>修改商品信息：</h3></center>
        <div class="container" >
                <div class="row">
                <div class="col-sm-10">
                    <table class="table table-hover">
        <tr>
            <td>编号</td>
            <td><input type="text" name="id" value="${schoolcar1.id}"/></td>
        </tr>
        <tr>
            <td>车牌号</td>
            <td><input type="text" name="platenumber" value="${schoolcar1.platenumber}"/></td>
        </tr>
        <tr>
            <td>车主</td>
            <td><input type="text" name="name" value="${schoolcar1.name}"/></td>
        </tr>
        <tr>
            <td colspan="2" ><input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
                </div>
                </div>
        </div>
</form>
</body>
</html>
