/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos2.Negocios;

import Gastos2.Datos.CategoriasD;
import Gastos2.Datos.Conexion;
import Gastos2.Datos.CreditosD;
import Gastos2.Datos.TiendasD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jorge.lopez
 */
public class CreditosN {
    
    
 Conexion conecta = new Conexion();   
  Connection co = conecta.conectar();
  String sql;   
  
  public void Insertar(CreditosD credito){
     try {
         sql="insert into creditosg2(MONTOCREDITO,INTERES,FECHA,DESCRIPCION,CONSUMOCREDITO,CONCREDITO1,CONCREDITO2)values(?,?,?,?,?,?,?)";
         PreparedStatement psmt ;
         psmt = co.prepareStatement(sql);
         psmt.setDouble(1, credito.getMontoCredito());
         psmt.setDouble(2, credito.getInteres());
           psmt.setDate(3, credito.getFecha());
         psmt.setString(4, credito.getDescripcion());
         
         psmt.setDouble(5, credito.getConsumidoCredito());
         psmt.setDouble(6, credito.getConCredito1());
         psmt.setDouble(7, credito.getConCredito2());
          
         psmt.executeUpdate();
        
     } catch (SQLException ex) {
         ex.printStackTrace();
     }
      
  }  
  

 public void Actualizar(CreditosD credito){
     
      try {
         sql="update creditosg2 set MONTOCREDITO=?,INTERES=?,FECHA=?,DESCRIPCION=?,CONSUMOCREDITO=?,CONCREDITO1=?,CONCREDITO2=? where IDCREDITOS=?";
         PreparedStatement psmt ;
         psmt = co.prepareStatement(sql);
         psmt.setDouble(1, credito.getMontoCredito());
         psmt.setDouble(2, credito.getInteres());
           psmt.setDate(3, credito.getFecha());
         psmt.setString(4, credito.getDescripcion());
         
         psmt.setDouble(5, credito.getConsumidoCredito());
         psmt.setDouble(6, credito.getConCredito1());
         psmt.setDouble(7, credito.getConCredito2());         
         psmt.setInt(8, credito.getIdCredito());
          
         psmt.executeUpdate();
        
     } catch (SQLException ex) {
         ex.printStackTrace();
     }
     
     
  
 }
 
 public void Eliminar(int id){
     
     try {
         sql=" delete  creditosg2   where IDCREDITOS=?";
         PreparedStatement pr = co.prepareStatement(sql);
         pr.setInt(1,id );
         
         pr.executeUpdate();
     } catch (SQLException ex) {
          ex.printStackTrace();
     }
    
 }
 public ArrayList listarCreditos(){
       ArrayList <CreditosD> lista = new  ArrayList();
     try {
         sql="select * from creditosg2";
         PreparedStatement psmt ;
         ResultSet rs;
       
         psmt = co.prepareStatement(sql);         
         rs =psmt.executeQuery();
         
          /*ArrayList <TiendasD> listaTiendas = new ArrayList();
            PreparedStatement st = conecta.prepareStatement(sql);
            rs = st.executeQuery();*/
         
         
         while(rs.next()){
          CreditosD cre = new CreditosD();
          cre.setIdCredito(rs.getInt("IDCREDITOS "));
          cre.setMontoCredito(rs.getDouble("MONTOCREDITO"));
          cre.setInteres(rs.getDouble("INTERES"));
          cre.setFecha(rs.getDate("FECHA"));
          cre.setDescripcion(rs.getString("DESCRIPCION"));
          cre.setConsumidoCredito(rs.getInt("CONSUMOCREDITO"));
          cre.setConCredito1(rs.getDouble("CONCREDITO1"));
          cre.setConCredito2(rs.getDouble("CONCREDITO2"));
          lista.add(cre);
         }
        
          return lista;
        
     } catch (SQLException ex) {
          ex.printStackTrace(); ;
          return null;
     }
   
 
 }
 
 /*
 idcreditos double
montocredito double
interes double
fecha date
descripcion string
consumocredito double
concredito1 double
concredito2 double
 */
 public  ArrayList listarCreditos2(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList <CreditosD> lista = new ArrayList();
            String sql="select * from creditosg2 ";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);
            
            resultado = pr.executeQuery();
            while(resultado.next()){
                CreditosD cn = new CreditosD();
               cn.setIdCredito(resultado.getInt("idcreditos"));
               cn.setMontoCredito(resultado.getDouble("montocredito"));
               cn.setInteres(resultado.getDouble("interes"));
               cn.setFecha(resultado.getDate("fecha"));
               cn.setDescripcion(resultado.getString("descripcion"));
               cn.setConsumidoCredito(resultado.getDouble("consumocredito"));
               cn.setConCredito1(resultado.getDouble("concredito1"));
               cn.setConCredito2(resultado.getDouble("concredito2"));
                            
               lista.add(cn);
                
            } 
           return lista; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     }
}
