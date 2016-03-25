<%-- 
    Document   : home
    Created on : Feb 18, 2016, 8:08:39 PM
    Author     : smahapat
--%>

<div class="jumbotron">
    <h2>Divyadrushti</h2>
    <p>An eye to your world</p>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="row">
                            <div class="col-md-6">
                                <p class="input-group">
                                    <input type="text" class="form-control" uib-datepicker-popup="{{format}}" ng-model="startdt" is-open="startdtpopup.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" placeholder="Start Date"/>
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-default" ng-click="openstartdt()"><i class="glyphicon glyphicon-calendar"></i></button>
                                    </span>
                                </p>
                            </div>

                            <div class="col-md-6">
                                <p class="input-group">
                                    <input type="text" class="form-control" uib-datepicker-popup="{{format}}" ng-model="enddt" is-open="enddtpopup.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" placeholder="End Date"/>
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-default" ng-click="openenddt()"><i class="glyphicon glyphicon-calendar"></i></button>
                                    </span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="form-group">
                            <select>
                                <option>Select Camera</option>
                            </select>
                        </div>
                    </div>
                    <input type="checkbox" checked> Show recent images
                </div>
                <div class="dd-hr-line"></div>
                <div class="row">
                    <div class="col-lg-3">
                        <a href="#" class="thumbnail">
                            <img src="resources/images/eye.png" alt="...">
                        </a>
                    </div>
                    <div class="col-lg-3">
                        <a href="#" class="thumbnail">
                            <img src="resources/images/logo.png" alt="...">
                        </a>
                    </div>
                    <div class="col-lg-3">
                        <a href="#" class="thumbnail">
                            <img src="resources/images/logo_green.png" alt="...">
                        </a>
                    </div>
                    <div class="col-lg-3">
                        <a href="#" class="thumbnail">
                            <img src="resources/images/parachute.jpg" alt="...">
                        </a>
                    </div>
                </div>
            </div>



        </div>
    </div>



</div>
