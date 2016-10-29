<%
	String str = "Application scope";
	application.setAttribute("applicationStr",str);
%>

<%
	String msg = (String)application.getAttribute("applicationStr");
	
%>
In application2.jsp:<br>
applicationStr = <%=msg%>

<a href="application3.jsp">application3.jsp</a>



