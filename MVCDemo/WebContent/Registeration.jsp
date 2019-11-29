<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<c:url value="E:\uroosa\servlets\MVCDemo\WebContent\js\uroosa.js" />"></script>
<title>Registeration Page</title>
</head>
<body>
<hr/>
<div align="center">
<form action="register" method="post" name="regF">
<h1 style="background-color:lightblue;color:blue;text-align:center">REGISTERATION FORM</h1>
<div   style="background-color:lightblue;width:30%">
<table><tr><td>Customer ID:</td><td><input type="text" name="customerId"/></td></tr>
<tr><td>Customer Name:</td><td><input type="text" name="customerName"/></td></tr>
<tr><td>Gender : </td>
<td><input type="radio" name="gender" value="m" checked>Male
<input type="radio" name="gender" value="f">Female</td></tr>
<tr><td>Email:</td><td><input type="text" name="email"/></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
<tr><td>City:</td><td>
<select name="city">
<option>Lucknow</option>
<option>Delhi NCR</option>
<option>Greater Noida</option>
</select>
</td></tr>
<tr><td></td><td><input type="submit" value="register"/></td></tr>
</table>

</div>
</form>
</div>


</body>
</html>