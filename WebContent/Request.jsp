<%@ page language="java" contentType="text/html;charset=Big5" %>
<html>
<head>
  <title>CH5 - Request.jsp</title>
</head>
<body>

<h2>javax.servlet.http.HttpServletRequest �����Ҵ��Ѫ���k</h2>


	<form action="Request.jsp" method="Get">
		Name�G<input type="text" name="Name" size="20" maxlength="20"><br>
		Number�G<input type="text" name="Number" size="20" maxlength="20"><br>
		<br> <input type="submit" value="�ǰe">
	</form>

getParameter("Name")�G<%= request.getParameter("Name") %><br>
getParameter("Number")�G<%= request.getParameter("Number") %><br>
getAttribute("Name")�G<%= request.getAttribute("Name") %><br>
getAttribute("Number")�G<%= request.getAttribute("Number") %><br><br>

getAuthType( )�G<%= request.getAuthType() %><br>
getProtocol( )�G<%= request.getProtocol() %><br>
getMethod( )�G<%= request.getMethod() %><br>
getScheme( )�G<%= request.getScheme() %><br>
getContentType( )�G<%= request.getContentType() %><br>
getContentLength( )�G<%= request.getContentLength() %><br>
getCharacterEncoding( )�G<%= request.getCharacterEncoding() %><br>
getRequestedSessionId( )�G<%= request.getRequestedSessionId() %><br><br>

getContextPath( )�G<%= request.getContextPath() %><br>	
getServletPath( )�G<%= request.getServletPath() %><br> 
getPathInfo( )�G<%= request.getPathInfo() %><br>
getRequestURI( )�G<%= request.getRequestURI() %><br>
getQueryString( )�G<%= request.getQueryString() %><br><br>

getRemoteAddr( )�G<%= request.getRemoteAddr() %><br>
getRemoteHost( )�G<%= request.getRemoteHost() %><br>
getRemoteUser( )�G<%= request.getRemoteUser() %><br>
getRemotePort( )�G<%= request.getRemotePort() %><br>
getServerName( )�G<%= request.getServerName() %><br>
getServerPort( )�G<%= request.getServerPort() %><br>

</body>
</html>
