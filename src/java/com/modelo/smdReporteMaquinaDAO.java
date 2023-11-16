/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

import com.conexion.Conexion;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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

    public int imprimir(smdReporteMaquina u) {
        int res = 0;
        System.out.println("Entro a imprimir");
        try {
            this.conectar();
            String consultaReporteYObservaciones = "SELECT rm.*, o.observacion "
                    + "FROM smd_reporte_maquina rm "
                    + "LEFT JOIN smd_observaciones o ON rm.id_smd_reporte_maquina = o.id_smd_reporte_maquina "
                    + "WHERE rm.id_smd_reporte_maquina = ?";
            PreparedStatement pre = this.conectar().prepareStatement(consultaReporteYObservaciones);
            pre.setInt(1, u.getIdSmdReporteMaquina());
            generar(u.getBatchLocal(), u);
            res = 1;
        } catch (Exception e) {
            System.out.println("Error al imprimir: " + e.getMessage());
        } finally {
            this.cerrarConexion();
        }
        return res;
    }

    public void generar(String oracle, smdReporteMaquina info) {
        FileOutputStream archivo = null;
        try {
            // Especifica la ruta completa del archivo
            String rutaArchivo = "C:\\Users\\Diego\\OneDrive\\Documentos\\NetBeansProjects\\DigitalizacionSMD\\" + oracle + ".pdf";
            archivo = new FileOutputStream(rutaArchivo);
            com.itextpdf.text.Document documento = new com.itextpdf.text.Document();
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            // Agrega la imagen al documento
            float escala = 10;
            Image imagen = Image.getInstance("https://1000marcas.net/wp-content/uploads/2022/06/Thales-Logo.jpg");
            imagen.scalePercent(escala);
            imagen.setAlignment(Element.ALIGN_CENTER);
            documento.add(imagen);

            // Agrega contenido al PDF aquí
            Paragraph parrafo = new Paragraph("Datos del pedido", new Font(Font.FontFamily.TIMES_ROMAN, 14));
            parrafo.setAlignment(1);
            documento.add(parrafo);
            documento.add(new Paragraph("Contenido del reporte:"));
            documento.add(new Paragraph("  "));
            documento.add(new Paragraph("Batch Local: " + info.getBatchLocal()));
            documento.add(new Paragraph("Batch Oracle: " + info.getBatchOracle()));
            documento.add(new Paragraph(""));
            documento.add(new Paragraph("________________________________________________________"));
            documento.add(new Paragraph(""));

            documento.add(new Paragraph("Total: " + info.getTotal()));
            documento.add(new Paragraph("Bad: " + info.getBad()));
            documento.add(new Paragraph("Good: " + info.getGood()));
            documento.add(new Paragraph("Perdidas: " + info.getLost()));
            documento.add(new Paragraph("Purged: " + info.getPurged()));
            documento.add(new Paragraph("Remade: " + info.getRemade()));
            documento.add(new Paragraph("Remain: " + info.getRemain()));
            documento.add(new Paragraph("Good:  " + info.getGood()));
            documento.add(new Paragraph("Perdidas:  " + info.getLost()));
            documento.add(new Paragraph("Purged:  " + info.getPurged()));
            documento.add(new Paragraph(""));
            documento.add(new Paragraph(""));
            documento.add(new Paragraph(""));
            
            Paragraph parrafo1 = new Paragraph("Thales Planta Cuernavaca", new Font(Font.FontFamily.TIMES_ROMAN, 10));
            parrafo1.add(new Paragraph("Thales Planta Cuernavaca", new Font(Font.FontFamily.TIMES_ROMAN, 10)));
            parrafo1.add(new Paragraph("Dirección: C. 9 Este 192, Civac, 62578 Jiutepec, Mor.", new Font(Font.FontFamily.TIMES_ROMAN, 10)));
            parrafo1.add(new Paragraph("Teléfono: 777 329 3900", new Font(Font.FontFamily.TIMES_ROMAN, 10)));
            parrafo1.setAlignment(1);
            documento.add(parrafo1);
// Agrega más información según sea necesario

            documento.close();
            abrir(rutaArchivo);  // Mover esta línea para que se ejecute después de cerrar el documento
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (archivo != null) {
                try {
                    archivo.close();  // Cerrar el archivo en la cláusula finally
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void abrir(String nombre) {
        try {
            File path = new File(nombre);
            Desktop.getDesktop().open(path);
        } catch (Exception e) {
            System.out.println("Error de abrir: " + e);
        }
    }
}
