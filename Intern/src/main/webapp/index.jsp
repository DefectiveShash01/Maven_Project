<html>
<body>
<h2>Hello!</h2>
<!--  -->
<p>Welcome to the database</p>
<form action="Home" method="post" >
	<label for="option">Choose an option:</label>
	<select id="option" name="option" size="6" onchange="location=this.value" >
  		<option value="Record">Print the Record</option>
  		<option value="InputName">Find Name in Record</option>
  		<option value="InputReg">Find Registration Number in Record</option>
  		<option value="CheckMarks">Results for Student</option>
  		<option value="Sort">Sort </option>
  		<option value="AddStudent">Add Students</option>
 	</select><br><br>
</form>

</body>
</html>
