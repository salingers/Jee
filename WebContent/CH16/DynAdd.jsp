<%@ page contentType="text/html;charset=Big5"%>
<%@ taglib prefix="JSPBook" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>CH16 - DynAdd.jsp</title>
</head>
<body>

	<h2>Tag File �d��</h2>

	<JSPBook:DynAdd num1="111" num2="222" num3="444">

		<jsp:attribute name="great">
		<font color="red">SUM�G${sum} ...</red>
		
		</jsp:attribute>

		<jsp:attribute name="less">
		<font color="blue">SUM�G${sum} ...</red>		
		
		</jsp:attribute>
	</JSPBook:DynAdd>

</body>
</html>