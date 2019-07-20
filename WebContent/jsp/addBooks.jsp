<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<link rel="stylesheet" href="css/bookstore.css" type="text/css" />
<script src="js/bookstore.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>


</head>
<body>
<jsp:include page="header.jsp" flush="true" />
<br>
<br>

<jsp:include page="leftColumn.jsp" flush="true" />



<H2>Please enter a book title and the corresponding author and click submit</H2>
<form method="GET" >
<label style="padding:0; margin:0;">Book Title</label>  <input type="text" name="title"><br>
  <label style="padding:0; margin:0;">Author Firstname</label> <input type="text" name="firstname">
   <label style="padding:0; margin:0;">Author Lastname</label> <input type="text" name="lastname">
    <label style="padding:0; margin:0;"> Publisher</label> <input type="text" name="lastname">
  <input type="hidden" name="action" value="addBooks" /> 
  <input type="submit" value="Submit">

</form>

</body>
</html>