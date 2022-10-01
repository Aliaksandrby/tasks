<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>Info</title>
		<link rel="stylesheet" href="css/style_table.css">
	</head>
	<body>
	    <h2>Persons</h2>
        <table>
          <tr>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
          </tr>
        <c:forEach items="${persons}" var="person">
          <tr>
            <td><c:out value="${person.name}"/></td>
            <td><c:out value="${person.phone}"/></td>
            <td><c:out value="${person.email}"/></td>
          </tr>
        </c:forEach>
        </table>
	</body>
</html>