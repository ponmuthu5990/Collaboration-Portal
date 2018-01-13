app
		.controller(
				'CustomerController',
				function(CustomerService, $scope, $location, $rootScope,
						$cookieStore) {
					console.log("Customer Controller...")

					$scope.signUp = function() {
						CustomerService.signUp($scope.customer).then(
								function(response) {
									console.log("Registration Successfully...")
									console.log(response.status)
									console.log(response.data)
									$location.path('/login')
								}, function(response) {
									console.log(response.status)
									console.log(response.data)
									$scope.error = response.data
									$location.path('/signup')
								})
					}
					$scope.signIn = function() {
						$scope.error = {}
						if ($scope.customer.userName != null
								&& $scope.customer.password == null) {

							CustomerService
									.signIn($scope.customer)
									.then(
											function(response) {

												$rootScope.customer = response.data;
												$rootScope.username = $rootScope.customer.userName;
												$location.path('/login')

											}, function(response) {
												console.log(response.status)
												console.log(response.data)
												$scope.error = response.data
												$location.path('/login')
											})
						}
						if ($scope.customer.userName != null
								&& $scope.customer.password != null) {

							if ($rootScope.customer.password == $scope.customer.password) {

								CustomerService
										.checkPassword($rootScope.customer)
										.then(
												function(response) {

													$rootScope.customer = response.data;
													$rootScope.username = $rootScope.customer.userName;
													$rootScope.currentUser = response.data;
													$cookieStore.put(
															"currentUser",
															response.data);
													$location.path('/home')

												},
												function(response) {
													console
															.log(response.status)
													console.log(response.data)
													$scope.error = response.data
													$location.path('/login')
												})
							} else {
								$scope.error.code = '3';
								$scope.error.message = 'Invalid credentials.. please enter valid password';
							}

						}
					}
					$scope.profileDetails = function(currentUser) {
						CustomerService
								.profileDetails(currentUser)
								.then(
										function(response) {
											console
													.log("profile Details fetched Successfully...")
											console.log(response.status)
											console.log(response.data)
											$rootScope.customerProfile = response.data;
											$location.path('/profile')
										}, function(response) {
											console.log(response.status)
											console.log(response.data)
											$scope.error = response.data

										})
					}

				})
