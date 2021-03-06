<%@ page contentType="text/html;charset=big5" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <title>CH6 - Param.jsp</title>
</head>
<body>

  <h2>EL隱含物件 param、paramValues</h2>
  
  <form method="post" action="Param.jsp">
		<p>
			姓名：<input type="text" name="username" size="15" />
		</p>
		<p>
			密碼：<input type="password" name="password" size="15" />
		</p>
		<p>
			性別：<input type="radio" name="sex" value="Male" checked />男 <input
				type="radio" name="sex" value="Female" /> 女
		</p>
		<p>
			年齡：<select name="old">
				<option value="10">10 - 20</option>
				<option value="20" selected>20 - 30</option>
				<option value="30">30 - 40</option>
				<option value="40">40 - 50</option>
			</select>
		</p>
		<p>
			興趣：<input type="checkbox" name="habit" value="Reading" />看書 <input
				type="checkbox" name="habit" value="Game" />打電動 <input
				type="checkbox" name="habit" value="Travel" />旅遊 <input
				type="checkbox" name="habit" value="Music" />聽音樂 <input
				type="checkbox" name="habit" value="Tv" />看電視
		</p>

		<p>
			<input type="submit" value="傳送" /> <input type="reset" value="清除" />
		</p>
	</form>
	
  <fmt:requestEncoding value="Big5" />

  姓名：${param.username}</br>
  密碼：${param.password}</br>
  性別：${param.sex}</br>
  年齡：${param.old}</br>
  興趣：${paramValues.habit[0]}
        ${paramValues.habit[1]}
    
</body>
</html>