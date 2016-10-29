<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR入门</title>

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test3.js'></script>
		
		<script type="text/javascript">
			function hello(){
				test3.hello(              //返回字符串数组
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
			<input type="button" value="测试DWR" onclick="hello()"/>
		</form>
	</body>
</html>
