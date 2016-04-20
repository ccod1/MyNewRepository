<%@ page  language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" 
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
<script src="<c:url value="/resources/app.js"/>"></script>
<title>Insert title here</title>



</head>
<body>

<%  String im1=request.getParameter("im1");


	
%>
<!-- Check the category -->
<% if(im1.equals("img1")){ %>
<center><div class="container" ng-init="getProduct();" ng-app="sortApp" ng-controller="mainController">

	<center><div class="table table-responsive">
			<table class="table">
				<tr>
				<td>
				<img class="img-responsive" src="<c:url value="/resources/image/img1.jpg"/>" style="width:200px;height:200px">
				</td>
				</tr>
			</table>
	</div></center>
	<form>
	<div class="form-group">
		<div class="input-group">
			<div class="input-group-addon">
				<i class="fa fa-search"></i>
			</div>
			<input type="text" class="form-control" placeholder="Search the name" ng-model="na"/>
		</div>
		
	</div>
</form>



	<div class="table-responsive">
		<table class="display table">
		<thead>  
          <tr>  
            <th>NAME</th>  
            <th>PRODUCT ID</th>  
            <th>ADD TO CART</th>  
            
          </tr>  
        </thead>  
        <tbody>  
         	<tr ng-repeat="c in categ | filter:na">
         		<td>{{c.name}}</td>
         		<td>{{c.product_id}}</td>
         		
         		<td><a href="addtocart?pid={{c.product_id}}"><italic>i</italic></a></td>
         	</tr>
		</tbody>
		</table>
	
	</div>
	
	<br><br>
	<h2><a href="view.jsp">View Cart</a></h2><br>
	<h2><a href="order.jsp">Order Received</a></h2><br>
	<h2><a href="orderconfirm.jsp">Order Confirmation</a></h2><br>

</div></center>
<% }
else if(im1.equals("img2"))
{
%>
<center><div class="container" ng-init="getProduct();" ng-app="sortApp" ng-controller="mainController">

	<center><div class="table table-responsive">
			<table class="table">
				<tr>
				<td>
				<img class="img-responsive" src="<c:url value="/resources/image/img2.jpg"/>" style="width:200px;height:200px">
				</td>
				</tr>
			</table>
	</div></center>
	<form>
	<div class="form-group">
		<div class="input-group">
			<div class="input-group-addon">
				<i class="fa fa-search"></i>
			</div>
			<input type="text" class="form-control" placeholder="Search the name" ng-model="na"/>
		</div>
		
	</div>
</form>


	<div class="table-responsive">
		<table class="display table">
		<thead>  
          <tr>  
            <th>NAME</th>  
            <th>PRODUCT ID</th>  
            <th>ADD TO CART</th>   
          </tr>  
        </thead>  
        <tbody>  
         	<tr ng-repeat="c in categ | filter:na">
         		<td>{{c.name}}</td>
         		<td>{{c.product_id}}</td>
         		
         		<td><a href="addtocart?pid={{c.product_id}}"><italic>i</italic></a></td>
         	</tr>
		</tbody>
		</table>
	</div>
	<br><br>
	<h2><a href="view.jsp">View Cart</a></h2><br>
	<h2><a href="order.jsp">Order Received</a></h2><br>
	<h2><a href="orderconfirm.jsp">Order Confirmation</a></h2><br>
	

</div></center>
<% }
else if(im1.equals("img3"))
{

%>
<center><div class="container" ng-init="getProduct();" ng-app="sortApp" ng-controller="mainController">

	
	<center><div class="table table-responsive">
			<table class="table">
				<tr>
				<td>
				<img class="img-responsive" src="<c:url value="/resources/image/img3.jpg"/>" style="width:200px;height:200px">
				</td>
				</tr>
			</table>
	</div></center>
	
	<form>
	<div class="form-group">
		<div class="input-group">
			<div class="input-group-addon">
				<i class="fa fa-search"></i>
			</div>
			<input type="text" class="form-control" placeholder="Search the name" ng-model="na"/>
		</div>
		
	</div>
</form>



	<div class="table-responsive">
		<table class="display table">
		<thead>  
          <tr>  
            <th>NAME</th>  
            <th>PRODUCT ID</th>  
            <th>ADD TO CART</th>  
          </tr>  
        </thead>  
        <tbody>  
         	<tr ng-repeat="c in categ | filter:na">
         		<td>{{c.name}}</td>
         		<td>{{c.product_id}}</td>
         		
         		<td><a href="addtocart?pid={{c.product_id}}"><italic>i</italic></a></td>
         	</tr>
		</tbody>
		</table>
	
	</div>
	
	
	<br><br>
	<h2><a href="view.jsp">View Cart</a></h2><br>
	<h2><a href="order.jsp">Order Received</a></h2><br>
	<h2><a href="orderconfirm.jsp">Order Confirmation</a></h2><br>

</div></center>
<% } 

else
{
%>

<center><div class="container" ng-init="getProduct();" ng-app="sortApp" ng-controller="mainController">

	<form>
	<div class="form-group">
		<div class="input-group">
			<div class="input-group-addon">
				<i class="fa fa-search"></i>
			</div>
			<input type="text" class="form-control" placeholder="Search the name" ng-model="na"/>
		</div>
		
	</div>
</form>



	<div class="table-responsive">
		<table class="display table">
		<thead>  
          <tr>  
            <th>NAME</th>  
            <th>PRODUCT ID</th>  
             <th>ADD TO CART</th>  
          </tr>  
        </thead>  
        <tbody>  
         	<tr ng-repeat="c in categ | filter:na">
         		<td>{{c.name}}</td>
         		<td>{{c.product_id}}</td>
         		
         		<td><a href="addtocart?{{c.product_id}}"><italic>i</italic></a></td>
         	</tr>
		</tbody>
		</table>
	
	</div>
	
	
	<br><br>
	<h2><a href="view.jsp">View Cart</a></h2><br>
	<h2><a href="order.jsp">Order Received</a></h2><br>
	<h2><a href="orderconfirm.jsp">Order Confirmation</a></h2><br>

</div></center>

<%
}
%>

</body>
</html>