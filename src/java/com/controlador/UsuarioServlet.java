/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.modelo.smdUsuario;
import com.modelo.smdUsuarioDAO;

/**
 *
 * @author Diego
 */
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //captura de datos
            String edadStr = request.getParameter("txtEdad");
            int edad = 0;  // Valor predeterminado si la cadena está vacía
            if (edadStr != null && !edadStr.isEmpty()) {
                try {
                    edad = Integer.parseInt(edadStr);
                } catch (NumberFormatException e) {
                    // Manejar la excepción o mostrar un mensaje de error
                    System.out.println("Error de conversión de edad: " + e.getMessage());
                }
            }

            String strcodigo = request.getParameter("txtCodigo");
            int cod = 0;  // Valor predeterminado si la cadena está vacía
            if (strcodigo != null && !strcodigo.isEmpty()) {
                try {
                    cod = Integer.parseInt(strcodigo);
                } catch (NumberFormatException e) {
                    // Manejar la excepción o mostrar un mensaje de error
                    System.out.println("Error de conversión de edad: " + e.getMessage());
                }
            }

            //int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String amaterno = request.getParameter("txtAmaterno");
            String grupo = request.getParameter("txtGrupo");
            String sexo = request.getParameter("txtSexo");
            String telefono = request.getParameter("txtTelefono");
            //int edad = Integer.parseInt(request.getParameter("txtEdad"));
            String contrasena = request.getParameter("txtContrasena");
            String mensaje = "Error";
            String user = request.getParameter("user");
            String contra = request.getParameter("contra");
            int res;
            boolean buscar = false;
            int activo = 1;
            //System.out.println("cod-"+cod+" edad-"+edad+" nombre-"+nombre+" apellido-"+apellido);
            System.out.println("smdUsuario{" + "idUser=" + cod + ", nombre=" + nombre + ", apellido=" + apellido + ", amaterno=" + amaterno + ", activo=" + activo + ", grupo=" + grupo + ", sexo=" + sexo + ", telefono=" + telefono + ", edad=" + edad + ", contraseña=" + contrasena + '}');
            smdUsuario u = new smdUsuario(cod, nombre, apellido, amaterno, activo, grupo, sexo, telefono, edad, contrasena);

            smdUsuarioDAO udao = new smdUsuarioDAO();
            if (request.getParameter("btnGuardar") != null) {
                res = udao.insertarCliente(u);
                if (res != 0) {
                    mensaje = "registro agregado";
                }
            } else if (request.getParameter("btnEditar") != null) {
                res = udao.modificarUsuario(u);
                System.out.println("Entro al boton de editar");
                if (res != 0) {
                    mensaje = "registro modificado";
                }
            } else if (request.getParameter("btnEliminar") != null) {
                res = udao.eliminarUsuario(u);
                if (res != 0) {
                    mensaje = "registro Eliminado";
                }
            } else if (request.getParameter("btnBuscarUsuario") != null) {
                System.out.println("entro a DAO: " + user + "   " + contra);
                buscar = udao.buscarUsuario(user, contra);
                if (buscar != false) {
                    mensaje = "registro Encontrado en la abse de datos";
                    request.getRequestDispatcher("/vistas/menu1.jsp").forward(request, response);
                }
                mensaje = "Usuario o contraseña incorrecto";
                request.setAttribute("message", mensaje);
                request.getRequestDispatcher("/vistas/IniciarSesion.jsp").forward(request, response);
            
            }else if (request.getParameter("btnImprimir") != null) {
                System.out.println("Entro a imprimir");
                res = udao.imprimir(u);
                if (res != 0) {
                    mensaje = "Se genero el reporte de forma exitosa";
                    request.getRequestDispatcher("/vistas/imprimirCliente.jsp").forward(request, response);
                }
            }

            if (request.getParameter("btnGuardarCrear") != null) {
                res = udao.insertarCliente(u);
                if (res != 0) {
                    mensaje = "registro agregado desde el btnGuardarCrear";
                    request.setAttribute("message", mensaje);
                    request.getRequestDispatcher("/vistas/IniciarSesion.jsp").forward(request, response);

                }
            }
            
           
            
            request.setAttribute("message", mensaje);
            request.getRequestDispatcher("/vistas/clientes.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error de insersion de datos: " + e.getLocalizedMessage());
            System.out.println("error en servlet: " + e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
