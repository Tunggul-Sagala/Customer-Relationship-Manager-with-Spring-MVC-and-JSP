<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Customer Relationship Manager</title>
	
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
				<h3>CRM - Customer Relationship Manager</h3>
		</div>
	</div>
	
	<div id="container">	
		<div id="content">
			<input type="button" value="Add Customer"
					onclick="window.location.href='${pageContext.request.contextPath}/add'; return false;"
					class="add-button" />
		</div>
	</div>	
	<table>
			<tr>
				<th>First name</th>
				<th>Last name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<c:forEach var="temp" items="${customers}">
				<c:url var="updateLink" value="/update">
					<c:param name="customerId" value="${temp.id}" />
				</c:url>
				<c:url var="deleteLink" value="/delete">
					<c:param name="customerId" value="${temp.id}" />
				</c:url>
				<tr>
					<td>${temp.firstName}</td>
					<td>${temp.lastName}</td>
					<td>${temp.email}</td>
					<td><a href="${updateLink}">Update</a>
					|
						<a href="${deleteLink}" 
							onclick="if (!(confirm('Are you sure want to delete this customer?'))) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>