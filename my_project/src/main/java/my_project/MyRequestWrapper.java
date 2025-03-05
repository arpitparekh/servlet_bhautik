package my_project;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class MyRequestWrapper  extends HttpServletRequestWrapper{

	public MyRequestWrapper(HttpServletRequest request) {
		super(request);
		
	}
	
//	@Override
//	public String[] getParameterValues(String name) {
//	    if (name.equals("first_name")) {
//	        String[] originalValues = super.getParameterValues(name);
//	        if (originalValues != null && originalValues.length > 0) {
//	            String[] modifiedValues = new String[originalValues.length];
//	            for (int i = 0; i < originalValues.length; i++) {
//	                modifiedValues[i] = originalValues[i] + " Bhai";
//	            }
//	            return modifiedValues;
//	        }
//	    }
//	    return super.getParameterValues(name);
//	}
	
	@Override
	public String getParameter(String name) {
		// first_name
		
		System.out.println("From Request Wrapper ");
		
		if (name.equals("first_name")) {
			String originalValue = super.getParameter(name);
			if (originalValue!=null){
				System.out.println();
				System.out.println();
				return originalValue + " Bhai";
			}else {
				System.out.println();
				System.out.println();
				return super.getParameter(name);
				
			}
		}else {
			System.out.println();
			System.out.println();
			return super.getParameter(name);
		}
		
		
		
	}
	
	@Override
	public void setRequest(ServletRequest request) {
		// TODO Auto-generated method stub
		super.setRequest(request);
	}

}
