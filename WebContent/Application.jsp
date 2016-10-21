<%@ page contentType="text/html;charset=Big5"%>

<html>
<head>
<title>CH5 - Page1.jsp</title>
</head>
<body>

	</br>
	<%
		application.setAttribute("Name", "mike");
		application.setAttribute("Password", "browser");

		String Name = (String) application.getAttribute("Name");
		String Password = (String) application.getAttribute("Password");
	%>


</body>
</html>