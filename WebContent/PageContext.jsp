<%@ page import="java.util.Enumeration"
	contentType="text/html;charset=Big5"%>

<html>
<head>
<title>CH5 - PageContext.jsp</title>
</head>
<body>

	<h2>javax.servlet.jsp.PageContext - pageContext ª«¥ó</h2>

	<%
		Enumeration e = pageContext.getAttributeNamesInScope(PageContext.APPLICATION_SCOPE);

		while (e.hasMoreElements())
		{
			out.println("application attribute¡G" + e.nextElement() + "<br>");
		}
	%>



	<%
		pageContext.setAttribute("Name", "mike");
		pageContext.setAttribute("Password", "browser");

		String Name = (String) pageContext.getAttribute("Name");
		String Password = (String) pageContext.getAttribute("Password");

		out.println("Name = " + Name);
		out.println("Password = " + Password);
	%>


	\${pageContext.request.queryString}¡G${pageContext.request.queryString}
	</br> \${pageContext.request.requestURL}¡G${pageContext.request.requestURL}
	</br> \${pageContext.request.contextPath}¡G${pageContext.request.contextPath}
	</br> \${pageContext.request.method}¡G${pageContext.request.method}
	</br> \${pageContext.request.protocol}¡G${pageContext.request.protocol}
	</br> \${pageContext.request.remoteUser}¡G${pageContext.request.remoteUser}
	</br> \${pageContext.request.remoteAddr }¡G${pageContext.request.remoteAddr}
	</br> \${pageContext.session.id}¡G${pageContext.session.id}
	</br>

</body>
</html>