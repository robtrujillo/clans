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
         <h2>EMPLOYEE</h2>
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

        </div>
    </body>
</html>
