<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html >
<!--  get init paramater imageURL -->
<%String imageURL = application.getInitParameter("imageURL");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="js/jquery-1.9.1.js"></script>
<link rel="stylesheet" href="css/bookstore.css" type="text/css" />
<script src="js/bookstore.js" type="text/javascript"></script>

</head>

<body>
	<div id="centered">

		<!--  include header.jsp here -->
		<jsp:include page="header.jsp" flush="true "/>
		<br />
		<!--  include leftColumn.jsp here -->
		<jsp:include page="leftColumn.jsp" flush="true "/>
		<div>
			<span class="label" style="margin-left: 15px;">List of All
				Books</span>
		</div>


		<!--  include list.jsp here -->
		<jsp:include page="list.jsp" flush="true "/>

	</div>


</body>
</html>

