angular.module('sortApp',[]).controller('mainController',function($scope,$http){
	
	$scope.getProduct=function()
	{
		console.log("im in getProduct");
		$http({method:'GET',url:'home1'}).success(function(data,status,headers,config)
				
		{
			
			$scope.categ=JSON.parse(JSON.stringify(data));
			
			for(var c=0;c<$scope.categ.length;c++)
				{
					var cc=$scope.categ[c];
					console.log(cc);
					console.log($scope.categ);
					return $scope.categ;
				}
			
			
		});
	};
	
	$scope.getProductinf=function()
	{
		console.log("im in getAProduct");
		$http({method:'GET',url:'aproductinfo1'}).success(function(data,status,headers,config)
				
		{
			
			$scope.categ=JSON.parse(JSON.stringify(data));
			
			for(var c=0;c<$scope.categ.length;c++)
				{
					var cc=$scope.categ[c];
					console.log(cc);
					console.log($scope.categ);
					return $scope.categ;
				}
			
			
		});
	};

	
	
});

	