<%-- 
    Document   : layout
    Created on : Feb 14, 2016, 1:12:23 PM
    Author     : smahapat
--%>

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
        <div class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand dd-navbar-brand" href="#"><img src="resources/images/eye.png" class="img-responsive"/></a>
                    <a class="navbar-brand" href="#">Divyadrushti</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class=""><a href="#/configure">Configure <span class="sr-only">(current)</span></a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="container dd-main-container" ng-view></div>

    </body>
</html>
