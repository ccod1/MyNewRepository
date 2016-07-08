<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" 
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<script>
var val=${jstring};
angular.module('myApp', []).controller('namesCtrl', function($scope) {
    $scope.blognames=val;
});
</script>

<center><h1>Hi ${name}</h1></center>


<div ng-app="myApp" ng-controller="namesCtrl">


	
	<center>	<table class="display table">
		
        <tbody>  
         	<tr ng-repeat="c in blognames | filter:na">
         		<td><a href="openbl?bln={{c.blog_name}}&user=${name}">{{c.blog_name}}</a></td>
      
         		
         		
         	</tr>
		</tbody>
		</table>
	
</center>
	</div>	
</body>
</html>