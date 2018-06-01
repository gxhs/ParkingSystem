<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <!--声明文档兼容模式，表示使用IE浏览器的最新模式-->

    <title>登录管理员</title>
    <!-- 引入Bootstrap核心样式文件 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入jQuery核心js文件 -->
    <script src="js/jquery-1.11.3.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body background="img/login.jpg">

<form class="form-horizontal" style="margin-top: 200px; margin-left: 251px;" action="${pageContext.request.contextPath }/admin/login.action">
    <div class="form-group">
        <label for="username" class="col-sm-6 control-label" style="color: white">用户名</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="username"
                   placeholder="请输入用户名" name="name"
                   onblur="checkusername(this.value)" onfocus="clearError()"/>
            <span id="usernameerror"></span>
        </div>
    </div>

    <div class="form-group">
        <label for="password" class="col-sm-6 control-label" style="color: white">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
        <div class="col-sm-3">
            <input type="password" class="form-control" id="password" placeholder="请输入密码"
                   name="password" onblur="checkpsw(this.value)" onfocus="clearpswerror()"/>
            <span id="passworderror"></span>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-6 col-sm-6">
            <button type="submit" class="btn btn-default">提交</button>
        </div>
    </div>

</form>
</div>

</body>
</html>
