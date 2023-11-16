/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package reportepdf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.conexion.Conexion;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author Diego
 */
@WebServlet(name = "pdf", urlPatterns = {"/pdf"})
public class pdf extends HttpServlet  {

   
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("reportepdf/pdf");
        OutputStream our = response.getOutputStream();
        
        try {
            try {
                Document documento =  new Document();
                PdfWriter.getInstance(documento, our);
                
                documento.open();
                Paragraph par1 = new Paragraph();
                Font fonttitulo = new Font(Font.FontFamily.HELVETICA,16);
                par1.add(new Phrase("Reporte de prueba de usuarios.jar",fonttitulo));
                par1.setAlignment((Element.ALIGN_CENTER));
                par1.add(new Paragraph(Chunk.NEWLINE));
                par1.add(new Paragraph(Chunk.NEWLINE));
                documento.add(par1);
                
                 documento.open();
                Paragraph par2 = new Paragraph();
                Font fonttitulo1 = new Font(Font.FontFamily.HELVETICA,16);
                par2.add(new Phrase("Reporte PDF del area de usuarios ",fonttitulo1));
                par2.setAlignment((Element.ALIGN_CENTER));
                par2.add(new Paragraph(Chunk.NEWLINE));
                par2.add(new Paragraph(Chunk.NEWLINE));
                documento.add(par2);
                
                
                documento.close();
            } catch (Exception e) {
                System.out.println("Error de imprimir: " +e);
            }
            
        } catch (Exception e) {
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
