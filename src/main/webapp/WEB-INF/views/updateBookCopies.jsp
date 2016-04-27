<%@ include file="include.html" %>
<%@page import="com.gcit.lms.entity.BookCopies"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.BookCopies" %>
    <%@ page import="com.gcit.lms.entity.Book" %>
    <%@ page import="com.gcit.lms.service.AdministratorService" %>
    <%List<BookCopies> bc = null;
    if(request.getAttribute("bookCopies")!=null){
    	bc = (List<BookCopies>)request.getAttribute("bookCopies");
    	}%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS</title>
</head>
<body>
<h4>Edit Book Copies Below:</h4>
	<div class="row">
		<div class="col-md-6">
			<table border="2" id="authorsTable" class="table">
				<tr>
					<th>Book ID</th>
					<th>No. of Copies</th>
					<th>EDIT</th>
				</tr>
				<form action="updateCopies" method="post">
					<%
						for (BookCopies bcop : bc) {
					%>
					<tr>
						<td>
							<%
								out.println(bcop.getBooks().getBookId());
							%>
						</td>
						<td><input type="text" name="noOfCopies"
							value="<%=bcop.getNoOfCopies()%>"></td>
						<input type="hidden" name="branchId"
							value=<%=bcop.getBranch().getBranchId()%>>
						<input type="hidden" name="bookId"
							value=<%=bcop.getBooks().getBookId()%>>
						<td align="center"><button class="btn btn btn-primary" type="submit">Edit</button></td>
					</tr>
					<%}%>
				</form>
			</table>
		</div>
	</div>
</body>
</html>