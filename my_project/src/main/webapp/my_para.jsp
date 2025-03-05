<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Parameter</title>
</head>
<body>

	<form method="post" action="mypara">
		
		<label>First Name</label>
		<input type="text" name="first_name">
		<label>Last Name</label>
		<input type="text" name="last_name">
		<label>Birthday</label>
		<input type="date" name="birthday">
		<input type = "checkbox" name = "maths" checked = "checked" /> Maths
         <input type = "checkbox" name = "physics"  /> Physics
         <input type = "checkbox" name = "chemistry" checked = "checked" /> Chem
		
		<button> Click me</button>
	
	</form>

		
	<h1><%= request.getAttribute("result") %></h1>
	
	<h1><%= request.getAttribute("headerData") %></h1>
	
	<%
Cookie[] cookies = request.getCookies();
if (cookies != null) {
    for (Cookie cookie : cookies) {
        out.println(cookie.getName() + ": " + cookie.getValue() + "<br>");
    }
} else {
    out.println("No cookies found!");
}
%>

</body>
</html>