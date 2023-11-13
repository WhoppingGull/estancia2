/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

import java.sql.Date;

/**
 *
 * @author Diego
 */
public class smdReporteMaquina {
        private int idSmdReporteMaquina;
    private int idSmdProceso;
    private String batchOracle;
    private String batchLocal;
    private String pa;
    private int total;
    private int handled;
    private int good;
    private int bad;
    private int remain;
    private int remade;
    private int lost;
    private int removed;
    private int purged;
    private int recuperados;
    private String creationDate;

    public smdReporteMaquina(int idSmdReporteMaquina, int idSmdProceso, String batchOracle, String batchLocal, String pa, int total, int handled, int good, int bad, int remain, int remade, int lost, int removed, int purged, int recuperados, String creationDate) {
        this.idSmdReporteMaquina = idSmdReporteMaquina;
        this.idSmdProceso = idSmdProceso;
        this.batchOracle = batchOracle;
        this.batchLocal = batchLocal;
        this.pa = pa;
        this.total = total;
        this.handled = handled;
        this.good = good;
        this.bad = bad;
        this.remain = remain;
        this.remade = remade;
        this.lost = lost;
        this.removed = removed;
        this.purged = purged;
        this.recuperados = recuperados;
        this.creationDate = creationDate;
    }

    public smdReporteMaquina() {
    }
    

    public int getIdSmdReporteMaquina() {
        return idSmdReporteMaquina;
    }

    public void setIdSmdReporteMaquina(int idSmdReporteMaquina) {
        this.idSmdReporteMaquina = idSmdReporteMaquina;
    }

    public int getIdSmdProceso() {
        return idSmdProceso;
    }

    public void setIdSmdProceso(int idSmdProceso) {
        this.idSmdProceso = idSmdProceso;
    }

    public String getBatchOracle() {
        return batchOracle;
    }

    public void setBatchOracle(String batchOracle) {
        this.batchOracle = batchOracle;
    }

    public String getBatchLocal() {
        return batchLocal;
    }

    public void setBatchLocal(String batchLocal) {
        this.batchLocal = batchLocal;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHandled() {
        return handled;
    }

    public void setHandled(int handled) {
        this.handled = handled;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public int getBad() {
        return bad;
    }

    public void setBad(int bad) {
        this.bad = bad;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public int getRemade() {
        return remade;
    }

    public void setRemade(int remade) {
        this.remade = remade;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getRemoved() {
        return removed;
    }

    public void setRemoved(int removed) {
        this.removed = removed;
    }

    public int getPurged() {
        return purged;
    }

    public void setPurged(int purged) {
        this.purged = purged;
    }

    public int getRecuperados() {
        return recuperados;
    }

    public void setRecuperados(int recuperados) {
        this.recuperados = recuperados;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "smdReporteMaquina{" + "idSmdReporteMaquina=" + idSmdReporteMaquina + ", idSmdProceso=" + idSmdProceso + ", batchOracle=" + batchOracle + ", batchLocal=" + batchLocal + ", pa=" + pa + ", total=" + total + ", handled=" + handled + ", good=" + good + ", bad=" + bad + ", remain=" + remain + ", remade=" + remade + ", lost=" + lost + ", removed=" + removed + ", purged=" + purged + ", recuperados=" + recuperados + ", creationDate=" + creationDate + '}';
    }
    
    

}

    