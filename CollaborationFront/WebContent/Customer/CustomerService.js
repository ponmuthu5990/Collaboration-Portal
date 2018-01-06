app.factory('CustomerService',function($http){
	var customerService={};
	var BASE_URL="http://localhost:7053/RestFulService/"
		 
	customerService.signUp=function(customer){
		console.log("Registration Successfully...")
			console.log(customer)
		return $http.post(BASE_URL+"registerCustomer",customer)
	}
	customerService.signIn=function(customer){
		console.log("username checked Successfully...")
			console.log(customer)
		return $http.post(BASE_URL+"loginCustomer",customer)
	}
	customerService.checkPassword=function(customer){
		console.log("password checked Successfully...")
			console.log(customer)
		return $http.post(BASE_URL+"checkingPassword",customer)
	}
	customerService.signOut=function(){
		return $http.get(BASE_URL+"signOut")
	}
	customerService.profileDetails=function(customer){
		return $http.get(BASE_URL+"getProfile/"+customer.userId)
	}
		return customerService;
}) 