<%@ page import="javax.servlet.jsp.JspFactory"
	contentType="text/html;charset=Big5"%>

<html>
<head>
<title></title>
</head>
<body>

	<h2>���o JSP Container ���� - JspFactory ����</h2>

	<%
		JspFactory factory = JspFactory.getDefaultFactory();
	%>
	<%=factory.getEngineInfo().getSpecificationVersion()	%>


</body>
</html>