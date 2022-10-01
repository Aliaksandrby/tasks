<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Info</title>
	</head>
	<body>
	    <h1>Greetings user <c:out value="${browserBean.info}"/></h1>
	</body>
</html>