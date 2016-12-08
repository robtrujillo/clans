
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clans Web App</title>
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/site.css" />
        <script src="${cp}/resources/js/js.js"></script>
    </head>
    <body>
        
        <%--<c:forEach var="user" items="${listUsers}">--%>
            <!--<h4>${user.firstName} ${user.lastName}</h4>-->
        <%--</c:forEach>--%>


        <h2>Login</h2>
        <form:form method="GET" commandName="user" action="/ClansWebApp/login">
            <table>
                <tr>
                    <td>Email</td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><form:input path="password" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit"/>
                    </td>
                </tr>
            </table>               
        </form:form>
        <form:form method="POST" commandName="user" action="/ClansWebApp/register">
               
            <input type="submit" value="Register"/>
               
        </form:form>
    </body>

</html>
