<%@ page contentType="text/html;Big5"%>
<%@ page import="java.util.*"%>
<%@ page import="tw.com.javaworld.CH10.*"%>

<%
	UserList userlist = UserList.getInstance();
%>
<jsp:useBean id="usertrace" class="tw.com.javaworld.CH10.UserTrace"
	scope="session" />
<%
	String user_id = request.getParameter("user_id");

	usertrace.setUserName(user_id);

	session.setAttribute("usertrace", usertrace);

	userlist.addUser(usertrace.getUserName());

	session.setMaxInactiveInterval(10);
%>

<html>
<head>
<meta http-equiv="refresh" content=60>
<title>CH10 - UserList.jsp</title>
</head>
<body>


	<form method="POST" action="UserList.jsp">

		<p>
			請輸入使用者ID：<input type="text" name="user_id">
		</p>
		<p>
			<input type="submit" value="登入">
		</p>

	</form>

	<center>
		<p>
			<textarea rows="9" cols="15">
<%
	Enumeration elements = userlist.getList();

	while (elements.hasMoreElements())
	{
		String name = (String) elements.nextElement();
		out.println(name);
	}
%>
</textarea>
		</p>
	</center>
</body>
</html>