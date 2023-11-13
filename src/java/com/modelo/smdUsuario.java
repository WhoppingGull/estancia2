
package com.modelo;

/**
 *
 * @author Diego
 */
public class smdUsuario {
    private int idUser;
    private String nombre;
    private String apellido;
    private String amaterno;
    private int activo;
    private String grupo;
    private String sexo;
    private String telefono;
    private int edad;
    private String contraseña;

    public smdUsuario() {
    }

    public smdUsuario(int idUser, String nombre, String apellido, String amaterno, int activo, String grupo, String sexo, String telefono, int edad, String contraseña) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.amaterno = amaterno;
        this.activo = activo;
        this.grupo = grupo;
        this.sexo = sexo;
        this.telefono = telefono;
        this.edad = edad;
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
    

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "smdUsuario{" + "idUser=" + idUser + ", nombre=" + nombre + ", apellido=" + apellido + ", amaterno=" + amaterno + ", activo=" + activo + ", grupo=" + grupo + ", sexo=" + sexo + ", telefono=" + telefono + ", edad=" + edad + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
}
