<%@ page import="java.io.*,java.util.*"%>
<%@ page import="tw.com.javaworld.CH10.Book"%>
<%
	Vector buylist = (Vector) session.getAttribute("shoppingcart");

	String action = request.getParameter("action");

	if (action.equals("DELETE"))
	{
		String del = request.getParameter("del");
		int d = (new Integer(del)).intValue();
		buylist.removeElementAt(d);
	}
	else if (action.equals("ADD"))
	{
		boolean match = false;
%>
<jsp:useBean id="newBook" scope="page"
	class="tw.com.javaworld.CH10.Book" />
<jsp:setProperty name="newBook" property="*" />
<%
	if (buylist == null)
		{
			buylist = new Vector();
			buylist.addElement(newBook);
		}
		else
		{
			for (int i = 0; i < buylist.size(); i++)
			{
				Book book = (Book) buylist.elementAt(i);

				if (book.getName().equals(newBook.getName()))
				{
					book.setQuantity(book.getQuantity() + newBook.getQuantity());
					buylist.setElementAt(book, i);
					match = true;
				} //end of if name matches
			} // end of for

			if (!match)
			{
				buylist.addElement(newBook);
			}
		}
	}

	session.setAttribute("shoppingcart", buylist);

	if (buylist != null && (buylist.size() > 0))
	{
%>
<html>
<head>
<body>

	<table border="1" width="631">
		<tr bgcolor="#999999">
			<td width="194"><div align="center">
					<b>書名</b>
				</div></td>
			<td width="81"><div align="center">
					<b>作者</b>
				</div></td>
			<td width="93"><div align="center">
					<b>出版社</b>
				</div></td>
			<td width="57"><div align="center">
					<b>價格</b>
				</div></td>
			<td width="47"><div align="center">
					<b>數量</b>
				</div></td>
			<td width="119"><div align="center">
					<b></b>
				</div></td>
		</tr>
		<%
			for (int index = 0; index < buylist.size(); index++)
				{
					Book order = (Book) buylist.elementAt(index);
		%>
		<tr>
			<td><b><%=order.getName()%></b></td>
			<td><b><%=order.getAuthor()%></b></td>
			<td><b><%=order.getPublisher()%></b></td>
			<td><b><%=order.getPrice()%></b></td>
			<td><b><%=order.getQuantity()%></b></td>
			<td>
				<form name="deleteForm" action="Store.jsp" method="POST">
					<input type="submit" value="Delete"> <input type="hidden"
						name="del" value='<%=index%>'> <input type="hidden"
						name="action" value="DELETE">
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<p>
		<a href="Store.html">繼續購物</a>
	<form name="checkoutForm" action="Checkout.jsp" method="POST">
		<input type="hidden" name="action" value="CHECKOUT"> <input
			type="submit" name="Checkout" value="付款結帳">
	</form>
	<%
		}
		else
		{
	%>
	<br>
	<a href="Store.html">繼續購物</a>
	<%
		}
	%>


</body>
</html>