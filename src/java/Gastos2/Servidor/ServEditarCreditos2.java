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
@WebServlet(name = "ServEditarCreditos2", urlPatterns = {"/ServEditarCreditos2"})
public class ServEditarCreditos2 extends HttpServlet {

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
         int idcreditos     =  Integer.parseInt(request.getParameter("idcreditos"));  
         
            CreditosN crn = new CreditosN();
            CreditosD crd = new CreditosD();
            
            crd.setMontoCredito(MONTOCREDITO);
            crd.setInteres(INTERES);
            crd.setFecha(FECHA);
            crd.setDescripcion(DESCRIPCION);
            crd.setConsumidoCredito(CONSUMOCREDITO);
            crd.setConCredito1(CONCREDITO1);
            crd.setConCredito2(CONCREDITO2);
            crd.setIdCredito(idcreditos);
                 
            
            try{
            crn.Actualizar(crd);
            response.sendRedirect("creditos.jsp");
            }catch(Exception ex){
                  ex.printStackTrace();
            }   
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
