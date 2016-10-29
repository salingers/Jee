<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<html>
  <head>
  
    <title>Login</title>
	<script type="text/javascript">
		function doDelete(){
			form1.action="manager.do?method=delete";
			form1.submit();
		}
	</script>
  </head>
  
  <body>
    <form name="form1" action="" method="post">
    	<input type="button" value="Delete" onclick=doDelete()>
    </form>
  </body>
</html>
