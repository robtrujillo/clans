<%-- 
    Document   : employee_page
    Created on : Dec 7, 2016, 9:07:15 PM
    Author     : rvtru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/bootstrap.min.css" />
        <script src="${cp}/resources/js/frameworks/jquery-3.1.1.min.js"></script>
        <script src="${cp}/resources/js/frameworks/angular.min.js"></script>

        <script src="${cp}/resources/js/employee_page.js"></script>
        <script src="${cp}/resources/js/frameworks/bootstrap.min.js"></script>
    </head>
    <body>
        <div ng-app="myApp" ng-controller="myCtrl">
            <input type="hidden" id="userId" value='${employee.userId}'/>
            <h1>${employee.firstName} ${employee.lastName}</h1>
            <table>
                <tr>
                    <td><p class="text-muted" for="email">Email__</p></td>
                    <td><p id="email" class="text-info">${employee.email}</p></td>
                </tr>
                <tr>
                    <td><p class="text-muted" for="sex">Sex__</p></td>
                    <td><p id="sex" class="text-info">${employee.sex}</p></td>
                </tr>
                <tr>
                    <td><p class="text-muted" for="email">Address__</p></td>
                    <td><p id="email" class="text-info">${employee.street}, ${employee.city}, ${employee.state} ${employee.zipcode}</p></td>
                </tr>

                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse1">Create Advertisement</a>
                            </h4>
                        </div>
                        <div id="collapse1" class="panel-collapse collapse">
                            <ul class="list-group">
                                <div class="form-group">
                                    <label>Item Type:</label>
                                    <input type="text" ng-model="itemType" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Company:</label>
                                    <input type="text" ng-model="company" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Item Name:</label>
                                    <input type="text" ng-model="itemName" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Content:</label>
                                    <input placeholder="type content here" type="text" ng-model="content" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Unit Price:</label>
                                    <input type="text" ng-model="unitPrice" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Number Avaliable:</label>
                                    <input type="text" ng-model="numAvaliable" class="form-control">
                                </div>
                            </ul>
                            <a ng-click='updateAd()'>Create Advertisement</a>
                        </div>
                    </div>
                </div>

                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a ng-click="getRTList()" data-toggle="collapse" href="#collapse2">Record Transaction</a>
                            </h4>
                        </div>
                        <div id="collapse2" class="panel-collapse collapse" >
                            <ul class="list-group">
                                <div>
                                    <label>Accounts</label>
                                    <select ng-model="ssAcct" ng-options='x.firstName for x in accts'>
                                    </select>   
                                </div>
                                <div>
                                    <label>Items</label>
                                    <select ng-model="ssAd" ng-options='x.itemName for x in ads2'>
                                    </select>   
                                </div>
                                <div class="form-group">
                                    <label>Number Units</label>
                                    <input type="text" ng-model="NumUnits" class="form-control">
                                </div>
                            </ul>
                            <a ng-click='updateSales()'>Record Transaction</a>
                        </div>
                    </div>
                </div>

                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse3">Manage Accounts</a>
                            </h4>                            
                        </div>
                        <div id="collapse3" class="panel-collapse collapse" >
                            <ul class="list-group">
                                <button ng-click="addAcctBtn()"> Add Account </button>
                                <button ng-click="editAcctBtn()"> Edit Account </button>
                                <button ng-click="deleteAcctBtn()"> Delete Account </button>
                                <div>      
                                    <label ng-show="accountState == 0"> Pick user for account:</label>
                                    <select ng-show="accountState == 0" ng-model="user2Select" ng-options='x.firstName for x in names2'>
                                    </select>  
                                    <div ng-show="accountState == 0" class="form-group">
                                        <label ng-show="accountState == 0">Credit Card Number</label>
                                        <input type="text" ng-show="accountState == 0" ng-model="ccNum" class="form-control">
                                        <button ng-show="accountState == 0" ng-click="updateAccount()"> add </button>
                                    </div>
                                    <label ng-show="accountState == 1"> Accounts to edit: </label>
                                    <select ng-show="accountState == 1" ng-model="acct2Select" ng-options='x.firstName for x in accts2'>
                                    </select>   

                                    <div ng-show="accountState == 1" class="form-group">
                                        <label ng-show="accountState == 1">Credit Card Number</label>
                                        <input type="text" ng-show="accountState == 1" ng-model="ccNum" class="form-control">
                                        <button ng-show="accountState == 1" ng-click="updateAccount()"> edit </button>
                                    </div>  
                                    <div ng-show="accountState == 2" class="form-group">
                                        <label ng-show="accountState == 2"> Accounts to delete: </label>
                                        <select ng-show="accountState == 2" ng-model="acct2Select" ng-options='x.firstName for x in accts2'>
                                        </select>                                                                           
                                    </div>
                                    <button ng-show="accountState == 2" ng-click="deleteAccount()"> delete </button>      
                                </div>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a ng-click="getMailingList()"  data-toggle="collapse" href="#collapse4">Customer Mailing List</a>
                            </h4>
                        </div>
                        <div id="collapse4" class="panel-collapse collapse" >
                            <div ng-repeat="mail in mailingList">
                                <h4> {{mail.firstName}} {{mail.lastName}} {{mail.street}}  {{mail.city}}  {{mail.zipCode}}  {{mail.state}}  {{mail.country}}     {{mail.email}} </h4>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a ng-click="getNames2()"  data-toggle="collapse" href="#collapse5">Item Suggestion</a>
                            </h4>
                        </div>
                        <div id="collapse5" class="panel-collapse collapse" >
                            <label> Pick user for account:</label>
                            <select ng-model="user2Select" ng-options='x.firstName for x in names2'>
                            </select> 
                            <button ng-click="getSuggestion()"> Get Suggestion</button>
                            <div ng-repeat="sug in suggestion">
                                <h4> {{sug.itemName}} </h4>
                            </div>
                        </div>
                    </div>
                </div>


                <div>
                    <button ng-click="getAllAds()" class="btn btn-default">Click to get a list of ads to remove</button>
                    <select ng-show="ads.length > 0" ng-model="selectedAd" ng-options='x.itemName for x in ads'>
                    </select>      
                    <button ng-show="ads.length > 0" ng-click="deleteAd()">Delete Ad</button>                             
                </div> 


                <div id="messages">
                    <button id="msgBtn" ng-click="getNames()" class="btn btn-default">Click me to send a message</button>
                    <select ng-show="names.length > 0" ng-model="selectedName" ng-options='x.firstName for x in names'>
                    </select>                   

                </div>
<!--                TOP EMPLOYEE-->
                
                <div id="collapse1" class="panel-collapse collapse">
                            
                            <a ng-click='updateAd()'>Create Advertisement</a>
                        
                    
                </div>
                
                
                

        </div>
    </body>
</html>
