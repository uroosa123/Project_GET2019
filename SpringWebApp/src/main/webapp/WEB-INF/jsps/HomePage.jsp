<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored = "false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>  


<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">

<title>Home Page</title>
</head>
<body>
<div style="background-color:#000080">
<h1 class="muted" style="text-align: center;font-family: verdana;color:lightgrey;font-family:cursive;font-style:italic;background-color:#000080;">
			${myData}
		</h1>
<hr style="color:black;"/>
</div>
<div style="background-color:#000080">
<div class="container"  >
  <div class="row">
    <div class="span12">
      <div class="head">
        <div class="row-fluid" >
            <div class="span12" >
                <div class="span8" align="left">
                    <h1 class="muted" style="color:lightgrey;font-family:cursive;font-style:italic">ONLINE SHOPPING STORE</h1>
                </div>
                
                
<div align="right" style="margin-top:15px;">
<table>
			<tr>
				<td><a href="getSignInForm" style="color:white"><i class="icon-user brown"></i>Log In</a></td>
				<td></td>
				<td><a href="getSignUpForm" style="color:white"><i class="icon-edit icon-white"></i>Register</a></td>
			</tr>
		</table>
</div>

</div>
        </div>

        <div class="navbar">
            <div class="navbar-inner">
                <div class="container">
                    <ul class="nav">
                        <li>
                            <a href="#">Explore Product</a>
                        </li>

                        <li>
                            <a href="#">Search</a>
                        </li>

                        <li>
                            <a href="#">Features</a>
                        </li>

                        <li>
                            <a href="#">Blog</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
      </div>
    </div>
  </div>
</div>
</div>

<div style="background-color:white">
<div class="container" >
  
 
<div id="bs4-slide-carousel" class="carousel slide" data-ride="carousel" >
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="${pageContext.request.contextPath}/resources/images/new1.jpg" alt="Slide One">
      <
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="${pageContext.request.contextPath}/resources/images/images2.jpg" alt="Slide Two">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="${pageContext.request.contextPath}/resources/images/new2.jpg" alt="Slide Three">
    </div>
  </div>
  <a class="carousel-control-prev" href="#bs4-slide-carousel" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#bs4-slide-carousel" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>  
</div>

</div>
</div>

<!-- Footer -->
<footer class="page-footer font-small blue">

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3" style="background-color:#0041C2;color:white">© 2019 Copyright:
    <a href="https://mdbootstrap.com/education/bootstrap/" style="color:white"> Onlineshoppie.com</a>
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->

<script>
$('#bs4-slide-carousel').carousel({
  interval: 3000
})
</script>

</body>
</html>