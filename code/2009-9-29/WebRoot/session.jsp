<%
	String str = "Session scope";
	session.setAttribute("sessionStr",str);
%>

<%
	String msg = (String)session.getAttribute("sessionStr");
	
%>

sessionStr = <%=msg%>
<jsp:forward page="session2.jsp"></jsp:forward>


