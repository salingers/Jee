<%@ page info="JSP 2.0 �޳N��U" contentType="text/html;charset=Big5"%>

<html>
<head>
<title>CH5 - PageInfo.jsp</title>
</head>
<body>


	Page Info =
	<%=((javax.servlet.jsp.HttpJspPage) page).getServletInfo()%>

</body>
</html>