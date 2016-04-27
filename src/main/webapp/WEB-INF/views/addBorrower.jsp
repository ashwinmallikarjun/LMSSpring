<%@ include file="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.gcit.lms.entity.Borrower"%>
<%@ page import="com.gcit.lms.service.AdministratorService"%>
<%
	AdministratorService service = new AdministratorService();
	List<Borrower> borrower = service.getAllBorrower(null);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS</title>
</head>
<body>
<h4>Enter Borrower Details Below:</h4>
	
	<form action="addBorrower" method="post">
		<p>Borrower Name : <input type="text" name="name"> <br /></p>
		<p>Borrower Address : <input type="text" name="address"> <br /></p>
		<p>Borrower Phone : <input type="text" name="phone"> <br /></p>
		<p><button class="btn btn btn-primary" type="submit">Add Borrower</button></p>
	</form>
</body>
</html>