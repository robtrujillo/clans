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
        <h2>MANAGER_PAGE</h2>
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

                [[HELLO]]

        </div>
    </body>
</html>
