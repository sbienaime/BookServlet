
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  import =  " java.util.List " %>
<%@ page  import =  " java.util.ArrayList " %>
<%@ page  import =  " java.util.Iterator " %>
<%@ page import="edu.mdc.cop4807.books.model.*"%>   


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
		
		<span class="label">Featured Books</span>
		
		<!--  get category parameter -->
		 <%
                     String category = request.getParameter (  "category" );
                     String categoryId = request.getParameter (  "categoryId" );
                      if  (category!=  null ) {
               %>
				
		
		
		
		
		<!--  if category is not null, so the following -->		
		
		
		
		<div>
			<span class="label" style="margin-left: 15px;">List of <!--  category goes here -->Books
			</span>
		</div>
 <%
                     }
               %>
		<!--  end if category is not null-->
		
		<table id="grid">
			<thead>
				<tr>
					<th id="th-title">Book Title</th>
					<th id="th-author">Author</th>
				</tr>
			</thead>
			<tbody>
			
			   <%  List <Book> books =  (List<Book>) request.getAttribute ("bookList") ;
                                                Iterator <Book> iterator = books.iterator ();
                                                 while  (iterator.hasNext ()) {
                                                       Book book = (Book) iterator.next ();
                                                        if  (book.getCategoryId (). toString (). equals (categoryId)) {
                                                              Long bookId = book.getId ();
                                                              List <Author> authors = book.getAuthors ();
                            %>
			<!--  get attribute bookList -->
			<!--  for each book in booklist, if book is of the category category, get list of authors and print the following  -->
			
				<tr>
					<th scope="row" id="r100"><!--  book title goes here --></th>
					
					      <%
                                          for  (Author author: authors) {
                                                                                   if  ( book.getId (). equals (author.getBookId ())) {
                                   %><td> <%=author.getFirstName()+" "
                                                              +author.getLastName () %> </td>
 
                                   <%
                                         }
                                                                           }
                                   %>
					</tr>
					
					  <%
                                  }
                                                }
                            %>
					<!--  for each author of the current book, do the following  -->
				
					<!--  author first name and last name go here -->

					<!--  end for each author-->

				

				<!--  end for each book-->
			</tbody>

		</table>
	</div>
</body>
</html>