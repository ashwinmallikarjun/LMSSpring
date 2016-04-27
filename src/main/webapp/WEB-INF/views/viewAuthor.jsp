<%@ include file="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.Author" %>
    <%@ page import="com.gcit.lms.entity.Book" %>
    <%@ page import="com.gcit.lms.service.AdministratorService" %>
    <% 
    AdministratorService service = new AdministratorService();
    Integer authorsCount = service.getAuthorCount();
    
    List<Author> authors = new ArrayList<Author>();
	if (request.getAttribute("authors") != null) {
		authors = (List<Author>)request.getAttribute("authors");
		authorsCount = authors.size();
	}else{
		authors = service.getAllAuthors(1);	
	}
    %>
    

<script type="text/javascript">
	//Delete author function.
	function deleteAuthor(authorId) {

		$.ajax({
			url : "deleteAuthor",
			data : {
				authorId : authorId
			}
		}).done(function(data) {
			$('#authorsTable').html(data);
		});
	}
	
	//Search author function.
	function searchAuthor(){
	
	$.ajax({
		  url: "searchAuthors",
		  data:{
			  searchString: $('#searchStrings').val()
		  }
		}).done(function(data) {
		  $('#authorsTable').html(data);
		});
}
	
</script>

<title>LMS</title>


	<div class="input-group">
       	<p><input type="text" class="form-control" placeholder="SEARCH"
			aria-describedby="basic-addon1" name="searchString" id="searchStrings" onkeyup="searchAuthor()"></p>
		<p><button class="btn btn btn-info" onclick="searchAuthor()" id="searchStrings">Search</button></p>
	</div>


<div id="searchResults">

	<nav>
	<ul class="pagination">
		<li><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
		</a></li>
		<%
			if (authorsCount != null && authorsCount > 0) {
				int pageNo = authorsCount % 10;
				int pages = 0;
				if (pageNo == 0) {
					pages = authorsCount / 10;
				} else {
					pages = authorsCount / 10 + 1;
				}
				for (int i = 1; i <= pages; i++) {
		%>
		<li><a href="pageAuthors?pageNo=<%=i%>"><%=i%></a></li>
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
			<table align="center" border="2" id="authorsTable" class="table">
				<tr>
					<th>Author Name</th>
					<th>Book Title</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>

				<%
					for (Author a : authors) {
				%>
				<tr>
					<td>
						<%
							out.println(a.getAuthorName());
						%>
					</td>
					<td>
						<%
							if (a.getBooks() != null && a.getBooks().size() > 0) {
									for (Book b : a.getBooks()) {
										out.println(b.getTitle());
										out.println(", ");
									}
								}
						%>
					</td>
				<td align="center"><button type="button"
						class="btn btn btn-primary" data-toggle="modal"
						data-target="#myModal1"
						href="editAuthor?authorId=<%=a.getAuthorId()%>">EDIT</button></td>

					<td align="center"><button type="button"
							class="btn btn btn-danger"
							onclick="deleteAuthor(<%=a.getAuthorId()%>)">DELETE</button></td>
				</tr>
				<%} %>
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
