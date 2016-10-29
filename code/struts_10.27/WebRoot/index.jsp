<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登陆成功</title>
	
  </head>
  
  <body>
    登陆成功！！
    <bean:write name="msg"/><br>
    登陆时间：<bean:write name="time" format="yyyy/MM/dd hh:mm:ss" scope="request"/><br>
    Student:<br>
    stuNo:<bean:write name="stu" property="stuNo"/><br>
    stuName:<bean:write name="stu" property="stuName"/><br>    
    Dept:<bean:write name="stu" property="dept.deptName" /><br>
    
    
    <logic:notEmpty name="students">
    	 <logic:iterate id="student" name="students">
		    stuNo:<bean:write name="student" property="stuNo"/><br>
		    stuName:<bean:write name="student" property="stuName"/><br>    
		    Dept:<bean:write name="student" property="dept.deptName" /><br>
		    
		    ========================================================<br>
    	</logic:iterate>
    </logic:notEmpty>
    
   
    
   
  </body>
</html>
