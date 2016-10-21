<%@ page import="java.io.*" %>
<%@ page import="javax.xml.transform.*" %>
<%@ page import="javax.xml.transform.stream.*" %>

<%@page contentType="text/html;charset=Big5" %>

<%		
	StreamResult streamResult = new StreamResult(out);	
	TransformerFactory tf = TransformerFactory.newInstance();	
	
	Source xslSource = new StreamSource("http://localhost:8080/JSPBook/CH17/Books.xsl");	
	Transformer serializer = tf.newTransformer(xslSource);	
	
	serializer.setOutputProperty(OutputKeys.ENCODING,"Big5");	
	serializer.transform(new StreamSource("http://localhost:8080/JSPBook/CH17/Books.xml"), streamResult); 
%>