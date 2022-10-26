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
public class GastosD {
    
private int idGastos;    
private int idArticulos;  
private int idCredito;
private Double precioArticulo;
private Double preciokgPaquete;
private int cantidad;
private Date fecha;

    
public GastosD(){


}    

public GastosD(int pidGastos,int pidArticulos,int pidCredito,Double pprecioArticulo,Double ppreciokgPaquete ,int pcantidad ,Date pfecha){
this.idGastos=pidGastos;
this.idArticulos=pidArticulos;
this.idCredito=pidCredito;
this.precioArticulo=pprecioArticulo;
this.preciokgPaquete=  ppreciokgPaquete;
this.cantidad=pcantidad;
this.fecha=pfecha;
}

    /**
     * @return the idGastos
     */
    public int getIdGastos() {
        return idGastos;
    }

    /**
     * @param idGastos the idGastos to set
     */
    public void setIdGastos(int idGastos) {
        this.idGastos = idGastos;
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
     * @return the idCredito
     */
    public int getIdCredito() {
        return idCredito;
    }

    /**
     * @param idCredito the idCredito to set
     */
    public void setIdCredito(int idCredito) {
        this.idCredito = idCredito;
    }

    /**
     * @return the precioArticulo
     */
    public Double getPrecioArticulo() {
        return precioArticulo;
    }

    /**
     * @param precioArticulo the precioArticulo to set
     */
    public void setPrecioArticulo(Double precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    /**
     * @return the preciokgPaquete
     */
    public Double getPreciokgPaquete() {
        return preciokgPaquete;
    }

    /**
     * @param preciokgPaquete the preciokgPaquete to set
     */
    public void setPreciokgPaquete(Double preciokgPaquete) {
        this.preciokgPaquete = preciokgPaquete;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
