<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.Author" %>
    <%@ page import="com.gcit.lms.entity.Book" %>
    <%@ page import="com.gcit.lms.service.AdministratorService" %>
    <%Author author = null;
    if(request.getAttribute("author")!=null){
    	author = (Author)request.getAttribute("author");
    	}%>
    	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" ></script>
</head>
<body>
<div class="modal-body">
${result}
<h4>Edit Author Details Below:</h4>
	<form action="updateAuthor" method="post">
		<p>Author Name: <input type="text" name="authorName" value="<%=author.getAuthorName()%>"> <br /></p>
		<%if(author.getBooks() != null && author.getBooks().size()>0){ %>
		<p>Associated Book(s): <br/></p>
		<%for(Book b: author.getBooks()){ %>
		<p><input type="text" name="title" value="<%=b.getTitle() %>"> <br/></p>
			<input type="hidden" name="bookId" value=<%=b.getBookId() %>>
		<%}
		}%>
		<input type="hidden" name="authorId" value=<%=author.getAuthorId() %>>
		<p><button class="btn btn btn-primary" type="submit">Edit Author</button></p>
	</form>
	</div>
</body>
</html>