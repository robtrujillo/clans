/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http) {

    $scope.userId = parseInt($("#userId").val());
    $scope.pageId = parseInt($("#pageId").val());
    var x = 1+2;
    //$scope.firstName = $scope.page.user.firstName;
    //$scope.lastName = $scope.page.user.lastName;


//    var x = $http({
//        method: 'GET',
//        url: '/ClansWebApp/login',
//        params: {"email": $scope.email, "password": $scope.password}
//    });


});




