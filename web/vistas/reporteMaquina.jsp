<%-- 
    Document   : reporteMaquina
    Created on : 10 nov. 2023, 12:58:07
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.modelo.smdReporteMaquina" %>
<%@page import="com.modelo.smdReporteMaquinaDAO" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <title>Gestión de reportes de máquina</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>

    <script>
        function convertirAMayusculas(elemento) {
            elemento.value = elemento.value.toUpperCase();
        }
    </script>
    <body>
        <%!
            smdReporteMaquinaDAO reportedaos = new smdReporteMaquinaDAO();
        %>
        <div class="container">
            <%@include file="../template/menu.jsp" %>
            <hr>
            <div class="row">
                <div class="col-8"> <h1>Gestión de Reportes</h1></div>
                <div class="col-4 align self-end">
                    <div class="d-grid gap-2">
                        <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal">Agregar</button>
                    </div>
                </div>                                
            </div>
            <hr>           
            <div class="table table-hover">
                <table class="table table-striped">
                    <thead>
                    <th>ID Reporte</th>
                    <th>ID Proceso</th>
                    <th>Batch Oracle</th>
                    <th>Batch Local</th>
                    <th>PA</th>
                    <th>Total</th>
                    <th>Handled</th>
                    <th>Good</th>
                    <th>Bad</th>
                    <th>Remain</th>
                    <th>Remade</th>
                    <th>Lost</th>
                    <th>Removed</th>
                    <th>Purged</th>
                    <th>Recuperados</th>
                    <th>Fecha de Creación</th>
                    <th>Acciones</th>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<smdReporteMaquina> reprote = reportedaos.mostrarReportesMaquina();
                            if (reprote != null && !reprote.isEmpty()) {
                                for (smdReporteMaquina elem : reprote) {
                        %>
                        <tr>
                            <td class="codigo"><%= elem.getIdSmdReporteMaquina()%></td>
                            <td class="idProceso"><%= elem.getIdSmdProceso()%></td>
                            <td class="batchOracle"><%= elem.getBatchOracle()%></td>
                            <td class="batchLocal"><%= elem.getBatchLocal()%></td>
                            <td class="pa"><%= elem.getPa()%></td>
                            <td class="total"><%= elem.getTotal()%></td>
                            <td class="handled"><%= elem.getHandled()%></td>
                            <td class="good"><%= elem.getGood()%></td>
                            <td class="bad"><%= elem.getBad()%></td>
                            <td class="remain"><%= elem.getRemain()%></td>
                            <td class="remade"><%= elem.getRemade()%></td>
                            <td class="lost"><%= elem.getLost()%></td>
                            <td class="removed"><%= elem.getRemoved()%></td>
                            <td class="purged"><%= elem.getPurged()%></td>
                            <td class="recuperados"><%= elem.getRecuperados()%></td>
                            <td class="creationDate"><%= elem.getCreationDate()%></td>
                            <td>
                                <button type="button" class="btn btn-primary btnEditar" data-bs-toggle="modal" data-bs-target="#exampleModal">Edit</button><!-- comment -->
                                <button type="button" class="btn btn-danger btnEliminar" data-bs-toggle="modal" data-bs-target="#exampleModal">Eliminar</button>
                            </td>
                        </tr>
                        <%
                                }
                            } else {
                                out.print("No hay reportes");
                            }
                        %>
                    </tbody>

                </table>

            </div>
        </div>
        <!-- Button trigger modal -->
        <script>
            function validarFormulario() {
                var total = parseInt(document.getElementById("txtTotal").value) || 0;
                var good = parseInt(document.getElementById("txtGood").value) || 0;
                var bad = parseInt(document.getElementById("txtBad").value) || 0;
                var recuperados = parseInt(document.getElementById("txtRecuperados").value) || 0;

                // Validar que los valores no sean mayores al total
                if (good > total || bad > total || recuperados > total) {
                    alert("Los valores de Good, Bad y Recuperados no pueden ser mayores al Total.");
                    return false;
                }

                // Validar que los recuperados no sean mayores a los bad
                if (recuperados > bad) {
                    alert("El valor de Recuperados no puede ser mayor que el valor de Bad.");
                    return false;
                }

                // Agrega más validaciones según sea necesario

                return true;
            }
        </script>



        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Datos del reporte</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="${pageContext.servletContext.contextPath}/ReporteMaquinaServlet" method="POST" role="form" onsubmit="return validarFormulario()">
                            <div class="row">
                                <div class="col-6">
                                    <label>ID Reporte Maquina:</label>
                                    <input type="number" name="txtCodigo" class="form-control" id="txtCodigo" readonly="true">
                                </div>
                                <div class="col-6">
                                    <label>ID Proceso:</label>
                                    <input type="number" name="txtIdProceso" class="form-control" id="txtIdProceso">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Batch Oracle:</label>
                                    <input type="text" name="txtBatchOracle" class="form-control" id="txtBatchOracle" oninput="convertirAMayusculas(this)">
                                </div>
                                <div class="col-6">
                                    <label>Batch Local:</label>
                                    <input type="text" name="txtBatchLocal" class="form-control" id="txtBatchLocal" oninput="convertirAMayusculas(this)">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>PA:</label>
                                    <input type="text" name="txtPa" class="form-control" id="txtPa" oninput="convertirAMayusculas(this)">
                                </div>
                                <div class="col-6">
                                    <label>Total:</label>
                                    <input type="number" name="txtTotal" class="form-control" id="txtTotal">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Handled:</label>
                                    <input type="number" name="txtHandled" class="form-control" id="txtHandled">
                                </div>
                                <div class="col-6">
                                    <label>Good:</label>
                                    <input type="number" name="txtGood" class="form-control" id="txtGood">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Bad:</label>
                                    <input type="number" name="txtBad" class="form-control" id="txtBad">
                                </div>
                                <div class="col-6">
                                    <label>Remain:</label>
                                    <input type="number" name="txtRemain" class="form-control" id="txtRemain">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Remade:</label>
                                    <input type="number" name="txtRemade" class="form-control" id="txtRemade">
                                </div>
                                <div class="col-6">
                                    <label>Lost:</label>
                                    <input type="number" name="txtLost" class="form-control" id="txtLost">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Removed:</label>
                                    <input type="number" name="txtRemoved" class="form-control" id="txtRemoved">
                                </div>
                                <div class="col-6">
                                    <label>Purged:</label>
                                    <input type="number" name="txtPurged" class="form-control" id="txtPurged">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Recuperados:</label>
                                    <input type="number" name="txtRecuperados" class="form-control" id="txtRecuperados">
                                </div>
                                <!-- comment<div class="col-6">
                                    <label>Creation Date:</label>
                                    <input type="datetime-local" name="txtCreationDate" class="form-control" id="txtCreationDate">
                                </div> -->
                            </div>
                            <br><br>
                            <div class="row">
                                <div class="col-12">
                                    <button type="submit" name="btnEditar" class="btn btn-primary">Editar</button>
                                    <button type="submit" name="btnGuardar" class="btn btn-success" >Guardar</button>
                                    <button type="submit" name="btnEliminar" class="btn btn-danger" >Eliminar</button>

                                    <button type="button" class="btn btn-dark" data-bs-dismiss="modal">Cancelar</button>
                                </div>
                            </div>
                        </form>
                    </div>


                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <%
            if (request.getAttribute("message") != null) {
        %>
        <script>alert('<%=request.getAttribute("message")%>')</script>
        <% }%>
        <script src="${pageContext.servletContext.contextPath}/js/reporte.js"></script>
        <%@include file="../template/footer.jsp" %>

    </body>

</html>
