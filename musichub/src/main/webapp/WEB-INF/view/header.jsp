<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css"/>">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="<c:url value="/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js" />"></script>

</head>
<body>
		<div class="container">
			<nav class="navbar navbar-inverse">
 				<div class="container-fluid">
    				<ul class="nav navbar-nav navbar-left" role="tablist">
      					<li><a href="aboutus">ABOUT US</a></li> 
      					<li><a href="home?im1=allcat">ALL CATEGORIES</a></li>
      				</ul>
      				<ul class="nav navbar-nav navbar-right"> 
     					 <li><a href="signup">SIGN UP</a></li>
     					 <li><a href="login">SIGN IN</a></li>
   					</ul>
 		 		</div>
			</nav>
		</div>
</body>
</html>