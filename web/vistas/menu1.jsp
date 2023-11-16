<%-- 
    Document   : menu1
    Created on : 14 nov. 2023, 1:12:33
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Menu admin</title>
    </head>
    <body class="d-flex flex-column min-vh-100">



        <!-- Contenedor principal -->
        <div class="container-fluid flex-grow-1">
            <div class="row flex-grow-1">
                <!-- Columna izquierda para el menú -->
                <div class="col-md-3 bg-light">
                    <a href="${pageContext.servletContext.contextPath}/index.jsp" class="btn btn-primary d-block fs-5">Salir</a>
                    <img src="https://1000marcas.net/wp-content/uploads/2022/06/Thales-Logo.jpg" alt="Imagen" class="img-fluid" style="width: 100%; margin-right: 60px;">
                    <div style="width: 100%;">
                        <a href="${pageContext.servletContext.contextPath}/vistas/clientes.jsp" class="btn btn-primary d-block fs-4">Gestión de clientes</a>
                        <br>
                        <a href="${pageContext.servletContext.contextPath}/vistas/reporteMaquina.jsp" class="btn btn-primary d-block fs-4">Gestión de reportes de máquina</a>
                        <br>
                        <a href="${pageContext.servletContext.contextPath}/vistas/perdidas.jsp" class="btn btn-primary d-block fs-4">Gestión de pérdidas</a>
                        <br>
                        <a href="${pageContext.servletContext.contextPath}/vistas/observacion.jsp" class="btn btn-primary d-block fs-4">Pérdidas</a>
                        <br>
                        <a href="${pageContext.servletContext.contextPath}/vistas/MenuImpresiones.jsp" class="btn btn-primary d-block fs-4">Menú Impresiones</a>
                    </div>

                    <!--<ul>
                        <li><a href="#">Opción 1</a></li>
                        <li><a href="#">Opción 2</a></li>
                    <!-- Agrega más opciones según sea necesario 
                </ul>
                <br><br>
                <br><br>
                <br><br>
                <br><br>
                <br><br>
                <br><br>
                <br><br>
                <br><br>
                <br><br>
                <br><br> <br><br> -->
                </div>

                <!-- Columna derecha para la información -->
                <div class="col-md-9">
                    <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active" data-bs-interval="10000">
                                <img src="https://media.licdn.com/dms/image/C4D1BAQG00QoNW1ScWA/company-background_10000/0/1601558286842/thales_portugal_cover?e=2147483647&v=beta&t=5vCIOyL0DWNjOpB-644TBVBDtb1gcKux5fgZW6doJIQ" class="d-block w-100" alt="...">
                                <div class="carousel-caption d-none d-md-block">

                                </div>
                            </div>
                            <div class="carousel-item" data-bs-interval="2000">
                                <img src="https://i.ytimg.com/vi/q1DwbZMwCPs/maxresdefault.jpg" class="d-block w-100" alt="...">
                                <div class="carousel-caption d-none d-md-block">

                                </div>
                            </div>

                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
            </div>
        </div>
                  
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <%@include file="../template/footer.jsp" %>
    </body>
</html>

