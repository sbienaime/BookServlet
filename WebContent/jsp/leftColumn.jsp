<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="edu.mdc.cop4807.books.model.*"%>
<%@ page import="java.util.Iterator"%>

<%
	String param1 = application.getInitParameter("bookstoreURL");
%>
<head>
<link rel="stylesheet" href="css/bookstore.css" type="text/css" />
<script src="js/bookstore.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
</head>




<div class="leftbar">
	<ul id="menu">
		<li><div>
				<a class="link1" href="<%=param1%>?action=home"> <span
					class="label" style="margin-left: 15px;">Home</span>
				</a>
			</div></li>




		<li><div>
				<a class="link1" href="<%=param1%>?action=allBooks"><span
					style="margin-left: 15px;" class="label">All Books</span></a>
			</div></li>









		<li><div>
				<!-- Accessing the Category Model in leftColumn.jsp on Page 136 -->
				<span class="label" style="margin-left: 15px;">Categories</span>
			</div>






			<ul>
				<!--   get categoryList attribute -->

				<!--   for each category do the following -->
				<%
					List<Category> categoryList1 = (List <Category>) application.getAttribute("categoryList"); 
					Iterator<Category> iterator1 = categoryList1.iterator(); 
					while (iterator1.hasNext()) { 
					Category category1 = (Category) iterator1.next();
				%>


				<li><a class="label"
					href=<%=param1%>?action=category&categoryId=<%=category1.getId()%>&category=<%=category1.getCategoryDescription()%>><span
						class="label" style="margin-left: 30px;"><%=category1.getCategoryDescription()%></span></a>
				</li>
				<!--   end for each category -->
				<%
					}
				%>

			</ul></li>
		<li><div>
				<span class="label" style="margin-left: 15px;">Contact Us</span>
			</div></li>
			<li><div>
			<a class="link1" href="<%=param1%>?action=addBooks"> <span
					class="label" style="margin-left: 15px;">Add Books</span>
				</a>
			</div></li>
			
	</ul>
	<form class="search">
		<input type="hidden" name="action" value="search" /> <input id="text"
			type="text" name="keyWord" size="12" /> <span
			class="tooltip_message">?</span>
		<p />
		<input id="submit" type="submit" value="Search" />
	</form>


</div>






