<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="Xenon Boostrap Admin Panel" />
        <meta name="author" content="" />

        <title>DISTRA-MIT</title>

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Arimo:400,700,400italic">
        <link rel="stylesheet" href="../assets/css/fonts/linecons/css/linecons.css">
        <link rel="stylesheet" href="../assets/css/fonts/fontawesome/css/font-awesome.css">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../assets/css/xenon-core.css">
        <link rel="stylesheet" href="../assets/css/xenon-forms.css">
        <link rel="stylesheet" href="../assets/css/xenon-components.css">
        <link rel="stylesheet" href="../assets/css/xenon-skins.css">
        <link rel="stylesheet" href="../assets/css/custom.css">

        <script src="../assets/js/jquery-1.11.1.min.js"></script>
        <script src="menuScript.js"></script>


        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
                <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->


    </head>
    <body class="page-body">

        <nav class="navbar horizontal-menu navbar-fixed-top"><!-- set fixed position by adding class "navbar-fixed-top" -->

            <div class="navbar-inner">

                <!-- Navbar Brand -->
                <div class="navbar-brand">
                    <a href="index.html" class="logo">
                        <img src="../assets/images/mitforsite.png" width="80" alt="" class="hidden-xs" />
                        <img src="../assets/images/mitforsitemini.png" width="80" alt="" class="visible-xs" />
                    </a>
                </div>

                <!-- Mobile Toggles Links -->
                <div class="nav navbar-mobile">

                    <!-- This will toggle the mobile menu and will be visible only on mobile devices -->
                    <div class="mobile-menu-toggle">

                        <a href="#" data-toggle="user-info-menu-horizontal">
                            <i class="fa-key"></i>
                        </a>

                        <a href="#" data-toggle="mobile-menu-horizontal">
                            <i class="fa-bars"></i>
                        </a>
                    </div>
                </div>

                <div class="navbar-mobile-clear"></div>

                <!-- main menu -->

                <ul class="navbar-nav">
                    <li>
                        <a href="index.html">
                            <i class="fa fa-home"></i>
                            <span class="title">Home</span>
                        </a>
                    </li>
                    <li>
                        <a href="offertaFormativa.html">
                            <i class="linecons-desktop"></i>
                            <span class="title">Offerta Formativa</span>
                        </a>
                    </li>
                    <li>
                        <a href="gestioneTesi.html">
                            <i class="linecons-graduation-cap"></i>
                            <span class="title">Gestione Tesi</span>
                        </a>
                    </li>
                    <li>
                        <a href="gestioneTirocinio.html">
                            <i class="linecons-megaphone"></i>
                            <span class="title">Gestione Tirocinio</span>
                        </a>
                    </li>
                    <li class="opened active">
                        <a href="dottorato.html">
                            <i class="linecons-lightbulb"></i>
                            <span class="title">Dottorato</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="linecons-globe"></i>
                            <span class="title">Links</span>
                        </a>
                        <ul>
                            <li>
                                <a href="http://www.magistralemit.unisa.it/" target="_blank">
                                    <span class="title">DISTRA-MIT</span>
                                </a>
                            </li>
                            <li>
                                <a href="https://esse3web.unisa.it/unisa/Start.do" target="_blank">
                                    <span class="title">Esse3</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- notifications and other links -->
                <ul class="nav nav-userinfo navbar-right">
                    <li>
                        <a href="register.html">
                            <i class="fa-pencil"></i>
                            <span class="title">Registrazione</span>
                        </a>
                    </li>
                    <li>
                        <a href="login.html">
                            <i class="fa-user"></i>
                            <span class="title">Login</span>
                        </a>
                    </li>
                </ul>

            </div>

        </nav>
        <div class="page-container">
            <div class="sidebar-menu toggle-others">
                <div class="sidebar-menu-inner">	
                    <ul id="main-menu" class="main-menu">
                        <!-- add class "multiple-expanded" to allow multiple submenus to open -->
                        <!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
                        <li class="opened active">
                            <a href="#">
                                <i class="linecons-desktop"></i>
                                <span class="title">Home</span>
                            </a>
                        </li>
                        <li id="funzionalita1Permission_0">
                            <a href="#">
                                <i class="linecons-user"></i>
                                <span class="title">Profilo</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="linecons-tag"></i>
                                <span class="title">Curriculum</span>
                            </a>
                        </li>
                        <li id="funzionalita3Permission_0">
                            <a href="#">
                                <i class="linecons-calendar"></i>
                                <span class="title">Calerndario <br> corsi e seminari</span>
                            </a>

                        </li>
                        <li id="funzionalita3Permission_0">
                            <a href="#">
                                <i class="linecons-star"></i>
                                <span class="title">Collegio docenti</span>
                            </a>

                        </li>
                        <li id="funzionalita3Permission_0">
                            <a href="#">
                                <i class="linecons-key"></i>
                                <span class="title">Pannello <br> amministratore</span>
                            </a>

                        </li>
                    </ul>
                </div>
            </div>

            <!--BODY-->


            <div class="main-content" id="content">

            </div>




            <!-- Bottom Scripts -->
            <script src="../assets/js/bootstrap.min.js"></script>
            <script src="../assets/js/TweenMax.min.js"></script>
            <script src="../assets/js/resizeable.js"></script>
            <script src="../assets/js/joinable.js"></script>
            <script src="../assets/js/xenon-api.js"></script>
            <script src="../assets/js/xenon-toggles.js"></script>



            <!-- JavaScripts initializations and stuff -->
            <script src="../assets/js/xenon-custom.js"></script>
        </div>
    </body>
</html>
