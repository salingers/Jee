<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html;charset=MS950"%>
<html>
<head>
<title>CH9 - File_Chinese.jsp</title>
</head>
<%
	// �ŧi�N�W�Ǥ��ɮש�m����A����C:\Upload�ؿ���
	// �ŧi����W�Ǥ��ɮפj�p�� 5 MB
	String saveDirectory = "C:\\Upload\\";
	int maxPostSize = 5 * 1024 * 1024;

	// �ŧi�W���ɮצW��
	String FileName = null;

	// �ŧi�W���ɮ׫��A
	String ContentType = null;

	// �ŧi�ԭz�W���ɮפ��e�ԭz
	String Description = null;

	//  �p��W���ɮפ��Ӽ�
	int count = 0;

	// �ŧi�W���ɮ��ɦW�ҨϥΪ��s�X�A�w�]�Ȭ� ISO-8859-1�A
	// �Y�אּMS950�h�䴩�����ɦW	
	String enCoding = "MS950";

	// ���@�ӷs��MultipartRequest ������Amulti
	MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, enCoding);
%>
<body>
	<%
		//  ���o�Ҧ��W�Ǥ��ɮ׿�J���A�W�٤αԭz
		Enumeration filesname = multi.getFileNames();
		Enumeration filesdc = multi.getParameterNames();

		while (filesname.hasMoreElements())
		{
			String name = (String) filesname.nextElement();
			String dc = (String) filesdc.nextElement();
			FileName = multi.getFilesystemName(name);
			ContentType = multi.getContentType(name);
			Description = multi.getParameter(dc);

			if (FileName != null)
			{
				count++;
	%>
	<font color="red">�A�W�Ǫ���<%=count%>�Ӫ��ɮסG
	</font>
	<br> �ɮצW�٬��G<%=FileName%><br> �ɮ׫��A���G<%=ContentType%><br>
	�ɮת��ԭz�G<%=Description%><br>
	<br>

	<%
		} // end if 
		} // end while
	%>
	�z�`�@�W��
	<font color="red"><%=count%></font>���ɮ�


	<form name="Form1" enctype="multipart/form-data" method="post"
		action="File_Chinese.jsp">
		<p>
			�W���ɮ� 1�G <input type="file" name="File1" size="20" maxlength="20">
		</p>
		<p>
			�ɮ� 1�ԭz�G <input type="text" name="File1" size="30" maxlength="50">
		</p>
		<p>
			�W���ɮ� 2�G <input type="file" name="File2" size="20" maxlength="20">
		</p>
		<p>
			�ɮ� 2�ԭz�G <input type="text" name="File2" size="30" maxlength="50">
		</p>
		<p>
			�W���ɮ�3�G <input type="file" name="File3" size="20" maxlength="20">
		</p>
		<p>
			�ɮ� 3�ԭz�G <input type="text" name="File3" size="30" maxlength="50">
		</p>
		<p>
			<input type="submit" value="�W��"> <input type="reset"
				value="�M��">
		</p>
	</form>
</body>
</html>