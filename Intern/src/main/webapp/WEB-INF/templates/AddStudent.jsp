<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body>
<h2>Choose an option for sorting:</h2>
<form action="/Intern/NewRecord" method="post">
 	<br>Registration Number: <input type="text" id="RegNo" name="RegNo"><br>
	<br>Full Name:&emsp;&emsp;&emsp;&emsp;&ensp;<input type="text" id="Name" name="Name"><br>
	<br>Marks:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input type="text" id="Marks" name="Marks"><br><br>
	<input type="submit" value="Submit">
</form>

<form action="/Intern/" method="post">
	<input type="submit" value="Return">
</form>

</body>
</html>