<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
 <style>
      	body{
	         margin:0px;
}
      </style>   
	<body>
	<table border="0"  width="100%" height="59"
	 cellpadding="0" cellspacing="0" bgcolor="azure">
	 
		<tr>
			<td background="${pageContext.request.contextPath }/img/lg.jpg" width="557"></td>
		    <td> <a href="${pageContext.request.contextPath }/WebContent/index.jsp" target="_black"style="text-decoration: none">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;退出系统 </a> <c:if test="${!empty admin}">
		                            管理员：   ${admin.username}
		    </c:if></td>
		    
		</tr>
		
	</table>
	</body>

</html>