/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos2.Negocios;

import Gastos2.Datos.Conexion;
import Gastos2.Datos.GastosD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge.lopez
 */
public class GastosN {
    
  Conexion con = new Conexion();
Connection conectar = con.conectar();
String sql;
    
public void Ingresar(GastosD gastos){
    /*
    
    IDGASTOS         NOT NULL NUMBER 
FRK_IDARTICULOS           NUMBER 
FRK_IDCREDITO             NUMBER 
PRECIOARTICULO            NUMBER 
PRECIOKG_PAQUETE          NUMBER 
CANTIDAD                  NUMBER 
FECHA                     DATE 
    
    */
        
    try {       
        PreparedStatement psmt ;
         sql="insert into gastosg2 (frk_idArticulos,frk_idCredito,precioArticulo,precioKg_paquete,cantidad,fecha)values(?,?,?,?,?,?)";
        psmt = conectar.prepareStatement(sql);
        
        psmt.setInt(1,gastos.getIdArticulos());
        psmt.setInt(2, gastos.getIdCredito());
        psmt.setDouble(3, gastos.getPrecioArticulo());
        psmt.setDouble(4,gastos.getPreciokgPaquete());       
        psmt.setInt(5, gastos.getCantidad());
        psmt.setDate(6, gastos.getFecha());
        
        psmt.executeUpdate();
        
    } catch (SQLException ex) {
         ex.printStackTrace();
    }
    
}    
    
public void Editar(GastosD gastos){
      try {       
        PreparedStatement psmt ;
         sql="update gastosg2 set frk_idArticulos=?, frk_idCredito=? ,precioArticulo=? ,precioKg_paquete=? ,cantidad=? ,fecha=?  where idGastos=? ";
        psmt = conectar.prepareStatement(sql);
        
         psmt.setInt(1,gastos.getIdArticulos());
        psmt.setInt(2, gastos.getIdCredito());
        psmt.setDouble(3, gastos.getPrecioArticulo());
        psmt.setDouble(4,gastos.getPreciokgPaquete());       
        psmt.setInt(5, gastos.getCantidad());
        psmt.setDate(6, gastos.getFecha());
        psmt.setInt(7,gastos.getIdGastos());
        
        psmt.executeUpdate();
        
    } catch (SQLException ex) {
         ex.printStackTrace();
    } 
    

}
public void Eliminar(int codigo){
    try {
        sql ="delete gastosg2 where idGastos=?";       
        PreparedStatement psmt ;
        psmt = conectar.prepareStatement(sql);
        psmt.setInt(1, codigo);
        psmt.executeUpdate();        
    } catch (SQLException ex) {
         ex.printStackTrace();
    }
}  
    
    //metodo que devuelve el número de filas o registros encontrados 
	public int contarFilas(String com){
            ResultSet rs=null;
            Statement st=null;
		 try {
			 st = conectar.createStatement();
			 rs = st.executeQuery(com);
			 int contador = 0;
			 while(rs.next()){ //recorre todo el resulset
				 contador++;	//sumara las veces que haya registros
			 }
			 return contador; //devuelve cantidad de registros
		} catch (Exception e) {
			System.out.println("Error al contar registros "+e.getMessage());
			System.out.println(com);
			return 0;
		}		 
	 }
        public ResultSet getDatos(String com){
            ResultSet rs=null;
            Statement st=null;
            
		try {
			 st = conectar.createStatement();
			 rs = st.executeQuery(com);
		} catch (Exception e) {
			System.out.println("Error de la consulta "+e.getMessage());
		}
		return rs;
	}
        
        
   public ResultSet paginacion_Producto(int pg,int numreg){
      try {
          Statement st=null;
          ResultSet rs=null;
          st = conectar.createStatement();
          String com = "Select * from gastosg2 LIMIT "+(pg-1)*numreg+","+numreg;
          
           rs = getDatos(com);
          return rs;
          
      } catch (SQLException ex) {
           ex.printStackTrace();
           return null;
      }
      
	}
    
}
