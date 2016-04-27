<%@ include file="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.Author" %>
    <%@ page import="com.gcit.lms.entity.Book" %>
    <%@ page import="com.gcit.lms.entity.Genre" %>
    <%@ page import="com.gcit.lms.service.AdministratorService" %>
    <% 
    	AdministratorService service = new AdministratorService();
   	 	Integer bookCount = service.getBookCount();
    	
   	 	List<Book> books = new ArrayList<Book>();
    	if (request.getAttribute("book") != null) {
    		books = (List<Book>)request.getAttribute("book");
    		bookCount = books.size();
    	}else{
    		books = service.getAllBooks(1);	
    	}
    %>

<script type="text/javascript">
	//Delete book function.
	function deleteBook(bookId) {

		$.ajax({
			url : "deleteBook",
			data : {
				bookId : bookId
			}
		}).done(function(data) {
			$('#booksTable').html(data);
		});
	}
	
	
	//Search book function.
	function searchBook(){
	
	$.ajax({
		  url: "searchBooks",
		  data:{
			  searchString: $('#searchStrings').val()
		  }
		}).done(function(data) {
		  $('#booksTable').html(data);
		});
	}
	
	
</script>

<title>LMS</title>

	<div class="input-group">
       	<p><input type="text" class="form-control" placeholder="SEARCH"
			aria-describedby="basic-addon1" name="searchString" id="searchStrings" onkeyup="searchBook()"></p>
		<p><button class="btn btn btn-info" onclick="searchBook()" id="searchStrings">Search</button></p>
	</div>

<div id="searchResults">

	<nav>
	<ul class="pagination">
		<li><a href="#" aria-label="Previous"> <span
				aria-hidden="true">&laquo;</span>
		</a></li>
		<%
			if (bookCount != null && bookCount > 0) {
				int pageNo = bookCount % 10;
				int pages = 0;
				if (pageNo == 0) {
					pages = bookCount / 10;
				} else {
					pages = bookCount / 10 + 1;
				}
				for (int i = 1; i <= pages; i++) {
		%>
		<li><a href="pageBook?pageNo=<%=i%>"><%=i%></a></li>
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
			<table align="center" border="2" id="booksTable" class="table">
				<tr>
					<th>Book Title</th>
					<th>Author(s)</th>
					<th>Genre(s)</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<tr>
					<%
						for (Book b : books) {
					%>
					<td>
						<%
							out.println(b.getTitle());
						%>
					</td>
					<td>
						<%for (Author a : b.getAuthors()){
							out.println(a.getAuthorName());
							out.println(", ");
						}
						%>
					</td>
					<td>
						<%
							for (Genre g : b.getGenres()) {
									out.println(g.getGenre_name());
									out.println(", ");
								}
						%>
					</td>
					<td align="center"><button type="button"
							class="btn btn btn-primary" data-toggle="modal"
							data-target="#myModal1"
							href="editBook?bookId=<%=b.getBookId()%>">EDIT</button></td>
											
					<td align="center"><button type="button"
							class="btn btn-sm btn-danger"
							onclick="deleteBook(<%=b.getBookId()%>)">DELETE</button></td>
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

