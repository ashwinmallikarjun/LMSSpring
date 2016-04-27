<%@ include file="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.Borrower" %>
    <%@ page import="com.gcit.lms.entity.Author" %>
    <%@ page import="com.gcit.lms.service.AdministratorService" %>
    <%@ page import="com.gcit.lms.entity.Book" %>
    <%List<Book> bList = null;
    int cardNo = 0,branchId = 0;
    	if(request.getAttribute("bookList")!=null){
    		bList = (List<Book>)request.getAttribute("bookList");
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
<%if(bList != null){ %>
<h4>Select book to Check Out:</h4>

	<div class="row">
		<div class="col-md-6">
			<table border="2" id="authorsTable" class="table">
				<tr>
					<th >Book Name</th>
					<th>Author(s)</th>
					<th>SELECT</th>
				</tr>
				<tr align="center">
					<%
						for (Book b : bList) {
					%>

					<td>
						<%
							out.println(b.getTitle());
						%>
					</td>
					<td>
						<%
							for (Author a : b.getAuthors()) {
									out.println(a.getAuthorName());
									out.println(", ");
								}
						%>
					</td>
					<td align="center"><button type="button" class="btn btn btn-primary"
							onclick="javascript:location.href='checkOutBookSelect?cardNo=<%=cardNo%>&branchId=<%=branchId%>&bookId=<%=b.getBookId()%>'">CHECK
							OUT BOOK</button></td>
				</tr>
				<%} %>
			</table>
		</div>
	</div>
	<%}else{%>
		<p>No books available at this branch.</p>
		<p><button class="btn btn btn-primary" onclick="javascript:location.href='borrowerCard.jsp'">RETURN</button></p>
		<%}%>
	}
</body>
</html>