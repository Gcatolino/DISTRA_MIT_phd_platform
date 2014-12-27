<%-- 
    Document   : login
    Created on : 2-dic-2014, 23.05.03
    Author     : gemmacatolino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:choose>
    <c:when test="${sessionScope.person != null}">
        <c:redirect url="index.jsp" />
    </c:when>
</c:choose>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DISTRA-MIT</title>

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Arimo:400,700,400italic">
        <link rel="stylesheet" href="assets/css/fonts/linecons/css/linecons.css">
        <link rel="stylesheet" href="assets/css/fonts/fontawesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/bootstrap.css">
        <link rel="stylesheet" href="assets/css/xenon-core.css">
        <link rel="stylesheet" href="assets/css/xenon-forms.css">
        <link rel="stylesheet" href="assets/css/xenon-components.css">
        <link rel="stylesheet" href="assets/css/xenon-skins.css">
        <link rel="stylesheet" href="assets/css/custom.css">

        <script src="assets/js/jquery-1.11.1.min.js"></script>

        <c:choose>
            <c:when test="${sessionScope.loginError != null}">
                <script type="text/javascript">
                    $(function () {
                        $("#loginErrorDialog").modal();
                    });
                </script>
            </c:when>
        </c:choose>
    </head>

    <div id="loginErrorDialog" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Errore nell'autenticazione</h4>
                </div>
                <div class="modal-body">
                    <p>
                        Le tue credenziali sono errate.<br>
                        Controlla email e/o password.
                    </p>
                </div>
            </div>
        </div>
    </div>

    <body>
    <body class="page-body">
        <nav class="navbar horizontal-menu navbar-fixed-top"><!-- set fixed position by adding class "navbar-fixed-top" -->

            <div class="navbar-inner">

                <!-- Navbar Brand -->
                <div class="navbar-brand">
                    <a href="index.jsp" class="logo">
                        <img src="assets/images/mitforsite.png" width="80" alt="" class="hidden-xs" />
                        <img src="assets/images/mitforsitemini.png" width="80" alt="" class="visible-xs" />
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
                        <a href="index.jsp">
                            <i class="fa fa-home"></i>
                            <span class="title">Home</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="linecons-desktop"></i>
                            <span class="title">Offerta Formativa</span>
                        </a>		
                    </li>
                    <li>
                        <a href="#">
                            <i class="linecons-graduation-cap"></i>
                            <span class="title">Gestione Tesi</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="linecons-megaphone"></i>
                            <span class="title">Gestione Tirocinio</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
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
                        <a href="register.jsp">
                            <i class="fa-pencil"></i>
                            <span class="title">Registrazione</span>
                        </a>
                    </li>
                    <li class="opened active">
                        <a href="login.jsp">
                            <i class="fa-user"></i>
                            <span class="title">Login</span>
                        </a>
                    </li>
                </ul>

            </div>

        </nav>
        <!--BODY-->

        <div class="page-container">
            <div class="main-content">
                <div class="col-sm-2"></div>
                <div class="col-sm-8">
                    <div class="panel panel-default">

                        <div class="panel-heading">
                            <h3 class="panel-title">Accedi a MITPlatform</h3>
                        </div>

                        <div class="panel-body">
                            <form id="loginForm" method="POST" action="login">

                                <div id="form-group-username" class="form-group">
                                    <label>Username:</label>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa-user"></i></span>
                                        <input type="text" id="username" class="form-control" name="username" placeholder="Inserisci lo username" required/>
                                    </div>
                                    <span id="validate_username" style="color:#cc3f44"></span>
                                </div>

                                <div class="form-group">
                                    <label>Password:</label>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa-key"></i></span>
                                        <input type="password" id="password" class="form-control" name="password" placeholder="Inserisci la password" required/>
                                    </div>
                                    <span id="validate_password" style="color:#cc3f44"></span>
                                </div>

                                <div class="form-group">
                                    <label>
                                        <input type="checkbox" class="cbr cbr-done" id="rememberMeForLogin" checked>
                                        Ricordami la prossima volta
                                    </label>
                                </div>

                                <div class="col-sm-12">
                                    <div id="messageControl" align="center">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <input type="submit" id="signin" class="btn btn-blue" value="Sign in"> 
                                    <button type="reset"  id="reset"  class="btn btn-white">Reset</button>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
                <div class="col-sm-2"></div>
            </div>
        </div>


        <!-- Bottom Scripts -->
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/TweenMax.min.js"></script>
        <script src="assets/js/resizeable.js"></script>
        <script src="assets/js/joinable.js"></script>
        <script src="assets/js/xenon-api.js"></script>
        <script src="assets/js/xenon-toggles.js"></script>
        <script src="assets/js/jquery-ui/jquery-ui.min.js"></script>

        <!-- Imported scripts on this page -->
        <script src="assets/js/tocify/jquery.tocify.min.js"></script>

        <!-- Imported scripts on this page -->
        <script src="assets/js/jquery-validate/jquery.validate.min.js"></script>

        <!-- JavaScripts initializations and stuff -->
        <script src="assets/js/xenon-custom.js"></script>
    </body>
</html>
