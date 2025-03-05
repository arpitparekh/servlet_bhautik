<%@page import="my_project.Majoor"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crud Operation</title>
</head>
<body>

	<div id="main">
	
	<div id="form">
	<form action="mysql-crud" method="post">
	<label>Name</label> 
	<input id="name" name="name">
	<label>Salary</label>
	<input id="salary" name="salary" type="number">
	<button type="submit">Save Data</button>
	</form>
		
	</div>
	
		<ul>
			<% ArrayList<Majoor> list = (ArrayList<Majoor>)request.getAttribute("list");
			
			for(Majoor m : list){
				
		
		%>
		<li><%= m.getId() %></li>
		<li><%= m.getName() %></li>
		<li><%= m.getSalary() %></li>
		<li><form method="post"><button type="submit">Update</button> </form></li>
		<li><form method="post"><button type="submit">Delete</button> </form></li>
		
		<% } %>
		
		</ul>
	
	<div>

	</div>
	
		
	</div>

</body>
</html>