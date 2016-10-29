<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR入门</title>

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test5.js'></script>
		
		<script type="text/javascript">
			function hello(){
				test5.hello(              //返回字符串数组
					function (datas){
						alert(datas.key1);
						
						alert(datas["key2"]);
					}
				);		
			}
			
			function hello2(){
				test5.hello(              //返回字符串数组
					function (datas){
						for(var prop in datas){
							alert("key = " + prop + ",value = " + datas[prop]);
						}
					}
				);		
			}
		</script>
	</head>

	<body>
		<form>
			<input type="button" value="测试DWR1" onclick="hello()"/>
			<input type="button" value="测试DWR2" onclick="hello2()"/>
		</form>
	</body>
</html>
