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
        <div class="panel">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="row">
                            <div class="col-md-6">
                                <p class="input-group">
                                    <input type="text" class="form-control" uib-datepicker-popup="{{format}}" ng-model="startdt" is-open="startdtpopup.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" />
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-default" ng-click="openstartdt()"><i class="glyphicon glyphicon-calendar"></i></button>
                                    </span>
                                </p>
                            </div>

                            <div class="col-md-6">
                                <p class="input-group">
                                    <input type="text" class="form-control" uib-datepicker-popup="{{format}}" ng-model="enddt" is-open="enddtpopup.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" />
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-default" ng-click="openenddt()"><i class="glyphicon glyphicon-calendar"></i></button>
                                    </span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <input type="checkbox"> Show latest images
                    </div>
                </div>
            </div>
            <div class="panel-body">
                Modify the interval at which images are captured etc...
                <p></p>
                <div class="pull-right">
                    <a role="button" class="btn btn-sm btn-success" href="#/configure">View</a>
                </div>

            </div>

        </div>
    </div>



</div>
