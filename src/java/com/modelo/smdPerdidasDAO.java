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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class smdPerdidasDAO extends Conexion {

// Obtener la fecha actual

// Crear un Timestamp a partir de la fecha actual

    public int insertarPerdida(smdPerdidas u) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO smd_perdidas_de_proceso (id_smd_proceso, id_station, qty, estatus, perdida_tiempo) VALUES (?,?,?,?,now());";
            PreparedStatement pre = conectar().prepareStatement(sql);
            pre.setInt(1, u.getIdSmdProceso());
            pre.setInt(2, u.getIdStation());
            pre.setInt(3, u.getQty());
            pre.setInt(4, u.getEstatus());
            res = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar" + e.getMessage());
        } finally {
        }
        return res;
    }

    public ArrayList<smdPerdidas> mostrarPerdida() {
        ArrayList<smdPerdidas> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM smd_perdidas_de_proceso ORDER BY perdida_tiempo DESC;";
            PreparedStatement pre = this.conectar().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();

            while (rs.next()) {
                smdPerdidas u = new smdPerdidas();
                u.setIdSmdPerdidasProceso(rs.getInt(1));
                u.setIdSmdProceso(rs.getInt(2));
                u.setIdStation(rs.getInt(3));
                u.setQty(rs.getInt(4));
                u.setEstatus(rs.getInt(5));
                u.setPerdidaTiempo(rs.getString(6));

                lista.add(u);
                System.out.println("existen los datos" + u.toString());

            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al mostrar" + e.getMessage());
        } finally {
            this.cerrarConexion();
        }

        if (lista.isEmpty()) {
            System.out.println("No hay perddias");
        } else {
            System.out.println("Existen perddias");
        }
        return lista;
    }

    public int modificarPerdida(smdPerdidas perdida) {
        int res = 0;
        try {
            System.out.println("Perdida actualizar: " + perdida.toString());
            this.conectar();
            String sql = "UPDATE smd_perdidas_de_proceso SET id_smd_proceso=?, id_station=?, qty=?, estatus=?, perdida_tiempo= now() WHERE id_smd_perdidas_proceso=?;";
            PreparedStatement pre = this.conectar().prepareStatement(sql);
            pre.setInt(1, perdida.getIdSmdProceso());
            pre.setInt(2, perdida.getIdStation());
            pre.setInt(3, perdida.getQty());
            pre.setInt(4, perdida.getEstatus());
            //pre.setString(5, perdida.getPerdidaTiempo());
            pre.setInt(5, perdida.getIdSmdPerdidasProceso());

            res = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error de modificar: " + e.getMessage());
        } finally {
            this.cerrarConexion();
        }
        return res;
    }

    public int eliminarPerdida(smdPerdidas perdida) {
        int res = 0;

        try {
            this.conectar();
            String sql = "DELETE FROM smd_perdidas_de_proceso WHERE id_smd_perdidas_proceso=?;";
            PreparedStatement pre = this.conectar().prepareStatement(sql);
            pre.setInt(1, perdida.getIdSmdPerdidasProceso());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error de eliminar: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(smdPerdidasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrarConexion();
        }
        return res;
    }

    public boolean buscarPerdida(int idSmdPerdidasProceso) {
        boolean perdidaEncontrada = false;
        ResultSet rs = null;

        try {
            this.conectar();
            String sql = "SELECT * FROM smd_perdidas_de_proceso WHERE id_smd_perdidas_proceso=?;";
            PreparedStatement pre = this.conectar().prepareStatement(sql);
            pre.setInt(1, idSmdPerdidasProceso);
            rs = pre.executeQuery();

            // Verificar si se encontró algún resultado
            if (rs.next()) {
                perdidaEncontrada = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar perdida: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(smdPerdidasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(smdPerdidasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.cerrarConexion();
        }
        return perdidaEncontrada;
    }
    
        public int imprimir(smdPerdidas u) {
        int res = 0;
        System.out.println("Entro a imprimir");
        try {
            this.conectar();
            String consultaReporteYObservaciones = "SELECT rm.*, o.observacion "
                    + "FROM smd_reporte_maquina rm "
                    + "LEFT JOIN smd_observaciones o ON rm.id_smd_reporte_maquina = o.id_smd_reporte_maquina "
                    + "WHERE rm.id_smd_reporte_maquina = ?";
            PreparedStatement pre = this.conectar().prepareStatement(consultaReporteYObservaciones);
            pre.setInt(1, u.getIdSmdPerdidasProceso());
            generar(u.getIdStation(), u);
            res = 1;
        } catch (Exception e) {
            System.out.println("Error al imprimir: " + e.getMessage());
        } finally {
            this.cerrarConexion();
        }
        return res;
    }

    public void generar(int oracle, smdPerdidas info) {
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
            Paragraph parrafo = new Paragraph("Datos de la perdida", new Font(Font.FontFamily.TIMES_ROMAN, 14));
            parrafo.setAlignment(1);
            documento.add(parrafo);
            documento.add(new Paragraph("Contenido de la perddia seelccionada:"));
            documento.add(new Paragraph("  "));
            documento.add(new Paragraph("Hora y fecha de la perdida: " + info.getPerdidaTiempo()));
            documento.add(new Paragraph("Estatus de la perdida seleccioanda: " + info.getEstatus()));
            documento.add(new Paragraph("Qty de la perdida: "+info.getQty()));
            documento.add(new Paragraph(""));
            documento.add(new Paragraph("Identificadro de la perdida: " + info.getIdSmdPerdidasProceso()));
            documento.add(new Paragraph("Estacion de la falla: " + info.getIdStation()));

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
