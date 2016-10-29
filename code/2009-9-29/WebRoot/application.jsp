<%
	String str = "Application scope";
	application.setAttribute("applicationStr",str);
%>

<%
	String msg = (String)application.getAttribute("applicationStr");
	
%>

applicationStr = <%=msg%>
<jsp:forward page="application2.jsp"></jsp:forward>



