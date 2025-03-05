<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	
<h2><%= request.getAttribute("sessionId") %></h2>	
<form method="post" action="LoginServlet">
<input id="username" name="username">
<input id="password" name="password">
<button type="submit"> Login </button>
</form>

</body>
</html>