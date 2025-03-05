package my_project;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class CookiesManager
 */
@WebServlet("/CookiesManager")
public class CookiesManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Cookie firstName = new Cookie("FirstName", "Sumit");
		Cookie lastName = new Cookie("LastName", "Patel");
		
//		HttpSession session = request.getSession();  // id
//		System.out.println(session.getId());
		// 6D75BC5DFA3055ED11E0D23EA968CA8F
		// to identify different users on server
	
		
		response.addCookie(firstName);
		response.addCookie(lastName);
		
//		request.getRequestDispatcher("cookie_display.jsp").forward(request, response);
		response.sendRedirect("cookie_display.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
