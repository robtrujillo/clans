<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <h1>Hello World!</h1>
        <form action="ClansServlet">
            EXPLOSION <br>
            <input type="submit" value="BOOM">
        </form>
    <c:forEach var="user" items="${listUsers}" varStatus="status">
        <h1>${status.index}</h1>
        <h1>${user.firstName}</h1>
    </c:forEach>
    </body>
</html>
