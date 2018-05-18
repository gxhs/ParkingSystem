<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>出校</h1>
<form action="${pageContext.request.contextPath }/ps/outSchool.action " method="post">
	<input type="text" name="platenumber" >
	<input type="submit" value="出校"/>
</form>
</body>
</html>