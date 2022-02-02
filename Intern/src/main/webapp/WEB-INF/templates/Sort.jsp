 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body>
<h2>Choose an option for sorting:</h2>
<form action="/Intern/Sort" method="get">
 	<input type="radio" id="Reg"  value="0" name="selection">Registration Number&emsp;
	<input type="radio" id="Name" name="selection" value="1">Name&emsp;
	<input type="radio" id="Marks" name="selection" value="2">Marks<br><br>
	<input type="radio" id="Ascending" name="order" value="a">Ascending&emsp;
	<input type="radio" id="Descending" name="order" value="d">Descending<br><br>
	<input type="submit" value="Submit">
</form>

<h4>Record shown is as below:</h4>

 <%=request.getAttribute("data") %>
 <br>
<form action="/Intern/" method="post">
	<input type="submit" value="Return">
</form>

</body>
</html>

 