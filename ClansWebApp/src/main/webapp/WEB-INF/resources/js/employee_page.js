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
    $scope.index = 0;

    $scope.changeHello = function () {
        $scope.HELLO = "CHANGED BAM!";
    };

    $scope.deleteAd = function () {
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/byeAd',
            params: {"adId": $scope.selectedAd.adId}
        }).then(function (response) {
            alert("Deleted Ad:");
            $scope.getAllAds();
        }, function errorCallBack(response) {
            alert("delete Ad error");
        });
    };




    $scope.updateSales = function () {
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/createSales',
            params: {"adId": $scope.ssAd.adId, "accountId": $scope.ssAcct.accountId,
                "numUnits": parseInt($scope.NumUnits)}
        }).then(function (response) {
            alert("Added new Sales:");
        }, function errorCallBack(response) {
            alert("Update sales error");
        });
    };

    $scope.updateAd = function () {
        x = $scope.userId;
        var y = $http({
            method: 'GET',
            url: '/ClansWebApp/createAd',
            params: {"itemType": $scope.itemType, "itemName": $scope.itemName,
                "company": $scope.company, "content": $scope.content,
                "unitPrice": parseFloat($scope.unitPrice), "numAvailable": parseInt($scope.numAvaliable),
                "userId": x}
        }).then(function (response) {
            alert("Added New Ad:");
        }, function errorCallBack(response) {
            alert("Update Ad error");
        });
    };

    $scope.ads = [];
    $scope.getAllAds = function () {
        $http({
            method: 'GET',
            url: '/ClansWebApp/getAllAds'
        }).then(function (response) {
            $scope.ads = response.data;
        }, function errorCallBack(response) {
            alert("error in get allAds");
        });
    };

    $scope.ads2 = [];
    $scope.getAllAds2 = function () {
        $http({
            method: 'GET',
            url: '/ClansWebApp/getAllAds'
        }).then(function (response) {
            $scope.ads2 = response.data;
        }, function errorCallBack(response) {
            alert("error in get allAds");
        });
    };

    $scope.accts = [];
    $scope.getAllAccts = function () {
        $http({
            method: 'GET',
            url: '/ClansWebApp/getAllAcct'
        }).then(function (response) {
            $scope.accts = response.data;
        }, function errorCallBack(response) {
            alert("error in get allAds");
        });
    };

    $scope.accts2 = [];
    $scope.getAllAccts2 = function () {
        $http({
            method: 'GET',
            url: '/ClansWebApp/getAllAcct'
        }).then(function (response) {
            $scope.accts2 = response.data;
        }, function errorCallBack(response) {
            alert("error in get allAds");
        });
    };

    $scope.names2 = [];
    $scope.getNames2 = function () {
        $http({
            method: 'GET',
            url: '/ClansWebApp/getAllUsers',
            params: {"userId": 0}
        }).then(function (response) {
            $scope.names2 = response.data;
        }, function errorCallBack(response) {
            alert("error in get posts");
        });
    };


    $scope.getRTList = function () {
        $scope.getAllAccts();
        $scope.getAllAds2();
    };

    $scope.accountState = -1;

    $scope.addAcctBtn = function () {
        $scope.accountState = 0;
        $scope.getAllAccts2();
        $scope.getNames2();
    };

    $scope.editAcctBtn = function () {
        $scope.accountState = 1;
        $scope.getAllAccts2();
    };
    $scope.deleteAcctBtn = function () {
        $scope.accountState = 2;
        $scope.getAllAccts2();
    };
//
//    private int accountId; userId
//            private String creditCardNum;
    $scope.acct2Select = null;
    $scope.user2Select = null;

    $scope.deleteAccount = function () {
        x = $scope.acct2Select === null ? 0 : $scope.acct2Select.accountId;
        $http({
            method: 'GET',
            url: '/ClansWebApp/deleteAccount',
            params: {"accountId": x}
        }).then(function (response) {
            alert("deleted acount");
            $scope.getAllAccts2();
        }, function errorCallBack(response) {
            alert("error in delete Account");
        });
    };

    $scope.mailingList = [];
    $scope.getMailingList = function () {
        $http({
            method: 'GET',
            url: '/ClansWebApp/getMailingList',
            params: {}
        }).then(function (response) {
            $scope.mailingList = response.data;
        }, function errorCallBack(response) {
            alert("error in update Account");
        });
    }

    $scope.updateAccount = function () {
        x = $scope.acct2Select === null ? 0 : $scope.acct2Select.accountId;
        u = $scope.user2Select === null ? 0 : $scope.user2Select.userId;
        $http({
            method: 'GET',
            url: '/ClansWebApp/changeAccount',
            params: {"userId": u, "accountId": x, "creditCardNum": $scope.ccNum}
        }).then(function (response) {
            alert("updated acount");
        }, function errorCallBack(response) {
            alert("error in update Account");
        });
    };

    $scope.names = [];
    $scope.getNames = function () {
        $http({
            method: 'GET',
            url: '/ClansWebApp/getAllUsers',
            params: {"userId": 0}
        }).then(function (response) {
            $scope.names = response.data;
        }, function errorCallBack(response) {
            alert("error in get posts");
        });
    };

    $scope.suggestion = [];
    $scope.getSuggestion = function () {
        $http({
            method: 'GET',
            url: '/ClansWebApp/getSuggestion',
            params: {accountId: $scope.acct2Select.accountId}
        }).then(function (response) {
            $scope.suggestion = response.data;
        }, function errorCallBack(response) {
            alert("error in get suggestions");
        });
    };

    $scope.groups = [];
    $scope.getGroup = function () {
        $http({
            method: 'GET',
            url: '/ClansWebApp/getGroups',
            params: {userId: $scope.acct2Select.userId}
        }).then(function (response) {
            $scope.groups = response.data;
        }, function errorCallBack(response) {
            alert("error in get groups");
        });
    };

    $scope.BSIList = [];
    $scope.getBSI = function () {
        $http({
            method: 'GET',
            url: '/ClansWebApp/getBSI',
            params: {}
        }).then(function (response) {
            $scope.BSIList = response.data;
        }, function errorCallBack(response) {
            alert("error in get Best Selling item");
        });
    }
    
    $scope.histories = [];
    $scope.getHistory = function () {
        $http({
            method: 'GET',
            url: '/ClansWebApp/getHistory',
            params: {accountId: $scope.acct2Select.accountId}
        }).then(function (response) {
            $scope.histories = response.data;
        }, function errorCallBack(response) {
            alert("error in get Best Selling item");
        });
    }
});




