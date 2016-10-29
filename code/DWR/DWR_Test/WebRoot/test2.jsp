<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR入门</title>

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test2.js'></script>
		
		<script type="text/javascript">
			function hello(){
				test2.hello("李四",20,              //向Java类传递参数“李四” 
					function (data){
						alert(data);
					}
				);		
			}
		</script>
	</head>

	<body>
		<form>
			<input type="button" value="测试DWR" onclick="hello()"/>
		</form>
	</body>
</html>
