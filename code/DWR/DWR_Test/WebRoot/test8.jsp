<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR����</title>

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test8.js'></script>
		
		<script type="text/javascript">
			function hello(r){
				test8.addOrUpdatePermission(
					r.userId,
					r.resourceSn,
					r.checked
				);
			}
			
			function test(){
				test8.addOrUpdatePermission(
					$("hp").userId,
					$("hp").resourceSn,
					$("hp").checked
				);
			}
			
			
		</script>
	</head>

	<body>
		<form>			
			��Ȩ��<input type="checkbox" name="hp1" userId="123" resourceSn="789" onclick="hello(this)"/>
			��Ȩ2��<input type="checkbox" name="hp" userId="222" resourceSn="111" onclick="test()"/>
		</form>
	</body>
</html>
