<%@ page contentType="text/html;charset=Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title></title>
</head>
<body>

	<h2>
		<c:out value="redirect ���Ϊk" />
	</h2>

	<c:redirect url="http://java.sun.com">
		<c:param name="param" value="value" />
	</c:redirect>

	<c:out value="���|�����!!!" />

</body>
</html>