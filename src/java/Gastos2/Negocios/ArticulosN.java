/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos2.Negocios;

import Gastos2.Datos.ArticulosD;
import Gastos2.Datos.CategoriasD;
import Gastos2.Datos.Conexion;
import java.sql.Connection;
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
public class ArticulosN {

Conexion con = new Conexion();
Connection conectar = con.conectar();
String sql;
public void Insertar(ArticulosD articulos){
    
    
    try {
        PreparedStatement psmt;
        sql="insert into articulosg2(nombre,descripcion,marca,frk_idcategorias,fecha)values(?,?,?,?,?)"; 
        
        psmt = conectar.prepareStatement(sql);
        
        psmt.setString(1,articulos.getNombre());
        psmt.setString(2,articulos.getDescripcion());
        psmt.setString(3,articulos.getMarca());
        psmt.setInt(4, articulos.getIdcategorias());  
        psmt.setDate(5, articulos.getFecha());
        
        
        psmt.executeUpdate();
        
        
    } catch (SQLException ex) {
       ex.printStackTrace();
    }
    
    

}

public void Editar(ArticulosD articulos){
  try {
        PreparedStatement psmt;
                    //rticulosg2
        sql="update articulosg2  set nombre=?,descripcion=?,marca=?,frk_idcategorias=?,fecha=? where idArticulos=?";        
        psmt = conectar.prepareStatement(sql);
        
        psmt.setString(1,articulos.getNombre());
        psmt.setString(2,articulos.getDescripcion());
        psmt.setString(3,articulos.getMarca());
        psmt.setInt(4, articulos.getIdcategorias());                 
        psmt.setDate(5, articulos.getFecha());  
        
        psmt.setInt(6, articulos.getIdArticulos());
        
        psmt.executeUpdate();
        
        
    } catch (SQLException ex) {
       ex.printStackTrace();
    }
    
    
}

public void Eliminar(int codigo){
        PreparedStatement psmt;
        sql="delete  articulosg2 where idArticulos=?";
    
    try {
    
        psmt= conectar.prepareStatement(sql);
        psmt.setInt(1,codigo);
        
        psmt.executeUpdate();
        
    } catch (SQLException ex) {
       ex.printStackTrace();
    }
    
    
}


    public List<ArticulosD> visualizarArticulos(int codigo) {
        List<ArticulosD> lp = new ArrayList<ArticulosD>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            
            ps = conectar.prepareStatement("select a.idarticulos,a.nombre from articulosg2 a       inner join categoriasg2 c   "
                    + "      on a.frk_idcategorias = c.idcategorias     and a.frk_idcategorias= "+codigo);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No existen articulos registrados en esta Categoria ");
            } else {
              rs.beforeFirst();
                while (rs.next()) {
                    ArticulosD artp = new ArticulosD();
                    
                    
                    artp.setIdArticulos(rs.getInt("idarticulos"));
                    artp.setNombre(rs.getString("nombre"));                  
                    lp.add(artp);
                }
            }
        } catch (SQLException exception) {
            System.out.println("Imposible visualizar los articulos registrados en esta Categoria " + exception);
        }
        return lp;
    }
 public ArrayList visualizarArticulos2(int codigo) {
         ArrayList<ArticulosD> lp = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            
            ps = conectar.prepareStatement("select a.idarticulos,a.nombre from articulosg2 a       inner join categoriasg2 c    "
                    + "     on a.frk_idcategorias = c.idcategorias     where a.frk_idcategorias="+codigo);
            
           // ps.setInt(1, codigo);
            rs = ps.executeQuery();
                while (rs.next()) {
                    ArticulosD artp = new ArticulosD();
                    
                    
                    artp.setIdArticulos(rs.getInt("idarticulos"));
                    artp.setNombre(rs.getString("nombre"));                  
                    lp.add(artp);
                }
             return lp;
        } catch (SQLException exception) {
            System.out.println("Imposible visualizar los articulos registrados en esta Categoria " + exception);
            return null;
        }
       
    }
 public ArrayList visualizarArticulos3(int codigo) {
         ArrayList<ArticulosD> lp = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            
            ps = conectar.prepareStatement("select a.idarticulos,a.nombre from articulosg2 a       inner join categoriasg2 c    "
                    + "     on a.frk_idcategorias = c.idcategorias     and a.frk_idcategorias="+codigo);
            
           // ps.setInt(1, codigo);
            rs = ps.executeQuery();
                while (rs.next()) {
                    ArticulosD artp = new ArticulosD();
                    
                    
                    artp.setIdArticulos(rs.getInt("idarticulos"));
                    artp.setNombre(rs.getString("nombre"));                  
                    lp.add(artp);
                }
             return lp;
        } catch (SQLException exception) {
            System.out.println("Imposible visualizar los articulos registrados en esta Categoria " + exception);
            return null;
        }
       
    }
  public ArrayList visualizarArticulos4(int codigo) {
         ArrayList<ArticulosD> lp = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            
            ps = conectar.prepareStatement("select a.idarticulos,a.nombre from articulosg2 a       inner join categoriasg2 c    "
                    + "     on a.frk_idcategorias = c.idcategorias     and a.frk_idcategorias="+codigo);
            
           // ps.setInt(1, codigo);
            rs = ps.executeQuery();
                while (rs.next()) {
                    ArticulosD artp = new ArticulosD();
                    
                    
                    artp.setIdArticulos(rs.getInt("idarticulos"));
                    artp.setNombre(rs.getString("nombre"));                  
                    lp.add(artp);
                }
             return lp;
        } catch (SQLException exception) {
            System.out.println("Imposible visualizar los articulos registrados en esta Categoria " + exception);
            return null;
        }
       
    }
