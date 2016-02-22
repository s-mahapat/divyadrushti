<%-- 
    Document   : configure
    Created on : Feb 15, 2016, 10:08:45 PM
    Author     : smahapat
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
    <div class="col-lg-10">
        <div class="panel panel-default dd-tile-panel">
            <div class="panel-heading">
                <h3 class="panel-title">Frequency<span class="glyphicon glyphicon-flash pull-right" aria-hidden="true"></span></h3>
            </div>
            <div class="panel-body">
                <p>The interval at which images will be captured by the remote camera</p>
                <div><cron-selection output="cronFrequency" config="cronConfig"></cron-selection></div>
                <div class="pull-right"><button class="btn btn-success" ng-click="updateFrequency()">Update</button></div>
            </div>
        </div>
    </div>
</div>

