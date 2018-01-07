var app = angular.module("myApp", [ 'ngRoute', 'ngCookies' ])

app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'Home/home.html'
	}).when('/home', {
		templateUrl : 'Home/home.html'
	}).when('/blog', {
		templateUrl : 'Blog/viewBlog.html'
	}).when('/login', {
		templateUrl : 'Customer/login.html',
		controller : 'CustomerController'
	}).when('/register', {
		templateUrl : 'Customer/register.html',
		controller : 'CustomerController'
	}).when('/profile', {
		templateUrl : 'Customer/profile.html',
		controller : 'CustomerController'
	}).otherwise({
		templateUrl : 'Home/home.html'
	})

})

app.run(function(CustomerService, $rootScope, $cookieStore, $location) {

	if ($rootScope.currentUser == undefined) {
		$rootScope.currentUser = $cookieStore.get("currentUser")
	}

	$rootScope.signOut = function() {
		CustomerService.signOut().then(function(response) {
			$rootScope.error = response.data;
			delete $rootScope.currentUser
			delete $rootScope.customer
			delete $rootScope.username
			$cookieStore.remove("currentUser")
			$location.path('/login')
		}, function(response) {
			$location.path('/login')
		})
	}
})