<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body>
<h2>Record shown is as below:</h2>
<%=request.getAttribute("Err")%>
 <%=request.getAttribute("data")%>
 
 <br>
<form action="/Intern/" method="post">
	<input type="submit" value="Return">
</form>
</body>
</html>