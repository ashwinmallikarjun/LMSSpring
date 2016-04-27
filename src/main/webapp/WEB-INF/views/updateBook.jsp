<%@page import="com.gcit.lms.entity.Genre"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.Author" %>
    <%@ page import="com.gcit.lms.entity.Book" %>
    <%@ page import="com.gcit.lms.service.AdministratorService" %>
    <%Book book = null;
    if(request.getAttribute("book")!=null){
    	book = (Book)request.getAttribute("book");
    	}%>
    	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" ></script>
${result}
</head>
<body>
<div class="modal-body">
${result}
<h4>Edit Book Details Below:</h4>
	<form action="updateBook" method="post">
		<p>Book Name: <input type="text" name="title" value="<%=book.getTitle() %>"> <br /></p>
			<p>Author(s): </p>
			<%
				for (Author a : book.getAuthors()) {
			%>
			<p><input type="text" name="authorName"
					value="<%=a.getAuthorName()%>"> 
			</p>
			<%
				}
			%>
			<p>Genre(s):</p>
			<%
				for (Genre g : book.getGenres()) {
			%>
			<p> <input type="text" name="authorName"
					value="<%=g.getGenre_name()%>"> 
			</p>
			<%} %>
			<input type="hidden" name="bookId" value=<%=book.getBookId()%>></p>
		<p><button class="btn btn btn-primary" type="submit">Edit Book</button></p>
	</form>
	</div>
</body>
</body>
</html>