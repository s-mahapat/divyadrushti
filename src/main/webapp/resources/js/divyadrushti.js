/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var ddapp = angular.module('divyadrushti', ['ngRoute']);

ddapp.config(function ($routeProvider) {

    //home
    $routeProvider.when('/configure', {
        templateUrl: 'partial/configure'
    });
});

