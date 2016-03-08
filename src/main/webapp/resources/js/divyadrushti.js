/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var ddapp = angular.module('divyadrushti', ['ngRoute', 'ngResource', 'angular-cron-jobs']);

ddapp.constant('UserInfo', function(){
    return {username: document.getElementById('username').innerHTML,
            id: document.getElementById('username').getAttribute('data-userid')
        };
});

ddapp.config(function ($routeProvider) {

    //home
    $routeProvider.when('/', {
        templateUrl: 'partials/home',
        controller: 'HomeController'
    })
    .when('/home', {
        templateUrl: 'partials/home',
        controller: 'HomeController'
    })
    .when('/configure', {
        templateUrl: 'partials/configure',
        controller: 'ConfigController'
    })
    .otherwise({
        templateUrl: 'partials/home',
        controller: 'HomeController'
    });
});


ddapp.factory('UserFactory', ['$q', '$http', 'UserInfo', function($q, $http, userinfo) {
    
    var deferred = $q.defer();
    
    $http.get('rest/user?email=' + userinfo().username)
    .success(function(response){
        deferred.resolve(response);
    })
    .error(function(response){
        deferred.reject(response);
    });

    return deferred.promise;
 
}]);

ddapp.service('UserService', function(){
    
    var user;
    
    this.setUser = function(data){
        user = data;
        
    };
    
    this.getUser = function(){
        console.log("Current user get" + user.name);
        return user;
    };
});


ddapp.controller('HomeController', ['$scope', 'UserFactory', 'UserService', function($scope, userf, usersvc){
        
    userf.then(function(data){
        $scope.user = data;
        usersvc.setUser(data);
    });
    
}]);


ddapp.controller('ConfigController', ['$scope', '$http', 'UserInfo',
    function ($scope, $http, userinfo) {
        
        $scope.device = {};
        
        var user = userinfo();
        
        // config for cron field
        $scope.cronConfig = {
            options: {
                allowYear : false,
                allowMonth: false
            }
        };
        
        $scope.getDevices = function(){
            $http.get('rest/user/' + user.id + '/device/list')
            .then(function success(response){
                $scope.devices = response.data;
            }, function error(){
                
            });
        };
        
        $scope.addDevice = function(){
            $http.post('rest/user/' + user.id + '/device', $scope.device)
            .then(function(response) {
                // this callback will be called asynchronously
                // when the response is available
                $scope.getDevices();
            }, function(response) {
                alert("Failed to save device");
              // called asynchronously if an error occurs
              // or server returns response with an error status.
            });
        };
        
        $scope.getDevices();
    }
]);

