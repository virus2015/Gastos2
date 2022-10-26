/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos2.Servidor;

import Gastos2.Datos.TiendasD;
import Gastos2.Negocios.TiendasN;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge.lopez
 */

@WebServlet(name = "ServEditarTiendas2", urlPatterns = {"/ServEditarTiendas2"})
public class ServEditarTiendas2 extends HttpServlet {

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
            
       int idTiendas = Integer.parseInt(request.getParameter("idTiendas"));       
       String nombre = request.getParameter("nombre");
       String ciudad = request.getParameter("ciudad");
       String colonia = request.getParameter("colonia");
       String calle = request.getParameter("calle");
       String telefono = request.getParameter("telefono");
       String web = request.getParameter("web");
       
       TiendasN  tin = new TiendasN();
       TiendasD tid = new TiendasD();
       
      
       tid.setNombre(nombre);
       tid.setCiudad(ciudad);
       tid.setColonia(colonia);
       tid.setCalle(calle);
       tid.setTelefono(telefono);
       tid.setWeb(web);
       tid.setIdTiendas(idTiendas);
       
       tin.actualizar(tid);
       
     response.sendRedirect("tiendas2.jsp");  
            
            
            
            
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
