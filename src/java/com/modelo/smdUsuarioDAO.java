package com.modelo;

import com.conexion.Conexion;
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
        } catch ( Exception e) {
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
}
