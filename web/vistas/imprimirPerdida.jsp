<%-- 
    Document   : imprimirPerdida
    Created on : 16 nov. 2023, 10:17:56
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.modelo.smdPerdidas" %>
<%@page import="com.modelo.smdPerdidasDAO" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <!-- comment <script type="text/javascript" src="js/d3.v3.min.js"></script>-->

        <title>Imprecion de perdidas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
        <%!
            smdPerdidasDAO smdperdidas = new smdPerdidasDAO();
        %>
        <div class="container">
            <%@include file="../template/menu.jsp" %>
            <hr>
            <div class="row">
                <div class="col-8"> <h1>Impresion de perdidas</h1></div>
                <div class="col-4 align self-end">
                    <div class="d-grid gap-2">
                    </div>
                </div>                                
            </div>
            <hr>           
            <div class="table table-hover">
                <table class="table table-striped">
                    <thead>
                    <th>ID Pérdida</th>
                    <th>ID Proceso</th>
                    <th>ID Estación</th>
                    <th>Cantidad</th>
                    <th>Estatus</th>
                    <th>Fecha Pérdida</th>
                    <th>Acciones</th>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<smdPerdidas> perdidas = smdperdidas.mostrarPerdida();
                            if (perdidas != null && !perdidas.isEmpty()) {
                                for (smdPerdidas perdida : perdidas) {
                        %>
                        <tr>
                            <td class="codigo"><%= perdida.getIdSmdPerdidasProceso()%></td>
                            <td class="idProceso"><%= perdida.getIdSmdProceso()%></td>
                            <td class="idEstacion"><%= perdida.getIdStation()%></td>
                            <td class="cantidad"><%= perdida.getQty()%></td>
                            <td class="estatus"><%= perdida.getEstatus()%></td>
                            <td class="fechaPerdida"><%= perdida.getPerdidaTiempo()%></td>
                            <td>
                                <button type="submit" name="btnImprimir" class="btn btn-primary btnImprimir" data-bs-toggle="modal" data-bs-target="#exampleModal">Imprimir</button>
                            </td>
                        </tr>
                        <%
                                }
                            } else {
                                out.print("No hay pérdidas");
                            }
                        %>
                    </tbody>

            </div>
        </div>
        <!-- Button trigger modal -->
        <style>
            .modal-content {
                background-color: #fff; /* Puedes ajustar el color blanco según tus preferencias */
            }
        </style>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content bg-white">
                    <div class="modal-header">
                        <h5 class="modal-title fs-5" id="exampleModalLabel">Datos de la pérdida</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="${pageContext.servletContext.contextPath}/PerdidasServlet" method="POST" role="form">
                            <div class="row">
                                <div class="col-6">
                                    <label>ID Pérdida:</label>
                                    <input type="number" name="txtCodigo" class="form-control" id="txtCodigo" readonly="true">
                                </div>
                                <div class="col-6">
                                    <label>ID Proceso:</label>
                                    <input type="number" name="txtIdProceso" class="form-control" id="txtIdProceso" min="1" max="5" required>
                                    <div class="invalid-feedback">ID Proceso debe ser del 1 al 5.</div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>ID Estación:</label>
                                    <input type="number" name="txtIdEstacion" class="form-control" id="txtIdEstacion" min="1" max="24" required>
                                </div>
                                <div class="col-6">
                                    <label>Cantidad:</label>
                                    <input type="number" name="txtCantidad" class="form-control" id="txtCantidad" min="0" required>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Estatus:</label>
                                    <input type="number" name="txtEstatus" class="form-control" id="txtEstatus" pattern="[0-1]" title="Ingrese 0 o 1" required>
                                </div>
                                <div class="col-6">
                                    <label>Fecha Pérdida:</label>
                                    <input type="date" name="txtFechaPerdida" class="form-control" id="txtFechaPerdida" readonly>
                                </div>
                            </div>
                            <br><br>
                            <!-- Agrega más campos según tus necesidades -->
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
            // Configurar la fecha actual dinámicamente
            document.getElementById("txtFechaPerdida").valueAsDate = new Date();
            document.addEventListener('DOMContentLoaded', function () {
                document.querySelector('form').addEventListener('submit', function (event) {
                    var idProceso = parseInt(document.getElementById('txtIdProceso').value);
                    var idEstacion = parseInt(document.getElementById('txtIdEstacion').value);
                    var cantidad = parseInt(document.getElementById('txtCantidad').value);

                    var estatus = document.getElementById('txtEstatus').value;

                    if (idProceso < 1 || idProceso > 5) {
                        alert('ID Proceso debe ser del 1 al 5.');
                        event.preventDefault();
                    }

                    if (idEstacion < 1 || idEstacion > 24) {
                        alert('ID Estación debe ser del 1 al 24.');
                        event.preventDefault();
                    }

                    if (cantidad < 0) {
                        alert('La cantidad debe ser mayor o igual a 0.');
                        event.preventDefault();
                    }

                    if (!/^[01]$/.test(estatus)) {
                        alert('Ingrese 0 o 1 para el estatus.');
                        event.preventDefault();
                    }
                });
            });


        </script>


        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <%
            if (request.getAttribute("message") != null) {
        %>
        <script>alert('<%=request.getAttribute("message")%>')</script>
        <% }%>
        <script src="${pageContext.servletContext.contextPath}/js/perdidas.js"></script>




    </body>

</html>
