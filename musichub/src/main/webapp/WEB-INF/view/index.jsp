<html>
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
  <title>***Home***</title>
</head>
<body>
<%@include file="header.jsp"  %>
	<div class="container">
	<br>
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
  					<a href="home?im1=img1"><img class="img-responsive" src="<c:url value="/resources/image/img5.jpg"/>" style="width:200px;height:200px"   ></a>
  				</td>
   				<td>
  					<a href="home?im1=img2"><img class="img-responsive" src="<c:url value="/resources/image/img6.jpg"/>" style="width:200px;height:200px" ></a>
  				</td>
   				<td>
  					<a href="home?im1=img3"><img class="img-responsive" src="<c:url value="/resources/image/img7.jpg"/>" style="width:200px;height:200px" ></a>
  				</td>
  			</tr>
  			</table>
  
  		</div>
	</div>
		
		<%@include file="footer.jsp" %>
	</body>
</html>