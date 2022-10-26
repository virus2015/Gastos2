<%@page import="java.util.List"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Gastos2.Datos.Conexion"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Gastos2.Datos.ArticulosD"%>
<%@page import="Gastos2.Negocios.ArticulosN"%>
<%@page import="Gastos2.Datos.CreditosD"%>
<%@page import="Gastos2.Negocios.CreditosN"%>
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
       
        <script src="jquery-1.7.1.js" type="text/javascript"></script> 
        
        <script src="ajax2.js" type="text/javascript"></script>
        
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
     
     <h2>Editar Gastos Fijos</h2>
  <p>Editar los Gastos Fijos</p>
                
   <form action="/Gastos2/ServEditarGastosFijos" method ="POST">  
    
       <%
        Conexion con3 = new Conexion();
        Connection conect3 = con3.conectar();
         
        int id3 = Integer.parseInt(request.getParameter("id"));
        String  sql3="select * from gastosg2 where idgastos ="+id3;
        PreparedStatement ps =  conect3.prepareStatement(sql3);
        ResultSet resultado3 = ps.executeQuery();
        while(resultado3.next()){



       %>
       
       
     <div class="form-group">
      <label for="id">Id:</label>
      <input type="text" class="form-control" value="<%=resultado3.getString("idgastos")  %>" name="idgastos" required>
      </div>   
       
 <div class="form-group">
      
     <label for="id">Selecciona la Categoria:</label>
     
    
     <select class="form-control"  name ="idCategorias" id ="idCategorias"   >
               <%
      CategoriasN cn = new CategoriasN();
     List <CategoriasD>  cad  = cn.consultarTodos2();
      for (CategoriasD cx : cad ){
      %>
          <option value=<%=cx.getIdCategorias() %>> <%=cx.getDescripcion() %> </option>
           <% }%>
      </select>  
    
      </div>  
      
    <div class="form-group">   
                   <label>Seleccione un Articulo</label><br>
             <select class="form-control"  name ="idArticulos" id ="idArticulos">
                 
                    
                <option selected="selected">--Seleccione el Articulo--</option>
                    
                  
             </select>
    </div> 


      
      
           
                
                
           <div class="form-group">   
                   <label>Seleccione un Credito</label><br>
             <select class="form-control"  name ="frk_idcredito" >
                 
                <%
                   //CategoriasD cad = new CategoriasD();
                   CreditosN cred = new CreditosN();
                               
                 ArrayList <CreditosD> crd = cred.listarCreditos2();
                   for(int i=0;i<crd.size();i++){
                %>
                    
                    <option value="<%=crd.get(i).getIdCredito() %>"><%=crd.get(i).getIdCredito() %>---<%=crd.get(i).getMontoCredito() %> <%=crd.get(i).getDescripcion() %>  </option>
                    
                   <% }%>  
                </select>
      </div>          
                
                
        
    <div class="form-group">
      <label for="precioarticulo">Precio Articulo:</label>
      <input type="text" class="form-control"   name="precioarticulo" required value="<%=resultado3.getString("precioarticulo") %>" onkeypress="return filterFloat(event,this);">
      </div>
      <div class="form-group">
      <label for="preciokg_paquete">Precio Paquete:</label>
      <input type="text" class="form-control"   name="preciokg_paquete" required value="<%=resultado3.getString("preciokg_paquete") %>" onkeypress="return filterFloat(event,this);">
      </div>
                
      <div class="form-group">
      <label for="cantidad">Cantidad:</label>
      <input type="number" class="form-control"  value="<%=resultado3.getString("cantidad") %>"  name="cantidad" required>
      </div>
                
    
      <div class="form-group">
      <label for="fechas">Fecha:</label>
      <input type="date" class="form-control" value="<%=resultado3.getDate("fecha") %>"  name="fecha" required>
      </div>  
                
      <%
          }
      %>
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
