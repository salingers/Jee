<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR����</title>

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test3.js'></script>
		
		<script type="text/javascript">
			function hello(){
				test3.hello(              //�����ַ�������
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
			<input type="button" value="����DWR" onclick="hello()"/>
		</form>
	</body>
</html>
