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
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class smdObservacionesDAO extends Conexion {

    public int insertarObservacion(smdObservaciones observacion) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO smd_observaciones (observacion, fecha, id_smd_reporte_maquina) VALUES (?, ?, ?);";
            PreparedStatement pre = conectar().prepareStatement(sql);
            pre.setString(1, observacion.getObservacion());
            pre.setString(2, observacion.getFecha());
            pre.setInt(3, observacion.getIdSmdReporteMaquina());
            res = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar observación: " + e.getMessage());
        } finally {
            this.cerrarConexion();
        }
        return res;
    }

    public ArrayList<smdObservaciones> mostrarObservaciones() {
        ArrayList<smdObservaciones> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM smd_observaciones;";
            PreparedStatement pre = this.conectar().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                smdObservaciones observacion = new smdObservaciones();
                observacion.setIdObservacion(rs.getInt(1));
                observacion.setObservacion(rs.getString(2));
                observacion.setFecha(rs.getString(3));
                observacion.setIdSmdReporteMaquina(rs.getInt(4));
                lista.add(observacion);
                System.out.println("Existen los datos: " + observacion.toString());
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al mostrar observaciones: " + e.getMessage());
        } finally {
            this.cerrarConexion();
        }

        if (lista.isEmpty()) {
            System.out.println("No hay observaciones");
        } else {
            System.out.println("Existen observaciones");
        }
        return lista;
    }

    public int modificarObservacion(smdObservaciones observacion) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE smd_observaciones SET observacion=?, fecha=?, id_smd_reporte_maquina=? WHERE id_observaciones=?;";
            PreparedStatement pre = this.conectar().prepareStatement(sql);
            pre.setString(1, observacion.getObservacion());
            pre.setString(2, observacion.getFecha());
            pre.setInt(3, observacion.getIdSmdReporteMaquina());
            pre.setInt(4, observacion.getIdObservacion());

            res = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al modificar observación: " + e.getMessage());
        } finally {
            this.cerrarConexion();
        }
        return res;
    }

    public int eliminarObservacion(smdObservaciones observacion) {
        int res = 0;

        try {
            this.conectar();
            String sql = "DELETE FROM smd_observaciones WHERE id_observaciones=?;";
            PreparedStatement pre = this.conectar().prepareStatement(sql);
            pre.setInt(1, observacion.getIdObservacion());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar observación: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(smdObservacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrarConexion();
        }
        return res;
    }
    
    public int imprimir(smdObservaciones u) {
        int res = 0;
        System.out.println("Entro a imprimir");
        try {
            this.conectar();
            String consultaReporteYObservaciones = "SELECT rm.*, o.observacion "
                    + "FROM smd_reporte_maquina rm "
                    + "LEFT JOIN smd_observaciones o ON rm.id_smd_reporte_maquina = o.id_smd_reporte_maquina "
                    + "WHERE rm.id_smd_reporte_maquina = ?";
            PreparedStatement pre = this.conectar().prepareStatement(consultaReporteYObservaciones);
            pre.setInt(1, u.getIdObservacion());
            generar(u.getIdObservacion(), u);
            res = 1;
        } catch (Exception e) {
            System.out.println("Error al imprimir: " + e.getMessage());
        } finally {
            this.cerrarConexion();
        }
        return res;
    }

    public void generar(int nombre, smdObservaciones info) {
        FileOutputStream archivo = null;
        try {
            // Especifica la ruta completa del archivo
            String rutaArchivo = "C:\\Users\\Diego\\OneDrive\\Documentos\\NetBeansProjects\\DigitalizacionSMD\\" + nombre + ".pdf";
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
            documento.add(new Paragraph("Contenido de la observacion relaizada:"));
            documento.add(new Paragraph("  "));
            documento.add(new Paragraph("Identificadro de la observación: " + info.getIdObservacion()));
            documento.add(new Paragraph("Fecha de la observación"+info.getFecha()));
            documento.add(new Paragraph("________________________________________________________"));
            documento.add(new Paragraph(""));

            
            documento.add(new Paragraph("Observación:  " + info.getObservacion()));
            documento.add(new Paragraph("Identificador del reporte:  " + info.getIdSmdReporteMaquina()));
            
            
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
