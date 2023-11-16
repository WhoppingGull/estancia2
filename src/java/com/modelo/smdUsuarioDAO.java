package com.modelo;

import com.conexion.Conexion;
import com.itextpdf.text.Document;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class smdUsuarioDAO extends Conexion {

    public int insertarCliente(smdUsuario u) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO smd_usuario1 (nombre, apellido, amaterno, grupo, sexo, telefono, edad,contraseña) VALUES (?, ?, ?, ?, ?, ?, ?,?);";
            PreparedStatement pre = conectar().prepareStatement(sql);
            pre.setString(1, u.getNombre());
            pre.setString(2, u.getApellido());
            pre.setString(3, u.getAmaterno());
            pre.setString(4, u.getGrupo());
            pre.setString(5, u.getSexo());
            pre.setString(6, u.getTelefono());
            pre.setInt(7, u.getEdad());
            pre.setString(8, u.getContraseña());
            res = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar" + e.getMessage());
        } finally {
        }
        return res;
    }

    public ArrayList<smdUsuario> mostrarUsuario() {
        ArrayList<smdUsuario> lista = new ArrayList<>();
        try {
            String sql = "SELECT*FROM smd_usuario1;";
            PreparedStatement pre = this.conectar().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();

            while (rs.next()) {
                smdUsuario u = new smdUsuario();
                u.setIdUser(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellido(rs.getString(3));
                u.setAmaterno(rs.getString(4));
                u.setActivo(rs.getInt(5));
                u.setGrupo(rs.getString(6));
                u.setSexo(rs.getString(7));
                u.setTelefono(rs.getString(8));
                u.setEdad(rs.getInt(9));
                u.setContraseña(rs.getString(10));
                lista.add(u);
                System.out.println("existen los datos" + u.toString());

            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al mostrar" + e.getMessage());
        } finally {
            this.cerrarConexion();
        }

        if (lista.isEmpty()) {
            System.out.println("No hay Usuarios");
        } else {
            System.out.println("Existen Usuarios");
        }
        return lista;
    }

    public int modificarUsuario(smdUsuario u) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE smd_usuario1 SET nombre=?,apellido=?,amaterno=?,activo=?,grupo=?,sexo=?,telefono=?,edad=?, contraseña=? WHERE id_user=?;";
            PreparedStatement pre = this.conectar().prepareStatement(sql);
            System.out.println("SQL a ejecutar para modificar usuario: " + pre.toString());
            pre.setString(1, u.getNombre());
            pre.setString(2, u.getApellido());
            pre.setString(3, u.getAmaterno());
            pre.setInt(4, u.getActivo());
            pre.setString(5, u.getGrupo());
            pre.setString(6, u.getSexo());
            pre.setString(7, u.getTelefono());
            pre.setInt(8, u.getEdad());
            pre.setString(9, u.getContraseña());
            pre.setInt(10, u.getIdUser());

            res = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error de modificar: " + e.getMessage());
        } finally {
            this.cerrarConexion();
        }
        return res;
    }

    public int eliminarUsuario(smdUsuario u) {
        int res = 0;

        try {
            this.conectar();
            String sql = "DELETE FROM smd_usuario1 WHERE id_user=?;";
            PreparedStatement pre = this.conectar().prepareStatement(sql);
            pre.setInt(1, u.getIdUser());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error de modificar: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(smdUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrarConexion();
        }
        return res;
    }

    public boolean buscarUsuario(String user, String contra) {
        boolean usuarioEncontrado = false;
        ResultSet rs = null;

        try {
            System.out.println("entro a DAO: " + user + "   " + contra);
            this.conectar();
            String sql = "SELECT * FROM smd_usuario1 WHERE nombre=? AND contraseña=?;";
            PreparedStatement pre = this.conectar().prepareStatement(sql);
            pre.setString(1, user);
            pre.setString(2, contra);
            rs = pre.executeQuery();

            // Verificar si se encontró algún resultado
            if (rs.next()) {
                usuarioEncontrado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar usuario: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(smdUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(smdUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.cerrarConexion();
        }
        return usuarioEncontrado;
    }
    
     public int imprimir(smdUsuario u) {
        int res = 0;
        System.out.println("Entro a imprimir");
        try {
            this.conectar();
            String consultaReporteYObservaciones = "SELECT rm.*, o.observacion "
                    + "FROM smd_reporte_maquina rm "
                    + "LEFT JOIN smd_observaciones o ON rm.id_smd_reporte_maquina = o.id_smd_reporte_maquina "
                    + "WHERE rm.id_smd_reporte_maquina = ?";
            PreparedStatement pre = this.conectar().prepareStatement(consultaReporteYObservaciones);
            pre.setInt(1, u.getIdUser());
            generar(u.getNombre(), u);
            res = 1;
        } catch (Exception e) {
            System.out.println("Error al imprimir: " + e.getMessage());
        } finally {
            this.cerrarConexion();
        }
        return res;
    }

     
    public void generar(String nombre, smdUsuario info) {
        FileOutputStream archivo = null;
        try {
            System.out.println(""+info.toString());
            // Especifica la ruta completa del archivo
            String rutaArchivo = "C:\\Users\\Diego\\OneDrive\\Documentos\\NetBeansProjects\\DigitalizacionSMD\\" + nombre + ".pdf";
            archivo = new FileOutputStream(rutaArchivo);
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);
            documento.open();

            // Agrega la imagen al documento
            float escala = 10;
            Image imagen = Image.getInstance("https://1000marcas.net/wp-content/uploads/2022/06/Thales-Logo.jpg");
            imagen.scalePercent(escala);
            imagen.setAlignment(Element.ALIGN_CENTER);
            documento.add(imagen);

            // Encabezado de la carta de renuncia
            Paragraph encabezado = new Paragraph("Carta de Renuncia", new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
            encabezado.setAlignment(Element.ALIGN_CENTER);
            documento.add(encabezado);

            // Contenido de la carta de renuncia
            documento.add(new Paragraph(""));

            Paragraph cuerpoCarta = new Paragraph();
            cuerpoCarta.add(new Paragraph("Yo, " + info.getNombre()+ " " + info.getApellido()+ " " + info.getAmaterno() + ", identificado con ID " + info.getIdUser() + ", presento mi renuncia"));
            cuerpoCarta.add(new Paragraph("a la empresa Thales Planta Cuernavaca."));
            cuerpoCarta.add(new Paragraph(""));

            cuerpoCarta.add(new Paragraph("Motivo de la renuncia: _______________________________"));
            cuerpoCarta.add(new Paragraph(""));

            cuerpoCarta.add(new Paragraph("Agradezco la oportunidad de haber formado parte de la empresa y de haber contribuido a su desarrollo."));
            cuerpoCarta.add(new Paragraph(""));

            cuerpoCarta.add(new Paragraph("Atentamente,"));
            cuerpoCarta.add(new Paragraph(""));
            cuerpoCarta.add(new Paragraph(""+info.getNombre() + " " + info.getApellido()+ " " + info.getAmaterno()));
            cuerpoCarta.add(new Paragraph(""));

            documento.add(cuerpoCarta);

            // Pie de página
            Paragraph piePagina = new Paragraph("Thales Planta Cuernavaca | Dirección: C. 9 Este 192, Civac, 62578 Jiutepec, Mor. | Teléfono: 777 329 3900", new Font(Font.FontFamily.TIMES_ROMAN, 10));
            piePagina.setAlignment(Element.ALIGN_CENTER);
            documento.add(piePagina);

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
