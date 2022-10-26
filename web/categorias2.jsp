
<%@page import="Gastos2.Datos.GastosFijosD"%>
<%@page import="Gastos2.Negocios.GastosfIjosN"%>
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
              <input type="text" placeholder="Buscar por Descripcion" name="descripcion" class="form-control">
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
       
    <h2>Categorias </h2>
  <p>Categorias joven</p>
  <div class="container">

       <form action="/Gastos2/ServIngresarCategorias3" method ="POST">
    
    <div class="form-group">
      <label for="descripcions">Descripcion:</label>
      <input type="text" class="form-control"  name="descripcion" required>
    </div>
    
    <div class="form-group">
      <label for="detalles">Detalles:</label>
      <input type="text" class="form-control"  name="detalle" required>
    </div>
      
    
   <div class="form-group">
        <label for="idtiendas">Selecciona la Tienda:</label>
      <select class="form-control"  name ="idtiendas">
               <%
      TiendasN tin = new TiendasN();
     ArrayList <TiendasD>   tid = tin.selecAllTiendas();
      for (int i=0;i<tid.size();i++){
      %>
          <option value="<%=tid.get(i).getIdTiendas() %>"><%=tid.get(i).getNombre()%> </option>
           <% }%>
      </select>
    </div>  
      <div class="form-group">
        <label for="idtipogastos">Selecciona el Tipo de Gasto:</label>
      <select class="form-control"  name ="idtipoGasto">
               <%
      GastosfIjosN gn = new GastosfIjosN();
     ArrayList <GastosFijosD>   gd = gn.ListarGastosFijos();
      for (int i=0;i<gd.size();i++){
      %>
          <option value="<%=gd.get(i).getIdGastosFijos() %>"> <%=gd.get(i).getIdGastosFijos() %> <%=gd.get(i).getDescripcion() %> </option>
           <% }%>
      </select>
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
             <th>ID_CATEGORIAS</th>
             <th>DESCRIPCION</th>
             <th>DETALLES</th>
             <th>GASTOS</th>
             <th>TIENDAS</th>
             <th>ELIMINAR </th>
             <th>EDITAR</th>    
             
              <%
   Conexion con = new Conexion ();
   Connection conecta = con.conectar();
   
   ResultSet resultado;
   Statement psmt;
   psmt = conecta.createStatement();
   resultado   = psmt.executeQuery("SELECT c2.idcategorias,c2.descripcion,c2.detalles,t.descripcion as gasto,t2.nombre as nombre FROM categoriasg2"
           + " c2 inner join gastosfijos t"
           + " on t.idgastosfijos= frk_idgastos"
           + " inner join tiendasg2 t2 "
           + "on c2.frk_idtiendas= t2.idtiendas"); 
  %>
      </tr>
       
      
      <%
      String descripcion = request.getParameter("descripcion");
      
    if(descripcion!= null){
     
     psmt = conecta.createStatement();
   resultado   = psmt.executeQuery("SELECT c2.idcategorias,c2.descripcion,c2.detalles,t.descripcion as gasto,t2.nombre as nombre FROM categoriasg2"
           + " c2 inner join gastosfijos t"
           + " on t.idgastosfijos= frk_idgastos "
           + "inner join tiendasg2 t2 "
           + "on c2.frk_idtiendas= t2.idtiendas  "
           + "  where c2.descripcion like  '%"+descripcion+"%'");
     }else{
       System.err.print("Error joven");
    }
       while(resultado.next()){
      %>
      
      
      
    </thead>
    <tbody>
      <tr>
          <td> <%=resultado.getString("idcategorias") %> </td>
             <td> <%=resultado.getString("descripcion") %> </td>
             <td> <%=resultado.getString("detalles") %> </td>
             <td><%=resultado.getString("gasto") %>  </td>       
             <td><%=resultado.getString("nombre") %>  </td>   
             <td><a href="/Gastos2/ServEliminarCategorias3?id=<%=resultado.getString("idcategorias") %>"><button type="button" class="btn btn-danger">Eliminar</button></a> </td>
             <td><a href="/Gastos2/editarCategorias2.jsp?id=<%=resultado.getString("idcategorias") %>"><button type="button" class="btn btn-success">Editar</button> </a> </td>
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
