package my_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Boolean result = (Boolean)session.getAttribute("isLogin");
		if(result!=null) {
			if(result) {
				response.sendRedirect(request.getContextPath() + "/HomePageServlet");
			}else {
				System.out.println(session.getId());
				request.setAttribute("sessionId", session.getId());
				Integer count = 0;
				session.setAttribute("count", count);
				
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}else {
			System.out.println(session.getId());
			request.setAttribute("sessionId", session.getId());
			Integer count = 0;
			session.setAttribute("count", count);
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
			
			/*
			 * 
			 * Log the user out − The servers that support servlets 2.4, 
			 * you can call logout to 
			 * log the client out of the Web server and 
			 * invalidate all sessions belonging to all the users.
			 * 
			 */
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name =  request.getParameter("username");
		String password  = request.getParameter("password");
		
		HttpSession session = request.getSession();
		session.setAttribute("isLogin", true);
		response.sendRedirect(request.getContextPath() + "/HomePageServlet");
		
		
	}

}
