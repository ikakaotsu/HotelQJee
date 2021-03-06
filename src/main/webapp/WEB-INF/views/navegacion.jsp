<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index">Hotel version 0.1</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-messages">
                <li>
                    <a href="#">
                        Mensajes
                    </a>
                </li>
                <li class="divider"></li>          
                <li class="divider"></li>
                <li>
                    <a class="text-center" href="#">
                        <strong>Leer todos los mensajes</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </ul>
        </li>
        <!-- /.dropdown-messages -->
        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="#"><i class="fa fa-user fa-fw"></i>Perfil Usuario</a>
                </li>
                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Configuraci�n</a>
                </li>
                <li class="divider"></li>
                <li><a href="<c:url value='/logout' />"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li class="sidebar-search">
                    <div class="input-group custom-search-form">
                        <input type="text" class="form-control" placeholder="Buscar Cliente...">
                        <span class="input-group-btn">
                        <button class="btn btn-default" type="button">
                            <i class="fa fa-search"></i>
                        </button>
                    </span>
                    </div>
                    <!-- /input-group -->
                </li>
                
                 <li>
                    <a href="<c:url value='/listahabitaciones' />"><i class="fa fa-table fa-fw"></i> Habitaciones</a>
                </li>
                
               <li>
                    <a href="#"><i class="fa fa-sitemap fa-fw"></i> Usuarios<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                       <li>
                       		<a href="<c:url value="/listausuarios"/>">Lista Usuarios</a>
                		</li>
                        <li>
                        	
                            <a href="<c:url value='/nuevousuario' />">Nuevo Usuario</a>
                        </li>
                    </ul>  
                </li>
                
                <li>
                    <a href="#"><i class="fa fa-sitemap fa-fw"></i> Clientes<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                    	<li>
                        	<a href="<c:url value='/listaclientes' />">Lista Clientes</a>
                        </li>
                        
                        <li>
                       		
                            <a href="<c:url value='/nuevocliente' />">Nuevo Cliente</a>
                            
                        </li>
                    </ul>
                </li>
                
                  <li>
                    <a href="#"><i class="fa fa-sitemap fa-fw"></i> Cuenta Corrientes<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                    	<li>
                        	<a href="<c:url value='/listactacte' />">Lista Cuenta Corrientes</a>
                        </li>
                        <li>
                            <a href="<c:url value='/nuevoctacte' />">Nueva Cuenta Corriente</a>
                        </li>
                    </ul>
                </li>
                
                <li>
                    <a href="#"><i class="fa fa-sitemap fa-fw"></i> Facturacion<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="#">Crear Factura</a>
                        </li>
                        <li>
                            <a href="#">Buscar Factura</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>