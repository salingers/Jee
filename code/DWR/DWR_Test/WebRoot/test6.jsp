<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR����</title>

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test6.js'></script>
		
		<script type="text/javascript">
			function hello(){
				test6.hello(              //�����ַ�������
					function (datas){
						for(var i = 0; i < datas.length; i++){
							for(var j = 0; j < datas[i].length; j++){
								alert(datas[i][j]);
							}
						}
					}
				);		
			}
			
			
		</script>
	</head>

	<body>
		<form>
			<input type="button" value="����DWR1" onclick="hello()"/>
		</form>
	</body>
</html>
