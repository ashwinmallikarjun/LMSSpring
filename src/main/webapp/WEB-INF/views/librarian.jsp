<%@ include file="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.LibraryBranch" %>
    <%@ page import="com.gcit.lms.service.LibrarianService" %>
    <% 
    	LibrarianService service = new LibrarianService();
    	List<LibraryBranch> branch = service.getAllBranch(null);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS</title>
</head>
<body>
<h4>Select Your Branch:</h4>
	
	<form action="selectBranch" method="get">
		<p><select name="branchId">
			<%for(LibraryBranch b: branch){ %>
			<option value="<%=b.getBranchId()%>"><%=b.getBranchName() %></option>
			<%} %>
		</select></p>
		<p><button class="btn btn btn-primary" type="submit">Submit</button></p>
	</form>
		
</body>
</html>