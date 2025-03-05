<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Home Page</h1>
	<h2><%= request.getAttribute("sessionId") %></h2>
	<h2><%= request.getAttribute("count") %></h2>
	
	<form method="post" action="HomePageServlet">
	<button> Logout </button>
	</form>

</body>
</html>