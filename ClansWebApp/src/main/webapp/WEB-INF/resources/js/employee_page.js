/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http) {

    $scope.userId = parseInt($("#userId").val());
    
   
    var x = $http({
        method: 'GET',
        url: '/ClansWebApp/getPosts',
        params: {"pageId": $scope.pageId}
    }).then(function (response) {
        $scope.posts = response.data;
        x = 0;
        while (x < $scope.posts.length) {

            $scope.posts[x]["comments"] = [];
            x++;
        }
        //setTimeout(function(){ $('.collapse').collapse("hide"); }, 1);


    }, function errorCallBack(response) {
        alert("error in get posts");
    });
    $scope.index = 0
    
    $scope.changeHello = function (){
        $scope.HELLO = "CHANGED BAM!";
    }
    $scope.itemName = null;
    $scope.itemType = null;
    $scope.company = null;
    $scope.content = null;

    $scope.updateAd = function () {
        alert("HI");
        x = $scope.userId;
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/createAd',
            params: {"itemType": $scope.itemType, "itemName": $scope.itemName, 
                "company":$scope.company, "content":$scope.content, 
                "unitPrice":parseFloat($scope.unitPrice), "numAvailable":parseInt($scope.numAvaliable), 
                "userId":x}
        }).then(function (response) {
            alert("Added New Ad");
        }, function errorCallBack(response) {
            alert("Update Ad error");
        });


    };




});




