<%@ page contentType="text/html;charset=Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>CH7 - Core_catch.jsp</title>
</head>
<body>

	<h2>
		<c:out value="catch ���Ϊk" />
	</h2>

	<c:catch var="error_Message">
		<%
			String eFormat = "not number";
				int i = Integer.parseInt(eFormat);
		%>
	</c:catch>
	${error_Message}
</body>
</html>