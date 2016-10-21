<%@ page contentType="text/html;charset=Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>CH7 - Core_import.jsp</title>
</head>
<body>

	<h2>
		<c:out value="import 的用法" />
	</h2>


	<c:set var="input1" value="使用屬性範圍傳到Core_imported.jsp中" scope="request" />	
	<hr />

	<c:import url="Core_imported.jsp" charEncoding="Big5">
		<c:param name="input2" value="使用param傳到Core_imported.jsp中" />
	</c:import>
	
	<hr />

	${output1}

</body>
</html>