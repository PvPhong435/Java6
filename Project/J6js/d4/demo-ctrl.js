let host = "https://poly-java-6-58146-default-rtdb.firebaseio.com/";
const app = angular.module("app", []);
app.controller("ctrl", function($scope, $http)
{
	$scope.form = {}
	$scope.items = {}
	$scope.reset = function() {
		$scope.form={gender:true,country:'VN'};
		$scope.key=null;
	}
	$scope.load_all = function() {
		var url=`${host}/student.json`;
		$http.get(url).then(resp=>{
			$scope.items=resp.data;
			console.log("Success",resp)
		}).catch(error=>{
			console.log("Error",error)
		});
	}
	$scope.edit = function(key) {
		var url=`${host}/student/${scope.key}.json`;
		$http.get(url).then(resp=>{
			$scope.form=resp.data;
			$scope.key=key;
			console.log("Success",resp)
		}).catch(error=>{
			console.log("Error",error)
		});
	}
	$scope.create = function() {

	}
	$scope.update = function() {
		var item=angular.copy($scope.form);
		var url=`${host}/student/${scope.key}.json`;
		$http.put(url,item).then(resp=>{
			$scope.items[$scope.key]==resp.data;
			console.log(Success,resp)
		}).catch(eror=>{
			console.log("Error",error)
		});
	}
	$scope.delete = function(key) {

	}
	
	$scope.load_all();
	$scope.reset();
});