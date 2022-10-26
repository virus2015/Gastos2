<%@page import="java.util.Calendar"%>

<%@page import="Gastos2.Datos.CreditosD"%>
<%@page import="Gastos2.Negocios.CreditosN"%>
<%@page import="Gastos2.Datos.CategoriasD"%>
<%@page import="Gastos2.Datos.TiendasD"%>
<%@page import="Gastos2.Negocios.TiendasN"%>
<%@page import="Gastos2.Datos.Conexion" %>
<%@page import="Gastos2.Negocios.CategoriasN"%>
<%@page import="java.util.List"%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>

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
        <script type="text/javascript">
<!--
function filterFloat(evt,input){
    // Backspace = 8, Enter = 13, ?0? = 48, ?9? = 57, ?.? = 46, ?-? = 43
    var key = window.Event ? evt.which : evt.keyCode;    
    var chark = String.fromCharCode(key);
    var tempValue = input.value+chark;
    if(key >= 48 && key <= 57){
        if(filter(tempValue)=== false){
            return false;
        }else{       
            return true;
        }
    }else{
          if(key == 8 || key == 13 || key == 0) {     
              return true;              
          }else if(key == 46){
                if(filter(tempValue)=== false){
                    return false;
                }else{       
                    return true;
                }
          }else{
              return false;
          }
    }
}
function filter(__val__){
    var preg = /^([0-9]+\.?[0-9]{0,2})$/; 
    if(preg.test(__val__) === true){
        return true;
    }else{
       return false;
    }
    
}
-->
</script>
        
        
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
      
      
     
    
    
      
      <!-- Example row of columns -->
       <div class="container">            
            <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal">Ingresar</button>
            <form class="navbar-form navbar-right" role="form">
            <div class="form-group">
              <input type="text" placeholder="Busqueda por Descripcion" name="descripcion" class="form-control">
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
       
       
         <h2>Ingresar Gastos</h2>
  <p>Ingresar los Gastos</p>
  <div class="container">
   <form action="/Gastos2/ServInsertarGastos2" method ="POST">  
     
  <div class="form-group">
      
     <label for="idCategorias">Selecciona la Categoria:</label>
     
    
     <select class="form-control"  name ="idCategorias" id ="idCategorias" required  >
               <%
      CategoriasN cn = new CategoriasN();
     List <CategoriasD>  cad  = cn.consultarTodos();
      for (CategoriasD cx : cad ){
      %>
          <option value=<%=cx.getIdCategorias() %>> <%=cx.getDescripcion() %> </option>
           <% }%>
      </select>  
    
      </div>  
      
    <div class="form-group"  >   
                   <label for ="idArticulos">Seleccione un Articulo</label><br>
             <select class="form-control"  name ="idArticulos" id ="idArticulos"  required>
                 
                    
                <option selected="selected" required>--Seleccione el Articulo--</option>
                    
                  
             </select>
    </div>  


      
      
           
                
                
     <div class="form-group">   
                   <label for="frk_idcredito">Seleccione un Credito</label><br>
             <select class="form-control"  name ="frk_idcredito" >
                 
                <%
                   //CategoriasD cad = new CategoriasD();
                   CreditosN cred = new CreditosN();
                               
                 ArrayList <CreditosD> crd = cred.listarCreditos2();
                   for(int i=0;i<crd.size();i++){
                %>
                    
                    <option value="<%=crd.get(i).getIdCredito() %>"><%=crd.get(i).getIdCredito() %>--<%=crd.get(i).getMontoCredito() %>--<%=crd.get(i).getDescripcion() %>  </option>
                    
                   <% }%>  
                </select>
      </div>          
                
                
        
      <div class="form-group">
      <label for="precioarticulo">Precio Articulo:</label>
      <input type="text" class="form-control"   name="precioarticulo" required value="0" onkeypress="return filterFloat(event,this);">
      </div>
      <div class="form-group">
      <label for="preciokg_paquete">Precio Paquete:</label>
      <input type="text" class="form-control"   name="preciokg_paquete" required value="0" onkeypress="return filterFloat(event,this);">
      </div>
      <div class="form-group">
      <label for="cantidad">Cantidad:</label>
      <input type="number" class="form-control"  name="cantidad" required value="1">
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
             <th>ID_GASTOS</th>
             <th>NOMBRE</th>
             <th>DETALLE</th>
             <th>PRECIO </th>
             <th>PRECIO PAQUETE</th>
             <th>CANTIDAD </th>
             <th>DESCRIPCION </th>
             <th>FECHA</th>
             <th>ID CREDITO</th>
             <th>MONTO CREDITO</th>
             <th>DESCRIPCION CREDITO</th>
             
             
             <th>ELIMINAR </th>
             <th>EDITAR</th>    
             
              <%
   Conexion con = new Conexion ();
   Connection conecta = con.conectar();
   
   ResultSet resultado;
   Statement psmt;
   psmt = conecta.createStatement();
   resultado   = psmt.executeQuery("select g2.idgastos AS idgastos,a2.nombre as nombre,a2.descripcion as detalle,"
           + " g2.precioarticulo as precio, g2.preciokg_paquete as pre_mayo,g2.cantidad as cantidad, c2.descripcion as descripcion"
           + " ,g2.fecha  as fecha,cr2.idcreditos,  cr2.montocredito,cr2.descripcion as Descripcion_credito    from gastosg2 g2  "
           + "  inner join articulosg2 a2 "
           + "  on g2.frk_idArticulos= a2.idArticulos   "
           + "  inner join categoriasg2 c2   "
           + " on c2.idcategorias = a2.frk_idCategorias "
           + "  inner join creditosg2 cr2  "
           + "  on cr2.idcreditos= g2.frk_idcredito where c2.frk_idgastos=2  and g2.fecha    between '01/04/21' and '30/04/21'"); 
  %>
      </tr>
       
      
      <%
      String descripcion = request.getParameter("descripcion");
      
    if(descripcion!= null){
     
     psmt = conecta.createStatement();
    resultado   = psmt.executeQuery("select g2.idgastos AS idgastos,a2.nombre as nombre,a2.descripcion as detalle,"
           + " g2.precioarticulo as precio, g2.preciokg_paquete as pre_mayo,g2.cantidad as cantidad, c2.descripcion as descripcion"
           + " ,g2.fecha  as fecha,cr2.idcreditos,  cr2.montocredito,cr2.descripcion as Descripcion_credito    from gastosg2 g2  "
           + "  inner join articulosg2 a2 "
           + "  on g2.frk_idArticulos= a2.idArticulos   "
           + "  inner join categoriasg2 c2   "
           + " on c2.idcategorias = a2.frk_idCategorias "
           + "  inner join creditosg2 cr2  "
           + "  on cr2.idcreditos= g2.frk_idcredito where a2.nombre like '%"+descripcion+"%' and c2.frk_idgastos=2  and g2.fecha    between '01/04/21' and '30/04/21' "); 
   
   
   
   
     }else{
       System.err.print("Error joven");
    }
       while(resultado.next()){
      %>
      
      
      
    </thead>
    <tbody>
      <tr>
             <td> <%=resultado.getString("idgastos") %> </td>
             <td> <%=resultado.getString("nombre") %> </td>
             <td> <%=resultado.getString("detalle") %> </td>
             <td><%=resultado.getString("precio") %>  </td>       
             <td><%=resultado.getString("pre_mayo") %>  </td> 
             <td><%=resultado.getString("cantidad") %>  </td> 
             <td><%=resultado.getString("descripcion") %>  </td>
             <td><%=resultado.getDate("fecha") %>  </td>
             <td><%=resultado.getString("idcreditos") %>  </td>
             <td><%=resultado.getString("montocredito") %>  </td>
             <td><%=resultado.getString("Descripcion_credito") %>  </td>
             
             
             
             <td><a href="/Gastos2/ServEliminarGastos2?id=<%=resultado.getString("idgastos") %>"><button type="button" class="btn btn-danger">Eliminar</button></a> </td>
             <td><a href="/Gastos2/EditarGastos.jsp?id=<%=resultado.getString("idgastos") %>"><button type="button" class="btn btn-success">Editar</button> </a> </td>
      </tr>
      
      
      
     
       <% }%>
      
    </tbody>
      
    
    
  </table>
       
<table class="table table-hover">
    
      <%
                  
        Conexion con8 = new Conexion ();
        Connection conectar8 = con8.conectar();
        ResultSet resultado8;
      
        String sql8 ="select sum(g2.precioarticulo) as monto   from gastosg2 g2     "
                + "         inner join articulosg2 a2  "
                + "            on g2.frk_idArticulos= a2.idArticulos    "
                + "             inner join categoriasg2 c2          "
                + "      on c2.idcategorias = a2.frk_idCategorias   "
                + "            inner join creditosg2 cr2          "
                + "     on cr2.idcreditos= g2.frk_idcredito      "
                + "                    where c2.frk_idgastos=2  and g2.fecha    between '01/04/21' and '30/04/21'";
        PreparedStatement psmt8 = conectar8.prepareStatement(sql8);
        resultado8 = psmt8.executeQuery();
        while(resultado8.next()){
            
               
                %>
    
    
       <th>MONTO
       </th>  
       
      <tr>
          <td>MONTO $ <%=resultado8.getString("monto") %></td>
          <%}%>
     </tr>
</table>
       
       
      </div>   
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
