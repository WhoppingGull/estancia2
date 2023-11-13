<%-- 
    Document   : index
    Created on : 9 nov. 2023, 12:45:07
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

        <div class="container">
            <%@include file="template/menu.jsp" %>
            <title>Bienvenido a Thales Group!</title>>
            <!-- Contiene un artículo -->
            <!-- Pruebas -->
            <style>
                /* Estilos CSS directamente en el JSP */
                body {
                    font-family: 'Arial', sans-serif;
                    line-height: 1.6;
                    color: #333;
                }

                .container {
                    max-width: 1350px;
                    margin: 0 auto;
                    padding: 20px;
                }

                h1, h2, h3 {
                    color: #007BFF; /* Azul */
                }

                p {
                    margin-bottom: 15px;
                }

                img {
                    max-width: 100%;
                    height: auto;
                    display: block;
                    margin: 0 auto;
                }

                .swiper-container {
                    margin-top: 20px;
                }

                .swiper-slide {
                    padding: 20px;
                    background-color: #f9f9f9; /* Fondo gris claro */
                    border-radius: 8px;
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); /* Sombra ligera */
                }
            </style>

            <div class="container">

                <div class="swiper-wrapper">
                    <!-- Contenido de cada panel -->
                    <div class="swiper-slide">

                        <h2>Thales DIS CIVAC</h2>
                        <br>
                        <img src="https://1000marcas.net/wp-content/uploads/2022/06/Thales-Logo.jpg" alt="" width="310" height="162" />
                        <p>
                            Thales DIS CIVAC es una empresa líder en el sector de la tecnología y la innovación, dedicada a proporcionar soluciones avanzadas en el ámbito de la microelectrónica y la seguridad. Con una presencia global y un enfoque centrado en la excelencia, Thales DIS CIVAC ha marcado un estándar en el desarrollo de tecnologías de vanguardia.
                        </p>
                    </div>
                    <br><br>
                    <div class="swiper-slide">

                        <h3>Misión y Visión</h3>

                        <p>
                            En Thales DIS CIVAC, nuestra misión es impulsar la innovación tecnológica para abordar los desafíos más apremiantes de la sociedad actual. Nos esforzamos por ser líderes en la creación de soluciones seguras y eficientes que impulsen el progreso en diversos sectores, desde la industria hasta la seguridad nacional.
                        </p>

                        <p>
                            Con una visión orientada hacia el futuro, aspiramos a ser reconocidos como pioneros en el desarrollo de tecnologías disruptivas que mejoren la calidad de vida y contribuyan al avance sostenible de las comunidades en todo el mundo.
                        </p>
                    </div>
                    <br><br>
                    <div class="swiper-slide">
                        <h3>Innovación Continua</h3>

                        <p>
                            Thales DIS CIVAC se compromete con la innovación continua. Nuestro equipo de expertos altamente capacitados trabaja en colaboración para diseñar y desarrollar soluciones tecnológicas de vanguardia. Desde la fabricación de chips avanzados hasta la implementación de sistemas de seguridad de última generación, nuestra empresa se encuentra a la vanguardia de la revolución tecnológica.
                        </p>
                    </div>
                    <br><br>
                    <div class="swiper-slide">
                        <h3>Compromiso con la Sostenibilidad</h3>

                        <p>
                            Nos enorgullece nuestro compromiso con la sostenibilidad. En Thales DIS CIVAC, buscamos constantemente maneras de minimizar nuestro impacto ambiental y promover prácticas comerciales responsables. Creemos que la tecnología y la sostenibilidad pueden coexistir, y trabajamos incansablemente para lograr un equilibrio armonioso entre la innovación y la responsabilidad medioambiental.
                        </p>
                    </div>
                    <br><br>
                    <div class="swiper-slide">
                        <h3>Colaboración Global</h3>

                        <p>
                            La colaboración es la piedra angular de nuestro éxito. En Thales DIS CIVAC, fomentamos la colaboración global con socios estratégicos, clientes y comunidades. Creemos en el poder de unir fuerzas para abordar los desafíos globales y crear un impacto positivo duradero.
                        </p>
                    </div>
                </div>
                </body>
                </html>
