
<%-- 
    Document   : imprimirObservacion
    Created on : 16 nov. 2023, 11:08:59
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.modelo.smdObservaciones" %>
<%@page import="com.modelo.smdObservacionesDAO" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <title>Imprecion de Observaciones</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <%@include file="../template/menu.jsp" %>
            <hr>
            <div class="row">
                <div class="col-8"> <h1>Impresión de Observaciones</h1></div>
                <div class="col-4 align self-end">
                    <div class="d-grid gap-2">
                    </div>
                </div>                                
            </div>
            <hr>           
            <div class="table table-hover">
                <table class="table table-striped">
                    <thead>
                    <th>ID Observacion</th>
                    <th>Observacion</th>
                    <th>Fecha</th>
                    <th>ID Reporte Maquina</th>
                    <th>Acciones</th>
                    </thead>
                    <tbody>
                        <%
                            smdObservacionesDAO observacionesDAO = new smdObservacionesDAO();
                            ArrayList<smdObservaciones> listaObservaciones = observacionesDAO.mostrarObservaciones();
                            if (listaObservaciones != null && !listaObservaciones.isEmpty()) {
                                for (smdObservaciones observacion : listaObservaciones) {
                        %>
                        <tr>
                            <td class="idObservacion"><%= observacion.getIdObservacion()%></td>
                            <td class="observacion"><%= observacion.getObservacion()%></td>
                            <td class="fecha"><%= observacion.getFecha()%></td>
                            <td class="idReporteMaquina"><%= observacion.getIdSmdReporteMaquina()%></td>
                            <td>
                                <button type="submit" name="btnImprimir" class="btn btn-primary btnImprimir" data-bs-toggle="modal" data-bs-target="#exampleModal">Imprimir</button>

                            </td>
                        </tr>
                        <%
                                }
                            } else {
                                out.print("No hay Observaciones");
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Modal -->
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Datos de la Observación</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="${pageContext.servletContext.contextPath}/ObservacionesServlet" method="POST" role="form" onsubmit="return validarFormulario()">
                            <div class="row">
                                <div class="col-6">
                                    <label>ID Observación:</label>
                                    <input type="number" name="txtCodigo" class="form-control" id="txtCodigo" readonly="true">
                                </div>
                                <div class="col-6">
                                    <label>Observación:</label>
                                    <input type="text" name="txtObservacion" class="form-control" id="txtObservacion" oninput="convertirAMayusculas(this)">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Fecha:</label>
                                    <input type="datetime-local" name="txtFecha" class="form-control" id="txtFecha">
                                </div>
                                <div class="col-6">
                                    <label>ID Reporte Maquina:</label>
                                    <input type="number" name="txtIdSmdReporteMaquina" class="form-control" id="txtIdSmdReporteMaquina">
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="col-12">
                                    <button type="submit" name="btnImprimir" class="btn btn-black">Imprimir</button>
                                    <button type="button" class="btn btn-dark" data-bs-dismiss="modal">Cancelar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <script>

            function convertirAMayusculas(elemento) {
                elemento.value = elemento.value.toUpperCase();
            }
        </script>

        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="${pageContext.servletContext.contextPath}/js/observacion.js"></script>

        <% if (request.getAttribute("message") != null) {%>
        <script>alert('<%=request.getAttribute("message")%>')</script>
        <% }%>
    </body>
</html>
