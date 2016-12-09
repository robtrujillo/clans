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

        <script src="${cp}/resources/js/manager_page.js"></script>
        <script src="${cp}/resources/js/frameworks/bootstrap.min.js"></script>
    </head>
    <body>
        <h2>MANAGER</h2>
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


                <!--                EDIT EMPLOYEE-->
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse1">Edit Employee</a>
                            </h4>
                        </div>
                        <div id="collapse1" class="panel-collapse collapse">
                            <ul class="list-group">
                                <div class="form-group">
                                    <label>Employee ID:</label>
                                    <input type="text" ng-model="emplId" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Update Wage:</label>
                                    <input type="text" ng-model="emplWage" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Update Manager Status:</label>
                                    <input placeholder="0 or 1" type="text" ng-model="isMan" class="form-control">
                                </div>

                            </ul>

                            <button class="btn btn-lg btn-signin btn-default"  ng-click='updateEmployee()'>Update Employee</button>
                        </div>
                    </div>
                </div>

                <!--                ADD EMPLOYEE-->
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse2">New Employee</a>
                            </h4>
                        </div>
                        <div id="collapse2" class="panel-collapse collapse">
                            <ul class="list-group">
                                <div class="form-group">
                                    <label>First Name:</label>
                                    <input type="text" ng-model="fname" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Last Name:</label>
                                    <input type="text" ng-model="lname" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Sex:</label>
                                    <input placeholder="M, F, or O" type="text" ng-model="sex" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Email:</label>
                                    <input placeholder="example@email.com" type="text" ng-model="email" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Password:</label>
                                    <input type="text" ng-model="pass" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Phone Number:</label>
                                    <input placeholder="10 Digits, no special characters or spaces" type="text" ng-model="pNum" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Street Address:</label>
                                    <input placeholder="M or F" type="text" ng-model="sAdd" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>City:</label>
                                    <input placeholder="City" type="text" ng-model="city" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Zip Code:</label>
                                    <input placeholder="5 digit integer" type="zip" ng-model="itemName" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>State:</label>
                                    <input placeholder="2 Letter Abbrv. ex. 'NY'" type="text" ng-model="state" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Country:</label>
                                    <input placeholder="Country" type="text" ng-model="country" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Is Employee?:</label>
                                    <input placeholder="Bool(0,1)" type="text" ng-model="isEmpl" class="form-control">
                                </div>

                            </ul>

                            <button class="btn btn-lg btn-signin btn-default"  ng-click='updateUser()'>Add Employee</button>
                        </div>
                    </div>
                </div>
                <!--                DELETE EMPLOYEE-->
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse3">DELETE EMPLOYEE</a>
                            </h4>
                        </div>
                        <div id="collapse3" class="panel-collapse collapse">
                            <ul class="list-group">
                                <div class="form-group">
                                    <label>Employee ID:</label>
                                    <input type="text" ng-model="emplId" class="form-control">
                                </div>
                            </ul>

                            <button class="btn btn-lg btn-signin btn-default"  ng-click='deleteEmployee()'>DELETE EMPLOYEE</button>
                        </div>
                    </div>
                </div>
                <!--                All Items-->
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse4">Item Listing</a>
                            </h4>
                        </div>
                        <div id="collapse4" class="panel-collapse collapse">
                            <ul class="list-group">
                                <div class="form-group">
                                    <label>Employee ID:</label>
                                    <input type="text" ng-model="emplId" class="form-control">
                                </div>
                            </ul>

                            <button class="btn btn-lg btn-signin btn-default"  ng-click='getAdvertisement()'>DELETE EMPLOYEE</button>
                        </div>
                    </div>
                </div>

                <!--                TRANSACTIONS-->
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse5">Transactions</a>
                            </h4>
                        </div>
                        <ul class="list-group">
                            <div id="collapse5" class="panel-collapse collapse">
                                <ul class="list-group">
                                    <label>Search By Item Name:</label>
                                    <input placeholder = "Item Name" type="text" ng-model="itemType" class="form-control">
                                    </div>
                                </ul>

                                <button class="btn btn-lg btn-signin btn-default"  ng-click='updateEmployee()'>Search</button>

                                <ul class="list-group">
                                    <div class="form-group">
                                        <label>Search By User Name:</label>
                                        <input placeholder = "User Name" type="text" ng-model="itemType" class="form-control">
                                    </div>
                                </ul>

                                <button class="btn btn-lg btn-signin btn-default"  ng-click='updateEmployee()'>Search</button>

                            </div>
                    </div>
                </div>

                <!--                Revenue-->
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse6">Revenue</a>
                            </h4>
                        </div>
                        <div id="collapse6" class="panel-collapse collapse">
                            <ul class="list-group">
                                <div class="form-group">
                                    <label>Search By Item Name:</label>
                                    <input placeholder = "Item Name" type="text" ng-model="itemType" class="form-control">
                                </div>
                            </ul>

                            <button class="btn btn-lg btn-signin btn-default"  ng-click='updateEmployee()'>Search</button>

                            <ul class="list-group">
                                <div class="form-group">
                                    <label>Search By Item Type:</label>
                                    <input placeholder = "Item Type" type="text" ng-model="itemType" class="form-control">
                                </div>
                            </ul>

                            <button class="btn btn-lg btn-signin btn-default"  ng-click='updateEmployee()'>Search</button>

                        </div>
                    </div>
                </div>
                <!--                TOP EMPLOYEE-->

                <div id="collapse1" class="panel-collapse collapse">

                    <a ng-click='updateAd()'>Create Advertisement</a>


                </div>

        </div>
    </body>
</html>
