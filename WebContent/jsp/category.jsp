

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="js/jquery-1.9.1.js"></script>
<link rel="stylesheet" href="css/bookstore.css" type="text/css" />
<script src="js/bookstore.js"></script>


</head>
<body>
	<div id="centered">
		<!--  include header.jsp here -->
		<br />
		<!--  include leftColumn.jsp here -->
		
		<!--  get category parameter -->
		<!--  get categoryId parameter -->
		<!--  if category is not null, so the following -->

		<div>
			<span class="label" style="margin-left: 15px;">List of <!--  category goes here -->Books
			</span>
		</div>

		<!--  end if category is not null-->
		
		<table id="grid">
			<thead>
				<tr>
					<th id="th-title">Book Title</th>
					<th id="th-author">Author</th>
				</tr>
			</thead>
			<tbody>
			<!--  get attribute bookList -->
			<!--  for each book in booklist, if book is of the category category, get list of authors and print the following  -->
			
				
				<tr>
					<th scope="row" id="r100"><!--  book title goes here --></th>
					<!--  for each author of the current book, do the following  -->
				
					<td><!--  author first name and last name go here --></td>

					<!--  end for each author-->

				</tr>

				<!--  end for each book-->
			</tbody>

		</table>
	</div>
</body>
</html>