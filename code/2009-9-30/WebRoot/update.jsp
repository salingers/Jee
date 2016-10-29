<%@page language="java" import="com.umt.vo.User,java.util.*" pageEncoding="GBK"%>
<html>
  <head>
    <title>success.html</title>

	<script type="text/javascript">
		
		function doUpdate(){
			form1.action = "LoginServlet?method=update";
			form1.submit();
		}
		
		function doReset(){
			form1.reset();
		}
	</script>
  </head>
  
  <body>
  <form name="form1" action="" method="post">
 
      <table border="1" width="80%" align="center">
      		<tr>
      			<th colspan="2">
      				修改用户信息
      			</th>
      		</tr>
      		<%
      			User user = (User)request.getAttribute("user");
      			if(user != null){
      		 %>
      		<tr>
      			<th>Id</th>
      			<td><input type="text" name="id" value="<%=user.getId() %>" readonly/></td>
      		</tr>
      		<tr>
      			<th>Name</th>
      			<td><input type="text" name="name" value="<%=user.getName() %>" /></td>
      		</tr>
      		<tr>
      			<th>Pwd</th>
      			<td><input type="text" name="pwd" value="<%=user.getPwd() %>" /></td>
      		</tr>
      		<tr>
      			<th>EmpId</th>
      			<td><input type="text" name="empId" value="<%=user.getEmpId() %>" /></td>
      		</tr>
      			
      		<tr>
      			<td colspan="2" align="center"><input type="button" value="修改" onclick="doUpdate()"/>
      				<input type="button" value="重置" onclick="doReset()"/>
      			</td>
      		</tr>
      		<%} %>
      </table>
     </form>
  </body>
</html>
