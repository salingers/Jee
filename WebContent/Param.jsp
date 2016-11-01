<%@ page contentType="text/html;charset=big5" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <title>CH6 - Param.jsp</title>
</head>
<body>

  <h2>EL���t���� param�BparamValues</h2>
  
  <form method="post" action="Param.jsp">
		<p>
			�m�W�G<input type="text" name="username" size="15" />
		</p>
		<p>
			�K�X�G<input type="password" name="password" size="15" />
		</p>
		<p>
			�ʧO�G<input type="radio" name="sex" value="Male" checked />�k <input
				type="radio" name="sex" value="Female" /> �k
		</p>
		<p>
			�~�֡G<select name="old">
				<option value="10">10 - 20</option>
				<option value="20" selected>20 - 30</option>
				<option value="30">30 - 40</option>
				<option value="40">40 - 50</option>
			</select>
		</p>
		<p>
			����G<input type="checkbox" name="habit" value="Reading" />�ݮ� <input
				type="checkbox" name="habit" value="Game" />���q�� <input
				type="checkbox" name="habit" value="Travel" />�ȹC <input
				type="checkbox" name="habit" value="Music" />ť���� <input
				type="checkbox" name="habit" value="Tv" />�ݹq��
		</p>

		<p>
			<input type="submit" value="�ǰe" /> <input type="reset" value="�M��" />
		</p>
	</form>
	
  <fmt:requestEncoding value="Big5" />

  �m�W�G${param.username}</br>
  �K�X�G${param.password}</br>
  �ʧO�G${param.sex}</br>
  �~�֡G${param.old}</br>
  ����G${paramValues.habit[0]}
        ${paramValues.habit[1]}
    
</body>
</html>