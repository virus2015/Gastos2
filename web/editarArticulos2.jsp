<%@page import="java.util.Calendar"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="Gastos2.Datos.Conexion"%>
<%@page import="Gastos2.Datos.CategoriasD"%>
<%@page import="Gastos2.Negocios.CategoriasN"%>
<%@page import="Gastos2.Datos.GastosFijosD"%>
<%@page import="Gastos2.Negocios.GastosfIjosN"%>
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
  <h2>Editar Articulos</h2>
  <p>Editar los Articulos</p>
  <form action="/Gastos2/ServEditarArticulos3" method ="POST">
      <%
       int id = Integer.parseInt(request.getParameter("id"));
        
        Conexion con = new Conexion ();
        Connection conectar = con.conectar();
        ResultSet resultado;
        
        String sql ="select a.idarticulos as idarticulos,a.nombre as nombre,"
                + " a.descripcion as descripcion ,  a.marca as marca, a.frk_idCategorias as idCategoria,"
                + "a.fecha as fecha from articulosg2 a  where idArticulos="+id; 
                
        PreparedStatement psmt = conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
      %>
      
    <div class="form-group">
      <label for="ids">Id:</label>
      <input type="text" class="form-control" value="<%=resultado.getString("idarticulos") %>"  name="idarticulos" required>
    </div>
      
    <div class="form-group">
      <label for="nombres">Nombre:</label>
      <input type="text" class="form-control" value="<%=resultado.getString("nombre") %>"  name="nombre" required>
    </div>
    <div class="form-group">
      <label for="descripcions">Descripcion:</label>
      <input type="text" class="form-control" value="<%=resultado.getString("descripcion") %>"  name="descripcion" required>
    </div>
    <div class="form-group">
      <label for="marcas">Marca:</label>
      <input type="text" class="form-control" value="<%=resultado.getString("marca") %>"  name="marca" required>
    </div>
                                    <%
// Quiero la fecha actual para ponerla por defecto 
Calendar ahora = Calendar.getInstance();
int anyo = ahora.get(Calendar.YEAR);
int mes = ahora.get(Calendar.MONTH) +1; 
int dia = ahora.get(Calendar.DAY_OF_MONTH);
String sAhora = "";
if (mes < 10) {
sAhora = anyo + "-0" + mes;
} else {
sAhora = anyo + "-" + mes;
}
if (dia < 10) {
sAhora += "-0" + dia;
} else {
sAhora += "-"+dia;
} 
%>
   <div class="form-group">
      <label for="fechas">Fecha:</label>
      <input type="date" class="form-control" value="<%=sAhora%>"  name="fecha" required>
    </div>   
    <%}%>
   <div class="form-group">
       
    </div>  
      <div class="form-group">
        <label for="id">Selecciona la Categoria:</label>
      <select class="form-control"  name ="idCategoria">
               <%
      CategoriasN cn = new CategoriasN();
     ArrayList <CategoriasD>  cad  = cn.consultarTodosArt();
      for (int i=0;i<cad.size();i++){
      %>
          <option value="<%=cad.get(i).getIdCategorias() %>"> <%=cad.get(i).getDescripcion() %> </option>
           <% }%>
      </select>
    </div>  
      
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
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
