<%@ page import="javax.servlet.jsp.JspFactory"
	contentType="text/html;charset=Big5"%>

<html>
<head>
<title></title>
</head>
<body>

	<h2>取得 JSP Container 版本 - JspFactory 物件</h2>

	<%
		JspFactory factory = JspFactory.getDefaultFactory();
	%>
	<%=factory.getEngineInfo().getSpecificationVersion()	%>


</body>
</html>