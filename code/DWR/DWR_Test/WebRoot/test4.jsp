<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR»Î√≈</title>

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test4.js'></script>
		
		<script type="text/javascript">
			function hello(){
				test4.hello(              //∑µªÿList
				
					function (datas){
						for(var i = 0; i < datas.length; i++){
							alert(datas[i]);
						}
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
