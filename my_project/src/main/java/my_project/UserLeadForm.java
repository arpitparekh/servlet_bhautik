package my_project;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;


@WebServlet("/UserLeadForm")
public class UserLeadForm extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-Language", "es");
		
	    Locale locale = new Locale("es" != null ? "es" : "en");
	    ResourceBundle bundle = ResourceBundle.getBundle("resource.messages", locale);
	    System.out.println(bundle.getString("welcome"));
		
		request.getRequestDispatcher("user_lead.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String phone = request.getParameter("number");
		String email = request.getParameter("email");
		String question = request.getParameter("question");
		
		String from = "arpitparekh9@gmail.com";
		String to = email;
		String port = "587";
		String password = "pzzzplnkprfnuzsy";
		String host = "smtp.gmail.com";
		
		 Properties props = System.getProperties();
		 
		 props.put("mail.smtp.auth", "true");
	     props.put("mail.smtp.starttls.enable", "true");
	     props.put("mail.smtp.host", host);
	     props.put("mail.smtp.port", port);
	     props.put("mail.smtp.ssl.trust", host);
		 
	     Session session = Session.getInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(from, password);
	            }
	        });
		 
		 Message message = new MimeMessage(session);
         
         // Set From: header field of the header.
         try {
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	         
	         // Set Subject: header field
	         message.setSubject(phone);
	         
	         // Now set the actual message
	         message.setText(question);
	         
	         // Send message
	         jakarta.mail.Transport.send(message);
	         
	         System.out.println("Mail Sended Successfully");
	         
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
         
         // Set To: header field of the header.
         
		
		
	}

}
