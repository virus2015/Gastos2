<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Gastos2.Datos.TiendasD"%>
<%@page import="Gastos2.Negocios.TiendasN"%>
<%@page import="Gastos2.Datos.Conexion" %>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <style>
            body {
                padding-top: 50px;
                padding-bottom: 20px;
            }
        </style>
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/main.css">

        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          
            <a class="navbar-brand" href="index.jsp">Index</a>   
           <a class="navbar-brand" href="IngresarGastosFijos.jsp">Gastos Fijos</a>
            <a class="navbar-brand" href="IngresarGastosVariables.jsp">Gastos Variables</a>        
           <a class="navbar-brand" href="categorias2.jsp">Categorias</a>
           <a class="navbar-brand" href="tiendas2.jsp">Tiendas</a>
           <a class="navbar-brand" href="articulos2.jsp">Articulos</a>         
           <a class="navbar-brand" href="creditos.jsp">Creditos</a>     
        </div>
        <div id="navbar" class="navbar-collapse collapse">
         
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
     
    </div>

    <div class="container">            
            <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal">Ingresar</button>
             <form class="navbar-form navbar-right" role="form">
            <div class="form-group">
              <input type="text" placeholder="Buscar por idTiendas" name="id" class="form-control">
            </div>
            
            <button type="submit" class="btn btn-success">Buscar</button>
        </form>
     </div> 
    
  <div class="container">
      
      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document" style="z-index: 9999; width: 1250px">
                    <div class="modal-content">
                        <div class="modal-header">                            
                            <h4 class="modal-title" id="myModalLabel">Agregar Registro</h4>
                        </div>
   <div class="modal-body">
       
  <h2>Tiendas</h2>
  <p>Tiendas joven</p>
  <div class="container">
      <form action="/Gastos2/ServIngresarTiendas2" method ="POST">
    <div class="form-group">
      <label for="nombres">Nombre:</label>
      <input type="text" class="form-control" id="nombres" name="nombre" required="nombre">
    </div>
    <div class="form-group">
      <label for="ciudadd">Ciudad:</label>
      <input type="text" class="form-control" id="ciudadd" name="ciudad" required="Ciudad" >
    </div>
    <div class="form-group" >
        <label for ="colonias">Colonia:</label>  
        <input type ="text"  class="form-control" id ="colonias" name ="colonia" required>
    </div>
    
    <div class="form-group" >
        <label for ="calles">Calle:</label>  
        <input type ="text"  class="form-control" id ="calles" name ="calle"  required>
    </div>  
    
    <div class="form-group" >
        <label for ="telefonos">Telefonos:</label>  
        <input type ="text"  class="form-control" id ="telefonos" name ="telefono">
    </div>  
      
    <div class="form-group" >
        <label for ="webs">Web:</label>  
        <input type ="text"  class="form-control" id ="webs" name ="web">
    </div>  
      
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
      
      
  
   </div>
          </div>                    
          </div>
          </div>
      </div>
  <table class="table table-hover">
    <thead>
      <tr>
             <th>IDTIENDAS</th>
             <th>NOMBRE</th>
             <th>CIUDAD</th>
             <th>COLONIA</th>
             <th>CALLE</th>
             <th>TELEFONO</th>
             <th>WEB</th>
             <th>ELIMINAR </th>
             <th>EDITAR</th>    
             
              <%
   Conexion con = new Conexion ();
   Connection conecta = con.conectar();
   
   ResultSet resultado;
   Statement psmt;
   psmt = conecta.createStatement();
   resultado   = psmt.executeQuery("select * from tiendasg2");
  %>
      </tr>
       
      
      <%
      String id = request.getParameter("id");
      
    if(id!= null){
     
     psmt = conecta.createStatement();
   resultado   = psmt.executeQuery("select * from tiendasg2 where idtiendas='"+id+"'");
     }else{
       System.err.print("Error joven");
    }
       while(resultado.next()){
      %>
      
      
      
    </thead>
    <tbody>
      <tr>
          <td> <%=resultado.getString("idTiendas") %> </td>
             <td> <%=resultado.getString("nombre") %> </td>
             <td> <%=resultado.getString("ciudad") %> </td>
             <td><%=resultado.getString("colonia") %>  </td>
             <td><%=resultado.getString("calle") %>  </td>
             <td><%=resultado.getString("telefono") %> </td>
             <td><%=resultado.getString("web") %> </td>
             <td><a href="/Gastos2/ServEliminaTiendas2?id=<%=resultado.getString("idTiendas") %>"><button type="button" class="btn btn-danger">Eliminar</button></a> </td>
             <td><a href="/Gastos2/editarTiendas2.jsp?id=<%=resultado.getString("idTiendas") %>"><button type="button" class="btn btn-success">Editar</button> </a> </td>
      </tr>
     
       <% }%>
    </tbody>
  </table>
</div> <!-- /container -->        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>

        <script src="js/vendor/bootstrap.min.js"></script>

        <script src="js/main.js"></script>

        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
            function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
            e=o.createElement(i);r=o.getElementsByTagName(i)[0];
            e.src='//www.google-analytics.com/analytics.js';
            r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
            ga('create','UA-XXXXX-X','auto');ga('send','pageview');
        </script>
    </body>
</html>
