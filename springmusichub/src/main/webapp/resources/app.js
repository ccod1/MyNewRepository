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

	//var arr=${listData};
	
	//$scope.cate=arr;
	
});

	
	//$scope.cate=${listData};
	/*
	$scope.key={name:'',product_cod:'',product_price:'',description:''};
	$scope.val=[];	
	$scope.fetchUsers=function($scope,$http){
		$hhtp.get('http://localhost:8080/springmusichub/home/').then(function(response)
				{
					$scope.val=response.data;
				});
		
	};
	
	$scope.fetchUsers();
	
*/
		
	/*	
		$scope.record=
			[
			 	{name:'Farzana',product_id:'PRO101',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Saranya',product_id:'PRO102',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Niyamath',product_id:'PRO103',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Santhu',product_id:'PRO104',product_cost:'2000',description:'A R Rahman hits'},
		    ];
		
		$scope.instrument=
			[
			 	{name:'Guitar',product_id:'PRO101',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Tabla',product_id:'PRO102',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Piano',product_id:'PRO103',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Flute',product_id:'PRO104',product_cost:'2000',description:'A R Rahman hits'},
		    ];
		
		$scope.accessories=
			[
			 	{name:'Drum',product_id:'PRO101',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Brass',product_id:'PRO102',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Strings',product_id:'PRO103',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Keyboard',product_id:'PRO104',product_cost:'2000',description:'A R Rahman hits'},
		    ];
	
		$scope.category=
			[
			 	{name:'Farzana',product_id:'PRO101',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Saranya',product_id:'PRO102',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Niyamath',product_id:'PRO103',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Santhu',product_id:'PRO104',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Guitar',product_id:'PRO101',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Tabla',product_id:'PRO102',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Piano',product_id:'PRO103',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Flute',product_id:'PRO104',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Drum',product_id:'PRO101',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Brass',product_id:'PRO102',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Strings',product_id:'PRO103',product_cost:'2000',description:'A R Rahman hits'},
			 	{name:'Keyboard',product_id:'PRO104',product_cost:'2000',description:'A R Rahman hits'},
		    ];*/