public  ArrayList consultarArticulosParaGastos(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList <ArticulosD> listaArticulos = new ArrayList();
            String sql="select a.idarticulos as idarticulos,a.nombre as nombre, a.descripcion as detalle , a.marca as marca, c.descripcion as categoria,a.fecha as fecha from articulosg2 a\n" +
"     inner join categoriasg2 c\n" +
"     on a.frk_idcategorias= c.idcategorias ORDER BY a.idarticulos ";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);

            resultado = pr.executeQuery();
            while(resultado.next()){
                ArticulosD ad = new ArticulosD();
                
               ad.setIdArticulos(resultado.getInt("idarticulos"));
               ad.setNombre(resultado.getString("nombre"));
               ad.setDescripcion(resultado.getString("descripcion"));
               ad.setMarca(resultado.getString("marca"));
               ad.setIdcategorias(resultado.getInt("frk_idcategorias"));
               ad.setFecha(resultado.getDate("fecha"));
                            
               listaArticulos.add(ad);
                
            } 
           return listaArticulos; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     }

public ArrayList ListarTodos(){
    ResultSet resultado;
    ArrayList <ArticulosD> articulos = new ArrayList();
    
    try {
        PreparedStatement psmt ;
        sql="select a.idarticulos as id,a.nombre as articulo, a.descripcion as detalle , a.marca as marca, c.descripcion as categoria,a.fecha as fecha from articulosg2 a\n" +
"     inner join categoriasg2 c\n" +
"     on a.frk_idcategorias= c.idcategorias ORDER BY a.idarticulos";
        psmt= conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
            ArticulosD arti = new ArticulosD();
            arti.setIdArticulos(resultado.getInt("id"));
            arti.setNombre(resultado.getString("articulo"));
            arti.setDescripcion(resultado.getString("detalle"));
            arti.setMarca(resultado.getString("marca"));
            arti.setIdcategorias(resultado.getInt("categoria"));
            arti.setFecha(resultado.getDate("fecha"));
            
            articulos.add(arti);
        
        }
        return articulos;
    } catch (SQLException ex) {
         ex.printStackTrace();
         return null;
    }

    
    
    
}

