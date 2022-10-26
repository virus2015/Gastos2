/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos2.Servidor;

import Gastos2.Datos.GastosD;
import Gastos2.Negocios.GastosN;
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
@WebServlet(name = "ServInsertarGastosFijos", urlPatterns = {"/ServInsertarGastosFijos"})
public class ServInsertarGastosFijos extends HttpServlet {

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
      //IDGASTOS         NOT NULL NUMBER 
//FRK_IDARTICULOS           NUMBER 
//FRK_IDCREDITO             NUMBER 
//PRECIOARTICULO            NUMBER 
//PRECIOKG_PAQUETE          NUMBER 
//CANTIDAD                  NUMBER 
//FECHA                     DATE   
         //int idgastos = Integer.parseInt(request.getParameter("idgastos"));
         int frk_idarticulos = Integer.parseInt(request.getParameter("idArticulos"));
         int frk_idcredito = Integer.parseInt(request.getParameter("frk_idcredito"));
    Double precioarticulo = Double.parseDouble(request.getParameter("precioarticulo"));
         Double preciokg_paquete = Double.parseDouble(request.getParameter("preciokg_paquete"));
         int cantidad = Integer.parseInt(request.getParameter("cantidad"));
         Date fecha = Date.valueOf(request.getParameter("fecha"));
         
         
         GastosD gd = new GastosD();
         GastosN gn = new GastosN();
        
         gd.setIdArticulos(frk_idarticulos);
         gd.setIdCredito(frk_idcredito);
         gd.setPrecioArticulo(precioarticulo);
         gd.setPreciokgPaquete(preciokg_paquete);
         gd.setCantidad(cantidad);
         gd.setFecha(fecha);
         
         try{
         gn.Ingresar(gd);
         response.sendRedirect("IngresarGastosFijos.jsp");
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
