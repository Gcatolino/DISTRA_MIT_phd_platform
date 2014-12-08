<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<div class="sidebar-menu toggle-others">
    <div class="sidebar-menu-inner">	
        <ul id="main-menu" class="main-menu">
            <!-- add class "multiple-expanded" to allow multiple submenus to open -->
            <!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
            <li class="opened active">
                <a href="index.jsp">
                    <i class="linecons-desktop"></i>
                    <span class="title">Home</span>
                </a>
            </li>
            <li id="menu_profilo">
                <a href="#">
                    <i class="linecons-user"></i>
                    <span class="title" id="prova">Profilo</span>
                </a>
            </li>
            <li>
                <a href="curriculum.jsp">
                    <i class="linecons-tag"></i>
                    <span class="title">Curriculum</span>
                </a>
            </li>
            <li id="funzionalita3Permission_0">
                <a href="#">
                    <i class="linecons-calendar"></i>
                    <span class="title">Calendario <br> corsi e seminari</span>
                </a>

            </li>
            <li id="funzionalita3Permission_0">
                <a href="#">
                    <i class="linecons-star"></i>
                    <span class="title">Collegio docenti</span>
                </a>

            </li>
            <li id="funzionalita3Permission_0">
                <a href="amministrazione.jsp">
                    <i class="linecons-key"></i>
                    <span class="title">Pannello <br> amministratore</span>
                </a>

            </li>
        </ul>
    </div>
</div>