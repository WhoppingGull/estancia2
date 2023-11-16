<%-- 
    Document   : IniciarSesion
    Created on : 14 nov. 2023, 0:11:51
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
        <title>Iniciar Sesión</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <%!
            smdUsuarioDAO smdusuariodao = new smdUsuarioDAO();
        %>
        <div class="container mt-5">
            <div class="row">
                <!-- Columna para la imagen -->
                <div class="col-md-6">
                    <br><br><br>
                    <img src="https://1000marcas.net/wp-content/uploads/2022/06/Thales-Logo.jpg" alt="Imagen" class="img-fluid" style="width: 100%;">

                </div>
                <div class="col-md-6">
                    <div class="mx-auto" style="width: 600px; padding: 100px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);">
                        <h1>Iniciar sesión</h1>

                        <form action="${pageContext.servletContext.contextPath}/UsuarioServlet" method="POST" role="form">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Usuario</label>
                                <input type="text" name="user" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" maxlength="10">
                                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputPassword1" class="form-label">Contraseña</label>
                                <input type="password" name="contra" class="form-control" id="exampleInputPassword1" maxlength="10">
                            </div>
                            <div class="mb-3 form-check">
                                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                <label class="form-check-label" for="exampleCheck1">Check me out</label>
                            </div>
                            <button type="submit" name="btnBuscarUsuario"class="btn btn-primary">Acceder</button>
                            <br> <br><!-- comment -->
                            <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal">Agregar</button>                        </form>
                    
                        <br> <br><br> <br>
                         <a href="${pageContext.servletContext.contextPath}/index.jsp" class="btn btn-primary d-block fs-4">Menú principal</a>
                    
                </div>


                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Datos del Operador</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="${pageContext.servletContext.contextPath}/UsuarioServlet" method="POST" role="form">
                                    <div class="row">
                                        <!-- comment --><div class="col-6">
                                            <label>ID:</label>
                                            <input type="number" name="txtCodigo" class="form-control" id="txtCodigo" value="111" readonly="true">
                                        </div>

                                        <div class="col-6">
                                            <label>Nombre:</label>
                                            <input type="text" name="txtNombre" class="form-control" id="txtNombre">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <!-- comment <div class="col-6">
                                            <label>No. Empleado:</label>
                                            <input type="text" name="txtNoEmpleado" class="form-control" id="txtNoEmpleado">
                                        </div>-->
                                        <div class="col-6">
                                            <label>Apellido:</label>
                                            <input type="text" name="txtApellido" class="form-control" id="txtApellido">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-6">
                                            <label>Apellido Materno:</label>
                                            <input type="text" name="txtAmaterno" class="form-control" id="txtAmaterno">
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
                                            <input type="text" name="txtSexo" class="form-control" id="txtSexo">
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
                                            <button type="submit" name="btnGuardarCrear" class="btn btn-success" >Guardar</button>
                                            <button type="button" class="btn btn-dark" data-bs-dismiss="modal">Cancelar</button>

                                        </div>
                                    </div>
                                </form>
                            </div>

                        </div>
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
        <script src="${pageContext.servletContext.contextPath}/js/usuario.js"></script>



        <br><br><br><br><br><br>
        <%@include file="../template/footer.jsp" %>
    </body>

</html>
