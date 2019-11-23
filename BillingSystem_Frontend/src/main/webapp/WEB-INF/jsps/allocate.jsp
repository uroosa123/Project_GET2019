
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1" isELIgnored="false" %>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Allocation </title>

</head>

<body>

<hr/>
		<div align="center">
		<h1 style="text-align: center;font-family: verdana;color:#000080">Allocate Here! </h1>
		
		<core:if test="${not empty msg}">
		<div style="text-align: center;font-family: verdana;color:#000080" class="alert alert-success">${msg}
		</div>
		</core:if>
		
		
		<hr/>

     <form action="submitAllocate"  method="get">

				<label>Projects:</label>

			<select name="projectId">

			 	 <core:forEach items="${projList}" var="pOb">

					<option value="${pOb.projectId}">${pOb.projectName}</option>

				 </core:forEach>

			</select><br>

 			<div>

			<label>Role:</label>

				<select name="roleId">

				 	 <core:forEach items="${roleList}" var="rOb">

						<option value="${rOb.roleId}">${rOb.roleName} </option>

					 </core:forEach>

				</select><br>

			</div>

 		<label>Location:</label>

			<div>

				<div class="custom-control custom-radio">	

					 <input type="radio" name="location" value="Onsite" checked> Onsite<br>

 					 <input type="radio" name="location" value="Offshore"> Offshore<br>

					

					

					

				</div>

			<div>	

			<label>Employee:</label>

			<select name="employeeId">

			  

				 	 <core:forEach items="${empList}" var="rOb">

						<option value="${rOb.employeeId}">${rOb.employeeName} </option>

					 </core:forEach>

				</select><br>

				

			</div>

				<div class="form-group">

				    <button type="submit" class="btn btn-primary">Submit</button>

				 </div>

			</form>
			</div>

</body>

</html>