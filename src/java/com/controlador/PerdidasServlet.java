/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controlador;

import com.modelo.smdPerdidas;
import com.modelo.smdPerdidasDAO;
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
@WebServlet(name = "PerdidasServlet", urlPatterns = {"/PerdidasServlet"})
public class PerdidasServlet extends HttpServlet {

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
              //captura de datos
        String strCodigoPerdida = request.getParameter("txtCodigo");
        int codigoPerdida = 0;  // Valor predeterminado si la cadena está vacía
        if (strCodigoPerdida != null && !strCodigoPerdida.isEmpty()) {
            try {
                codigoPerdida = Integer.parseInt(strCodigoPerdida);
            } catch (NumberFormatException e) {
                // Manejar la excepción o mostrar un mensaje de error
                System.out.println("Error de conversión de código de pérdida: " + e.getMessage());
            }
        }

        String strIdSmdProceso = request.getParameter("txtIdProceso");
        int idSmdProceso = 0;  
        if (strIdSmdProceso != null && !strIdSmdProceso.isEmpty()) {
            try {
                idSmdProceso = Integer.parseInt(strIdSmdProceso);
            } catch (NumberFormatException e) {
                System.out.println("Error de conversión de ID de proceso: " + e.getMessage());
            }
        }

        String strIdStation = request.getParameter("txtIdEstacion");
        int idStation = 0;  
        if (strIdStation != null && !strIdStation.isEmpty()) {
            try {
                idStation = Integer.parseInt(strIdStation);
            } catch (NumberFormatException e) {
                System.out.println("Error de conversión de ID de estación: " + e.getMessage());
            }
        }

        String strQty = request.getParameter("txtCantidad");
        int qty = 0;  
        if (strQty != null && !strQty.isEmpty()) {
            try {
                qty = Integer.parseInt(strQty);
            } catch (NumberFormatException e) {
                System.out.println("Error de conversión de cantidad: " + e.getMessage());
            }
        }

        String strEstatus = request.getParameter("txtEstatus");
        int estatus = 0;  
        if (strEstatus != null && !strEstatus.isEmpty()) {
            try {
                estatus = Integer.parseInt(strEstatus);
            } catch (NumberFormatException e) {
                System.out.println("Error de conversión de estatus: " + e.getMessage());
            }
        }

        String perdidaTiempo = request.getParameter("txtFechaPerdida");

        

        smdPerdidas perdida = new smdPerdidas(codigoPerdida, idSmdProceso, idStation, qty, estatus, perdidaTiempo);
        System.out.println("perdida en servlet: "+ perdida.toString());
        smdPerdidasDAO perdidaDAO = new smdPerdidasDAO();
        String mensaje = "Error";
        int res;
        boolean buscar = false;

        if (request.getParameter("btnGuardar") != null) {
            res = perdidaDAO.insertarPerdida(perdida);
            if (res != 0) {
                mensaje = "Registro de pérdida agregado";
            }
        } else if (request.getParameter("btnEditar") != null) {
            res = perdidaDAO.modificarPerdida(perdida);
            System.out.println("Entro al boton de editar:");
            if (res != 0) {
                mensaje = "Registro de pérdida modificado";
            }
        } else if (request.getParameter("btnEliminar") != null) {
            res = perdidaDAO.eliminarPerdida(perdida);
            if (res != 0) {
                mensaje = "Registro de pérdida eliminado";
            }
        } else if (request.getParameter("btnBuscarPerdida") != null) {
            // Lógica para buscar pérdida
        }

        if (request.getParameter("btnGuardarCrear") != null) {
            res = perdidaDAO.insertarPerdida(perdida);
            if (res != 0) {
                mensaje = "Registro de pérdida agregado desde el btnGuardarCrear";
            }
        }else if (request.getParameter("btnImprimir") != null) {
                System.out.println("Entro a imprimir");
                res = perdidaDAO.imprimir(perdida);
                if (res != 0) {
                    mensaje = "Se genero el reporte de forma exitosa";
                    request.getRequestDispatcher("/vistas/imprimirReporte.jsp").forward(request, response);
                }
            }

        request.setAttribute("message", mensaje);
        request.getRequestDispatcher("/vistas/perdidas.jsp").forward(request, response);

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


   

