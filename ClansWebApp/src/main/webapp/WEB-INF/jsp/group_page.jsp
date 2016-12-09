<%-- 
    Document   : user_page
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
        <title>User Page</title>
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/bootstrap.min.css" />
        <script src="${cp}/resources/js/frameworks/jquery-3.1.1.min.js"></script>
        <script src="${cp}/resources/js/frameworks/angular.min.js"></script>

        <script src="${cp}/resources/js/group_page.js"></script>
        <script src="${cp}/resources/js/frameworks/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/page-wrapper.css" />
    </head>
    <body>
        <div id="page_wrap" class="container">
            <div ng-app="myApp" ng-controller="myCtrl">
                <input type="hidden" id="pageId" value='${page.pageId}'/>
                <input type="hidden" id="groupId" value='${page.group.groupId}'/>
                <input type="hidden" id="ownerId" value='${page.group.userId}'/>
                <input type="hidden" id="userId" value='${page.user.userId}'/>
                <h1>${page.group.groupName}</h1>
                <input ng-model="groupName" ng-show="${page.group.userId} == ${page.user.userId}" id="np" type="text" class="form-control" placeholder="New Group Name"></input> 
                <button ng-show="${page.group.userId} == ${page.user.userId}" class="btn btn-success" ng-click="updateGroups()">Save new group name!</button>
                <form:form method="GET" commandName="user" action="/ClansWebApp/logout">

                    <button class="btn btn-signout btn-warning" type="submit">Sign Out</button>  
                </form:form>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <select ng-change="sessionVar()" ng-model="otherUser.user" ng-options='user as getFullName(user) for user in names'>
                        Select a User</select>
                     <form:form method="GET" commandName="user" action="/ClansWebApp/switchUserPage">
                    <button id="leaveBtn" class="btn btn-signout btn-warning" type="submit">Go to their page!</button>  
                </form:form>
                <table>
                    


                    <div class="panel-group" id="accordion">
                        <input id="np" type="text" class="form-control" placeholder="Type here for new post"></input> 
                        <a ng-click='addPost($index, post.postId)'>Submit New Post</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <div ng-repeat="post in posts" class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <input ngReadonly="${page.group.userId} != ${page.user.userId} && ${page.user.userId} != post.userId)" type="text" class="form-control" ng-model="post.content"></input> 
                                    by {{post.firstName}} {{post.lastName}} - {{post.likeCount}} Likes
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-click='editPost($index, 1)'>Like</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-click='editPost($index, -1)'>Unlike</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-show="${page.group.userId} == ${page.user.userId} || ${page.user.userId} == post.userId" ng-click='editPost($index, 0)'>Save Edit</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-show="${page.group.userId} == ${page.user.userId} || ${page.user.userId} == post.userId" ng-click='deletePost($index)'>Delete</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-click="getComments(post.postId)" data-toggle="collapse" data-parent="#accordion"  href="#c_{{$index}}">
                                        See {{post.commentCount}} Comments</a>
                                    <br/>
                                    <input id="nc_{{$index}}" type="text" class="form-control" placeholder="Type here for new comment"></input> 
                                    <a ng-click='addComment($index, post.postId)'>Submit Comment</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                </h4>
                            </div>
                            <div id="c_{{$index}}" class="panel-collapse collapse ">
                                <p ng-show='post.comments.length === 0'>No Comments</p>
                                <div class="panel-body " ng-repeat='comment in post.comments'>
                                    <input ngReadonly="${page.group.userId} == ${page.user.userId}" type="text" class="form-control" ng-model="comment.content"></input> 
                                    by {{comment.firstName}} {{comment.lastName}} - {{comment.likeCount}} Likes
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-click='editComment($parent.$index, $index, 1)'>Like</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-click='editComment($parent.$index, $index, -1)'>Unlike</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-show="${page.group.userId} == ${page.user.userId}" ng-click='editComment($parent.$index, $index, 0)'>Save Edit</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-show="${page.group.userId} == ${page.user.userId}" ng-click='deleteComment($parent.$index, $index)'>Delete</a>
                                    

                                </div>
                            </div>
                        </div>
                    </div>
                </table>
                
                <br/>
               
            </div>
        </div>
    </body>
</html>
