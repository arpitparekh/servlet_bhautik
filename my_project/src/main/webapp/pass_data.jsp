<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pass Data</title>
</head>

<%@ page import="java.util.*" %>
<%@ page import="my_project.Student" %>
<body>

	<p><%= request.getAttribute("data") %></p>
	<ul>
	<%
	
	ArrayList<String> names = (ArrayList<String>) request.getAttribute("names"); 

	for(String name :names) { 
	
	%>
	
	<li> <%= name %> </li>
	
	<% } %>
	</ul>
	
	<%
		Student s = (Student) request.getAttribute("stu");
	%>
	
	<p> <%= s %> </p>
	
	<% Date d = new Date(); %>
	<p> <%= d %></p>
 	
	 
</body>
</html>