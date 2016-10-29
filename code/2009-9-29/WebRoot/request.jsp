<%
	String str = "Request scope";
	request.setAttribute("requestStr",str);
%>

<%
	String msg = (String)request.getAttribute("requestStr");
	
%>

requestStr = <%=msg%>
<jsp:forward page="request2.jsp"></jsp:forward>

