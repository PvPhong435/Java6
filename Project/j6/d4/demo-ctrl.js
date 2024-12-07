let host = "https://poly-java-6-58146-default-rtdb.firebaseio.com/";
// let host = "https://localhost:8080/rest";
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
		var url=`${host}/student/${key}.json`;
		$http.get(url).then(resp=>{
			$scope.form=resp.data;
			$scope.key=key;
			console.log("Success",resp)
		}).catch(error=>{
			console.log("Error",error)
		});
	}
	$scope.create = function() {
		var item=angular.copy($scope.form);
		var url=`${host}/student.json`;
		$http.post(url,item).then(resp=>{
			$scope.key=resp.data.name;
			$scope.items[$scope.key]=item;
			$scope.reset();
			console.log("Add Success",resp)
		}).catch(error=>{
			console.log("Add Error",error)
		});
	}
	$scope.update = function() {
		var item=angular.copy($scope.form);
		var url=`${host}/student/${$scope.key}.json`;
		$http.put(url,item).then(resp=>{
			$scope.items[$scope.key]==resp.data;
			console.log("Update Success",resp)
			$scope.reset();
		}).catch(eror=>{
			console.log("Error",eror)
		});
	}
	$scope.delete = function(key) {
		var url=`${host}/student/${key}.json`;
		$http.delete(url).then(resp=>{
			delete $scope.items[key];
			$scope.reset();
			console.log("Delete success",resp)
		}).catch(error=>{
			console.log("delete Error",resp)
		});
	}
	
	$scope.load_all();
	$scope.reset();
});