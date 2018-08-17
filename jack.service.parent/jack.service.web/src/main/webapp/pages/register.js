var app_register = angular.module("app_register", []);
app_register.controller("app_register_controller", function($scope, $http,
		$location) {
	$scope.userinfo = {};
	$scope.register = function(userinfo) {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/jack.service.web/user/register.do',
			data : userinfo,
			headers : {
				'Content-Type' : 'application/json;charset=UTF-8'
			}
		}).then(function(response) {
			msginfo = response.data;
			if (msginfo.code == 0) {
				console.log(msginfo.data);
			} else {
				
			}
		}).catch(function(response) {
			console.log("error");
			console.log(response);
		});
	}
});