<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>XmlHttpRequest Demo</title>
<script type="text/javascript" language="javascript">
	var req;

	function creatReq() // 建立xmlhttprequest
	{
		var url = "ajaxserver.jsp";

		if (window.XMLHttpRequest)
		{
			req = new XMLHttpRequest();
		}
		else
		{
			alert("你的瀏覽器是古代的，換一個吧！");
		}

		if (req)
		{
			req.onreadystatechange = callback; //指定回調函數
			
			req.open("GET", url, true); //與服務端建立連線(請求模式post或get，位址,true表示異步)
			req.send(null);
			

		}
	}

	function callback()
	{
		if (req.readyState == 4) //請求狀態為4表示成功
		{
			if (req.status == 200)
			{
				Dispaly(); //顯示資料
			}
			else
			{
				alert("服務端傳回狀態" + req.statusText);
			}
		}
		else
		{
			document.getElementById("myTime").innerHTML = "資料載入中";
		}
	}

	function Dispaly()
	{
		document.getElementById("myTime").innerHTML = req.responseText;
	}
</script>
</head>
<body>
	<div id="myTime"></div>

	<input id="Button1" type="button" value="時間" onclick="creatReq();" />
	
</body>
</html>