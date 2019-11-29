<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	
		<h1 style="text-align: center;font-family: verdana;color:#000080">Product List</h1>
		<h2 style="text-align: center;font-family: verdana;color:#000080">${msg}</h2>
		<table border="solid 1px #00080" bgcolor="lightgrey">
		<tr>
		    <th>Product ID</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th colspan="2">Options</th>
		</tr>
		<c:forEach items="${usersList}" var="userObj">
			<tr>
			    <td>${userObj.productId}</td>
				<td>${userObj.productName}</td>
				<td>${userObj.price}</td>
				<td><a href="${pageContext.request.contextPath}/updateUser/${userObj.productId}">Update</a></td>
				<td><a href="${pageContext.request.contextPath}/deleteUser/${userObj.productId}">Delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</div>

</body>
</html>