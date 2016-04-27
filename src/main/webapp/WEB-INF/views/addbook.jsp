<%@ include file="include.html" %>
<%@page import="com.gcit.lms.entity.Genre"%>
<%@page import="com.gcit.lms.entity.Publisher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.gcit.lms.entity.Author"%>
<%@ page import="com.gcit.lms.entity.Book"%>
<%@ page import="com.gcit.lms.service.AdministratorService"%>
<%
	AdministratorService service = new AdministratorService();
	List<Author> authors = service.getAllAuthors(null);
	List<Publisher> publishers = service.getAllPublisher();
	List<Genre> genres = service.getAllGenre();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS</title>
</head>
<body>
<h4>Enter Book Details Below:</h4>
	
	<form action="addBook" method="post">
		<p>Book Name: <input type="text" name="title"></p></br>
		
		<p>Associate Book to an Author(s):</p>
		<select multiple name="authorId">
			<p><%for(Author au: authors){ %>
			<option value="<%=au.getAuthorId()%>"><%=au.getAuthorName()%></option>
			<%} %>
		</select></p>
		<br/>
		
		<p>Associate Book to a Publisher:</p>
		<p><select name="publisherId">
			<%for(Publisher pu: publishers){ %>
			<option value="<%=pu.getPublisherId()%>"><%=pu.getPublisherName()%></option>
			<%} %>
		</select></p>
		<br/>
		
		<p>Associate Book to a Genre(s):</p>
		<p><select multiple name="genre_id">
			<%for(Genre gn: genres){ %>
			<option value="<%=gn.getGenre_id()%>"><%=gn.getGenre_name()%></option>
			<%} %>
		</select></p>
		<br/>
		
		<p><button class="btn btn btn-primary" type="submit">Add Book</button></p>
	</form>

</body>
</html>