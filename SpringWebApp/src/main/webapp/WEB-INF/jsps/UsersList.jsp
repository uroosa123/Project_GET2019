<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>

</head>
<body>
	<div align="center">
	
		
		<h2 style="text-align: center;font-family: verdana;color:#000080">${msg}</h2>
		<h1 style="text-align: center;font-family: verdana;color:#000080">Users List</h1>
		
		<table border="solid 1px #00080" bgcolor="lightgrey">
		<tr>
			<th>User Id</th>
			<th>User Name</th>
			<th>Gender</th>
			<th colspan="2">Options</th>
		</tr>
		<c:forEach items="${usersList}" var="userObj">
			<tr>
				<td>${userObj.userId}</td>
				<td>${userObj.userName}</td>
				<td>${userObj.gender}</td>
				<td><a href="${pageContext.request.contextPath}/updateUser/${userObj.userId}">Update</a></td>
				<td><a href="${pageContext.request.contextPath}/deleteUser/${userObj.userId}">Delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>