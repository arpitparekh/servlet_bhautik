package my_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;


@WebServlet("/mypara")
public class MyParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String result = "";
	String headerData = "";
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setAttribute("result", result);
//		request.setAttribute("headerData", headerData);
		System.out.println("Do Get Method");
		System.out.println("From Filter"+(String)request.getAttribute("Hello"));
		System.out.println();
		System.out.println();
		
		
		
//		response.setIntHeader("Refresh", 5);
		
		
		request.getRequestDispatcher("my_para.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String result = "";  // Reset for each request
		Enumeration e = request.getParameterNames();
		
		System.out.println("From Do Post");
		while(e.hasMoreElements()) {
			String paraName = (String)e.nextElement();
			System.out.println(paraName);
			String values = request.getParameter(paraName);
			System.out.println(values);
			result = result +paraName + ":\n" + values;
		}
		System.out.println();
		System.out.println();
		
		Enumeration headerNames = request.getHeaderNames();
	    
	      while(headerNames.hasMoreElements()) {
	         String paramName = (String)headerNames.nextElement();
	        
	         String paramValue = request.getHeader(paramName);
	         
	         headerData = headerData +paramName + ":\n" + paramValue;
	         System.out.println(headerData);
	         
	      }
		
		request.setAttribute("result", result);
		
		response.sendRedirect(request.getContextPath() + "/mypara");
		
	}

}