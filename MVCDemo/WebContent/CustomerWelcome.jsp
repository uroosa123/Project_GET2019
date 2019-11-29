<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Welcome</title>
</head>
<body>
<div align="right">
		<h2 style="font-weight:bold;color:blue"> ${sessionScope.uObj.customerName} </h2>
	</div>
	<hr/>
	
	<div align="center">
		<h1 style="font-style:verdana;font-weight:bold;color:green">Welcome Customer</h1>
	</div>
</body>
</html>