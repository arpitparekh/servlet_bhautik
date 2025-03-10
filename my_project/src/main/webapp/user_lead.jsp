<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Lead</title>
</head>
<body>

<form action="UserLeadForm" method="post">
<label>Enter Number</label><br>
<input type="number" placeholder="Enter Phone Number" name="number" required><br>
<label>Enter Email</label><br>
<input type="email" placeholder="Enter Email" name="email" value = "bhautikranpara777@gmail.com" required><br>
<label>Ask something</label><br>
<textarea type="text" placeholder="Enter Questions" name="question" required></textarea><br>
<button type="submit">Send Inquiry</button>

</form>

</body>
</html>