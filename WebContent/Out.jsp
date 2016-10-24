<%@ page contentType="text/html;charset=Big5"%>

<html>
<head>
<title></title>
</head>
<body>


	BufferSize :
	<%=out.getBufferSize()%><br> Available :
	<%=out.getRemaining()%><br> Used :
	<%=out.getBufferSize() - out.getRemaining()%><br>

</body>
</html>