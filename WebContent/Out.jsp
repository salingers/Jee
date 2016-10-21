<%@ page contentType="text/html;charset=Big5" %>

<html>
<head>
  <title>CH5 - Out.jsp</title>
</head>
<body>

<h2>javax.servlet.jsp.JspWriter - out клеє</h2>

BufferSize : <%= out.getBufferSize() %><br>
Available : <%= out.getRemaining() %><br>
Used : <%=  out.getBufferSize() -  out.getRemaining()%><br>

</body>
</html>