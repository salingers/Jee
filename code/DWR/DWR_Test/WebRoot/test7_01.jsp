<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR����</title>

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test7.js'></script>
		
		<script type="text/javascript">
			function hello(){
				test7.hasPermission(
					$("name").value,
					$("permission").value,
					function(data){
						$("hp").checked = data;
					}
				);
			}
			
			
		</script>
	</head>

	<body>
		<form>
			name:<input type="text" name="name" value=""/><br>
			permission:<input type="text" name="permission" value=""/><br>
			<input type="button" value="�����û��Ƿ���Ȩ��" onclick="hello()"/><br>
			<input type="checkbox" name="hp"/>ӵ��Ȩ��
		</form>
	</body>
</html>
