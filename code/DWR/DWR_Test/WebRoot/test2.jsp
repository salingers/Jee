<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR����</title>

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test2.js'></script>
		
		<script type="text/javascript">
			function hello(){
				test2.hello("����",20,              //��Java�ഫ�ݲ��������ġ� 
					function (data){
						alert(data);
					}
				);		
			}
		</script>
	</head>

	<body>
		<form>
			<input type="button" value="����DWR" onclick="hello()"/>
		</form>
	</body>
</html>
