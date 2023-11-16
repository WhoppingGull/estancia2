<%-- 
    Document   : footer
    Created on : 14 nov. 2023, 0:30:46
    Author     : Diego
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
        }

        footer {
            background-color: #1a1a1a;
            color: #fff;
            text-align: center;
            padding: 20px 0;
            position: relative;
            bottom: 0;
            width: 100%;
        }

        .footer-logo {
            max-width: 150px;
            height: auto;
        }

        .footer-content {
            max-width: 800px;
            margin: 0 auto;
        }

        .footer-section {
            margin-bottom: 20px;
        }

        .footer-section h4 {
            color: #007BFF;
        }

        .footer-section p {
            font-size: 18px; /* Ajusta el tamaño de la letra según sea necesario */
            color: #007BFF; /* Cambia el color de la letra a azul */
            margin: 0; /* Elimina el margen superior e inferior del párrafo */
        }

        .footer-social-icons a {
            display: inline-block;
            margin: 0 10px;
            color: #fff;
        }
    </style>
        <title>JSP Page</title>
    </head>
    <body>
        <footer>
        <div class="footer-content">
            <div class="footer-section">
                <img src="https://companieslogo.com/img/orig/HO.PA_BIG.D-64886ede.png?t=1646248987" alt="Thales Logo" class="footer-logo">
            </div>
            <div class="footer-section">
                <h4>Contacto</h4>
                <p>Dirección de la empresa: C. 9 Este 192, Civac, 62578 Jiutepec, Mor.<br>
                Teléfono:  777 329 3900<br>
                Correo electrónico: infodesc@thales.com</p>
            </div>
            <div class="footer-section">
                <h4>Síguenos</h4>
                <div class="footer-social-icons">
                    <a href="https://www.thalesgroup.com/es/countries/americas/thales-mexico" target="_blank">Facebook</a>
                    <a href="https://www.thalesgroup.com/es/countries/americas/thales-mexico" target="_blank">Twitter</a>
                    <a href="https://www.thalesgroup.com/es/countries/americas/thales-mexico" target="_blank">LinkedIn</a>
                    <!-- Añade más iconos según sea necesario -->
                </div>
            </div>
        </div>
    </footer>
    </body>
</html>

