<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR����</title>

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
            //function(item) { return item.status=="1"?"����":"����"; }, 
            function(item) { 
               var editLink = document.createElement("a");
               editLink.setAttribute("href","edit.do?id="+item.id);
               editLink.innerHTML="�༭";
               return editLink; 
            }
        ];
			
			
		</script>
	</head>

	<body>
		<form>			
		
			��Ȩ��<input type="checkbox" name="hp1" userId="123" resourceSn="789" onclick="test()"/>
			<table id="mytable" border="1">
			
			<tr>
					<td>�û�ID</td>
					<td>�û�����</td>
					<td>����</td>
					<td>�༭</td>
			</tr>
			<tbody id="mybody">
			
			</tbody>
				
			</table>
		</form>
	</body>
</html>
