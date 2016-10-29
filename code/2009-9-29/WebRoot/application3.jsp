<%
	String str = "Application scope";
	application.setAttribute("applicationStr",str);
%>

<%
	String msg = (String)application.getAttribute("applicationStr");
	
%>
In application3.jsp:<br>
applicationStr = <%=msg%>



