package my_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class CrudServlet
 */
@WebServlet("/crud")
public class CrudServlet extends HttpServlet {
	
	ArrayList<String> notes = new ArrayList<String>();
	
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("list", notes);
		
		request.getRequestDispatcher("crud.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String note =(String) request.getParameter("note");
		String des =(String) request.getParameter("des");
		System.out.println(note);
		notes.add(note);
		notes.add(des);
		
		System.out.println(notes);
		
		request.setAttribute("list", notes);
		
		response.sendRedirect(request.getContextPath() + "/crud");
		
	}

}
