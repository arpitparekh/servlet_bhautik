package my_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("sessionId", session.getId());
		
		Integer old = (Integer) session.getAttribute("count");
		session.setAttribute("count", old+1);
		request.setAttribute("count", session.getAttribute("count"));
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
		// JSON Web Token (JWT): A digitally signed, 
		// URL-safe way to transmit information between parties
		// spring boot

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("isLogin", false);
		response.sendRedirect(request.getContextPath() + "/LoginServlet");
		
	}

}
