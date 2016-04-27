<%@ include file="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.Author" %>
    <%@ page import="com.gcit.lms.entity.Book" %>
    <%@ page import="com.gcit.lms.service.AdministratorService" %>
     <%List<Book> bList = null;
    int cardNo = 0,branchId = 0;
    	if(request.getAttribute("bookLoanList")!=null){
    		bList = (List<Book>)request.getAttribute("bookLoanList");
    		cardNo = (Integer)request.getAttribute("cardNo");
    		branchId = (Integer)request.getAttribute("branchId");
    	}%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS</title>
</head>
<body>
	<%if(bList!=null && bList.size()>0){%>
		<div class="row">
		<div class="col-md-6">
	<table border="2" id="authorsTable" class="table">
	<tr>
		<th>Book Title</th>
		<th>Author Name</th>
		<th>RETURN</th>
	</tr>
	
		<% for (Book a: bList){ %>
		<tr>
		<td><% out.println(a.getTitle()); %></td>
		<td><%if(a.getAuthors()!=null && a.getAuthors().size() >0){
			for(Author b: a.getAuthors()){
				out.println(b.getAuthorName());
				out.println(", ");
				}
		}	
		%></td>
		<td align="center"><button class="btn btn btn-primary" type="button" onclick="javascript:location.href='returnBookSelect?cardNo=<%=cardNo %>&branchId=<%=branchId %>&bookId=<%=a.getBookId() %>'">RETURN BOOK</button></td>
		</tr>
		<%}%> 
	</table>
	</div>
	</div>
	<%}else{%>
		<div class="modal-body">
		<p>Book check-out record not found for this card number.</p>
		<p><button class="btn btn btn-primary" onclick="javascript:location.href='borrowerCard.jsp'">RETURN</button></p>
		</div>
	<%}%>
	
</body>
</html>