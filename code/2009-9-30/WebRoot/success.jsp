<%@page language="java" import="com.umt.vo.User,java.util.*" pageEncoding="GBK"%>
<html>
  <head>
    <title>success.html</title>

	<script type="text/javascript">
		function doDelete(id){
			form1.action = "LoginServlet?method=delete&id=" + id;
			form1.submit();
		}
		
		function doUpdate(id){
			form1.action = "LoginServlet?method=toUpdate&id=" + id;
			form1.submit();
		}
	</script>
  </head>
  
  <body>
  <form name="form1" action="" method="post">
  <%
  		String username = (String)session.getAttribute("username");
  		
   %>
    <font color=red>��ϲ������½�ɹ���<%=username %></font>
    
   
     
     <%
     	List<User> users = (List)request.getAttribute("users");
      %>
      
      <table border="1" width="80%" align="center">
      		<tr>
      			<th>Id</th>
      			<th>Name</th>
      			<th>Pwd</th>
      			<th>EmpId</th>
      			<th>����</th>
      		</tr>
      		<%
      			if(users != null){
      			for(int i = 0; i < users.size(); i++){
      				User u = users.get(i);
      		 %>
      		<tr>
      			<td><%=u.getId() %></td>
      			<td><%=u.getName() %></td>
      			<td><%=u.getPwd() %></td>
      			<td><%=u.getEmpId() %></td>
      			<td><a href="#" onclick="doDelete(<%=u.getId() %>)">ɾ��</a>
      				<a href="#" onclick="doUpdate(<%=u.getId() %>)">�޸�</a>
      			</td>
      		</tr>
      		
      		<%} }else{
      			out.write("<font color=red>���ݿ������޼�¼</font>");
      		}%>
      </table>
     </form>
  </body>
</html>
