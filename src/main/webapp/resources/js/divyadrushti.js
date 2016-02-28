/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var ddapp = angular.module('divyadrushti', ['ngRoute', 'ngResource', 'angular-cron-jobs']);

ddapp.config(function ($routeProvider) {

    //home
    $routeProvider.when('/', {
        templateUrl: 'partials/home'
    })
    .when('/home', {
        templateUrl: 'partials/home'
    })
    .when('/configure', {
        templateUrl: 'partials/configure',
        controller: 'ConfigController'
    })
    .otherwise({
        templateUrl: 'partials/home'
    });
});

ddapp.factory('User', ['$resource', function($resource) {
        
    // get the user from the server
    var user = $resource('rest/user',
    {
        'update' : {
                method: 'PUT'
        }
    });

    // set an app variable to be used later
    ddapp.value('user', user);
    return user;
}]);

ddapp.controller('HomeController', ['$scope', 'User', function($scope, $user){
        
    var username = document.getElementById('username').innerHTML;
    var loggedInUser = $user.get({email: username}, function(){

        // action to do on successfull user info retrival
        $scope.user = loggedInUser;
    });
}]);

ddapp.controller('ConfigController', ['$scope', '$http',
    function ($scope, $http) {
        
        // config for cron field
        $scope.cronConfig = {
            options: {
                allowYear : false,
                allowMonth: false
            }
        };
        
        $scope.updateFrequency = function(){
            $http({
                method: 'POST',
                url: 'configure/frequency'
            }).then(function(response) {
                // this callback will be called asynchronously
                // when the response is available
            }, function(response) {
              // called asynchronously if an error occurs
              // or server returns response with an error status.
            });
        };
    }
]);

