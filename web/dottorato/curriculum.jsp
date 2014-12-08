<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="dottorato.css">

        <script src="../assets/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="curriculum.js"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
                <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body class="page-body">

        <!-- Inclusione della pagina contenente il menù superiore --> 
        <jsp:include page="topMenu.jsp" flush="true"/> 
        <div class="page-container">

            <!-- Inclusione della pagina contenente il menù laterale --> 
            <jsp:include page="lateralMenu.jsp"/> 

            <!-- Contenuto della pagina --> 
            <div class="main-content" id="content">

                <div class="row">

                    <div class="col-sm-1"></div>
                    <div class="col-sm-10">

                        <!-- Elenco dei curriculum attivi nel ciclo --> 
                        <div class="panel panel-default">
                            <div class="panel-heading"> <h1> Curriculum </h1> </div>
                            <div class="panel-body row" id="curriculumList"> </div>
                        </div>
                    </div> 
                    <div class="col-sm-1"></div>
                    
                </div>
                <div class="row">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-10">

                    <!-- Descrizione del ciclo di dottorato --> 
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h1> Informatica, Sistemi Informativi e Tecnologie </h1>   
                            <h3> <span id="phdCycle"> </span>Coordinatore: Andrea De Lucia <span id="phdYear"> </span> </h3>
                        </div>
                        <div class="panel-body">
                            <p class="text-justify" id="phdDescription"> Il curriculum, Informatica, Sistemi Informativi e Tecnologie del Software, ha l’obiettivo di formare figure professionali dotate di una preparazione scientifica teorica e pratica idonea ad operare con piena professionalità e competenza, sia in ambito accademico che industriale, nelle varie fasi che caratterizzano la ricerca, lo sviluppo, il controllo di qualità e la produzione nel settore dei sistemi informativi e delle tecnologie del software. In particolare, il corso di dottorato di ricerca mira alla formazione di ricercatori con elevata conoscenza degli aspetti teorici, metodologici, sperimentali e applicativi di settore quali quelli dei sistemi informativi e delle basi di dati, dell’ingegneria del software, dell'ingegneria della conoscenza, del web engineering e dell'interazione uomo-macchina, con una elevata capacità di trasferire i risultati della ricerca in ambito industriale e di applicarli ai settori dell’economia e del management aziendale, del marketing e della comunicazione.
 </p>
                            <p class="text-justify" id="phdProfessor"></p>
                        </div>
                    </div>  
                    </div>
                    <div class="col-sm-1"></div>

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
