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
    <div class="col-lg-6">
        <div class="panel panel-default dd-tile-panel">
            <div class="panel-heading">
                <h3 class="panel-title">Devices<span class="glyphicon glyphicon-flash pull-right" aria-hidden="true"></span></h3>
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
    
    
    <div class="col-lg-6">
        <div class="panel panel-default dd-tile-panel dd-tile-panel-brown">
            <div class="panel-heading">
                <h3 class="panel-title">Personal Information<span class="glyphicon glyphicon-cog pull-right" aria-hidden="true"></span></h3>
            </div>
            <div class="panel-body">
                <strong>{{user.name}}</strong></br>
                <span>{{user.email}}</span></br>
                <span>{{user.mobile}}</span>
            </div>
            
        </div>
    </div>
</div>
