<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<script type="text/javascript">
<!--
	function doSubmit(){
		var username = document.forms[0].username.value;
		alert(username);
	}
//-->
</script>
 
<html> 
	<head>
		<title>JSP for LoignForm form</title>
	</head>
	<body>
		<html:form action="/loign?method=login" method="post">
			username : <html:text property="username"/><html:errors property="username"/><br/>
			pwd : <html:password property="pwd"/><html:errors property="pwd"/><br/>
			<html:submit onclick="doSubmit()"/><html:cancel/>
		</html:form>
		
		
	</body>
</html>

