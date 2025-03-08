<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>

	<h2>File Upload</h2>
	<form method="post" action="ServerFileUploadServlet" enctype = "multipart/form-data">
	
	<input type="file" name="image" required><br>
	<button type="submit">Upoload Image</button>
	
		
	</form>
</body>
</html>