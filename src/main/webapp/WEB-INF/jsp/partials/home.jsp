<%-- 
    Document   : home
    Created on : Feb 18, 2016, 8:08:39 PM
    Author     : smahapat
--%>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-primary">
            <div class="panel-heading">
            </div>
            <div class="panel-body">
                <div class="row">
                    <form class="form-inline">
                        <div class="col-lg-6">
                            <div class="row">
                                <div class="col-md-6">
                                    <p class="input-group">
                                        <input type="text" class="form-control" when-closed="getImagesForDateRange()" ng-click="openstartdt()" datetime-picker="dd/MM/yyyy HH:mm" datepicker-options="dateOptions" date-disabled="disabledDates(date, mode)" ng-model="startdt" is-open="startdtpopup.opened" placeholder="Start Date & Time"/>
                                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-default" ng-click="openstartdt()"><i class="glyphicon glyphicon-calendar"></i></button>
                                        </span>
                                    </p>
                                </div>

                                <div class="col-md-6">
                                    <p class="input-group">
                                        <input type="text" class="form-control" when-closed="getImagesForDateRange()" ng-click="openenddt()" datetime-picker="dd/MM/yyyy HH:mm" datepicker-options="dateOptions" date-disabled="disabledDates(date, mode)" ng-model="enddt" is-open="enddtpopup.opened" placeholder="End Date & Time"/>
                                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-default" ng-click="openenddt()"><i class="glyphicon glyphicon-calendar"></i></button>
                                        </span>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="camera">Camera &nbsp; </label>
                                <select id="camera" ng-model="selectedDeviceId" ng-change="getImagesForDateRange()" class="form-control">
                                    <option ng-hide="devices.length > 0">Select Camera</option>
                                    <option ng-repeat="device in devices" value="{{device.id}}" selected>{{device.name}}</option>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="dd-hr-line"></div>
                <div class="row text-center" ng-hide="images.length > 0">
                    <label><h6>No images taken during the selected date and time range.</h6></label>
                </div>
                <div class="row">
                    <div class="col-lg-3" ng-repeat="image in images">
                        <a href="" data-toggle="modal" data-target="#imgmodal_{{$index}}" class="thumbnail">
                            <img ng-src="{{image}}"/>
                        </a>
                    </div>

                </div>
                <div id="imgmodal_{{$index}}" class="modal fade" tabindex="-1" role="dialog" ng-repeat="image in images">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">x</button>
                    </div> <!--modal-header--> 
                    <div class="modal-body">
                        <img class="img-responsive" ng-src="{{image}}"/>
                    </div><!--modal-body-->
                    <div class="modal-footer">
                        <button class="btn" data-dismiss="modal">Close</button>
                    </div><!--modal-footer-->
                </div><!--Modal hide fade-->
            </div>



        </div>
    </div>



</div>
