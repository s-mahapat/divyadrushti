<%-- 
    Document   : configure
    Created on : Feb 15, 2016, 10:08:45 PM
    Author     : smahapat
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default dd-tile-panel">
            <div class="panel-heading">
                <h3 class="panel-title">Registered Devices<span class="pull-right" aria-hidden="true"><i class="fa fa-camera"></i></span></h3>
            </div>
            <div class="panel-body">
                <table class="table table-condensed table-responsive table-striped">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Mac address</th>
                            <th>Frequency</th>
                            <th>Next snap</th>
                            <th>Images</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr><td colspan="6"><span class="pull-right"><button class="btn btn-success" data-toggle="modal" data-target="#add-device-dialog">Add</button></span></td></tr>
                    </tfoot>
                    <tbody>
                        <tr ng-repeat="userdevice in devices">
                            <td>{{userdevice.name}}</td>
                            <td>{{userdevice.macAddress}}</td>
                            <td>{{prettifyCron(userdevice.cron)}}</td>
                            <td>{{getNextCronRun(userdevice.cron)}}</td>
                            <td><a href="" ng-click="getImagesForDevice(userdevice.id)">View</a></td>
                            <td><a href="">edit</a></td>
                        </tr>
                    </tbody>

                </table>
            </div>
        </div>
        <div class="modal fade" tabindex="-1" role="dialog" id="add-device-dialog">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Add Device</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" ng-submit="addDevice()">
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="text" class="form-control" id="deviceName" name="deviceName" ng-model="device.name" ng-required="true" placeholder="Device Name (e.g. living room)">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="text" class="form-control" id="deviceMacId" name="macAddress" ng-model="device.macAddress" ng-required="true" placeholder="MAC ID" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="cron" class="col-lg-1 control-label">Frequency</label>
                                <div class="col-lg-offset-1 col-lg-10">
                                    <cron-selection output="device.cron" config="cronConfig" id="cron"></cron-selection>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="enabled" id="device-enabled" ng-model="device.active"> Active
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                    <div class="modal-footer">

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>
    <div class="col-lg-6">

    </div>
</div>
<div class="row" ng-show="showImages">
    <div class="col-lg-12">
        <uib-carousel active="active" interval="myInterval" no-wrap="noWrapSlides">
            <uib-slide ng-repeat="slide in slides track by slide.id" index="slide.id">
                <img ng-src="{{slide.image}}" style="margin:auto;">
                <!--<div class="carousel-caption">
                    <h4>Slide {{slide.id}}</h4>
                    <p>{{slide.text}}</p>
                </div>-->
            </uib-slide>
        </uib-carousel>
    </div>

</div>

