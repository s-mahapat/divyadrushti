<%-- 
    Document   : layout
    Created on : Feb 14, 2016, 1:12:23 PM
    Author     : smahapat
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" ng-app="divyadrushti">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Divyadrushti</title>
        <%@include file="bootstrap.jsp" %>
        <link rel="stylesheet" type="text/css" href="resources/css/divyadrushti.css">

    </head>
    <body>
        <div class="navbar navbar-default dd-navbar-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand dd-navbar-brand" href="#/"><img src="resources/images/logo.png" class="img-responsive"/></a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                <span id="username" data-userid="${user.id}" data-username="${user.email}">${user.name}</span> <span class="caret"></span>
                                <i class="fa fa-user fa-lg"></i>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#/configure"><i class="fa fa-cogs"></i>Preferences</a></li>
                                <li><a href="logout"><i class="fa fa-sign-out"></i>Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        
        <div class="container dd-main-container" ng-view></div>

    </body>
</html>
