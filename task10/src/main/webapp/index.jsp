<%@ page contentType="text/html; charset=utf-8" %>
<html>
	<head>
		<title>Form</title>
	</head>
	<body>
	    <form action="/task10/show" method="post">
			<h1>Form</h1>
			<label for="name">Name:</label><input type="text" name="name"/><br>
			<label for="phone">Phone:</label><input type="text" name="phone"/><br>
			<label for="email">Email:</label><input type="text" name="email"/><br>
			<input type="submit" value="get data"/>
		</form>
	</body>
</html>