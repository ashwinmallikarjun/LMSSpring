<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.LibraryBranch" %>
    <%@ page import="com.gcit.lms.service.AdministratorService" %>
    <%LibraryBranch branch = null;
    if(request.getAttribute("branch")!=null){
    	branch = (LibraryBranch)request.getAttribute("branch");
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
<h4>Edit Branch Details Below:</h4>
	<form action="updateBranch" method="post">
		<p>Branch Name: <input type="text" name="branchName" value="<%=branch.getBranchName() %>"></p>
		<p>Branch Address: <input type="text" name="branchAddress" value="<%=branch.getBranchAddress() %>"></p>
		<input type="hidden" name="branchId" value=<%=branch.getBranchId()%>>
		<p><button class="btn btn btn-primary" type="submit">Edit Branch</button></p>
	</form>
</div>
</body>
</html>