<%-- 
    Document   : menu
    Created on : 9 nov. 2023, 12:52:40
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<br>
<style>
    .navbar {
        border-radius: 10px; /* Puedes ajustar este valor según tus preferencias */
    }
    
    
</style>

<script>
    $(document).ready(function () {
        $('.navbar').click(function () {
            $('.navbar-collapse').collapse('toggle');
        });
    });
</script>
<nav class="navbar navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Menú</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.servletContext.contextPath}/vistas/menu1.jsp">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/vistas/clientes.jsp">Usuarios</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/vistas/reporteMaquina.jsp">Reporte de Máquinas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/vistas/perdidas.jsp">Gestión de perdidas</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Reporte de Máquinas
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
                
            </ul>
            
        </div>
    </div>
</nav>
