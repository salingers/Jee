<%@ page contentType="text/html;charset=Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
</head>
<body>
	<h2>�еn�J - �W�١Gadmin �K�X�G1234</h2>

	<c:set var="passed" value="passing" scope="session" />

	<form method="post" action="/JSPBook/LoginChecker">
		<table>
			<tr>
				<th>�ϥΪ̦W�١G</th>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<th>�ϥΪ̱K�X�G</th>
				<td><input type="password" name="password"></td>
			</tr>
			<th><input type="hidden" name="originalURI"
				value="${requestScope.originalURI}"></th>

			<tr>
				<th><input name="submit" type="submit" value="�n�J"></th>
			</tr>
		</table>
	</form>

</body>
</html>