public ArrayList ListarTodos22(){
    ResultSet resultado;
    ArrayList <ArticulosD> articulos = new ArrayList();
    
    try {
        PreparedStatement psmt ;
        sql="select a.idarticulos as idarticulos,a.nombre as nombre, a.descripcion as detalle , a.marca as marca, c.descripcion as categoria,a.fecha as fecha from articulosg2 a\n" +
"     inner join categoriasg2 c\n" +
"     on a.frk_idcategorias= c.idcategorias ORDER BY a.idarticulos";
        psmt= conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
            ArticulosD arti = new ArticulosD();
            arti.setIdArticulos(resultado.getInt("idarticulos"));
            arti.setNombre(resultado.getString("nombre"));
            arti.setDescripcion(resultado.getString("detalle"));
            arti.setMarca(resultado.getString("marca"));
            arti.setIdcategorias(resultado.getInt("categoria"));
            arti.setFecha(resultado.getDate("fecha"));
            
            articulos.add(arti);
        
        }
        return articulos;
    } catch (SQLException ex) {
         ex.printStackTrace();
         return null;
    }

    
    
    
}
public ArrayList ListarTodosD(){
    ResultSet resultado;
    ArrayList <ArticulosD> articulos = new ArrayList();
    
    try {
        PreparedStatement psmt ;
        sql="  select a.idarticulos as idarticulos, a.NOMBRE as nombre,a.DESCRIPCION as descripcion,a.MARCA as\n" +
"             marca,a.frk_categorias AS idCategorias from articulosg a\n" +
"              inner join categoriasg c   \n" +
"              on  a.frk_categorias= c.idCategorias  WHERE c.frk_idgastosfijos=2    ";
        psmt= conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
            ArticulosD arti = new ArticulosD();
            arti.setIdArticulos(resultado.getInt("idArticulos"));
            arti.setNombre(resultado.getString("nombre"));
            arti.setDescripcion(resultado.getString("descripcion"));
            arti.setMarca(resultado.getString("marca"));
            arti.setIdcategorias(resultado.getInt("idCategorias"));
            articulos.add(arti);
        
        }
        return articulos;
    } catch (SQLException ex) {
         ex.printStackTrace();
         return null;
    }

    
    
    
}

public ArrayList ListarTodosGF(){
    ResultSet resultado;
    ArrayList <ArticulosD> articulos = new ArrayList();
    
    try {
        PreparedStatement psmt ;
        sql="  select a.idarticulos as idarticulos, a.NOMBRE as nombre,a.DESCRIPCION as descripcion,a.MARCA as\n" +
"             marca,a.frk_categorias AS idCategorias from articulosg a\n" +
"              inner join categoriasg c   \n" +
"              on  a.frk_categorias= c.idCategorias  WHERE c.frk_idgastosfijos=1    ";
        psmt= conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
            ArticulosD arti = new ArticulosD();
            arti.setIdArticulos(resultado.getInt("idArticulos"));
            arti.setNombre(resultado.getString("nombre"));
            arti.setDescripcion(resultado.getString("descripcion"));
            arti.setMarca(resultado.getString("marca"));
            arti.setIdcategorias(resultado.getInt("idCategorias"));
            articulos.add(arti);
        
        }
        return articulos;
    } catch (SQLException ex) {
         ex.printStackTrace();
         return null;
    }

    
    
    
}
public ArrayList ListarTodosGV(){
    ResultSet resultado;
    ArrayList <ArticulosD> articulos = new ArrayList();
    
    try {
        PreparedStatement psmt ;
        sql="  select a.idarticulos as idarticulos, a.NOMBRE as nombre,a.DESCRIPCION as descripcion,a.MARCA as\n" +
"             marca,a.frk_categorias AS idCategorias from articulosg a\n" +
"              inner join categoriasg c   \n" +
"              on  a.frk_categorias= c.idCategorias  WHERE c.frk_idgastosfijos=3    ";
        psmt= conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
            ArticulosD arti = new ArticulosD();
            arti.setIdArticulos(resultado.getInt("idArticulos"));
            arti.setNombre(resultado.getString("nombre"));
            arti.setDescripcion(resultado.getString("descripcion"));
            arti.setMarca(resultado.getString("marca"));
            arti.setIdcategorias(resultado.getInt("idCategorias"));
            articulos.add(arti);
        
        }
        return articulos;
    } catch (SQLException ex) {
         ex.printStackTrace();
         return null;
    }

    
    
    
}


    
    
    
    
    
    
    
    
}
