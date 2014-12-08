<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar horizontal-menu navbar-fixed-top"><!-- set fixed position by adding class "navbar-fixed-top" -->

    <div class="navbar-inner">

        <!-- Navbar Brand -->
        <div class="navbar-brand">
            <a href="index.jsp" class="logo">
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
                <a href="../index.jsp">
                    <i class="fa fa-home"></i>
                    <span class="title">Home</span>
                </a>
            </li>
            <li>
                <a href="../offertaFormativa.html">
                    <i class="linecons-desktop"></i>
                    <span class="title">Offerta Formativa</span>
                </a>
            </li>
            <li>
                <a href="../gestioneTesi.html">
                    <i class="linecons-graduation-cap"></i>
                    <span class="title">Gestione Tesi</span>
                </a>
            </li>
            <li>
                <a href="../gestioneTirocinio.html">
                    <i class="linecons-megaphone"></i>
                    <span class="title">Gestione Tirocinio</span>
                </a>
            </li>
            <li class="opened active">
                <a href="index.jsp">
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
            <c:choose>
                <c:when test="${sessionScope.person == null}">
                    <li>
                        <a href="../register.html">
                            <i class="fa-pencil"></i>
                            <span class="title">Registrazione</span>
                        </a>
                    </li>
                    <li>
                        <a href="../login.jsp">
                            <i class="fa-user"></i>
                            <span class="title">Login</span>
                        </a>
                    </li>
                </c:when>
                <c:when test="${sessionScope.person != null}">
                    <li>
                        <i class="fa-user"></i>
                        <span class="title">Ciao ${sessionScope.person.name}!</span>
                    </li>
                    <li>
                        <a href="../logout">
                            <i class="fa-off"></i>
                            <span class="title">Logout</span>
                        </a>
                    </li>
                </c:when>
            </c:choose>
        </ul>

    </div>

</nav>