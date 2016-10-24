<%@ page contentType="text/html;charset=Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title></title>
</head>
<body>


	<form name="Form" method="post" action="Hidden.jsp">
		<p>
			<input type="hidden" name="name" value="browser">
		</p>
		<p>
			<input type="hidden" name="number" value="1234">
		</p>

		<input type="submit" value="¶Ç°e">
	</form>
	<br> name¡G
	<font color="red">${param.name}</font>
	<br> number¡G
	<font color="red">${param.number}</font>
	<br>

	<c:url value="/CH7/HelloJSTL.jsp" var="myUrl">
		<c:param name="name" value="111" />
	</c:url>

	<a href='<c:out value="${myUrl}" />'>Click here</a>
	<br>


</body>
</html>
