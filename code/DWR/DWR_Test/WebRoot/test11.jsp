<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR入门</title>

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test11.js'></script>
		
		<script type="text/javascript">
			
			function test(){
			
				test11.getCurrentPerssions( function(data){
					for(var i = 0; i < data.length; i++){
						var num = data[i];
						alert(num);
						
						$("checkbox_" + num).checked = true;
					}
				});
			}
	
			
		</script>
	</head>

	<body onload="test()">
		<form>			
		
			<table border="0" width="80%" align="center">
			
				<tr>
					<td>投保</td>
					<td></td>
					<td>
						<input type="checkbox" value="101" id="checkbox_101"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>新建投保信息</td>
					<td>
						<input type="checkbox" value="1011" id="checkbox_1011"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>查看投保信息</td>
					<td>
						<input type="checkbox" value="1012" id="checkbox_1012"/>
					</td>
				</tr>
				
				
				<tr>
					<td>索赔</td>
					<td></td>
					<td>
						<input type="checkbox" value="102" id="checkbox_102"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>新建索赔信息</td>
					<td>
						<input type="checkbox" value="1021" id="checkbox_1021"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>查看索赔信息</td>
					<td>
						<input type="checkbox" value="1022" id="checkbox_1022"/>
					</td>
				</tr>
				
			</table>
		</form>
	</body>
</html>
