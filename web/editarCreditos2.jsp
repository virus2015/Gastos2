<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Gastos2.Datos.Conexion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Gastos2.Datos.TiendasD"%>
<%@page import="Gastos2.Negocios.TiendasN"%>
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
       <form class="navbar-form navbar-right" role="form">
            
          </form>
    </div>
    
    <div class="container">
  <h2>Editar Tiendas</h2>
  <p>Editar tiendas</p>
  
  <%
   int id = Integer.parseInt(request.getParameter("id"));
           
       Conexion con = new Conexion();
       Connection conecta = con.conectar();
       
       
       String sql="select * from creditosg2 where idcreditos="+id;
       PreparedStatement prep = conecta.prepareStatement(sql);
       ResultSet resultado = prep.executeQuery();
       
       while(resultado.next()){
  %>
  
   <form action="/Gastos2/ServEditarCreditos2" method ="POST">
    <div class="form-group">
      <label >Id Credito:</label>
      <input type="text" class="form-control"  name="idcreditos" required value="<%=resultado.getString("idcreditos") %>"  onkeypress="return filterFloat(event,this);">
    </div>   
       
       
    <div class="form-group">
      <label >Monto Credito:</label>
      <input type="text" class="form-control"  name="montocredito" required value="<%=resultado.getString("montocredito") %>"  onkeypress="return filterFloat(event,this);">
    </div>
    <div class="form-group">
      <label >Interes:</label>
      <input type="text" class="form-control"  name="interes" value="<%=resultado.getString("interes") %>" onkeypress="return filterFloat(event,this);">
    </div>
      
    <div class="form-group" >
        <label >Fecha:</label>  
        <input type ="date"  class="form-control" name ="fecha"  required value="<%=resultado.getDate("fecha") %>"  >
    </div>  
    
    <div class="form-group" >
        <label >Descripcion:</label>  
        <input type ="text"  class="form-control" name ="descripcion"  value="<%=resultado.getString("descripcion") %>">
    </div>  
      
    <div class="form-group" >
        <label >Consumo Credito:</label>  
        <input type ="text"  class="form-control"  name ="consumocredito"  value="<%=resultado.getString("consumocredito") %>" onkeypress="return filterFloat(event,this);">
    </div>  
      
    <div class="form-group" >
        <label>Dato1 :</label>  
        <input type ="text"  class="form-control"  name ="concredito1"  value="<%=resultado.getString("concredito1") %>" onkeypress="return filterFloat(event,this);">
    </div>  
      
    <div class="form-group" >
        <label >Dato 2:</label>  
        <input type ="text"  class="form-control"  name ="concredito2"  value="<%=resultado.getString("concredito2") %>"  onkeypress="return filterFloat(event,this);">
    </div> 
      
    <button type="submit" class="btn btn-primary">Submit</button>
    
    
    
  </form>
    
    <%}%>
</div>
    
    

   <!-- /container -->        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
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
