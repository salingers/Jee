<%@ page contentType="text/html;charset=Big5"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

</head>
<body>

	<fmt:requestEncoding value="Big5" />

	<form name="form1" action="Introspection.jsp" method="post">
		<p>
			姓名： <input type="text" name="name">
		</p>
		<p>
			編號： <input type="text" name="number">
		</p>
		<p>
			<input type="submit" value="傳送"> <input type="reset"
				value="取消">
		</p>
	</form>

	<jsp:useBean id="myBean" scope="page"
		class="tw.com.javaworld.SimpleBean" />
	<jsp:setProperty name="myBean" property="*" />

	姓名：<jsp:getProperty name="myBean" property="name" /><br> 
	編號：<jsp:getProperty
		name="myBean" property="number" />

</body>
</html>
