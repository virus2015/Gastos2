<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Gastos2.Datos.TiendasD"%>
<%@page import="Gastos2.Negocios.TiendasN"%>
<%@page import="Gastos2.Datos.Conexion" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        
        <script src="validarCampos.js" type="text/javascript"></script>
        
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
              <input type="text" placeholder="Buscar por Idcredito" name="id" class="form-control">
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
       
    <h2>Creditos </h2>
  <p>Creditos joven</p>
  <div class="container">
     <form action="/Gastos2/ServIngresarCreditos2" method ="POST">
    <div class="form-group">
      <label >Monto Credito:</label>
      <input type="text" class="form-control"  name="montocredito" required required value="0" onkeypress="return filterFloat(event,this);" >
    </div>
    <div class="form-group">
      <label >Interes:</label>
      <input type="text" class="form-control"  name="interes" required value="0" onkeypress="return filterFloat(event,this);" >
    </div>
      
    <div class="form-group" >
        <label >Fecha:</label>  
        <input type ="date"  class="form-control" name ="fecha"  required >
    </div>  
    
    <div class="form-group" >
        <label >Descripcion:</label>  
        <input type ="text"  class="form-control" name ="descripcion">
    </div>  
      
    <div class="form-group" >
        <label >Consumo Credito:</label>  
        <input type ="text"  class="form-control"  name ="consumocredito" required value="0" onkeypress="return filterFloat(event,this);">
    </div>  
      
    <div class="form-group" >
        <label>Dato1 :</label>  
        <input type ="text"  class="form-control"  name ="concredito1" required value="0" onkeypress="return filterFloat(event,this);">
    </div>  
      
    <div class="form-group" >
        <label >Dato 2:</label>  
        <input type ="text"  class="form-control"  name ="concredito2" required value="0" onkeypress="return filterFloat(event,this);">
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
             <th>ID_CREDITO</th>
             <th>MONTO CREDITO</th>
             <th>INTERES</th>
             <th>FECHA</th>
             <th>DESCRIPCION</th>
             <th>CONSUMO CREDITO</th>
             <th>DATO 1</th>
             <th>DATO 2</th>
             <th>ELIMINAR </th>
             <th>EDITAR</th>    
             
              <%
   Conexion con = new Conexion ();
   Connection conecta = con.conectar();
   
   ResultSet resultado;
   Statement psmt;
   psmt = conecta.createStatement();
   resultado   = psmt.executeQuery("select * from creditosg2");
  %>
      </tr>
       
      
      <%
      String id = request.getParameter("id");
      
    if(id!= null){
     
     psmt = conecta.createStatement();
   resultado   = psmt.executeQuery("select * from creditosg2 where IDCREDITOS='"+id+"'");
     }else{
       System.err.print("Error joven");
    }
       while(resultado.next()){
      %>
      
      
      
    </thead>
    <tbody>
      <tr>
          <td> <%=resultado.getString("idcreditos") %> </td>
             <td> <%=resultado.getString("montocredito") %> </td>
             <td> <%=resultado.getString("interes") %> </td>
             <td><%=resultado.getDate("fecha") %>  </td>
             <td><%=resultado.getString("descripcion") %>  </td>
             <td><%=resultado.getString("consumocredito") %> </td>
             <td><%=resultado.getString("concredito1") %> </td>
             <td><%=resultado.getString("concredito2") %> </td>
             <td><a href="/Gastos2/ServEliminaCreditos2?id=<%=resultado.getString("idcreditos") %>"><button type="button" class="btn btn-danger">Eliminar</button></a> </td>
             <td><a href="/Gastos2/editarCreditos2.jsp?id=<%=resultado.getString("idcreditos") %>"><button type="button" class="btn btn-success">Editar</button> </a> </td>
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
