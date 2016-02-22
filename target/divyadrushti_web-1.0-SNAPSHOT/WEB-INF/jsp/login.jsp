<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DivyaDrushti</title>
        <%@include file="bootstrap.jsp" %>
        <style>
            body{
                background-image: url("resources/images/park.jpg");
                background-size: cover;
            }

            #login{
                padding: 25px;
                background-color: #e6e6e6;
                border-radius: 10px;
            }

            @media(max-width:768px){

                body{
                    background-image: none;
                    background-color: black;
                }
            }

        </style>

    </head>
    <body>
        <div class="container">
            <div class="row"></br></br></div>
            <div class="row">
                <div class="col-lg-offset-3 col-lg-6">
                    <div id="login">
                        <form class="form-horizontal" action="j_security_check" method="POST">
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                <input type="username" name="j_username" class="form-control" id="inputEmail3" placeholder="username" required>
                            </div>
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                <input type="password" name="j_password" class="form-control" id="inputPassword3" placeholder="password" required>

                            </div>
                            <div class="form-group">
                                <div class="col-lg-offset-1 col-lg-8">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox"> Remember me
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-offset-1 col-lg-10">
                                    <button type="submit" class="btn btn-success">Sign in</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </body>

</html>
