<%@ page contentType="text/html;charset=Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title></title>
</head>
<body>

	<h2>
		<c:out value="import ���Ϊk" />
	</h2>


	<c:set var="input1" value="�ϥ��ݩʽd��Ǩ�Core_imported.jsp��" scope="request" />	
	<hr />

	<c:import url="imported.jsp" charEncoding="Big5">
		<c:param name="input2" value="�ϥ�param�Ǩ�Core_imported.jsp��" />
	</c:import>
	
	<hr />

	${output1}

</body>
</html>