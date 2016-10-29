
<%
	String msg = (String)session.getAttribute("sessionStr");
	
%>
In session2.jsp:<br>
sessionStr = <%=msg%>
<br>
<a href="session3.jsp">session3.jsp</a>


