<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<frameset rows="9%,*">
    <frame src="${pageContext.request.contextPath }/WebContent/adminTop.jsp" scrolling="No" noresize="noresize">
    </frame>
    <frameset cols="12%,*">
        <frame src="${pageContext.request.contextPath }/WebContent/adminleft.jsp" name="f1"/>
        </frame>
        <frame src="${pageContext.request.contextPath }/WebContent/rightMain.jsp" name="f2"/>
        </frame>
    </frameset>
</frameset>
</head>

<noframes>
    <body>
    </body>
</noframes>
</html>