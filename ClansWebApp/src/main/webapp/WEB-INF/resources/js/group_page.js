/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http) {

    /* id of page */
    
    $scope.pageId = parseInt($("#pageId").val());
    
    /* id of logged in user */
    $scope.userId = parseInt($("#userId").val());
    /* id of group */
    $scope.groupId = parseInt($("#groupId").val());
    /* id of owner of group - has admin priviledge */
    $scope.ownerId = parseInt($("#ownerId").val());
    
    


    $scope.names = [];
    $scope.getNames = function () {
        $http({
            method: 'GET',
            url: '/ClansWebApp/getAllUsers',
            params: {"userId": 0}
        }).then(function (response) {
            $scope.names = response.data;
            //$scope.selectedName = $scope.names[0].firstName;
            $scope.receiver = {"receiver": $scope.names[0]};
            $scope.otherUser = {"user": $scope.names[0]};
            $scope.sessionVar();
            alert("Owner " + $scope.ownerId + " User " + $scope.userId )
        }, function errorCallBack(response) {
            alert("error in get posts");
        });
    }
    $scope.getFullName = function (user) {
        return user.firstName + ' ' + user.lastName;
    };
    $scope.getNames();
    $scope.sessionVar = function () {
        var temp = $scope.otherUser.user;
        var x = $http({
            method: 'GET',
            url: '/ClansWebApp/sessionVar',
            params: {"userId": temp.userId}
        }).then(function (response) {
            //alert($scope.id_user);
        }
        , function errorCallBack(response) {
            alert("error in get posts");
        });
    }

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
    }, function errorCallBack(response) {
        alert("error in get posts " + $scope.pageId);
    });

    $scope.addPost = function () {

        content = $("#np").val();
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/savePost',
            params: {"content": content, "pageId": $scope.pageId, "userId": $scope.userId}
        }).then(function (response) {
            $(id).value = "";
            x();
        }, function errorCallBack(response) {
            alert("add post error\n");
        });
    }

    $scope.editPost = function (index, like) {
        postIndex = index;

        post = $scope.posts[postIndex];
        likes = like;
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/savePost',
            params: {"postId": post.postId, "content": post.content, "likeCount": like}
        }).then(function (response) {
            $scope.posts[postIndex].likeCount += likes;
        }, function errorCallBack(response) {
            alert("save post error\n");
        });
    }

    $scope.deletePost = function (index) {
        postIndex = index;
        post = $scope.posts[postIndex];
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/byePost',
            params: {"postId": post.postId}
        }).then(function (response) {
            $scope.posts.splice(index, 1);
        }, function errorCallBack(response) {
            alert("delete post error\n");
        });
    }


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

    $scope.addComment = function (postIndex, postId) {
        index = postIndex;
        var id = "#nc_" + index
        content = $(id).val();
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/saveComment',
            params: {"content": content, "postId": postId, "userId": $scope.userId}
        }).then(function (response) {
            $(id).value = "";
        }, function errorCallBack(response) {
            alert("add comments error\n");
        });
    }

    $scope.editComment = function (i1, i2, like) {
        postIndex = i1;
        commentIndex = i2;
        comment = $scope.posts[postIndex].comments[commentIndex];
        likes = like;
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/saveComment',
            params: {"commentId": comment.commentId, "content": comment.content, "likeCount": like}
        }).then(function (response) {

            $scope.posts[postIndex].comments[commentIndex].likeCount += likes;
        }, function errorCallBack(response) {
            alert("edit comments error\n");
        });
    }

    $scope.deleteComment = function (i1, i2) {
        postIndex = i1;
        commentIndex = i2;
        comment = $scope.posts[postIndex].comments[commentIndex];
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/byeComment',
            params: {"commentId": comment.commentId}
        }).then(function (response) {
            $scope.posts[index]["comments"].splice(commentIndex, 1);
        }, function errorCallBack(response) {
            alert("delete comment error\n");
        });
    }

    $scope.sent = false;
    $scope.sendMessage = function (msg, sbj) {
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/saveMessage',
            params: {"senderId": $scope.userId, "receiverId": $scope.receiver.receiver.userId, "content": msg, "subject": sbj}
        }).then(function (response) {
            $scope.sent = true;
            //$scope.posts[index]["comments"].splice(commentIndex, 1);
        }, function errorCallBack(response) {
            alert("send message error\n");
            $scope.sent = false;
        });
    }

    $scope.getConvos = function () {
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/getMessages',
            params: {"userId": $scope.userId}
        }).then(function (response) {
            $scope.convos = response.data;
            //$scope.posts[index]["comments"].splice(commentIndex, 1);
        }, function errorCallBack(response) {
            alert("get messages error\n");
        });
    }

    $scope.getMessages = function (otherId, index) {
        i = index;
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/getConvos',
            params: {"senderId": $scope.userId, "receiverId": otherId}
        }).then(function (response) {
            $scope.convos[i]["msgs"] = response.data;

        }, function errorCallBack(response) {
            alert("get convos error\n");
        });
    }

    $scope.deleteMessage = function (i1, i2) {
        convoIndex = i1;
        messageIndex = i2;
        message = $scope.convos[convoIndex].msgs[messageIndex];
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/byeMessage',
            params: {"messageId": message.messageId}
        }).then(function (response) {
            $scope.convos[convoIndex]["msgs"].splice(messageIndex, 1);
        }, function errorCallBack(response) {
            alert("delete message error\n");
        });
    }

    $scope.updateGroups = function () {
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/saveGroup',
            params: {"userId": $scope.userId, "groupName": $scope.groupName, "groupId":$scope.groupId}
        }).then(function (response) {

        }, function errorCallBack(response) {
            alert("error making group\n");
        });
    }

    $scope.getMyGroups = function () {
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/getGroups',
            params: {"userId": $scope.userId}
        }).then(function (response) {
            $scope.groups = response.data;
        }, function errorCallBack(response) {
            alert("error making group\n");
        });
    }

    $scope.getGroups = function () {
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/getGroups',
            params: {"ownerId": $scope.userId, "groupName": $scope.groupName}
        }).then(function (response) {

        }, function errorCallBack(response) {
            alert("error making group\n");
        });
    }

    $scope.signout = function () {
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/signout',
            params: {"userId": $scope.userId, "signedIn": false}
        }).then(function (response) {

        }, function errorCallBack(response) {
            alert("sign out error\n");
        });
    }




});




