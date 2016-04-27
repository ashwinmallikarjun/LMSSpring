<%@ include file="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS</title>
</head>
<body>
<h4>Enter Borrower Details Below</h4>

	<form action="checkBorrower" method="get">
		<p>
			Card Number: <input type="text" name="cardNo"> <br />
		</p>
		<p>
			<button class="btn btn btn-primary" type="submit">Submit</button>
		</p>
	</form>
</body>
	
</html>