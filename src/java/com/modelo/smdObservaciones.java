/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author Diego
 */
public class smdObservaciones {
     private int idObservacion;
    private String observacion;
    private String fecha;
    private int idSmdReporteMaquina;

    public smdObservaciones(int idObservacion, String observacion, String fecha, int idSmdReporteMaquina) {
        this.idObservacion = idObservacion;
        this.observacion = observacion;
        this.fecha = fecha;
        this.idSmdReporteMaquina = idSmdReporteMaquina;
    }

    @Override
    public String toString() {
        return "smdObservaciones{" + "idObservacion=" + idObservacion + ", observacion=" + observacion + ", fecha=" + fecha + ", idSmdReporteMaquina=" + idSmdReporteMaquina + '}';
    }
    
    public smdObservaciones(){
    }

    public int getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(int idObservacion) {
        this.idObservacion = idObservacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdSmdReporteMaquina() {
        return idSmdReporteMaquina;
    }

    public void setIdSmdReporteMaquina(int idSmdReporteMaquina) {
        this.idSmdReporteMaquina = idSmdReporteMaquina;
    }

    
    
}
