<%-- 
    Document   : configure
    Created on : Feb 15, 2016, 10:08:45 PM
    Author     : smahapat
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
    <div class="col-lg-6">
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
                        </tr>
                    </thead>
                    <tfoot>
                        <tr><td colspan="4"><span class="pull-right"><button class="btn btn-success" data-toggle="modal" data-target="#add-device-dialog">Add</button></span></td></tr>
                    </tfoot>
                    <tbody>
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
                        <form class="form-horizontal">
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="text" class="form-control" id="deviceName" placeholder="Device Name (e.g. cam_living)">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="MAC ID" class="form-control" id="deviceMacId" placeholder="MAC ID">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="cron" class="col-lg-1 control-label">Frequency</label>
                                <div class="col-lg-offset-1 col-lg-10">
                                    <cron-selection output="cronFrequency" config="cronConfig" id="cron"></cron-selection>
                                </div>
                            </div>
                            
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-success">Save</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>
    <div class="col-lg-6">
        
    </div>
</div>

