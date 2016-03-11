/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var ddapp = angular.module('divyadrushti', ['ngRoute', 'ngResource', 'angular-cron-jobs', 'ui.bootstrap']);

ddapp.constant('UserInfo', function () {
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
            });
    /*.otherwise({
     templateUrl: 'partials/home',
     controller: 'HomeController'
     });*/
});


ddapp.factory('UserFactory', ['$q', '$http', 'UserInfo', function ($q, $http, userinfo) {

        var deferred = $q.defer();

        $http.get('rest/user?email=' + userinfo().username)
                .success(function (response) {
                    deferred.resolve(response);
                })
                .error(function (response) {
                    deferred.reject(response);
                });

        return deferred.promise;

    }]);

ddapp.service('UserService', function () {

    var user;

    this.setUser = function (data) {
        user = data;

    };

    this.getUser = function () {
        console.log("Current user get" + user.name);
        return user;
    };
});


ddapp.controller('HomeController', ['$scope', 'UserFactory', 'UserService', function ($scope, userf, usersvc) {

        userf.then(function (data) {
            $scope.user = data;
            usersvc.setUser(data);
        });

    }]);


ddapp.controller('ConfigController', ['$scope', '$http', 'UserInfo',
    function ($scope, $http, userinfo) {

        $scope.device = {};

        var user = userinfo();
        var slides = $scope.slides = [];
        var currIndex = 0;


        // config for cron field
        $scope.cronConfig = {
            options: {
                allowYear: false,
                allowMonth: false
            }
        };

        $scope.prettifyCron = function (cron) {
            var schedule = later.parse.cron(cron);
            return getPrettyCron(schedule['schedules'][0]);
        };

        $scope.getNextCronRun = function (cron) {

            later.date.localTime();
            var s = later.parse.cron(cron);
            var mom = moment(later.schedule(s).next(1));
            return mom.format("DD/MM/YYYY hh:mm:ss");
        }

        $scope.getDevices = function () {
            $http.get('rest/user/' + user.id + '/device/list')
                    .then(function success(response) {
                        $scope.devices = response.data;
                    }, function error() {

                    });
        };

        $scope.addDevice = function () {
            $http.post('rest/user/' + user.id + '/device', $scope.device)
                    .then(function (response) {
                        // this callback will be called asynchronously
                        // when the response is available
                        $scope.getDevices();
                    }, function (response) {
                        alert("Failed to save device");
                        // called asynchronously if an error occurs
                        // or server returns response with an error status.
                    });
        };

        $scope.addSlide = function () {
            var newWidth = 600 + slides.length + 1;
            slides.push({
                image: 'http://lorempixel.com/' + newWidth + '/300',
                text: ['Nice image', 'Awesome photograph', 'That is so cool', 'I love that'][slides.length % 4],
                id: currIndex++
            });
        };
        
        for (var i = 0; i < 4; i++) {
            $scope.addSlide();
        }
        
        $scope.getDevices();


    }
]);

