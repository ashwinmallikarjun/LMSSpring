<%@ include file="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.gcit.lms.entity.LibraryBranch"%>
<%@ page import="com.gcit.lms.service.AdministratorService"%>
<%
	AdministratorService service = new AdministratorService();
	List<LibraryBranch> branch = service.getAllBranch(null);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS</title>
</head>
<body>
<h4>Enter Book Details Below:</h4>
	
	<form action="addBranch" method="post">
		<p>Branch Name : <input type="text" name="branchName"> <br /></p>
		<p>Branch Address : <input type="text" name="branchAddress"> <br /></p>
		<p><button class="btn btn btn-primary" type="submit">Add Branch</button></p>
	</form>

</body>
</html>