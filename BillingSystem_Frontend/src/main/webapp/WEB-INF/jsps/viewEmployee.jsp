<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header2.jsp" %>
 <%@ include file="footer.jsp" %>
 <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="Billing"  method="get">

					<div>

						<label>Employee :</label>

						<select name="employeeId">

						 	 <core:forEach items="${devL}" var="pOb">

								<option value="${pOb.empObj.employeeId}" >${pOb.empObj.employeeName}</option>

							 </core:forEach>

						</select><br>

					</div>
					<div>

						<label>Month :</label>

						<select  name="month" required="true">

							<option value="January">January</option>

							<option value="February">February</option>

							<option value="March">March</option>

							<option value="April">April</option>

							<option value="May">May</option>

							<option value="June">June</option>

							<option value="July">July</option>

							<option value="August">August</option>

							<option value="September">September</option>

							<option value="October">October</option>

							<option value="November">November</option>

							<option value="December">December</option>

						</select>

						<br>

					</div>

					

					

					<div>

					<label>Year :</label>

					<input type="number" name="year" size="30"  placeholder="Select Year" required/><br>

					</div>

					

					<div class="form-group">

							    <button type="submit" class="btn btn-primary">Submit</button>

					</div>

				</form>
				</div>
</body>
</html>