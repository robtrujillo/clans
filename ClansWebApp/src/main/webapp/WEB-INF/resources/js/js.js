/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http) {

    $scope.email = "";
    $scope.password = "";

    $scope.signin = function () {
        var x = $http({
            method: 'POST',
            url: '/ClansWebApp/login',
            params: {"email": $scope.email, "password": $scope.password}
        });
    };

});




