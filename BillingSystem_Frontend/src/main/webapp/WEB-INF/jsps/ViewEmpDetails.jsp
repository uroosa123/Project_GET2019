<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1" isELIgnored="false"%>

       <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style >

.bill{

text-align:center;

}



.dropbtn {

  background-color: #4CAF50;

  color: white;

  padding: 16px;

  font-size: 16px;

  border: none;

  cursor: pointer;

}



.dropdown {

  position: relative;

  display: inline-block;

}



.dropdown-content {

  display: none;

  position: absolute;

  background-color: #f9f9f9;

  min-width: 160px;

  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);

  z-index: 1;

}



.dropdown-content a {

  color: black;

  padding: 12px 16px;

  text-decoration: none;

  display: block;

}



.dropdown-content a:hover {background-color: #f1f1f1}



.dropdown:hover .dropdown-content {

  display: block;

}



.dropdown:hover .dropbtn {

  background-color: #3e8e41;

}





* {box-sizing: border-box;}



body { 

  margin: 0;

  font-family: Arial, Helvetica, sans-serif;

}

.hello{

float:right;}

.header {

  overflow: hidden;

  background-color: #f1f1f1;

  padding: 20px 10px;

}



.header a {

  float: left;

  color: black;

  text-align: center;

  padding: 12px;

  text-decoration: none;

  font-size: 18px; 

  line-height: 25px;

  border-radius: 4px;

}



.header a.logo {

  font-size: 25px;

  font-weight: bold;

}



.header a:hover {

  background-color: #ddd;

  color: black;

}



.header a.active {

  background-color: dodgerblue;

  color: white;

}



.header-right {

  float: right;

}



@media screen and (max-width: 500px) {

  .header a {

    float: none;

    display: block;

    text-align: left;

  }

  

  .header-right {

    float: none;

  }

}

</style>

<title></title>

</head>

<body>

<div class="header">

  <a href="#default" class="logo">IRIS SOFTWARE</a>

  <div class="header-right">

    <a class="active" href="#home">Home</a>

   

     <a href="logout">Logout</a>

  </div>

</div>



<div class="bill">      

	     

	      

		  	<h3>Employee Billing</h3><hr>

			

				<h5>Employee ID : ${de}</h5>

				<h5> Name :<strong> ${name}</strong></h5>

				<h5>Month : ${mo}</h5>

				<h5> year: ${y} </h5>

				<h5>Bill : <strong>$ ${bill}</strong></h5>

			

		</div>

</body>

</html>