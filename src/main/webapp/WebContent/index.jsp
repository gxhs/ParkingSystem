<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="UTF-8">
		<title>后台模板测试</title>
		<frameset rows="9%,*">
			<frame src="${pageContext.request.contextPath }/WebContent/indexTop.jsp" scrolling="No" noresize="noresize"  ></frame>
			<frame src="${pageContext.request.contextPath }/WebContent/admin.jsp" name="f1">   </frame>
			</frameset>
		</frameset>
	</head>
	<body>
	</body>
</html>
