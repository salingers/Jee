<%@ page contentType="text/html;charset=Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
</head>
<body>
	<h2>請登入 - 名稱：admin 密碼：1234</h2>

	<c:set var="passed" value="passing" scope="session" />

	<form method="post" action="/JSPBook/LoginChecker">
		<table>
			<tr>
				<th>使用者名稱：</th>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<th>使用者密碼：</th>
				<td><input type="password" name="password"></td>
			</tr>
			<th><input type="hidden" name="originalURI"
				value="${requestScope.originalURI}"></th>

			<tr>
				<th><input name="submit" type="submit" value="登入"></th>
			</tr>
		</table>
	</form>

</body>
</html>