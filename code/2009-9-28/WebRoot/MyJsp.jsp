<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<html>
  <head>
  
    <title>��һ��Jspҳ��</title>
  </head>
  
  <body>
    <h1>�����еĵ�һ��Jspҳ��,�ɹ��Ӵ���...</h1>
    
    <% 
    	System.out.println("Hello World��");
    	
    	for(int i = 1; i < 7; i++){
    		out.write("<h" + i + ">����" + i + "</h" + i + ">");
    	}
    	
    %>
     
  </body>
</html>
