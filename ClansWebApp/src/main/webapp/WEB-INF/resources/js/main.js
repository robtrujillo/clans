/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var x = $http({
  method: 'GET',
  url: '/login'
}).then(function successCallback(response) {
    alert("worked");
    // this callback will be called asynchronously
    // when the response is available
  }, function errorCallback(response) {
    alert("error");
    // called asynchronously if an error occurs
    // or server returns response with an error status.
  });

