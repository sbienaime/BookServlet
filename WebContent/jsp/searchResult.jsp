<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html >
<%
	String imageURL = application.getInitParameter("imageURL");
%>
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
		<jsp:include page="header.jsp" flush="true " />

		<form class="search">
			<input type="hidden" name="action" value="search" /><input id="text"
				type="text" name="keyWord" size="12" /><span
				class="tooltip_message">?</span>
			<p />
			<input id="submit" type="submit" value="Search" />
		</form>
		<br />
		<!--  include leftColumn.jsp here -->
		<jsp:include page="leftColumn.jsp" flush="true " />

		<!--  include list.jsp here -->
		<jsp:include page="list.jsp" flush="true " />


	</div>


</body>
</html>

