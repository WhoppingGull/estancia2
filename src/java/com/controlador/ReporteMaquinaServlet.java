/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controlador;

import com.modelo.smdReporteMaquina;
import com.modelo.smdReporteMaquinaDAO;
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
@WebServlet(name = "ReporteMaquinaServlet", urlPatterns = {"/ReporteMaquinaServlet"})
public class ReporteMaquinaServlet extends HttpServlet {

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
            // Captura de datos
            String strIdReporteMaquina = request.getParameter("txtCodigo");
            int idReporteMaquina = 0;
            if (strIdReporteMaquina != null && !strIdReporteMaquina.isEmpty()) {
                try {
                    idReporteMaquina = Integer.parseInt(strIdReporteMaquina);
                } catch (NumberFormatException e) {
                    System.out.println("Error de conversión de ID de Reporte de Máquina: " + e.getMessage());
                }
            }

            int idProceso = Integer.parseInt(request.getParameter("txtIdProceso"));
            String batchOracle = request.getParameter("txtBatchOracle");
            String batchLocal = request.getParameter("txtBatchLocal");
            String pa = request.getParameter("txtPa");
            int total = Integer.parseInt(request.getParameter("txtTotal"));
            int handled = Integer.parseInt(request.getParameter("txtHandled"));
            int good = Integer.parseInt(request.getParameter("txtGood"));
            int bad = Integer.parseInt(request.getParameter("txtBad"));
            int remain = Integer.parseInt(request.getParameter("txtRemain"));
            int remade = Integer.parseInt(request.getParameter("txtRemade"));
            int lost = Integer.parseInt(request.getParameter("txtLost"));
            int removed = Integer.parseInt(request.getParameter("txtRemoved"));
            int purged = Integer.parseInt(request.getParameter("txtPurged"));
            int recuperados = Integer.parseInt(request.getParameter("txtRecuperados"));
            String creationDate = "now()";

            String mensaje = "Error";
            int res;
            // Crear objeto smdReporteMaquina con los datos obtenidos
            smdReporteMaquina reporte = new smdReporteMaquina(idReporteMaquina, idProceso, batchOracle, batchLocal, pa, total, handled, good, bad, remain, remade, lost, removed, purged, recuperados, creationDate);
            System.out.println("reporte: "+reporte.toString());
            smdReporteMaquinaDAO reporteDAO = new smdReporteMaquinaDAO();
            if (request.getParameter("btnGuardar") != null) {
                res = reporteDAO.insertarReporte(reporte);
                System.out.println("Entro al boton de guardar");
                if (res != 0) {
                    mensaje = "registro agregado";
                }
             
                
            } else if (request.getParameter("btnEditar") != null) {
                res = reporteDAO.modificarReporte(reporte);
                if (res != 0) {
                    mensaje = "registro modificado";
                }
            } else if (request.getParameter("btnEliminar") != null) {
                res = reporteDAO.eliminarReporte(reporte);
                if (res != 0) {
                    mensaje = "registro eliminado";
                }
            }

            request.setAttribute("message", mensaje);
            request.getRequestDispatcher("/vistas/reporteMaquina.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Error de inserción de datos: " + e.getLocalizedMessage());
            System.out.println("Error en servlet: " + e);
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
