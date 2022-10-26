/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos2.Negocios;
import Gastos2.Datos.Conexion;
import Gastos2.Datos.CategoriasD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jorge.lopez
 */
public class CategoriasN {
    
    Conexion con = new Conexion();
    Connection conecta = con.conectar();
    String sql ;
            
    
    
    
    public void guardar(CategoriasD cate){
    
    sql="insert into categoriasg2(DESCRIPCION,DETALLES,FRK_IDGASTOS,FRK_IDTIENDAS)values(?,?,?,?)";     
    try{
    PreparedStatement pr = conecta.prepareStatement(sql);
    pr.setString(1,cate.getDescripcion());
    pr.setString(2,cate.getDetalles());
    pr.setInt(3,cate.getIdgastosfijos());
    pr.setInt(4,cate.getIdTiendas());
    
     pr.executeUpdate();
    
    
    }catch(SQLException ex){
      ex.printStackTrace();
    }
     
        
    }
    
    public void actualizar(CategoriasD cate) throws SQLException{
    
    sql=" update  categoriasg2  set DESCRIPCION=?,DETALLES=?,FRK_IDGASTOS=?,FRK_IDTIENDAS=? where idCategorias=?";     
  
    PreparedStatement pr = conecta.prepareStatement(sql);
    pr.setString(1,cate.getDescripcion());
    pr.setString(2,cate.getDetalles());
    pr.setInt(3,cate.getIdgastosfijos());
    pr.setInt(4,cate.getIdTiendas() );
    
    pr.setInt(5, cate.getIdCategorias());
    
     pr.executeUpdate();
    
    
     
        
    }
    
     public void eliminar(int id) throws SQLException{
    
    sql=" delete  categoriasg2   where idCategorias=?";   
    PreparedStatement pr = conecta.prepareStatement(sql);
    pr.setInt(1,id );
    
     pr.executeUpdate();
    
    
     
        
    }
     
