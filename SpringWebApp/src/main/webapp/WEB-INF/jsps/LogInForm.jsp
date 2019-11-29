<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: center;font-family: verdana;color:#000080">
			${msg}
		</h1>
		<h1 style="text-align: center;font-family: verdana;color:#000080">
			${msg1}
		</h1>
		<hr/>
		<div align="center">
		<h1 style="text-align: center;font-family: verdana;color:#000080">Sign In</h1>
		<form action="signIn" method="post">
			<table>
				<tr>
					<td>User Id : </td>
					<td><input type="text" name="userId"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pass"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Sign In"/></td>
				</tr>
			</table>
		</form>
		</div>
</body>
</html>