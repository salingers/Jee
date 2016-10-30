package no1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BadTechnobabbleLibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	PrintWriter     m_out    = null;
	String          m_useridparam  = null;
    public BadTechnobabbleLibraryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = "Online Technobabble Library";
	    response.setContentType("text/html");
	    m_out = response.getWriter();
	    m_useridparam = request.getParameter("userid");

	    m_out.println("<HTML>");
	    m_out.println("<TITLE>" + title + "</TITLE>");
	    m_out.println("<BODY BGCOLOR='WHITE'>");
	    m_out.println("<CENTER><H1>" + title + 
	                  "</H1></CENTER>");
	    m_out.println("<HR>");

	    //This will put the user's personal page in..
	    putInUserData();
	    m_out.println("<HR>");
	    m_out.println("</BODY></HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void putInUserData() throws IOException{
	    BufferedReader br = null;
	    String fn = m_useridparam + ".html"; 
	    String htmlfile = 
	    getServletContext().getRealPath(fn);
	    System.out.println("debug: Trying to open " + htmlfile);
	    File htmlSnippetFile = new File(htmlfile);
	    try{
	      String  line;
	      if (!htmlSnippetFile.exists()){
	        m_out.println("File " + fn + "not found!");
	        return;
	      }
	      br = new BufferedReader(new FileReader(htmlfile));
	      char[] buffer = new char[2];
	      int count = 0;
	      do{
	        m_out.write(buffer, 0, count);
	        m_out.flush();
	        count = br.read(buffer, 0, buffer.length);
	      }
	      while (count != -1);
	    } catch (Exception e){
	      m_out.println("Error in reading file!!");
	      e.printStackTrace(System.err);
	    } finally{
	      if (br != null)
	        br.close();
	    }
	}
}
