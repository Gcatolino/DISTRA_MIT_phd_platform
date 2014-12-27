<%-- 
    Document   : addMission
    Created on : 26-dic-2014, 17.40.28
    Author     : gemmacatolino
--%>

@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="Xenon Boostrap Admin Panel" />
        <meta name="author" content="" />

        <title>DISTRA-MIT Dottorato</title>

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Arimo:400,700,400italic">
        <link rel="stylesheet" href="../assets/css/fonts/linecons/css/linecons.css">
        <link rel="stylesheet" href="../assets/css/fonts/fontawesome/css/font-awesome.css">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../assets/css/xenon-core.css">
        <link rel="stylesheet" href="../assets/css/xenon-forms.css">
        <link rel="stylesheet" href="../assets/css/xenon-components.css">
        <link rel="stylesheet" href="../assets/css/xenon-skins.css">
        <link rel="stylesheet" href="../assets/css/custom.css">
        <link rel="stylesheet" href="style/dottorato.css">

        <script src="../assets/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="script/index.js"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
                <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style>
            hr {
                display: block;
                margin-top: 0.5em;
                margin-bottom: 0.5em;
                margin-right: auto;
                border-style: inset;
                color: #305b90;
                background-color: #305b90;
                height: 3px;
            }
        </style>
    </head>
    <body class="page-body">

        <!-- Inclusione della pagina contenente il menù superiore -->
        <jsp:include page="topMenu.jsp" flush="true"/>
        <div class="page-container">

            <!-- Inclusione della pagina contenente il menù laterale -->
            <jsp:include page="lateralMenu.jsp"/>

            <!-- Contenuto della pagina -->



            <!--Qui chiama servlet update che prende infomazioni person-->
            <form id="#" class="form-horizontal" method="POST" action="#" style='color: #000;font-size:medium ; margin-left: 3%' />
            <div class="form-group">
                <hr>
                <p style="font-size: x-large ; color: #000">Inserisci Mission</p>
                <hr>
                <br>
                <b>Luogo:</b>
                <br>
                <input style='color: #000;font-size:medium'>
                <br>
                <br>
                <b>Descrizione:</b>
                <br>
                <textarea name="testo" rows="5" cols="40"  style='color: #000;font-size:medium ; margin-left: 0%'>
</textarea>
                <br>
                <br>
                <b>Data di Inizio:</b>
                <br>
                <input style='color: #000;font-size:medium' placeholder="gg/mm/aaaa">
                <br>
                <br>
                <b>Data di Fine</b>
                <br>
                <input style='color: #000;font-size:medium' placeholder="gg/mm/aaaa">
                <br>
                <br>
                <br>
                <div align="center">
                                    <input type="submit" id="#" class="btn btn-red" value="Inserisci"> 

                                </div>

            </div>
        </form>
</body>
</html>
