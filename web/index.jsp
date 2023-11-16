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
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Bootstrap JS y Popper.js (requeridos para los componentes con JavaScript) -->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>

    </head>
    
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="#">Bienvenido a Thales Dis</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp" style="font-size: 24px;">Casa <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="vistas/IniciarSesion.jsp" style="font-size: 24px;">Iniciar Sesión</a>
                </li>
                
            </ul>
            <span class="navbar-text" style="font-size: 24px;">
                Thales Group
            </span>
        </div>
    </nav>



    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

        <div class="container">


            <div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Inicio de Sesión</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <p>¿Desea iniciar sesión para acceder a funcionalidades adicionales?</p>
                        </div>
                        <div class="modal-footer">
                            <a href="${pageContext.servletContext.contextPath}/vistas/IniciarSesion.jsp" class="btn btn-primary">Iniciar Sesión</a>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Continuar Navegando</button>
                        </div>
                    </div>
                </div>
            </div>


            <title>Bienvenido a Thales Group!</title>
            <br><br><br><br>

            <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://www.thalesgroup.com/sites/default/files/styles/max1600/public/database/assets/images/2019-07/DigiSec_Home_Banner_2.jpg.webp?itok=Ql1mrO9z" class="d-block w-100 img-fluid" alt="...">
                        <div class="carousel-caption d-none d-md-block bg-overlay">
                            <h1>Damos soporte a nuestras operaciones</h1>
                            <p>Los países, las ciudades y los operadores de transporte confían en las soluciones de transporte terrestre de Thales para adaptarse a la rápida urbanización y satisfacer las nuevas demandas de movilidad, a nivel local, entre ciudades y a través de las fronteras nacionales.</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="https://www.thalesgroup.com/sites/default/files/styles/max1600/public/database/assets/images/2022-02/Banner-Thales-Transport_0.jpg.webp?itok=JHaxD3Xs" class="d-block w-100 img-fluid" alt="...">
                        <div class="carousel-caption d-none d-md-block bg-overlay">
                            <h1>La tecnología de Thales facilitará el transporte de mercancías en Cádiz</h1>
                            <p>Thales participa en el desarrollo del transporte de mercancías en el ramal ferroviario de acceso a la dársena del Bajo de la Cabezuela, en Cádiz.</p>
                            <p>Con un presupuesto de 7,29 millones de euros, este contrato con Adif representa un tramo de vía única de 4,4 kilómetros en ancho ibérico y forma parte de las actuaciones previstas para la línea Sevilla-Cádiz.
                            </p>
                        </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
            <br><br><br><br>
            <!-- Contiene un artículo -->
            <!-- Pruebas -->
            <style>
                /* Estilos CSS directamente en el JSP */
                body {
                    font-family: 'Arial', sans-serif;
                    line-height: 1.6;
                    color: #333;
                }
                .bg-overlay {
                    background: rgba(0, 0, 0, 0.7); /* Fondo gris con opacidad */
                    color: white; /* Texto en color blanco para contrastar */
                    padding: 20px; /* Ajusta según sea necesario */
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
            <img src="https://1000marcas.net/wp-content/uploads/2022/06/Thales-Logo.jpg" class="img-fluid" alt="..." width="410" height="100">
            <div class="d-flex flex-row">
                <div class="card mx-4" style="width: 18rem;">
                    <img src="https://www.thalesgroup.com/sites/default/files/styles/max1600/public/database/assets/images/2022-04/Thales%20Smart%20sustainable%20train_0.jpg.webp?itok=plZm7eWa" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">¿Qué es exactamente un tren autónomo?</h5>
                        <p class="card-text">Un tren totalmente autónomo es aquel que puede interpretar su entorno, tomar decisiones y conducirse a sí mismo según su objetivo, sin necesidad de intervención humana.</p>
                        <a href="https://www.thalesgroup.com/es/el-mundo/transport/magazine/trenes-inteligentes-sostenibles" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
                <br><br>
                <div class="card mx-4" style="width: 18rem;">
                    <img src="https://www.thalesgroup.com/sites/default/files/styles/max1600/public/database/assets/images/2022-10/GettyImages-108315401_light.jpg.webp?itok=eE86RNgt" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Porqué el 5G es tan importante para los ferrocarriles?</h5>
                        <p class="card-text">El 5G cambia las reglas del juego tanto para las líneas prncipales de ferrocarriles como para los metros. Dos características lo hacen especialmente atractivo:</p>
                        <a href="https://www.thalesgroup.com/es/el-mundo/transport/news/bienvenido-al-ferrocarril-5g" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
                <br><br>
                <div class="card mx-4" style="width: 18rem;">
                    <img src="https://www.thalesgroup.com/sites/default/files/styles/max1600/public/database/assets/images/2019-04/nubia_0.jpg.webp?itok=PxCIqB_x" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Thales presenta sus innovaciones aeroespaciales</h5>
                        <p class="card-text">hales presentará su solución para control de tráfico aéreo, vigilancia y defensa aérea en FAMEX 2019.</p>
                        <a href="https://www.thalesgroup.com/es/america-latina/press-release/thales-presenta-sus-innovaciones-aeroespaciales-durante-famex-2019" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
                <br><br>
                <div class="card mx-4" style="width: 18rem;">
                    <img src="https://www.thalesgroup.com/sites/default/files/styles/product_page_slices_hero_1920x500_/public/database/assets/images/2023-01/119206011_L.jpg?itok=4EKQLcBn" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Pagina Oficial</h5>
                        <p class="card-text">Thales se enorgullece de su distinguido historial de asociaciones sólidas y duraderas en México, que se remonta a 1965.</p>
                        <a href="https://www.thalesgroup.com/es/countries/americas/thales-mexico" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
            </div>
            <br>

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
                <br><br>
                <div class="ratio ratio-16x9">
                    <iframe src="https://www.youtube.com/embed/QXa5tpcH6Jg" title="YouTube video" allowfullscreen></iframe>
                </div>
            </div>
            <%@include file="../template/footer.jsp" %>

    </body>
</html>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script>
    // Muestra el modal al cargar la página
    window.onload = function () {
        var myModal = new bootstrap.Modal(document.getElementById('myModal'));
        myModal.show();
    };
</script>
