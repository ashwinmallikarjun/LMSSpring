<%@ include file="include.html" %>
<%@page import="com.gcit.lms.entity.Book"%>
<%@page import="com.gcit.lms.entity.LibraryBranch"%>
<%@page import="com.gcit.lms.entity.BookLoans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.BookLoans" %>
    <%@ page import="com.gcit.lms.service.AdministratorService" %>
    <% List<BookLoans> bkl = null;
    int cardNo = 0;
       if(request.getAttribute("bookLoans")!=null){
       	bkl = (List<BookLoans>)request.getAttribute("bookLoans");
       	cardNo = (Integer)request.getAttribute("cardNo");
       	}else{
       		out.println("Object is null in borrowerBooks.jsp");
       	}	
	%>
    	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" ></script>
${result}
</head>
<body>
<h4>Edit Due Date Below:</h4>

	<div class="row">
		<div class="col-md-6">
			<table border="2" id="authorsTable" class="table">
				<tr>
					<th>Book ID</th>
					<th>Branch ID</th>
					<th>Issued Date</th>
					<th>Due Date</th>
					<th>EXTEND</th>
				</tr>

				<%
					for (BookLoans b : bkl) {
				%>
				<tr>
					<td>
						<%
							out.println(b.getBooks().getBookId());
						%>
					</td>
					<td>
						<%
							out.println(b.getBranch().getBranchId());
						%>
					</td>
					<td>
						<%
							out.println(b.getDateOut());
						%>
					</td>
					<td>
						<%
							out.println(b.getDueDate());
						%>
					</td>
					<td align="center"><button type="button" class="btn btn btn-primary"
							onclick="javascript:location.href='editDate?cardNo=<%=cardNo%>&branchId=<%=b.getBranch().getBranchId()%>&bookId=<%=b.getBooks().getBookId()%>&dueDate=<%=b.getDueDate() %>'">EXTEND</button></td>
					<%} %>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>