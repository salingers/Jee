<%@ page import="java.util.*"%>

<%@ page import="tw.com.javaworld.CH10.Book"%>

<html>
<head>
<title>CH10 - Checkout.jsp</title>
</head>
<body>

	<h2>�����ѩ� - ���b</h2>
	<center>
		<table border="1" width="631">
			<tr bgcolor="#999999">
				<td width="194"><div align="center">
						<b>�ѦW</b>
					</div></td>
				<td width="81"><div align="center">
						<b>�@��</b>
					</div></td>
				<td width="57"><div align="center">
						<b>�X����</b>
					</div></td>
				<td width="93"><div align="center">
						<b>����</b>
					</div></td>
				<td width="47"><div align="center">
						<b>�ƶq</b>
					</div></td>
				<td width="119"><div align="center">
						<b></b>
					</div></td>
			</tr>
			<%
				Vector buylist = (Vector) session.getAttribute("shoppingcart");
				float total = 0;

				for (int i = 0; i < buylist.size(); i++)
				{
					Book order = (Book) buylist.elementAt(i);
					String name = order.getName();
					String author = order.getAuthor();
					String publisher = order.getPublisher();
					float price = order.getPrice();
					int quantity = order.getQuantity();
			%>
			<tr>
				<td><b><%=name%></b></td>
				<td><b><%=author%></b></td>
				<td><b><%=publisher%></b></td>
				<td><b><div align="right"><%=price%></div></b></td>
				<td><b><div align="right"><%=quantity%></div></b></td>
			</tr>
			<%
				total += (price * quantity);
				}

				String amount = new Float(total).toString();
			%>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><font color="red"><b>�`���B�G</b></font></td>
				<td></td>
				<td><font color="red"><b>$<%=amount%></b></font></td>
				<td></td>
			</tr>
		</table>
		<p>
			<a href="Store.html">�O�_�~���ʪ�</a>
	</center>

</body>
</html>