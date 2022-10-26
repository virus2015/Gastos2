/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos2.Datos;

import java.sql.Date;

/**
 *
 * @author jorge.lopez
 */
public class ArticulosD {
    
private int idArticulos;
private String nombre;
private String descripcion;
private String  marca;
private int idcategorias;
private Date fecha;


public ArticulosD(){
}
    
 public ArticulosD(int pidArticulos, String pnombre, String pdescripcion,String pmarca,int pidCategorias ,Date pfecha){
 this.idArticulos=pidArticulos;
 this.nombre=pnombre;
 this.descripcion=pdescripcion;
 this.marca=pmarca;
 this.idcategorias =  pidCategorias; 
 this.fecha = pfecha;
 
}   

    /**
     * @return the idArticulos
     */
    public int getIdArticulos() {
        return idArticulos;
    }

    /**
     * @param idArticulos the idArticulos to set
     */
    public void setIdArticulos(int idArticulos) {
        this.idArticulos = idArticulos;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the idcategorias
     */
    public int getIdcategorias() {
        return idcategorias;
    }

    /**
     * @param idcategorias the idcategorias to set
     */
    public void setIdcategorias(int idcategorias) {
        this.idcategorias = idcategorias;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

  
    
    
}
