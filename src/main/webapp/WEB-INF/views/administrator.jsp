<%@ include file="include.html" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>LMS</title>
</head>
<body>
<h4>Choose your task:</h4>
	<div class="row">
		<div class="col-md-6">
			<table border="2" id="administratorTable" class="table">
				<tr>
					<th>Author Details</th>
					<th>Book Details</th>
					<th>Library Branch Details</th>
					<th>Borrower Details</th>
					<th>Book Loan Details</th>
				</tr>
				<tr>
					<td>
						<p>
							<a href="addauthor.jsp">Add Author</a>
						</p>
						<p>
							<a href="viewAuthor.jsp">View Author(s)</a>
						</p>
					</td>

					<td>
						<p>
							<a href="addbook.jsp">Add Book</a>
						</p>
						<p>
							<a href="viewBook.jsp">View Book(s)</a>
						</p>
					</td>

					<td>
						<p>
							<a href="addBranch.jsp">Add Library Branch</a>
						</p>
						<p>
							<a href="viewBranch.jsp">View Library Branch(s)</a>
						</p>
					</td>

					<td>
						<p>
							<a href="addBorrower.jsp">Add Borrower</a>
						</p>
						<p>
							<a href="viewBorrower.jsp">View Borrower(s)</a>
						</p>
					</td>

					<td>
						<p>
							<a href="overRideDate.jsp">Over-ride due date for a book loan</a>
						</p>
					</td>

				</tr>
			</table>
		</div>
	</div>
</body>
</html>