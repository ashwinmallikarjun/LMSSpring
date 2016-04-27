<%@ include file="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.Borrower" %>
    <%@ page import="com.gcit.lms.service.AdministratorService" %>
    <%@ page import="com.gcit.lms.entity.LibraryBranch" %>
    <%@ page import="com.gcit.lms.service.LibrarianService" %>
    <% LibraryBranch lib = null;
    
    	LibrarianService service = new LibrarianService();
    	List<LibraryBranch> branch = service.getAllBranch(null);
    
    	Borrower brr = null;
    	if(request.getAttribute("cardNo")!=null){
    		brr = (Borrower)request.getAttribute("cardNo");
    	}%>
    	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>LMS</title>
</head>
<body>
<%if(brr!=null){ %>
<h4>Choose Your Task:</h4>

	<div class="row">
		<div class="col-md-6">
			<table border="2" id="brrOperationTable" class="table">
				<tr>
					<th>Branch Name</th>
					<th>CHECK OUT</th>
					<th>RETURN</th>

				</tr>
				<tr>
					<%
						for (LibraryBranch b : branch) {
					%>

					<td>
						<%
							out.println(b.getBranchName());
						%>
					</td>

					<td align="center"><button class="btn btn btn-primary"
							type="button"
							onclick="javascript:location.href='checkOutBook?cardNo=<%=brr.getCardNo()%>&branchId=<%=b.getBranchId()%>'">CHECK
							OUT BOOK</button></td>

					<td align="center"><button class="btn btn btn-success" 
							onclick="javascript:location.href='returnBook?cardNo=<%=brr.getCardNo()%>&branchId=<%=b.getBranchId()%>'">RETURN
							BOOK</button></td>

				</tr>
				<%} %>
			</table>
		</div>
	</div>
	<%} else{%>
		<div class="alert alert-danger" role="alert">
        <p><strong>Oh snap!</strong> Invalid Card number. Please try again.</p>
        <p><button class="btn btn btn-primary" onclick="javascript:location.href='borrowerCard.jsp'">RETURN</button></p>
      </div>
	<%}%>
</body>

</html>