<%@ page language="java" import="java.util.*,com.umt.vo.*" pageEncoding="GBK"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body> 
  
  <!-- c:out  start -->
  =========================================c:out  start==================================================<br>
    <%
    	String str = "Hello JSTL";
    	request.setAttribute("str_request",str);
     %>
    
      str_request = <c:out value="${str_request}"/>
      
      <%
      	String str_session = "Session Msg";
      	session.setAttribute("str_session",str_session);
       %>
       
       <br>
       str_session =  <c:out value="${str_session}"></c:out>
       
       
       <br>
       <%
       		String str2 = "request Msg";
       		String str3 = "session Msg";
       		String str4 = "application Msg";
       		request.setAttribute("str",str2);
       		session.setAttribute("str",str3);
       		application.setAttribute("str",str4);
        %>
        
       Msg = <c:out value="${sessionScope.str}" ></c:out><br>
       request  Msg = <c:out value="${requestScope.str}" ></c:out><br>
        application  Msg = <c:out value="${applicationScope.str}" ></c:out><br>
       null Msg = <c:out value="${ss}" default="null Msg"></c:out>
       
       <%
       		Student stu = new Student(1,"yexu","18");
       		request.setAttribute("stu",stu);
        %>
        <br>
        NUM:<c:out value="${stu.num}"/><br>
        NAME:<c:out value="${stu.stuName}"/><br>
        AGE:<c:out value="${stu.age}"/><br>
        
        <%
       		Student stu2 = new Student(1,"yexu","18");
       		Dept dept = new Dept(1001,"deptName");
       		stu2.setDept(dept);
       		request.setAttribute("stu2",stu2);
        %>
        <br>
        NUM:<c:out value="${stu2.num}"/><br>
        NAME:<c:out value="${stu2.stuName}"/><br>
        AGE:<c:out value="${stu2.age}"/><br>
        DEPT:<c:out value="${stu2.dept.deptName}"></c:out><br>
        
       <!-- c:out  end -->
       =========================================c:out  end==================================================<br>
       =========================================c:set  start==================================================<br>
       <br>
       <c:set var="param1" value="123" scope="request"></c:set>
       param=<c:out value="${param1}"></c:out>
        =========================================c:set  end==================================================<br>
        
        <%
        	List<Student> stus = new ArrayList<Student>();
        	stus.add(new Student(1,"yexu","18",new Dept(1001,"music")));
        	stus.add(new Student(2,"yexu2","20",new Dept(1001,"music")));
        	stus.add(new Student(3,"yexu3","25",new Dept(1001,"music")));
        	
        	request.setAttribute("stus",stus);
         %>
         
         <table>
         	<tr>
         		<td>
         			NUM
         		</td>
         		<td>
         			NAME
         		</td>
         		<td>
         			AGE
         		</td>
         		<td>
         			DEPT
         		</td>
         	</tr>
         	<!-- 数据行 -->
         	<c:forEach var="st" items="${requestScope.stus}" >
	         	<tr>
	         		<td>
	         			<c:out value="${st.num}"></c:out>
	         		</td>
	         		<td>
	         			<c:out value="${st.stuName}"></c:out>
	         		</td>
	         		<td>
	         		<c:if test="${st.age <= 20}">
	         			少年
	         		</c:if>
	         		<c:if test="${st.age > 20 && st.age <= 30}">
	         			青年
	         		</c:if>
	         	<!--	<c:choose>
	         			<c:when test="${st.age <= 20}">
	         				少年
	         			</c:when>
	         			<c:when test="${st.age <= 30}">
	         				青年
	         			</c:when>
	         			<c:when test="${st.age <= 50}">
	         				中年
	         			</c:when>
	         			<c:otherwise>
	         				老年
	         			</c:otherwise>
	         		</c:choose>-->
	         		</td>
	         		<td>
	         			<c:out value="${st.dept.deptName}"></c:out>
	         		</td>
	         	</tr>
         	</c:forEach>
         </table>
         	<c:forEach var="i" begin="0" end="10" step="1">
         		<c:out value="${i}"></c:out>
         	</c:forEach>
         	
         	
         	
         
  </body>
</html>
