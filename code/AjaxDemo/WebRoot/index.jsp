<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<script type="text/javascript">
	var xmlHttp;

	function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
	}

	function startRequest() {
		createXMLHttpRequest();
		xmlHttp.onreadystatechange = handleStateChange;
		xmlHttp.open("POST", "Ajax", true);
		xmlHttp.send(null);
	}

	function handleStateChange() {
		
		if (xmlHttp.readystate == 4) {
			if (xmlHttp.status == 200) {
				var table = document.getElementById("t1");
				var xmlDoc = xmlHttp.responseXML.getElementsByTagName("students");
				
				var students = xmlDoc[0].getElementsByTagName("student");
				var str = "";
				for(var i = 0; i < students.length; i++){
					var student = students[i];
					var id = student.getAttribute("id");
					//两种方式，都可以。
					
					var name = student.getElementsByTagName("name")[0].firstChild.data;	//获得文本节点的值
					var tel = student.getElementsByTagName("tel")[0].firstChild.nodeValue; //获得文本节点的值
					alert(id + " " + name + " " + tel);
					str = id + ";" + name + ";" + tel;
					addRow(table,str);
				}
			}
		}
	}
	
	//向指定目标表中插入指定的参数
	//table为目标表
	//params为参数：如1;yexu;123
	//参数用“；”进行分割
	function addRow(table,params){		
		var length = parseInt(table.rows.length);
		//获得参数数组，以“；”进行分割
		var param = params.split(";");
		alert(length);
		var tr = table.insertRow(length);
		
		for(var i = 0; i < param.length; i++){
		
			var td = tr.insertCell(i);
			td.innerHTML = param[i];
		}
		
	}
	//删除指定目标表中所有的行。
	//table为目标表
	
	function deleteRow(table){		
		var length = parseInt(table.rows.length);
		for(var i = length - 1; i > 0; i--)
		{
			table.deleteRow(i);
		}
	}
	
	function doSubmit(){
		var table = document.getElementById("t1");
		if(table.style.display == "none"){
			table.style.display = "block";
			startRequest();
		}else{
			table.style.display = "none";
			this.deleteRow(table);
		}
	}
</script>


	</head>


	<body>
		<form name="form1" action="#" method="post">
		<input type="text"/>
			<input type="button" value="简单请求" onclick="doSubmit()" />
			<input type="submit" value="提交" />
			<table id = "t1" border = 1 style = "display:none">
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>TEL</td>
				</tr>
			</table>
		</form>

	</body>
</html>
