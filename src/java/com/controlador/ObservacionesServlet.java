/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controlador;

import com.modelo.smdObservaciones;
import com.modelo.smdObservacionesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
@WebServlet(name = "ObservacionesServlet", urlPatterns = {"/ObservacionesServlet"})
public class ObservacionesServlet extends HttpServlet {

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
            // Captura de datos
            String strCodigoObservacion = request.getParameter("txtCodigo");
            int codigoObservacion = 0;  // Valor predeterminado si la cadena está vacía
            if (strCodigoObservacion != null && !strCodigoObservacion.isEmpty()) {
                try {
                    codigoObservacion = Integer.parseInt(strCodigoObservacion);
                } catch (NumberFormatException e) {
                    // Manejar la excepción o mostrar un mensaje de error
                    System.out.println("Error de conversión de código de observación: " + e.getMessage());
                }
            }

            String observacion1 = request.getParameter("txtObservacion");

            String strFecha = request.getParameter("txtFecha");
// Aquí puedes realizar la conversión de String a java.util.Date según tus necesidades

            String strIdSmdReporteMaquina = request.getParameter("txtIdSmdReporteMaquina");
            int idSmdReporteMaquina = 0;
            if (strIdSmdReporteMaquina != null && !strIdSmdReporteMaquina.isEmpty()) {
                try {
                    idSmdReporteMaquina = Integer.parseInt(strIdSmdReporteMaquina);
                } catch (NumberFormatException e) {
                    System.out.println("Error de conversión de ID de reporte de máquina: " + e.getMessage());
                }
            }

            smdObservaciones observacion = new smdObservaciones(codigoObservacion, observacion1, strFecha, idSmdReporteMaquina);
            System.out.println("Observación en servlet: " + observacion.toString());
            smdObservacionesDAO observacionDAO = new smdObservacionesDAO();
            String mensaje = "Error";
            int res;
            boolean buscar = false;

            try {
                if (request.getParameter("btnGuardar") != null) {
                    res = observacionDAO.insertarObservacion(observacion);
                    if (res != 0) {
                        mensaje = "Registro de observación agregado";
                    }
                } else if (request.getParameter("btnEditar") != null) {
                    res = observacionDAO.modificarObservacion(observacion);
                    System.out.println("Entro al boton de editar:");
                    if (res != 0) {
                        mensaje = "Registro de observación modificado";
                    }
                } else if (request.getParameter("btnEliminar") != null) {
                    res = observacionDAO.eliminarObservacion(observacion);
                    if (res != 0) {
                        mensaje = "Registro de observación eliminado";
                    }
                } else if (request.getParameter("btnBuscarObservacion") != null) {
                    // Lógica para buscar observación
                } else if (request.getParameter("btnImprimir") != null) {
                    System.out.println("Entro a imprimir");
                    res = observacionDAO.imprimir(observacion);
                    if (res != 0) {
                        mensaje = "Se genero el reporte de forma exitosa";
                        request.getRequestDispatcher("/vistas/imprimirReporte.jsp").forward(request, response);
                    }
                }

                if (request.getParameter("btnGuardarCrear") != null) {
                    res = observacionDAO.insertarObservacion(observacion);
                    if (res != 0) {
                        mensaje = "Registro de observación agregado desde el btnGuardarCrear";
                    }
                }

                request.setAttribute("message", mensaje);
                request.getRequestDispatcher("/vistas/observaciones.jsp").forward(request, response);

            } catch (Exception e) {
                System.out.println("Error de inserción de datos: " + e.getLocalizedMessage());
                System.out.println("Error en servlet: " + e);
            }

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
