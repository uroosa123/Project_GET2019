
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Registration Form</title>
</head>
<body>
<div align="center">
<h1 style="text-align: center;font-family: verdana;color:#000080">Product Registration Form</h1>
<hr/>
<form action="${pageContext.request.contextPath}/registerUser" method="post">
			<table>
				<tr>
					<td>Product Name</td>
					<td><input type="text" name="productName" onkeyup="check()"/></td>
				</tr>
				<tr>
					<td>Product Price</td>
					<td><input type="text" name="price" /></td>
				</tr>
				</table>
			<input type="submit" value="Submit" onclick="return confirm('Are you sure you want to add the product')" /></form>
			</table>
			</div>
</body>
</html>