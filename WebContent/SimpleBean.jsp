<%@ page contentType="text/html;charset=Big5"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

</head>
<body>

	<fmt:requestEncoding value="Big5" />

	<form name="form1" action="Introspection.jsp" method="post">
		<p>
			�m�W�G <input type="text" name="name">
		</p>
		<p>
			�s���G <input type="text" name="number">
		</p>
		<p>
			<input type="submit" value="�ǰe"> <input type="reset"
				value="����">
		</p>
	</form>

	<jsp:useBean id="myBean" scope="page"
		class="tw.com.javaworld.SimpleBean" />
	<jsp:setProperty name="myBean" property="*" />

	�m�W�G<jsp:getProperty name="myBean" property="name" /><br> 
	�s���G<jsp:getProperty
		name="myBean" property="number" />

</body>
</html>
