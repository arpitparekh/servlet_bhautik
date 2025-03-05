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
		
		Majoor m = (Majoor)request.getAttribute("obj");
		
		
		ArrayList<Majoor> list =  handler.showData();
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("mysqlcrud.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String id = request.getParameter("updateId");
		String delId = request.getParameter("deleteId");
		if(id!=null) {  // update
			
			Majoor m = handler.getSingleData(Integer.parseInt(id));
			request.setAttribute("obj", m);
			ArrayList<Majoor> list =  handler.showData();
			request.setAttribute("list", list);
			doGet(request, response);
			
		}  // insert
		else {
			
			if(delId!=null) {
				
				handler.deleteData(Integer.parseInt(delId));
				
			}else {
				
				String oldId = request.getParameter("id");
				String name = request.getParameter("name");
				float salary = Float.parseFloat(request.getParameter("salary"));
				
				if(oldId!=null) {  // update
					handler.updateData(name, salary, Integer.parseInt(oldId));
				}else {  // insert		
					handler.insertData(name, salary);	
				}
			}
			
			response.sendRedirect(request.getContextPath() + "/mysql-crud");
			
			
		}
		
		
		
	}

}