     public List<CategoriasD> visualizarCategorias() {
        List<CategoriasD> lp = new ArrayList<CategoriasD>();
      PreparedStatement ps;
      ResultSet rs;
        try {
            //conexao = Conexao.getConnection();
            ps = conecta.prepareStatement("select idcategorias,descripcion from categoriasg2");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No existen categorias Registradas");
            } else {
                rs.beforeFirst();
                while (rs.next()) {
                    CategoriasD catp = new CategoriasD();                   
                    
                    catp.setIdCategorias(rs.getInt("idcategorias"));
                    catp.setDescripcion(rs.getString("descripcion"));
                 
                    
                  lp.add(catp);
                }
            }
        } catch (SQLException exception) {
            System.out.println("Imposible visualizar la categoria " + exception);
        }
        return lp;
    } 
     
     public  ArrayList consultarTodos(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList <CategoriasD> lista = new ArrayList();
            String sql="select idcategorias,descripcion from categoriasg2 g2\n" +
"where g2.frk_idgastos=2 ";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);
            
            resultado = pr.executeQuery();
            while(resultado.next()){
                CategoriasD cn = new CategoriasD();
               cn.setIdCategorias(resultado.getInt("idCategorias"));
               cn.setDescripcion(resultado.getString("descripcion"));
            //   cn.setDetalles(resultado.getString("detalles"));
                            
               lista.add(cn);
                
            } 
           return lista; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     } 
     public  ArrayList consultarTodosArt(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList <CategoriasD> lista = new ArrayList();
            String sql="select idcategorias,descripcion from categoriasg2  ";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);
            
            resultado = pr.executeQuery();
            while(resultado.next()){
                CategoriasD cn = new CategoriasD();
               cn.setIdCategorias(resultado.getInt("idCategorias"));
               cn.setDescripcion(resultado.getString("descripcion"));
            //   cn.setDetalles(resultado.getString("detalles"));
                            
               lista.add(cn);
                
            } 
           return lista; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     }
     
       public  ArrayList consultarTodos2(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList <CategoriasD> lista = new ArrayList();
            String sql="select idcategorias,descripcion from categoriasg2 g2\n" +
"where g2.frk_idgastos=1 ";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);
            
            resultado = pr.executeQuery();
            while(resultado.next()){
                CategoriasD cn = new CategoriasD();
               cn.setIdCategorias(resultado.getInt("idCategorias"));
               cn.setDescripcion(resultado.getString("descripcion"));
            //   cn.setDetalles(resultado.getString("detalles"));
                            
               lista.add(cn);
                
            } 
           return lista; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     }
         public  ArrayList consultarTodos3(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList <CategoriasD> lista = new ArrayList();
            String sql="select idcategorias,descripcion from categoriasg2 g2\n" +
"where g2.frk_idgastos=3 ";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);
            
            resultado = pr.executeQuery();
            while(resultado.next()){
                CategoriasD cn = new CategoriasD();
               cn.setIdCategorias(resultado.getInt("idCategorias"));
               cn.setDescripcion(resultado.getString("descripcion"));
            //   cn.setDetalles(resultado.getString("detalles"));
                            
               lista.add(cn);
                
            } 
           return lista; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     }
         
            public  ArrayList consultarTodos4(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList <CategoriasD> lista = new ArrayList();
            String sql="select idcategorias,descripcion from categoriasg2 g2\n" +
"where g2.frk_idgastos=2 ";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);
            
            resultado = pr.executeQuery();
            while(resultado.next()){
                CategoriasD cn = new CategoriasD();
               cn.setIdCategorias(resultado.getInt("idCategorias"));
               cn.setDescripcion(resultado.getString("descripcion"));
            //   cn.setDetalles(resultado.getString("detalles"));
                            
               lista.add(cn);
                
            } 
           return lista; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     }
     ///////////////////////////////////////////////////////////////////checar
     public  ArrayList consultarTodosG(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList  lista = new ArrayList();
            String sql=" select a2.idcategorias,a2.descripcion,a2.detalles from categoriasg2 a2\n" +
"                  where a2.FRK_IDGASTOSFIJOS=2     ";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);
            
            resultado = pr.executeQuery();
            while(resultado.next()){
            CategoriasD cate = new CategoriasD();
            cate.setIdCategorias(resultado.getInt("idCategorias"));
            cate.setDescripcion(resultado.getString("descripcion"));
            cate.setDetalles(resultado.getString("detalles"));
            
            lista.add(cate);
                
            } 
           return lista; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     }
     
      public  ArrayList consultarTodosGF(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList  lista = new ArrayList();
            String sql="  select a2.idcategorias,a2.descripcion,a2.detalles from categoriasg2 a2\n" +
"                  where a2.FRK_IDGASTOSFIJOS=1";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);
            
            resultado = pr.executeQuery();
            while(resultado.next()){
            CategoriasD cate = new CategoriasD();
            cate.setIdCategorias(resultado.getInt("idCategorias"));
            cate.setDescripcion(resultado.getString("descripcion"));
            cate.setDetalles(resultado.getString("detalles"));
            lista.add(cate);
                
            } 
           return lista; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     }
       public  ArrayList consultarTodosGFV(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList  lista = new ArrayList();
            String sql="     select a2.idcategorias,a2.descripcion,a2.detalles from categoriasg2 a2\n" +
"                  where a2.FRK_IDGASTOSFIJOS=3";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);
            
            resultado = pr.executeQuery();
            while(resultado.next()){
            CategoriasD cate = new CategoriasD();
            cate.setIdCategorias(resultado.getInt("idCategorias"));
            cate.setDescripcion(resultado.getString("descripcion"));
            cate.setDetalles(resultado.getString("detalles"));
            lista.add(cate);
                
            } 
           return lista; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     }
     public static CategoriasD consultarUno(int id) throws SQLException{
     ResultSet resultado;    
   
        Conexion con = new Conexion();
        Connection conecta = con.conectar();
         CategoriasD cate=null;
                        
            
          Statement pr;
          pr= conecta.createStatement();
          
          resultado = pr.executeQuery("SELECT * from categoriasg2 where idCategorias='"+id+"'");
            
            
            while(resultado.next()){
           
           cate=  new CategoriasD(resultado.getInt("idCategorias"),resultado.getString("descripcion"),resultado.getString("detalles"),resultado.getInt("frk_idGastosfijos"), resultado.getInt("frk_idTiendas"));
      
          
                
            } 
            resultado.close();
           
           return cate;
            
      
     }

    public void ListarUno(Date fecha1,Date fecha2){
     Statement stm ;
     ResultSet resultado;
     sql="select cg.descripcion,sum(gg.monto) as monto from gastosg gg\n" +
"inner join articulosg aa\n" +
"on aa.idarticulos = gg.frk_idarticulos\n" +
"inner join categoriasg cg\n" +
"on cg.idcategorias= gg.frk_idcategorias \n" +
"inner join tiendasg tt\n" +
"on tt.idTiendas = gg.frk_idTiendas\n" +
"\n" +
"\n" +
"where gg.fecha between '"+fecha1+"' and '"+fecha2+"' and gg.monto is not null\n" +
"group by cg.descripcion order by cg.descripcion";   
    
     try {
       
        
             
        stm = conecta.createStatement();
        resultado = stm.executeQuery(sql);
        
        while(resultado.next()){
         resultado.getString("descripcion");
          resultado.getString("monto");
        }
       
    } catch (SQLException ex) {
         ex.printStackTrace();
         
    }


}
    
    
    public void recuperaCategorias(Date fecha1,Date fecha2)
    {      
    
                Conexion cn = new Conexion();
                Connection conect =cn.conectar();
                PreparedStatement psmt ;
              // List<String> listado = new ArrayList<String>();
            String sql ="select cg.descripcion,sum(gg.monto) as monto from gastosg gg\n" +
"inner join articulosg aa\n" +
"on aa.idarticulos = gg.frk_idarticulos\n" +
"inner join categoriasg cg\n" +
"on cg.idcategorias= gg.frk_idcategorias \n" +
"inner join tiendasg tt\n" +
"on tt.idTiendas = gg.frk_idTiendas\n" +
"\n" +
"\n" +
"where gg.fecha between '"+fecha1+"' and '"+fecha2+"' and gg.monto is not null\n" +
"group by cg.descripcion order by cg.descripcion";
                    
                  
            
              try {
                  psmt = conect.prepareStatement(sql);
                  
                  ResultSet rs = psmt.executeQuery(sql);
                     while(rs.next()){
                         
                        psmt.setString(1, rs.getString("descripcion"));
                         psmt.setString(2, rs.getString("monto"));
                         
                     }
                  
                  
              } catch (SQLException ex) {
                 ex.printStackTrace();
               
              }

          }
    
    }
    
