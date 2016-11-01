<%@ page language="java" contentType="text/html;Big5"%>
<%@ page import="java.util.*"%>

<%!public void show_items(HttpSession session, JspWriter out) throws java.io.IOException
	{
		out.println("<H1>�C�X�Ҧ��ʪ�����������</H1><br>");

		Enumeration item_names = session.getAttributeNames();

		out.println("<p>�A�v�g�ʶR�F�U�C�F��G</p>");
		out.println("<table border=\"1\" width=\"196\" height=\"59\">");
		out.println("<tr><td width=\"121\">�ӫ~�W��</td><td width=\"59\">�ƶq</td></tr>");

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
		out.println("<a href=\"Shopping.html\">�~���ʪ�</a>");
	}%>

<html>
<head>
<title>CH10 - ShowCartItems.jsp</title>
<meta http-equiv="Content-Type" content="text/html; charset=big5">
</head>
<body>
	<center>

		<%
			// ���Y�O�Ĥ@�����ʪ�����
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

						// ����ʪ����ثe�����e
						show_items(session, out);
					}

					// �p�G�S��ܪ��~��
					else
					{
						out.println("�A����ܥ[�J�ʪ��椺�����~ �Ц^�W�@��<br>");
						out.println("<a href=\"Shopping.html\">�^�W�@��</a>");
					}
				}
				else
				{
					out.println("�|�������󪫫~�[�J�A���ʪ�����");
				}
			}

			// �Y���O�Ĥ@�����ʪ��ɡA�Ysession.isNew()��false
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
								// �N���~�p�ƾ��@�֥[���ʧ@
								count = new Integer(count.intValue() + 1);
								session.setAttribute(item_name + "count", count);
							}
						}

						show_items(session, out);
					}
					else
					{
						out.println("�A����ܥ[�J�ʪ��椺�����~ �Ц^�W�@��<br>");
						out.println("<a href=\"Shopping.html\">�^�W�@��</a>");
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
