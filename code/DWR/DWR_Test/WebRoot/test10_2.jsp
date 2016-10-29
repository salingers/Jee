<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR入门</title>

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test10.js'></script>
		
		<script type="text/javascript">
			
			function test(){
			
				test10.method2( function(data){
				alert(data);
				DWRUtil.removeAllRows("mybody");
				DWRUtil.addRows("mybody", data, cellFunctions);
				});
			}
			
		
        var cellFunctions = [ 
            function(item) { return item.id; }, 
            function(item) { return item.name; }, 
            function(item) { return item.age; }, 
            //function(item) { return item.status=="1"?"正常":"冻结"; }, 
            function(item) { 
               var editLink = document.createElement("a");
               editLink.setAttribute("href","edit.do?id="+item.id);
               editLink.innerHTML="编辑";
               return editLink; 
            }
        ];
			
			
		</script>
	</head>

	<body>
		<form>			
		
			授权：<input type="checkbox" name="hp1" userId="123" resourceSn="789" onclick="test()"/>
			<table id="mytable" border="1">
			
			<tr>
					<td>用户ID</td>
					<td>用户姓名</td>
					<td>年龄</td>
					<td>编辑</td>
			</tr>
			<tbody id="mybody">
			
			</tbody>
				
			</table>
		</form>
	</body>
</html>
