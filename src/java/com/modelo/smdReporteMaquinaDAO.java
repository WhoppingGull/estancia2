/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class smdReporteMaquinaDAO extends Conexion {

    public int insertarReporte(smdReporteMaquina u) {
        int res = 0;
        try {
            this.conectar();
            System.out.println("reporte en servlet: " + u.toString());
            Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
            String sql = "INSERT INTO smd_reporte_maquina(id_smd_reporte_maquina,id_smd_proceso, batch_oracle, batch_local, pa, total, handled, good, bad, remain, remade, lost, removed, purged, recuperados, creation_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now());";
            PreparedStatement pre = conectar().prepareStatement(sql);
            pre.setInt(1, u.getIdSmdReporteMaquina());
            pre.setInt(2, u.getIdSmdProceso());
            pre.setString(3, u.getBatchOracle());
            pre.setString(4, u.getBatchLocal());
            pre.setString(5, u.getPa());
            pre.setInt(6, u.getTotal());
            pre.setInt(7, u.getHandled());
            pre.setInt(8, u.getGood());
            pre.setInt(9, u.getBad());
            pre.setInt(10, u.getRemain());
            pre.setInt(11, u.getRemade());
            pre.setInt(12, u.getLost());
            pre.setInt(13, u.getRemoved());
            pre.setInt(14, u.getPurged());
            pre.setInt(15, u.getRecuperados());
            System.out.println("res; " + res);
            res = pre.executeUpdate();
            System.out.println("res; " + res);
        } catch (Exception e) {
            System.out.println("Error al insertar EN INSERTAR EN BASE DE DATOS: " + e.getMessage());
        } finally {
            this.cerrarConexion();
        }
        System.out.println("res; " + res);
        return res;
    }

    public ArrayList<smdReporteMaquina> mostrarReportesMaquina() {
        ArrayList<smdReporteMaquina> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM smd_reporte_maquina;";
            PreparedStatement pre = this.conectar().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();

            while (rs.next()) {
                smdReporteMaquina reporte = new smdReporteMaquina();
                reporte.setIdSmdReporteMaquina(rs.getInt("id_smd_reporte_maquina"));
                reporte.setIdSmdProceso(rs.getInt("id_smd_proceso"));
                reporte.setBatchOracle(rs.getString("batch_oracle"));
                reporte.setBatchLocal(rs.getString("batch_local"));
                reporte.setPa(rs.getString("pa"));
                reporte.setTotal(rs.getInt("total"));
                reporte.setHandled(rs.getInt("handled"));
                reporte.setGood(rs.getInt("good"));
                reporte.setBad(rs.getInt("bad"));
                reporte.setRemain(rs.getInt("remain"));
                reporte.setRemade(rs.getInt("remade"));
                reporte.setLost(rs.getInt("lost"));
                reporte.setRemoved(rs.getInt("removed"));
                reporte.setPurged(rs.getInt("purged"));
                reporte.setRecuperados(rs.getInt("recuperados"));
                reporte.setCreationDate(rs.getString("creation_date"));

                lista.add(reporte);
                System.out.println("Existen los datos: " + reporte.toString());
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al mostrar: " + e.getMessage());
        } finally {
            this.cerrarConexion();
        }

        if (lista.isEmpty()) {
            System.out.println("No hay reportes de máquina");
        } else {
            System.out.println("Existen reportes de máquina");
        }
        return lista;
    }

    public int modificarReporte(smdReporteMaquina u) {
        int res = 0;
        try {
            this.conectar();
            System.out.println("u: " + u.toString());
            String sql = "UPDATE smd_reporte_maquina SET id_smd_proceso=?, batch_oracle=?, batch_local=?, pa=?, total=?, handled=?, good=?, bad=?, remain=?, remade=?, lost=?, removed=?, purged=?, recuperados=?, creation_date=now() WHERE id_smd_reporte_maquina=?;";
            PreparedStatement pre = this.conectar().prepareStatement(sql);
            System.out.println("SQL a ejecutar para modificar usuario: " + pre.toString());
            pre.setInt(1, u.getIdSmdProceso());
            pre.setString(2, u.getBatchOracle());
            pre.setString(3, u.getBatchLocal());
            pre.setString(4, u.getPa());
            pre.setInt(5, u.getTotal());
            pre.setInt(6, u.getHandled());
            pre.setInt(7, u.getGood());
            pre.setInt(8, u.getBad());
            pre.setInt(9, u.getRemain());
            pre.setInt(10, u.getRemade());
            pre.setInt(11, u.getLost());
            pre.setInt(12, u.getRemoved());
            pre.setInt(13, u.getPurged());
            pre.setInt(14, u.getRecuperados());
            pre.setInt(15, u.getIdSmdReporteMaquina());

            res = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error de modificar: " + e.getMessage());
        } finally {
            this.cerrarConexion();
        }
        return res;
    }

    public int eliminarReporte(smdReporteMaquina u) {
        int res = 0;

        try {
            this.conectar();
            String sql = "DELETE FROM smd_reporte_maquina WHERE id_smd_reporte_maquina=?;";
            PreparedStatement pre = this.conectar().prepareStatement(sql);
            pre.setInt(1, u.getIdSmdReporteMaquina());
            res = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        } finally {
            this.cerrarConexion();
        }
        return res;
    }

}
