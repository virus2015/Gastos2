/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos2.Servidor;

import Gastos2.Datos.ArticulosD;
import Gastos2.Negocios.ArticulosN;
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
@WebServlet(name = "ServEditarArticulos2", urlPatterns = {"/ServEditarArticulos2"})
public class ServEditarArticulos2 extends HttpServlet {

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
         
         
        String  nombre = request.getParameter("nombre");
        String  descripcion = request.getParameter("descripcion");
        String  marca = request.getParameter("marca");         
        int    idCategoria = Integer.parseInt(request.getParameter("idCategoria"));        
        Date    fecha  = Date.valueOf(request.getParameter("fecha"));          
        int    idarticulos = Integer.parseInt(request.getParameter("idarticulos"));  
        
        ArticulosN  an = new ArticulosN();
        ArticulosD  ad = new ArticulosD();
        
        ad.setNombre(nombre);
        ad.setDescripcion(descripcion);
        ad.setMarca(marca);
        ad.setIdcategorias(idCategoria);
        ad.setFecha(fecha);
        ad.setIdArticulos(idarticulos);
        
        
        try{
        an.Editar(ad);
        
          response.sendRedirect("articulos2.jsp");
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
