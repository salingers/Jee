package org.apache.jsp.CH3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HelloJSP_jsp extends org.apache.jasper.runtime.HttpJspBase
		implements org.apache.jasper.runtime.JspSourceDependent
{

	int k = 0;

	private static java.util.Vector _jspx_dependants;

	private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value;

	public java.util.List getDependants()
	{
		return _jspx_dependants;
	}

	public void _jspInit()
	{
		_jspx_tagPool_c_out_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
	}

	public void _jspDestroy()
	{
		_jspx_tagPool_c_out_value.release();
	}

	public void _jspService(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException, ServletException
	{

		JspFactory _jspxFactory = null;
		PageContext pageContext = null;
		HttpSession session = null;
		ServletContext application = null;
		ServletConfig config = null;
		JspWriter out = null;
		Object page = this;
		JspWriter _jspx_out = null;

		try
		{
			_jspxFactory = JspFactory.getDefaultFactory();
			response.setContentType("text/html;charset=Big5");
			pageContext = _jspxFactory.getPageContext(this, request, response, null, true, 8192, true);
			application = pageContext.getServletContext();
			config = pageContext.getServletConfig();
			session = pageContext.getSession();
			out = pageContext.getOut();
			_jspx_out = out;

			out.write("\r\n");
			out.write("\r\n\r\n");
			out.write("<html>\r\n");
			out.write("<head>\r\n  ");
			out.write("<title>CH3 - HelloJSP.jsp");
			out.write("</title>\r\n");
			out.write("</head>\r\n");
			out.write("<body>\r\n\r\n");
			out.write("<h2>JSP 將會被轉譯為 Servlet");
			out.write("</h2>\r\n\r\n");
			out.write("\r\n");
			
			if (_jspx_meth_c_out_0(pageContext))
			{
				return;
			}
			
			out.write("\r\n");

			String name = "browser";

			out.println("大家好 !!");

			out.write("\r\n");
			out.print(name);
			out.write("\r\n\r\n");
			out.write("</body>\r\n");
			out.write("</html>");
		}
		catch (Throwable t)
		{
			if (!(t instanceof SkipPageException))
			{
				out = _jspx_out;
				if (out != null && out.getBufferSize() != 0)
					out.clearBuffer();
				if (pageContext != null)
					pageContext.handlePageException(t);
			}
		}
		finally
		{
			if (_jspxFactory != null)
				_jspxFactory.releasePageContext(pageContext);
		}
	}

	private boolean _jspx_meth_c_out_0(PageContext pageContext) throws Throwable
	{
		JspWriter out = pageContext.getOut();
		// c:out
		org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value
				.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
		_jspx_th_c_out_0.setPageContext(pageContext);
		_jspx_th_c_out_0.setParent(null);
		_jspx_th_c_out_0.setValue(new String("Hi"));
		int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
		if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
			return true;
		_jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_0);
		return false;
	}
}
