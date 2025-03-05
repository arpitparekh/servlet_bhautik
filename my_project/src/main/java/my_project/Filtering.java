package my_project;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Date;

/**
 * Servlet implementation class Filtering
 */
//@WebFilter("/mypara")
@WebFilter("/*")
public class Filtering implements Filter {
	
	@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			// TODO Auto-generated method stub
			Filter.super.init(filterConfig);
			System.out.println("Filter init method called");
		}

  
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("From Filter...");
		/*
		 * 
    	To intercept requests from a client before they access a resource at back end.
    	To manipulate responses from server before they are sent back to the client.
		 */
		
		// get reuqested use ip address
		
//		String ipAdd = request.getRemoteAddr();
//		String dateTime = new Date().toString();
//		
//		System.out.println(ipAdd);
//		System.out.println(dateTime);
//		
//		
//		System.out.println("===== Incoming Request Details =====");
//	   
	    
	        HttpServletRequest httpRequest = (HttpServletRequest) request;
	        
	        MyRequestWrapper wrapper= new MyRequestWrapper(httpRequest);

	        // Get HTTP Method
	        System.out.println("HTTP Method: " + wrapper.getMethod());
//
//	        // Get Request URL & URI
//	        System.out.println("Request URL: " + httpRequest.getRequestURL().toString());
//	        System.out.println("Request URI: " + httpRequest.getRequestURI());
//
//	        // Get Query String
//	        System.out.println("Query String: " + httpRequest.getQueryString());
//
//	        // Get User-Agent
//	        System.out.println("User-Agent: " + httpRequest.getHeader("User-Agent"));
//
//	        // Get Referrer
//	        System.out.println("Referrer: " + httpRequest.getHeader("Referer"));
//
//	        // Get Content Type
//	        System.out.println("Content Type: " + request.getContentType());

	        // Get Headers
//	        System.out.println("Headers:");
//	        java.util.Enumeration<String> headerNames = httpRequest.getHeaderNames();
//	        while (headerNames.hasMoreElements()) {
//	            String headerName = headerNames.nextElement();
//	            System.out.println(headerName + ": " + httpRequest.getHeader(headerName));
//	        }
//	        
	        

//	         Get Request Parameters
	        java.util.Enumeration<String> parameterNames = wrapper.getParameterNames();
	        while (parameterNames.hasMoreElements()) {
	            String paramName = parameterNames.nextElement();
	           
	            System.out.println(paramName + " = " + wrapper.getParameter(paramName));
	        }
	        System.out.println();
			System.out.println();
	        
	        request.setAttribute("Hello", "Kemcho");
	        // 
	       // Cannot forward after response has been committed

	    // Continue the chain
	    chain.doFilter(wrapper, response);
	    
	    
	    // wrapper request class pending
	
		
	}

}
