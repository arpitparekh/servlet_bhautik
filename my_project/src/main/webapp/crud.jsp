<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crud</title>
</head>
<body>

<div id="main" >
	<div id="form">
	<h1> Form</h1>
	<form method="post" action="crud">
	<input name="note" id="note">
	<input name="des" id="des">
	
	<button> Save Data </button>
	</form>
	</div>
	
	<div id="list">
		<h1> List</h1>
		
		<ul>
		
		<%
		ArrayList<String> notes = (ArrayList<String>)request.getAttribute("list");
		
		for(String data:notes){
		
		%>
		<li><%= data %></li>
		<%
		}
		%>
		
		</ul>
		
	</div>
</div>

</body>
</html>