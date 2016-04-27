<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.Borrower" %>
    <%@ page import="com.gcit.lms.service.AdministratorService" %>
    <%Borrower borrower = null;
    if(request.getAttribute("borrower")!=null){
    	borrower = (Borrower)request.getAttribute("borrower");
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
<h4>Edit Borrower Details Below:</h4>
	<form action="updateBorrower" method="post">
		<p>Borrower Name: <input type="text" name="name" value="<%=borrower.getName() %>"> <br /></p>
		<p>Borrower Address: <input type="text" name="address" value="<%=borrower.getAddress() %>"> <br /></p>
		<p>Borrower Phone: <input type="text" name="phone" value="<%=borrower.getPhone() %>"> <br /></p>
		<input type="hidden" name="cardNo" value=<%=borrower.getCardNo()%>>
		<p><button class="btn btn btn-primary" type="submit">Edit Borrower</button></p>
	</form>
	</div>
</body>
</html>