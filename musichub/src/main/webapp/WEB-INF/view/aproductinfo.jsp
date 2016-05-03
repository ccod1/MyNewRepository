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
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" 
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
<script src="<c:url value="/resources/app.js"/>"></script>



<title>***Category***</title>
</head>
<body>
<%@include file="header.jsp" %>

<center><div class="container" ng-init="getProductinf();" ng-app="sortApp" ng-controller="mainController">

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
            <th>PRODUCT PRICE</th>
            <th>PRODUCT MANUFACTURE</th>  
            
            
          </tr>  
        </thead>  
        <tbody>  
         	<tr ng-repeat="c in categ | filter:na">
         		<td>{{c.name}}</td>
         		<td>{{c.code}}</td>
         		<td>{{C.price}}</td>
         		<td>{{c.manufact}}</td>
         		
         		<td><a type="button" href="proedit?code=${c.code}" class="btn btn-info">UPDATE</a></td>
         		<td><a type="button" href="prodelete" class="btn btn-danger">DLETE</a></td>
         	</tr>
		</tbody>
		</table>
	
	</div>
	
	<%@include file="footer.jsp" %>

</body>
</html>