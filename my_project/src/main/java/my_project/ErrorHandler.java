package my_project;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ErrorHandler
 */
@WebServlet("/error_handler")
public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Calling Error Page");
		
		Throwable throwable = (Throwable)
			      request.getAttribute("jakarta.servlet.error.exception");
			      Integer statusCode = (Integer)
			      request.getAttribute("jakarta.servlet.error.status_code");
			      String servletName = (String)
			      request.getAttribute("jakarta.servlet.error.servlet_name");
	
			  
			 
			      
if(throwable!=null) {
	
	request.setAttribute("error", throwable.getMessage());	
	
}else if(statusCode!=null) {
	
	request.setAttribute("error", statusCode.toString());
	
}else if(servletName!=null) {
	
	request.setAttribute("error", servletName);	
	
}
		      
		request.getRequestDispatcher("error_page.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
