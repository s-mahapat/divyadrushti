<%-- 
    Document   : home
    Created on : Feb 18, 2016, 8:08:39 PM
    Author     : smahapat
--%>

<div class="jumbotron">
  <h1>Welcome to Divyadrushti</h1>
  <p>An eye to your world</p>
</div>

<div class="row">
    <div class="col-lg-4">
        <div class="panel panel-default dd-tile-panel">
            <div class="panel-heading">
                <h3 class="panel-title">Preferences<span class="glyphicon glyphicon-flash pull-right" aria-hidden="true"></span></h3>
            </div>
            <div class="panel-body">
                Modify the interval at which images are captured etc...
                <p><a class="pull-right" href="#/configure">Configure <span class="sr-only">(current)</span></a></p>
            </div>
            
        </div>
    </div>
    
    <div class="col-lg-4">
        <div class="panel panel-default dd-tile-panel dd-tile-panel-orange">
            <div class="panel-heading">
                <h3 class="panel-title">Captured Images<span class="glyphicon glyphicon-flash pull-right" aria-hidden="true"></span></h3>
            </div>
            <div class="panel-body">
                View captured images
                <p><a class="pull-right" href="#/configure">Configure <span class="sr-only">(current)</span></a></p>
            </div>
            
        </div>
    </div>
    
    <div class="col-lg-4">
        <div class="panel panel-default dd-tile-panel dd-tile-panel-brown">
            <div class="panel-heading">
                <h3 class="panel-title">Personal Information<span class="glyphicon glyphicon-flash pull-right" aria-hidden="true"></span></h3>
            </div>
            <div class="panel-body">
                <strong>{{user.name}}</strong>
            </div>
            
        </div>
    </div>
</div>
