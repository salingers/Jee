<%@ page language="java" contentType="text/html;Big5"%>
<%@ page import="java.util.*"%>

<%!public void show_items(HttpSession session, JspWriter out) throws java.io.IOException
	{
		out.println("<H1>列出所有購物車內的物件</H1><br>");

		Enumeration item_names = session.getAttributeNames();

		out.println("<p>你己經購買了下列東西：</p>");
		out.println("<table border=\"1\" width=\"196\" height=\"59\">");
		out.println("<tr><td width=\"121\">商品名稱</td><td width=\"59\">數量</td></tr>");

		while (item_names.hasMoreElements())
		{
			String name = (String) item_names.nextElement();

			if (name.endsWith("count"))
			{
				Integer count = (Integer) session.getAttribute(name);
				int length = name.length();

				String real_name = name.substring(0, length - 5);

				out.println("<tr>");
				out.println("<td width=\"121\">" + real_name + "</td>");
				out.println("<td width=\"59\">" + count + "</td>");
				out.println("</tr>");
			}
		}

		out.println("</table>");
		out.println("<a href=\"Shopping.html\">繼續購物</a>");
	}%>

<html>
<head>
<title>CH10 - ShowCartItems.jsp</title>
<meta http-equiv="Content-Type" content="text/html; charset=big5">
</head>
<body>
	<center>

		<%
			// 假若是第一次來購物的話
			if (session.isNew())
			{
				String show = request.getParameter("type");

				if (show == null)
				{
					String[] items = request.getParameterValues("items");

					if (items != null)
					{
						for (int i = 0; i < items.length; i++)
						{
							String item_name = items[i];
							session.setAttribute(item_name, item_name);
							session.setAttribute(item_name + "count", new Integer(1));
						}

						// 顯示購物車目前的內容
						show_items(session, out);
					}

					// 如果沒選擇物品時
					else
					{
						out.println("你未選擇加入購物欄內之物品 請回上一頁<br>");
						out.println("<a href=\"Shopping.html\">回上一頁</a>");
					}
				}
				else
				{
					out.println("尚未有任何物品加入你的購物車中");
				}
			}

			// 若不是第一次來購物時，即session.isNew()為false
			else
			{
				String show = request.getParameter("type");

				if (show == null)
				{
					String[] items = request.getParameterValues("items");

					if (items != null)
					{
						for (int i = 0; i < items.length; i++)
						{
							String item_name = items[i];
							Integer count = (Integer) session.getAttribute(item_name + "count");

							if (count == null)
							{
								session.setAttribute(item_name, item_name);
								session.setAttribute(item_name + "count", new Integer(1));
							}
							else
							{
								// 將物品計數器作累加的動作
								count = new Integer(count.intValue() + 1);
								session.setAttribute(item_name + "count", count);
							}
						}

						show_items(session, out);
					}
					else
					{
						out.println("你未選擇加入購物欄內之物品 請回上一頁<br>");
						out.println("<a href=\"Shopping.html\">回上一頁</a>");
					}
				}
				else
				{
					show_items(session, out);
				}
			}
		%>
	</center>
</body>
</html>
