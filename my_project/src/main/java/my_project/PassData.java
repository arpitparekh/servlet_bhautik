package my_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/passdata")
public class PassData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassData() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String data = "Hello From Bascom Bridge";
		request.setAttribute("data", data);
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Sumit");
		names.add("Pradip");
		names.add("Patil");
		names.add("Pranav");
		request.setAttribute("names", names);
		
		Student s = new Student("Sumit", "1234567890", 23);
		
		request.setAttribute("stu", s);
	
		
		request.getRequestDispatcher("pass_data.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
