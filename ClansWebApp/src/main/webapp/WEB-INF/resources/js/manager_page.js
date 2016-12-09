/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http) {

    $scope.userId = parseInt($("#userId").val());
    $scope.pageId = parseInt($("#pageId").val());
    

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
    $scope.getComments = function (postId) {
        x = postId;
        index = 0;
        for (; postId !== $scope.posts[index].postId; index++)
            ;

        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/getComments',
            params: {"postId": x}
        }).then(function (response) {
            $scope.posts[index]["comments"] = response.data
        }, function errorCallBack(response) {
            alert("get comments error");
        });
    };
    
    $scope.editComment = function(i1, i2){
        postIndex = i1;
        commentIndex = i2;
        comment = $scope.posts[postIndex].comments[commentIndex];
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/saveComment',
            params: {"commentId":comment.commentId, "content": comment.content}
        }).then(function (response) {
            $scope.posts[index]["comments"] = response.data;
        }, function errorCallBack(response) {
            alert("get comments error\n");
        });
    }
    $scope.sendPost = function() {
        var data = $.param({
            json: JSON.stringify({
                commentId: comment.commentId
            })
        });
        $http.post("/echo/json/", data).success(function(data, status) {
            $scope.hello = data;
        })
    } 




});



