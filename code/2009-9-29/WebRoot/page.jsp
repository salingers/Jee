<%
	String str = "page scope";
	pageContext.setAttribute("pageStr",str);
%>

<%
	String msg = (String)pageContext.getAttribute("pageStr");
	
%>

pageStr = <%=msg%>

<jsp:forward page="page2.jsp"></jsp:forward>