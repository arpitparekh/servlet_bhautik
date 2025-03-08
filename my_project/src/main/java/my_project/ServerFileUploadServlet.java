package my_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/ServerFileUploadServlet")
@MultipartConfig 
public class ServerFileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	final static String uploadPath = "uploads";
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("file_upload.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Part filePart = request.getPart("image");
		 
		 String fileName = filePart.getSubmittedFileName();		 
		 
		 String uploadPath = getServletContext().getRealPath("") + File.separator + ServerFileUploadServlet.uploadPath;
		 
		 File uploadedFileDir = new File(uploadPath);
		 if(!uploadedFileDir.exists()) {
			 uploadedFileDir.mkdir();
			 System.out.println("Folder Created Scucessfully");
		 }
		 
		 filePart.write(uploadPath + "/" + fileName);
		 
		 System.out.println(uploadPath);
		 System.out.println("File Write SuccessFully");
		 
		
	}

}
