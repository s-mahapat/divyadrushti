/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var ddapp = angular.module('divyadrushti', ['ngRoute', 'ngResource', 'angular-cron-jobs', 'ui.bootstrap', 'ui.bootstrap.datetimepicker']);

ddapp.constant('UserInfo', function () {
    return {username: document.getElementById('username').getAttribute('data-username'),
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
        return user;
    };
});


ddapp.service('UserDeviceService', ['$q', '$http', 'UserInfo', function($q, $http, userInfo){
   
    
    var user = userInfo();
    
    this.getDevices = function(){
        var deferred = $q.defer();
        $http.get('rest/user/' + user.id + '/device/list')
        .success(function (response) {
            deferred.resolve(response);
        })
        .error(function (response) {
            deferred.reject(response);
        });

        return deferred.promise;
    };

}]);


ddapp.controller('HomeController', ['$scope', '$http','UserFactory', 'UserService', 'UserDeviceService', 
    function ($scope, $http, userf, usersvc, userDevicesFactory) {

        $scope.selectedDevice = 0;
        
        // save the user data in userService
        userf.then(function (data) {
            $scope.user = data;
            usersvc.setUser(data);
        });
        
        // get user devices
        userDevicesFactory.getDevices().then(function(data){
            $scope.devices = data;
            $scope.selectedDeviceId = $scope.devices[$scope.devices.length - 1].id;
            
            // get the images taken in the last 24 hrs
            $scope.getImagesForDateRange();
        });
        
        // set the start date to one day earlier date
        var yesterday = new Date();
        yesterday.setDate(yesterday.getDate() - 1);
        
        $scope.startdt = yesterday;
        $scope.enddt = new Date();
        
        // datepicker options
        $scope.dateOptions = {
            
            // dont show week numbers
            showWeeks: false
        };
        
        // disable dates greater than today
        $scope.disabledDates = function(date, mode) {
            return (mode === 'day' && (date > new Date()));
        };

        $scope.startdtpopup = {
            opened: false
        };

        $scope.enddtpopup = {
            opened: false
        };

        $scope.openstartdt = function () {
            $scope.startdtpopup.opened = true;
            $scope.enddtpopup.opened = false;
        };

        $scope.openenddt = function () {
            $scope.startdtpopup.opened = false;
            $scope.enddtpopup.opened = true;
        };
        
        $scope.getImagesForDateRange = function(){
            
            var sdt = new Date($scope.startdt);
            var edt = new Date($scope.enddt);
            var url = 'rest/user/' + $scope.user.id + '/device/' + $scope.selectedDeviceId + '/images/' + sdt.getTime() + "/" + edt.getTime();
            $http.get(url)
                .then(function success(response){
                    $scope.images = response.data;
                }, 
                function error(response){

                });
        };
        
        

    }]);


ddapp.controller('ConfigController', ['$scope', '$http', 'UserInfo',
    function ($scope, $http, userinfo) {

        $scope.device = {};
        var user = userinfo();
        var slides = $scope.slides = [];
        var currIndex = 0;

        // let the user add the mac id of a new device
        $scope.isMacIdReadOnly = false;

        // config for cron field
        $scope.cronConfig = {
            options: {
                allowYear: false,
                allowMonth: false
            }
        };

        $scope.prettifyCron = function (cron) {
            var schedule = later.parse.cron(cron, false);
            console.log(getPrettyCron(schedule['schedules'][0]));
            return getPrettyCron(schedule['schedules'][0]);
        };

        $scope.getNextCronRun = function (cron) {

            later.date.localTime();
            var s = later.parse.cron(cron);
            var mom = moment(later.schedule(s).next(1));
            return mom.format("DD/MM/YYYY hh:mm:ss");
        };

        $scope.getDevices = function () {
            $http.get('rest/user/' + user.id + '/device/list')
                    .then(function success(response) {
                        $scope.devices = response.data;
                        console.log($scope.devices);
                    }, function error() {

                    });
        };

        // saves a device to database
        $scope.saveDevice = function () {

            if ($scope.device.id) {

                $http.put('rest/user/' + user.id + '/device', $scope.device)
                        .then(function (response) {
                            // this callback will be called asynchronously
                            // when the response is available
                            $scope.getDevices();
                        }, function (response) {
                            alert("Failed to save device");
                            // called asynchronously if an error occurs
                            // or server returns response with an error status.
                        });

            } else {
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
            }



        };

        // dynamically add slides to the carousel
        $scope.addSlide = function (imageUrl) {
            $scope.slides.push({
                image: imageUrl,
                //image: 'http://lorempixel.com/' + newWidth + '/300',
                //text: ['Nice image', 'Awesome photograph', 'That is so cool', 'I love that'][slides.length % 4],
                id: currIndex++
            });
        };

        // given a device id get the images for that device and user id combination
        // from the server
        $scope.getImagesForDevice = function (deviceId) {
            var url = 'rest/user/' + user.id + '/device/' + deviceId + '/images';
            var userImages = [];
            curreIndex = 0;
            slides = $scope.slides = [];
            $scope.$evalAsync(function () {
                $http.get(url)
                        .then(function success(response) {
                            userImages = response.data;
                            for (var i = 0; i < userImages.length; i++) {
                                $scope.addSlide(userImages[i]);
                            }

                            // change the index value so tha UI is refreshed with the new set of images
                            $scope.index = userImages.length;

                        }, function error(response) {

                        });
            });

        };

        // loads a device on the pop up modal dialog
        $scope.loadDevice = function (index) {

            // based on the index load the device on the dialog
            $scope.device = $scope.devices[index];

            // the user cannot edit the mac id once a device is added.
            $scope.isMacIdReadOnly = true;
        };

        // update an existing device information like cron, name, active statuc etc
        $scope.updateDevice = function (index) {

        };

        // get the list of user devices and display on the UI.
        $scope.getDevices();

    }
]);

