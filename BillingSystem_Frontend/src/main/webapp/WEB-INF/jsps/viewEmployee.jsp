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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div align="center">

<core:if test="${not empty errorMsg}">
		<div style="text-align: center;font-family: verdana;color:#000080" class="alert alert-success">${errorMsg}
		</div>
		</core:if>

<form action="Billing"  method="get">


					<div>

						<label>Employee :</label>

						<select name="employeeId">

						 	 <core:forEach items="${devL}" var="pOb">

								<option value="${pOb.employeeId}" >${pOb.employeeName}</option>

							 </core:forEach>

						</select><br>

					</div>
					<div>

						<label>Month :</label>

						<select  name="month" required="true">

							<option value="january">January</option>

							<option value="february">February</option>

							<option value="march">March</option>

							<option value="april">April</option>

							<option value="may">May</option>

							<option value="june">June</option>

							<option value="july">July</option>

							<option value="august">August</option>

							<option value="september">September</option>

							<option value="october">October</option>

							<option value="november">November</option>

							<option value="december">December</option>

						</select>

						<br>

					</div>

					

					

					<div>

					<label>Year :</label>

					<input type="number" name="year" id="year" size="30"  placeholder="Select Year" required/><br>

		</div>

					

					<div class="form-group">

							    <button type="submit" class="btn btn-primary">Submit</button>

					</div>

				</form>
				</div>
</body>
</html>