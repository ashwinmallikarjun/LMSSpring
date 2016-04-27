<%@ include file="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.Author" %>
    <%@ page import="com.gcit.lms.entity.Book" %>
    <%@ page import="com.gcit.lms.service.AdministratorService" %>
    <% 
    	AdministratorService service = new AdministratorService();
    	List<Book> books = service.getAllBooks(null);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS</title>
</head>
<body>
<h4>Enter Author Details Below:</h4>
	
	<form action="addAuthor" method="post">
		<p>Author Name: <input type="text" name="authorName"> <br /></p>
		<p>Associate author to books:<br/></p>
		<p><select name="bookId">
			<%for(Book b: books){ %>
			<option value="<%=b.getBookId()%>"><%=b.getTitle() %></option>
			<%} %>
		</select></p>
		<p><button class="btn btn btn-primary" type="submit">Add Author</button></p>
	</form>
	
</body>
</html>