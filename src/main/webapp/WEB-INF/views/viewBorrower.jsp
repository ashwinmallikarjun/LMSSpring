<%@ include file="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.gcit.lms.entity.Borrower"%>
<%@ page import="com.gcit.lms.service.AdministratorService"%>
<%
		AdministratorService service = new AdministratorService();
   		Integer brrCount = service.getBorrowerCount();
	    
	    List<Borrower> brr = new ArrayList<Borrower>();
		if (request.getAttribute("borrower") != null) {
			brr = (List<Borrower>)request.getAttribute("borrower");
			brrCount = brr.size();
		}else{
			brr = service.getAllBorrower(1);	
		}
%>

<script type="text/javascript">
	//Delete author function.
	function deleteBorrower(cardNo) {

		$.ajax({
			url : "deleteBorrower",
			data : {
				cardNo : cardNo
			}
		}).done(function(data) {
			$('#borrowerTable').html(data);
		});
	}
	
	//Search book function.
	function searchBorrower(searchString){
	
	$.ajax({
		  url: "searchBorrower",
		  data:{
			  searchString: $('#searchStrings').val()
		  }
		}).done(function(data) {
		  $('#borrowerTable').html(data);
		});
	}
	
	
</script>

<title>LMS</title>

	<div class="input-group">
		<p><input type="text" class="form-control" placeholder="SEARCH"
			aria-describedby="basic-addon1" name="searchString" id="searchStrings" onkeyup="searchBorrower()"></p>
		<p><button class="btn btn btn-info" onclick="searchBorrower()" id="searchStrings">Search</button></p>
	</div>


<div id="searchResults">

	<nav>
	<ul class="pagination">
		<li><a href="#" aria-label="Previous"> <span
				aria-hidden="true">&laquo;</span>
		</a></li>
		<%
			if (brrCount != null && brrCount > 0) {
				int pageNo = brrCount % 10;
				int pages = 0;
				if (pageNo == 0) {
					pages = brrCount / 10;
				} else {
					pages = brrCount / 10 + 1;
				}
				for (int i = 1; i <= pages; i++) {
		%>
		<li><a href="pageBorrower?pageNo=<%=i%>"><%=i%></a></li>
		<%
			}

			}
		%>
		<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		</a>
	</ul>
	</nav>
	<div class="row">
		<div class="col-md-6">
			<table border="2" id="borrowerTable" class="table">
				<tr>
					<th>Name</th>
					<th>Address</th>
					<th>Phone</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<tr>
					<%
						for (Borrower b : brr) {
					%>
					<td>
						<%
							out.println(b.getName());
						%>
					</td>
					<td>
						<%
							out.println(b.getAddress());
						%>
					</td>
					<td>
						<%
							out.println(b.getPhone());
						%>
					</td>
						
					<td align="center"><button type="button"
							class="btn btn btn-primary" data-toggle="modal"
							data-target="#myModal1"
							href="editBorrower?cardNo=<%=b.getCardNo()%>">EDIT</button></td>
							
					<td align="center"><button type="button"
							class="btn btn-sm btn-danger"
							onclick="deleteBorrower(<%=b.getCardNo()%>)">DELETE</button></td>

				</tr>
				<%}%>
			</table>
		</div>
	</div>
</div>	
	
	<div id="myModal1" class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg">
			<div class="modal-content"></div>
		</div>
	</div>
