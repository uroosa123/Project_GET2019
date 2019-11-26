<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header2.jsp" %>
 <%@ include file="footer.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr/>
		<div align="center">
		<h1 style="text-align: center;font-family: verdana;color:#000080">Configure Here! </h1>
		
		<core:if test="${not empty msg}">
		<div style="text-align: center;font-family: verdana;color:#000080" class="alert alert-success">${msg}
		</div>
		</core:if>
		
		
		<hr/>
		
		<f:form action="submitConfig" modelAttribute="pObj" method="get" id="projectform">

			
			<label>Projects:</label>

			<f:select path="projectId" >

			 	 <core:forEach items="${projList}" var="pOb">

					<f:option value="${pOb.projectId}">${pOb.projectName}</f:option>

				 </core:forEach>

			</f:select></br>
			

			


			<div><label>Role:</label>

				<f:select path="roleId" >

				 	 <core:forEach items="${roleList}" var="rOb">

						<f:option value="${rOb.roleId}">${rOb.roleName} </f:option>

					 </core:forEach>

				</f:select></div>

			

			<label>Location:</label>

			

			<!--  	<div class="custom-control custom-radio">	

					<f:radiobutton path="location" value="Onsite"  id="Onsite"/>

					<label class="custom-control-label" for="Onsite">Onsite</label>
</div>

               <div class="custom-control custom-radio">
					<f:radiobutton path="location" value="Offshore"  id="Offshore" checked = "checked"/>

					<label class="custom-control-label" for="Offshore">Offshore</label>

				</div>
				-->
				
				<div class="custom-control custom-radio">	

					 <input type="radio" name="location" value="Onsite"> Onsite<br>

 					 <input type="radio" name="location" value="Offshore" checked> Offshore<br>

					

					

					

				</div>

				

			<br><div class="form-group">

	    			<label>Per Hour Billing  : </label> <f:input type="number" path="perHourBilling" size="30" min="10" max="2000" placeholder="Enter Per Hour Billing" required="required"/>
		   

			 </div>

			

			<div class="form-group">

			    <button type="submit" class="btn btn-primary">Submit</button>

			 </div>

			</f:form>
		</div>
</body>
</html>