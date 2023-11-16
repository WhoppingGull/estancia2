<%-- 
    Document   : imprimirCliente
    Created on : 16 nov. 2023, 10:43:28
    Author     : Diego
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.modelo.smdUsuario" %>
<%@page import="com.modelo.smdUsuarioDAO" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <!-- comment <script type="text/javascript" src="js/d3.v3.min.js"></script>-->

        <title>Imprimir Clientes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
        <%!
            smdUsuarioDAO smdusuariodao = new smdUsuarioDAO();
        %>
        <div class="container">
            <%@include file="../template/menu.jsp" %>
            <hr>
            <div class="row">
                <div class="col-8"> <h1>Imprimir cliente</h1></div>
                <div class="col-4 align self-end">
                    <div class="d-grid gap-2">

                    </div>
                </div>                                
            </div>
            <hr>           
            <div class="table table-hover">
                <table class="table table-striped">
                    <thead>
                    <th>ID Usuario</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Apellido Materno</th>
                    <th>Activo</th>
                    <th>Grupo</th>
                    <th>Sexo</th>
                    <th>Teléfono</th>
                    <th>Edad</th>
                    <th>Contraseña</th>
                    <th>Acciones</th>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<smdUsuario> listausuario = smdusuariodao.mostrarUsuario();
                            if (listausuario != null && !listausuario.isEmpty()) {
                                for (smdUsuario elem : listausuario) {
                        %>
                        <tr>
                            <td class="codigo"><%= elem.getIdUser()%></td>
                            <td class="nombre"><%= elem.getNombre()%></td>
                            <td class="apellido"><%= elem.getApellido()%></td>
                            <td class="amaterno"><%= elem.getAmaterno()%></td>
                            <td class="activo"><%= elem.getActivo()%></td>
                            <td class="grupo"><%= elem.getGrupo()%></td>
                            <td class="sexo"><%= elem.getSexo()%></td>
                            <td class="telefono"><%= elem.getTelefono()%></td>
                            <td class="edad"><%= elem.getEdad()%></td>
                            <td class="contraseña"><%= elem.getContraseña()%></td>
                            <td>                                
                                <button type="submit" name="btnImprimir" class="btn btn-primary btnImprimir" data-bs-toggle="modal" data-bs-target="#exampleModal">Imprimir</button>
                            </td>
                        </tr>
                        <%
                                }
                            } else {
                                out.print("No hay Uusaurios");
                            }
                        %>
                    </tbody>

                </table>

            </div>
        </div>
        <!-- Button trigger modal -->
        <script>

            function mostrarError(elementId, mensaje) {
                var errorDiv = document.createElement("div");
                errorDiv.className = "error-message";
                errorDiv.innerHTML = mensaje;
                var element = document.getElementById(elementId);
                element.parentNode.appendChild(errorDiv);
            }

            function limpiarErrores() {
                var errores = document.getElementsByClassName("error-message");
                while (errores.length > 0) {
                    errores[0].parentNode.removeChild(errores[0]);
                }
            }

            function validarNombre() {
                limpiarErrores();
                var nombre = document.getElementById("txtNombre").value;
                if (!/^[A-Za-z ]{1,20}$/.test(nombre)) {
                    mostrarError("txtNombre", "Ingrese un Nombre válido (solo letras, máximo 20 caracteres).");
                    return false;
                }
                return true;
            }

            function validarApellido() {
                limpiarErrores();
                var apellido = document.getElementById("txtApellido").value;
                if (!/^[A-Za-z ]{1,20}$/.test(apellido)) {
                    mostrarError("txtApellido", "Ingrese un Apellido válido (solo letras, máximo 20 caracteres).");
                    return false;
                }
                return true;
            }

            function validarAmaterno() {
                limpiarErrores();
                var amaterno = document.getElementById("txtAmaterno").value;
                if (!/^[A-Za-z ]{1,20}$/.test(amaterno)) {
                    mostrarError("txtAmaterno", "Ingrese un Apellido Materno válido (solo letras, máximo 20 caracteres).");
                    return false;
                }
                return true;
            }

            function validarTelefono() {
                limpiarErrores();
                var telefono = document.getElementById("txtTelefono").value;
                if (!/^\d{10}$/.test(telefono)) {
                    mostrarError("txtTelefono", "Ingrese un Teléfono válido (10 dígitos numéricos).");
                    return false;
                }
                return true;
            }

            function validarSexo() {
                limpiarErrores();
                var sexo = document.getElementById("txtSexo").value;
                if (!/^[HM]$/.test(sexo.toUpperCase())) {
                    mostrarError("txtSexo", "Ingrese un Sexo válido (solo 'H' o 'M').");
                    return false;
                }
                return true;
            }

            function validarEdad() {
                limpiarErrores();
                var edad = document.getElementById("txtEdad").value;
                if (isNaN(edad) || edad < 18) {
                    mostrarError("txtEdad", "Ingrese una Edad válida (mayor de 18 años).");
                    return false;
                }
                return true;
            }

            function validarCnotra() {
                limpiarErrores();
                var contraseña = document.getElementById("txtContrasena").value;
                if (!/^[A-Za-z0-9]{8,20}$/.test(contraseña)) {
                    mostrarError("txtContrasena", "Ingrese una contraseña (solo letras y números, máximo 20 caracteres).");
                    return false;
                }
                return true;
            }

            function validarFormulario() {
                limpiarErrores();
                return (
                        validarNombre() &&
                        validarApellido() &&
                        validarAmaterno() &&
                        validarTelefono() &&
                        validarSexo() &&
                        validarEdad() &&
                        validarCnotra()
                        // Agrega más funciones de validación si es necesario
                        );
            }
        </script>

        <script>
            function convertirAMayusculas(elemento) {
                elemento.value = elemento.value.toUpperCase();
            }
        </script>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Datos del Operador</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="${pageContext.servletContext.contextPath}/UsuarioServlet" method="POST" role="form" onsubmit="return validarFormulario()">
                            <div class="row">
                                <!-- comment --><div class="col-6">
                                    <label>ID:</label>
                                    <input type="number" name="txtCodigo" class="form-control" id="txtCodigo" value="111" readonly="true">
                                </div>

                                <div class="col-6">
                                    <label>Nombre:</label>
                                    <input type="text" name="txtNombre" class="form-control" id="txtNombre" oninput="convertirAMayusculas(this)"
                                           >
                                </div>
                            </div>
                            <div class="row">
                                <!-- comment <div class="col-6">
                                    <label>No. Empleado:</label>
                                    <input type="text" name="txtNoEmpleado" class="form-control" id="txtNoEmpleado">
                                </div>-->
                                <div class="col-6">
                                    <label>Apellido:</label>
                                    <input type="text" name="txtApellido" class="form-control" id="txtApellido" oninput="convertirAMayusculas(this)">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Apellido Materno:</label>
                                    <input type="text" name="txtAmaterno" class="form-control" id="txtAmaterno" oninput="convertirAMayusculas(this)">
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Grupo:</label>
                                    <select name="txtGrupo"id="txtGrupo" class="form-select">
                                        <option value="A"> A</option>
                                        <option value="B"> B</option>
                                        <option value="C"> C</option>
                                    </select>
                                </div>
                                <div class="col-6">
                                    <label>Sexo:</label>
                                    <input type="text" name="txtSexo" class="form-control" id="txtSexo" oninput="convertirAMayusculas(this)">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Teléfono:</label>
                                    <input type="text" name="txtTelefono" class="form-control" id="txtTelefono">
                                </div>
                                <div class="col-6">
                                    <label>Edad:</label>
                                    <input type="number" min="17" name="txtEdad" class="form-control" id="txtEdad">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Contraseña:</label>
                                    <input type="password" name="txtContrasena" class="form-control" id="txtContrasena" autocomplete="current-password">
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
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="${pageContext.servletContext.contextPath}/js/usuario.js"></script>

        <%
            if (request.getAttribute("message") != null) {
        %>
        <script>alert('<%=request.getAttribute("message")%>')</script>
        <% }%>
    </body>
</html>
