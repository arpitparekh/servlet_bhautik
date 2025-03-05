package my_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class MySqlCrudServlet
 */
@WebServlet("/mysql-crud")
public class MySqlCrudServlet extends HttpServlet {
	
	
	DatabaseHandler handler = new DatabaseHandler();
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Majoor> list =  handler.showData();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("mysqlcrud.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Calling insert data");
		String name = request.getParameter("name");
		Float salary = Float.parseFloat(request.getParameter("salary"));
		System.out.println("Calling insert data");
		
		
		handler.insertData(name, salary);
		
		response.sendRedirect(request.getContextPath() + "/mysql-crud");
		
	}

}
