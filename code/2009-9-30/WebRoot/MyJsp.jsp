<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<html>
  <head>
  
    <title>第一个Jsp页面</title>
  </head>
  
  <body>
    <h1>人生中的第一个Jsp页面,成功从此起步...</h1>
    
    <% 
    	System.out.println("Hello World！");
    	
    	for(int i = 1; i < 7; i++){
    		out.write("<h" + i + ">标题" + i + "</h" + i + ">");
    	}
    	
    %>
     
  </body>
</html>
