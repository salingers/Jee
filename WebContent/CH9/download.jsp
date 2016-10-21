<%@ page import="com.jspsmart.upload.*"%>
<%@ page contentType="text/html;charset=MS950"%>

<html>
<head>
<title>CH9 - download.jsp</title>
</head>
<body>


	<jsp:useBean id="mySmartUpload" scope="page"
		class="com.jspsmart.upload.SmartUpload" />

	<%
		// SmartUpload之初始化
		mySmartUpload.initialize(pageContext);

		//必須如此宣告，否則將會把檔案顯示於瀏覽器中
		mySmartUpload.setContentDisposition("inline;");

		//將 sample.zip下載，下載預設名稱為downloaded.zip
		mySmartUpload.downloadFile("C:\\upload\\sample.zip", "application/x-zip-compressed", "downloaded.zip");
	%>

</body>
</html>