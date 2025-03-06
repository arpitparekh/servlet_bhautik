package my_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Servlet implementation class MySqlCrudServlet
 */
@WebServlet("/mysql-crud")
@MultipartConfig 
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
		if(id!=null) {  // fill the fields
			
			Majoor m = handler.getSingleData(Integer.parseInt(id));
			request.setAttribute("obj", m);
			ArrayList<Majoor> list =  handler.showData();
			request.setAttribute("list", list);
			doGet(request, response);
			
		}  
		else {
			
			if(delId!=null) {  // delete
				
				handler.deleteData(Integer.parseInt(delId));
				
			}else { 
				
				String oldId = request.getParameter("id");
				String name = request.getParameter("name");
				
//				String id = new String(request.getPart("id").getInputStream().readAllBytes()).trim();
//			    String name = new String(request.getPart("name").getInputStream().readAllBytes()).trim();
//			    String salaryStr = new String(request.getPart("salary").getInputStream().readAllBytes()).trim();
			    
				
				// salary is also coming in parts ?
				Part salaryPart = request.getPart("salary");
                String salaryStr = new String(salaryPart.getInputStream().readAllBytes()).trim();
                float salary = Float.parseFloat(salaryStr);  // Convert to float
                
                Part filePart = request.getPart("image");
                InputStream is = filePart.getInputStream();
                
                String fileName = filePart.getSubmittedFileName();
                
				
				if(oldId!=null) {  // update
					handler.updateData(name, salary, Integer.parseInt(oldId));
				}else {  // insert		
					handler.insertData(name, salary,is,fileName);	
				}
			}
			response.sendRedirect(request.getContextPath() + "/mysql-crud");			
		}	
		
	}

}
