
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clans Web App</title>
<!--        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/site.css" />
        <script src="${cp}/resources/js/js.js"></script>-->
        <link rel="stylesheet" href="${cp}/resources/css/lib/bootstrap.min.css">
        <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.min.css">
        <link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
        <!-- <link rel="stylesheet" href="/css/lib/bootstrap-responsive.min.css"> -->
<!--        <link rel="stylesheet" href="main.css">-->
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/site.css" />
    </head>
    <body>
        
        <%--<c:forEach var="user" items="${listUsers}">--%>
            <!--<h4>${user.firstName} ${user.lastName}</h4>-->
        <%--</c:forEach>--%>
<div id="fb-root"></div>
<div class="apollo">
            <div class="apollo-container clearfix">
                <div class="apollo-facebook">
                    <div class="apollo-image"><img src="https://pbs.twimg.com/profile_images/508012914125463552/hIWOgrFq.png"></img></div>
                </div>
<!--        <h2>Login</h2>-->
    <div class="apollo-login">
       
        <form:form method="GET" commandName="user" action="/ClansWebApp/login">
                <div class="apollo-login">
                    <form class="form-signin" id="apollo-login-form">
                        <div class="form-group">
<!--                    <td>Email</td>-->
                    <form:input path="email" class="form-control email" placeholder="Email address" />
                        </div>
               
                <div class="form-group">
                    <form:input path="password" class="form-control" placeholder="Password" />
                
                
<!--                        <input type="submit" value="Submit"/>-->
                </div>         
           <button class="btn btn-lg btn-signin btn-default" type="submit">Sign in</button>              
        </form:form>
         <form:form method="POST" commandName="user" action="/ClansWebApp/register">
            <button class="btn btn-primary btn-lg btn-signin btn-block" type="submit">Register</button> 
        </form:form>
           <!--<p class="apollo-register-account"> <a type="submit" class="register-link">Need an account? <strong>Register here </strong><i class="icon-arrow-right"></i></a><br/> <a href="#" class="password-link"><small>Forgot your password?</small></a>  </p>-->
                    
                </div>
        
        <script src="/js/lib/jquery.min.js"></script>
        <script src="/js/lib/images.js"></script>
        <script src="/js/lib/md5.js"></script>
        <script src="/js/lib/bootstrap.min.js"></script>
        <script src="/js/main.js"></script>
    </div>
    </body>

</html>