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

        <script src="${cp}/resources/js/user_page.js"></script>
        <script src="${cp}/resources/js/frameworks/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/page-wrapper.css" />
    </head>
    <body>
        <div id="page_wrap" class="container">
            <div ng-app="myApp" ng-controller="myCtrl">
                <input type="hidden" id="userId" value='${page.user.userId}'/>
                <input type="hidden" id="pageId" value='${page.pageId}'/>
                <h1>${page.user.firstName} ${page.user.lastName}</h1>

                <form:form method="GET" commandName="user" action="/ClansWebApp/logout">

                    <button class="btn btn-signout btn-warning" type="submit">Sign Out</button>  
                </form:form>
                <table>
                    <tr>
                        <td><p class="text-muted" for="email">Email__</p></td>
                        <td><p id="email" class="text-info">${page.user.email}</p></td>
                    </tr>
                    <tr>
                        <td><p class="text-muted" for="sex">Sex__</p></td>
                        <td><p id="sex" class="text-info">${page.user.sex}</p></td>
                    </tr>
                    <tr>
                        <td><p class="text-muted" for="email">Address__</p></td>
                        <td><p id="email" class="text-info">${page.user.street}, ${page.user.city}, ${page.user.state} ${page.user.zipcode}</p></td>
                    </tr>


                    <div class="panel-group" id="accordion">
                        <input id="np" type="text" class="form-control" placeholder="Type here for new post"></input> 
                        <a ng-click='addPost($index, post.postId)'>Submit New Post</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <div ng-repeat="post in posts" class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <input type="text" class="form-control" ng-model="post.content"></input> 
                                    by {{post.firstName}} {{post.lastName}} - {{post.likeCount}} Likes
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-click='editPost($index, 1)'>Like</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-click='editPost($index, -1)'>Unlike</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-click='editPost($index, 0)'>Save Edit</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-click='deletePost($index)'>Delete</a>
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
                                    <input type="text" class="form-control" ng-model="comment.content"></input> 
                                    by {{comment.firstName}} {{comment.lastName}} - {{comment.likeCount}} Likes
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-click='editComment($parent.$index, $index, 1)'>Like</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-click='editComment($parent.$index, $index, -1)'>Unlike</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-click='editComment($parent.$index, $index, 0)'>Save Edit</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a ng-click='deleteComment($parent.$index, $index)'>Delete</a>

                                </div>
                            </div>
                        </div>
                    </div>
                </table>
                <div id="send_msg">
                    <button id="msgBtn" ng-click="getNames()" class="btn btn-default">Click me to start making a message!</button>
                    <select ng-show="names.length > 0" ng-model="receiver.receiver" ng-options='user as getFullName(user) for user in names'>
                        Select a User to message</select>
                    <input ng-show="names.length > 0" placeholder="Enter Subject for Message Here" type="text" class="form-control" ng-model="subjectContent"></input> 
                    <input ng-show="names.length > 0" placeholder="Enter Message Here" type="text" class="form-control" ng-model="messageContent"></input> 
                    <span><button ng-show="names.length > 0" ng-click="sendMessage(messageContent, subjectContent)" class="btn btn-facebook">Click to Send</button>
                        <label ng-show="sent">Sent!</label></span>
                </div>
                <br/>
                <div check_msg>

                    <div class="panel-group">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a ng-click='getConvos()' data-toggle="collapse" href="#collapse1">Click me to see who you've been messaging!</a>
                                </h4>
                            </div>
                            <div id="collapse1" class="panel-collapse collapse">
                                <ul class="list-group">
                                    <li ng-repeat='convo in convos' class="list-group-item">
                                        <div  class="panel-group">
                                            <div class="panel panel-default">
                                                <div class="panel-heading">
                                                    <h4 class="panel-title">
                                                        <a ng-click='getMessages(convo.userId, $index)' data-toggle="collapse" href="#ms_{{$index}}">Messages with {{convo.firstName}} {{convo.lastName}}</a>
                                                    </h4>
                                                </div>
                                                <div id="ms_{{$index}}" class="panel-collapse collapse">
                                                    <ul class="list-group">
                                                        <li ng-repeat='msg in convo.msgs' class="list-group-item">
                                                            <label>{{msg.subject}}</label>
                                                            {{msg.content}} -by {{msg.senderFName}} {{msg.senderLName}}
                                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                                            <a ng-click='deleteMessage($parent.$index, $index)'>Delete</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>


                <button class="btn btn-default" data-toggle="collapse" data-target="#mk_grp">Click Me to Look at Group Stuff</button>
                <div id="mk_grp" class="collapse">

                    <input ng-model="groupName" type="text" class="form-control" placeholder="What is the name of your new group?"></input> 
                    <button class="btn btn-default" ng-click="updateGroups()">Create New Group!</button>
                    <button ng-click="getMyGroups()"class="btn btn-default" data-toggle="collapse" data-target="#my_grps">Click Me to Look at Groups You are a Member of!</button>
                    <ul  class="collapse" id="my_grps">
                        <li ng-show="!(groups.length > 0)">Not a member of any groups</li>
                        <li ng-repeat="group in groups">{{ group.groupName }}</li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
