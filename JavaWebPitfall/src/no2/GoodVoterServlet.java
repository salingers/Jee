package no2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoodVoterServlet
 */
public class GoodVoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodVoterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vote = request.getParameter("vote");
		ServletOutputStream out = response.getOutputStream(); 
        VoterApp voter = VoterApp.getInstance(); 
        if ( vote == null ){
            response.setContentType("text/html"); 
            out.println("<TITLE>Poll of the Day!</TITLE>");
            out.println("<FORM METHOD='POST' ACTION='" + 
                        request.getRequestURI() + "'>");
            out.println(voter.getPollOfTheDay()); 
            out.println("<INPUT TYPE='SUBMIT' VALUE='Vote Now!'>");
            out.println("</FORM>"); 
        }else{
            voter.addToPollResults(vote); 
            byte[] generatedGraph = voter.generateImageBytes();
            if ( generatedGraph == null ){
                response.setContentType("text/html"); 
                out.println("<B>Technical difficulties.. Please see" +
                            " your administrator for details.</B>");
                return;
            } else{
                response.setContentType("image/gif");
                out.write(generatedGraph, 0, generatedGraph.length);
                out.flush();
            }
        }
	}

}
