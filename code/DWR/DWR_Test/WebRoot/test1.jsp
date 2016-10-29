<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR»Î√≈</title>

		<script type='text/javascript' src='<%=request.getContextPath() %>/dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test1.js'></script>
		
		<script type="text/javascript">
			function hello2(){
				test1.hello(returnHello);
			}
			
			function returnHello(value){
				alert(value);
			}
		</script>
	</head>

	<body>
		<form>
			<input type="button" value="≤‚ ‘DWR" onclick="hello2()"/>
		</form>
	</body>
</html>
