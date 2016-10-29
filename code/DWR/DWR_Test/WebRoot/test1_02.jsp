<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR»Î√≈</title>

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test1.js'></script>
		
		<script type="text/javascript">
			function hello(){
				test1.hello(
					function(data){
						alert(data);
					}
				);
			}
			
		</script>
	</head>

	<body>
		<form>
			<input type="button" value="≤‚ ‘DWR" onclick="hello()"/>
		</form>
	</body>
</html>
