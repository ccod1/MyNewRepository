var taskManagerModule = angular.module('colloborateApp', []);
taskManagerModule.controller('colloborateController', function ($scope,$http,$location,$log,$window) {
 var urlBase="http://" + $window.location.host + "/colloboratebackend";
  //get all tasks and display initially
  //add a new task
 
 $http.get(urlBase+'/tasks').
 success(function(data) {
     $scope.user = data;
    
});
 

 
 $scope.registerUser = function addTask() {
	// alert("function is called");
  if(($scope.name=="")&&($scope.password="")&&($scope.email="")){
   alert("Insufficient Data!");
  }
  else{
   $http.post(urlBase + '/tasks/insert/' + $scope.name+ '/' + $scope.password + '/' + $scope.email).
    success(function(data) {
    alert("Task added  " +data );
   $scope.user=data;
    $scope.name="";
    $scope.password="";
    $scope.email="";
    var url = "http://" + $window.location.host + "/ColloborateFrontEnd/Login.html";
    $log.log(url);
    $window.location.href = url;     
      });
  } 
 };
 
 
 $scope.loginUser=function login(){
	 alert("inside login");
	if(($scope.username=="")&&($scope.password==""))
		{
			alert("Insufficient Data");
		}
	else
		{
		alert("inside login");
			$http.post(urlBase+ '/login/' +$scope.username+ '/' +$scope.password).success(function(data){
				alert("credentials correct  "+data);
				$scope.cre=data;
				  var url = "http://" + $window.location.host + "/ColloborateFrontEnd/Home.html";
				    $log.log(url);
				    $window.location.href = url;  
			});
		}
 };
 
 
 
});
