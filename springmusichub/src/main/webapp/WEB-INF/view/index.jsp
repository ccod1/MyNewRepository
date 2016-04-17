<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css"/>">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="<c:url value="/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js" />"></script>
  <style>
  .carousel-inner > .item > img
   {
     
      margin: auto;
     height:40%;
  	width: 30%;
 
  }
  .left carousel-control
  {
  background-color: teal;
  }
 
  
  </style>
</head>
<body>

<div class="container">
<br>

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
  
  <div id="myCarousel" class="carousel slide" data-ride="carousel" >
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" >
      <div class="item active">
        <img src="<c:url value="/resources/image/img1.jpg"/>" alt="" width="460" height="300"/>
      </div>

      <div class="item">
        <img src="<c:url value="/resources/image/img2.jpg"/>" alt="" width="460" height="300"/>
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/image/img3.jpg"/>" alt="" width="460" height="300"/>
      </div>

      <div class="item">
        <img src="<c:url value="/resources/image/img4.jpg"/>" alt="" width="460" height="300"/>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <br>
  <div class="table-responsive">
  <table class="table table-bordered">
  <tr>
  <td>
  <a href="home?im1=img1"><img class="img-responsive" src="<c:url value="/resources/image/img1.jpg"/>" style="width:200px;height:200px"   ></a>
  </td>
   <td>
  <a href="home?im1=img2"><img class="img-responsive" src="<c:url value="/resources/image/img2.jpg"/>" style="width:200px;height:200px" ></a>
  </td>
   <td>
  <a href="home?im1=img3"><img class="img-responsive" src="<c:url value="/resources/image/img3.jpg"/>" style="width:200px;height:200px" ></a>
  </td>
  </tr>
  </table>
  
  </div>
</div>
</body>
</html>
