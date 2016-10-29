<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR入门</title>

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test9.js'></script>
		
		<script type="text/javascript">
			
			function test(){
			
				dwr.engine.setAsync(false);		//设置为同步，那么就先调用method1（），在执行method2（）；否则不确定
				test9.method1(
					function(data){
						alert(data);
					}
				);
				test9.method2(
					function(data){
						alert(data);
					}
				);	//测试异步通信，method1（）和method2（）执行的先后顺序的不固定的。
			}
			
			
		</script>
	</head>

	<body>
		<form>			
			授权：<input type="checkbox" name="hp1" userId="123" resourceSn="789" onclick="test()"/>
		</form>
	</body>
</html>
