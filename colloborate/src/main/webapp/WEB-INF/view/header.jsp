<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css"/>">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="<c:url value="/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js" />"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

</head>
<body>
		<div class="container">
			<nav class="navbar navbar-inverse" >
 				<div class="container-fluid">
    				<ul class="nav navbar-nav navbar-left" role="tablist">
      					<li><a href="aboutus">ABOUT US</a></li> 
      					<li><a href="home">HOME</a>
      					<c:if test="${not empty name}">
      				<font style="color: white;"><li>Welcome ${name}</li></font>
      					</c:if>
      					
      				</ul>
      				<ul class="nav navbar-nav navbar-right"> 
      					
      					 <li><a href="blog?user=${name}"><i class="fi-social-blogger"></i>BLOGS</a></li>
      					 <li><a href="chat?user=${name}">CHAT</a></li>
      					 <li><a href="forum?user=${name}">FORUM</a></li>
      					 <li><a href="userprofile?user=${name}">USER PROFILE</a></li>
      					 <li><a href="createblog?user=${name}">CREATE BLOG</a></li>
      					 <li><a href="createforum?user=${name}">CREATE FORUM</a></li>
     					 <li><a href="logout"><i class="glyphicon glyphicon-log-out"></i> LOGOUT</a></li>

     					
   					</ul>
 		 		</div>
			</nav>
		</div>
</body>
</html>