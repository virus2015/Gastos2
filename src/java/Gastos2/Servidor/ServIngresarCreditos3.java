/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos2.Servidor;

import Gastos2.Datos.CreditosD;
import Gastos2.Negocios.CreditosN;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge.lopez
 */
@WebServlet(name = "ServIngresarCreditos3", urlPatterns = {"/ServIngresarCreditos3"})
public class ServIngresarCreditos3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
         
Double MONTOCREDITO       =  Double.parseDouble(request.getParameter("montocredito"));   
Double INTERES       =  Double.parseDouble(request.getParameter("interes"));        
Date FECHA       =  Date.valueOf(request.getParameter("fecha"));           
String DESCRIPCION  =  request.getParameter("descripcion"); 
Double CONSUMOCREDITO   =  Double.parseDouble(request.getParameter("consumocredito"));       
Double CONCREDITO1     =  Double.parseDouble(request.getParameter("concredito1"));        
Double CONCREDITO2     =  Double.parseDouble(request.getParameter("concredito2"));  
            
            CreditosN crn = new CreditosN();
            CreditosD crd = new CreditosD();
            
            crd.setMontoCredito(MONTOCREDITO);
            crd.setInteres(INTERES);
            crd.setFecha(FECHA);
            crd.setDescripcion(DESCRIPCION);
            crd.setConsumidoCredito(CONSUMOCREDITO);
            crd.setConCredito1(CONCREDITO1);
            crd.setConCredito2(CONCREDITO2);
            
       /*<input type="text" class="form-control" id="montocreditos" name="montocredito" required >
      <input type="text" class="form-control" id="interess" name="interes"  >    
        <input type ="date"  class="form-control" id ="fechas" name ="fecha"  required>  
        <input type ="text"  class="form-control" id ="descripcions" name ="descripcion">
        <input type ="text"  class="form-control" id ="consumocreditos" name ="consumocredito">
        <input type ="text"  class="form-control" id ="webs" name ="concredito1"
        <input type ="text"  class="form-control" id ="concredito2s" name ="concredito2">*/
    
            
            
            
            crn.Insertar(crd);
            response.sendRedirect("creditos.jsp");
            
        }   
            
            
        }
    }

   