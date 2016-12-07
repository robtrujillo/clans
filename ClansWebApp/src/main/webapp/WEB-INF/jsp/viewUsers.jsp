<%-- 
    Document   : viewUsers
    Created on : Dec 7, 2016, 1:49:35 PM
    Author     : Chuntak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        THIS WORKS
        <c:forEach var="user" items="${listUsersV}">
            <h4>${user.userId} ${user.firstName} ${user.lastName} ${user.city} </h4>
        </c:forEach>
    </body>
</html>
