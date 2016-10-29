<%@page language="java" import="com.umt.vo.User,java.util.*" pageEncoding="GBK"%>
<html>
  <head>
    <title>success.html</title>

  </head>
  
  <body>
  <%
  		String username = (String)request.getAttribute("username");
  		
   %>
    <font color=red>¹§Ï²Äú£¡µÇÂ½³É¹¦£¡<%=username %></font>
    
    <%
    	User user = (User)request.getAttribute("user");
     %>
     
     id = <%=user.getId() %>
     <br>
     Name=<%=user.getName() %>
     <br>
     Pwd=<%=user.getPwd() %>
     <br>
     EmpId=<%=user.getEmpId() %>
     <br>
     
     <%
     	List users = (List)request.getAttribute("users");
      %>
      
      <table border="1" widht="80%" align="center">
      		<tr>
      			<th>Id</th>
      			<th>Name</th>
      			<th>Pwd</th>
      			<th>EmpId</th>
      		</tr>
      		<%
      			for(int i = 0; i < users.size(); i++){
      				User u = (User)users.get(i);
      		 %>
      		<tr>
      			<td><%=u.getId() %></td>
      			<td><%=u.getName() %></td>
      			<td><%=u.getPwd() %></td>
      			<td><%=u.getEmpId() %></td>
      		</tr>
      		
      		<%} %>
      </table>
  </body>
</html>
