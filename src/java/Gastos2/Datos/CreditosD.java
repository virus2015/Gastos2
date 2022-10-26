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
public class CreditosD {
    
    private int idCredito;
    private double montoCredito;
    private double interes;
    private Date fecha;
    private String descripcion;  
    private double consumidoCredito;
    private double conCredito1;
    private double conCredito2;
    
    
    public CreditosD(){
    
    
    }
     public CreditosD(int pidCredito,double pmontoCredito,double pinteres,Date pfecha,String pdescripcion, double pconsumidoCredito,
                                                                      double pconCredito1,double pconCredito2){
     this.idCredito =pidCredito;
     this.montoCredito = pmontoCredito;
     this.interes =pinteres;
     this.fecha =pfecha;
     this.descripcion =pdescripcion;
     this.consumidoCredito =pconsumidoCredito;
     this.conCredito1 =pconCredito1;
     this.conCredito2 =pconCredito2;
    
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
     * @return the montoCredito
     */
    public double getMontoCredito() {
        return montoCredito;
    }

    /**
     * @param montoCredito the montoCredito to set
     */
    public void setMontoCredito(double montoCredito) {
        this.montoCredito = montoCredito;
    }

    /**
     * @return the interes
     */
    public double getInteres() {
        return interes;
    }

    /**
     * @param interes the interes to set
     */
    public void setInteres(double interes) {
        this.interes = interes;
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
     * @return the consumidoCredito
     */
    public double getConsumidoCredito() {
        return consumidoCredito;
    }

    /**
     * @param consumidoCredito the consumidoCredito to set
     */
    public void setConsumidoCredito(double consumidoCredito) {
        this.consumidoCredito = consumidoCredito;
    }

    /**
     * @return the conCredito1
     */
    public double getConCredito1() {
        return conCredito1;
    }

    /**
     * @param conCredito1 the conCredito1 to set
     */
    public void setConCredito1(double conCredito1) {
        this.conCredito1 = conCredito1;
    }

    /**
     * @return the conCredito2
     */
    public double getConCredito2() {
        return conCredito2;
    }

    /**
     * @param conCredito2 the conCredito2 to set
     */
    public void setConCredito2(double conCredito2) {
        this.conCredito2 = conCredito2;
    }

   
     
     
     
     
     
     
}
