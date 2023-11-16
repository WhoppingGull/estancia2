
package com.modelo;

/**
 *
 * @author Diego
 */
public class smdPerdidas {
    
     private int idSmdPerdidasProceso;
    private int idSmdProceso;
    private int idStation;
    private int qty;
    private int estatus;
    private String perdidaTiempo;

    public smdPerdidas(int idSmdPerdidasProceso, int idSmdProceso, int idStation, int qty, int estatus, String perdidaTiempo) {
        this.idSmdPerdidasProceso = idSmdPerdidasProceso;
        this.idSmdProceso = idSmdProceso;
        this.idStation = idStation;
        this.qty = qty;
        this.estatus = estatus;
        this.perdidaTiempo = perdidaTiempo;
    }
    
    public smdPerdidas(){
    }

    @Override
    public String toString() {
        return "smdPerdidas{" + "idSmdPerdidasProceso=" + idSmdPerdidasProceso + ", idSmdProceso=" + idSmdProceso + ", idStation=" + idStation + ", qty=" + qty + ", estatus=" + estatus + ", perdidaTiempo=" + perdidaTiempo + '}';
    }

    
    
    public int getIdSmdPerdidasProceso() {
        return idSmdPerdidasProceso;
    }

    public void setIdSmdPerdidasProceso(int idSmdPerdidasProceso) {
        this.idSmdPerdidasProceso = idSmdPerdidasProceso;
    }

    public int getIdSmdProceso() {
        return idSmdProceso;
    }

    public void setIdSmdProceso(int idSmdProceso) {
        this.idSmdProceso = idSmdProceso;
    }

    public int getIdStation() {
        return idStation;
    }

    public void setIdStation(int idStation) {
        this.idStation = idStation;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getPerdidaTiempo() {
        return perdidaTiempo;
    }

    public void setPerdidaTiempo(String perdidaTiempo) {
        this.perdidaTiempo = perdidaTiempo;
    }
    
    
    
    
}
