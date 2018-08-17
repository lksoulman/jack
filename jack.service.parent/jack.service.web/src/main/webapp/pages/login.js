var app_login = angular.module("app_login", []);
app_login.controller("app_login_controller", function($scope, $http) {
	$scope.user = {};
	$scope.login = function() {
		alert($scope.user.name + " " + $scope.user.password);
		// $http({
		// method : 'POST',
		// url : 'process.php',
		// data : $.param($scope.formData), // pass in data as strings
		// headers : {
		// 'Content-Type' : 'application/x-www-form-urlencoded'
		// }
		// }).success(function(data) {
		// console.log(data);
		// if (!data.success) {
		// $scope.errorName = data.errors.name;
		// $scope.errorSuperhero = data.errors.superheroAlias;
		// } else {
		// $scope.message = data.message;
		// }
		// });
	};
});