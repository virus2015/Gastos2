/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos2.Datos;

/**
 *
 * @author jorge.lopez
 */
public class CategoriasD {
    
     private int idCategorias;
    private String descripcion;
    private String detalles;
    private int idgastosfijos;
    private int idTiendas;
    
    public CategoriasD(){
    
    }
     public CategoriasD(int pIdCateogias,String pdescripcion,String pdetalles ,int pidgastosfijos,int pidTiendas){
     this.idCategorias= pIdCateogias;
     this.descripcion=pdescripcion;
     this.detalles=pdetalles;
     this.idgastosfijos=pidgastosfijos;          
     this.idTiendas=pidTiendas;
      }

    /**
     * @return the idCategorias
     */
    public int getIdCategorias() {
        return idCategorias;
    }

    /**
     * @param idCategorias the idCategorias to set
     */
    public void setIdCategorias(int idCategorias) {
        this.idCategorias = idCategorias;
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
     * @return the detalles
     */
    public String getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    /**
     * @return the idgastosfijos
     */
    public int getIdgastosfijos() {
        return idgastosfijos;
    }

    /**
     * @param idgastosfijos the idgastosfijos to set
     */
    public void setIdgastosfijos(int idgastosfijos) {
        this.idgastosfijos = idgastosfijos;
    }

    /**
     * @return the idTiendas
     */
    public int getIdTiendas() {
        return idTiendas;
    }

    /**
     * @param idTiendas the idTiendas to set
     */
    public void setIdTiendas(int idTiendas) {
        this.idTiendas = idTiendas;
    }
     
    
}
