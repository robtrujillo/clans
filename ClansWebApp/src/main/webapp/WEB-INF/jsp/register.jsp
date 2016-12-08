<%-- 
    Document   : register
    Created on : Dec 7, 2016, 9:20:48 PM
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
        <title>Register</title>
    </head>
    <body>
        <h1>Register</h1>
            <form:form method="POST" commandName="user" action="/ClansWebApp/register">
            <table>
                <tr>
                    <td>First Name</td>
                    <td><form:input path="firstName" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><form:input path="lastName" /></td>
                </tr>
                <tr>
                <tr>
                    <td>Email</td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><form:input path="password" /></td>
                </tr>
                <tr>
                <tr>
                    <td>Gender (M or F)</td>
                    <td><form:input path="sex" /></td>
                </tr>
                <tr>
                    <td>Phone Number (only digits)</td>
                    <td><form:input path="phoneNum" /></td>
                </tr>
                <tr>
                <tr>
                    <td>Street</td>
                    <td><form:input path="street" /></td>
                </tr>
                <tr>
                    <td>City</td>
                    <td><form:input path="city" /></td>
                </tr>
                <tr>
                <tr>
                    <td>Zip Code</td>
                    <td><form:input path="zipcode" /></td>
                </tr>
                <tr>
                    <td>State (ex: "NY")</td>
                    <td><form:input path="state" /></td>
                </tr>
                <tr>
                <tr>
                    <td>Country</td>
                    <td><form:input path="country" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit"/>
                    </td>
                </tr>
            </table>               
        </form:form>
    </body>
</html>
