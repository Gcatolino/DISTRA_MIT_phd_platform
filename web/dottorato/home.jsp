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
        <script type="text/javascript">
            $.get("GetPhdCycleInfo?phdCycleId=15", function (data) {
                parsedData = $.parseJSON(data);
                $("#phdCycle").html(parsedData.phdCycle);
                $("#phdYear").html(parsedData.phdYear);
                $("#phdDescription").html(parsedData.phdDescription);
            });
        </script>
        
        <style>
            .panel-curriculum:hover{
                background-color: #e8eaf6;
            }
        </style>


        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
                <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->


    </head>
    <body class="page-body">

        <jsp:include page="topMenu.jsp" flush="true"/> 
        <div class="page-container">
            <jsp:include page="lateralMenu.jsp"/> 

            <!--BODY-->


            <div class="main-content" id="content">
                <div class="row">

                    <div class="col-sm-8">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1> Dottorato di Ricerca in Management & IT </h1>

                                <h3><span id="phdCycle"></span>° ciclo - Anno <span id="phdYear"></span></h3>
                            </div>
                            <div class="panel-body">
                                <p class="text-justify" id="phdDescription"></p>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="row">
                                <div class="panel-heading"> <h1> Curriculum attivi </h1> </div>
                            </div>
                            <div class="panel-body row">
                            <div class="panel-curriculum col-sm-4 text-center"> 
                                <a> <h4> Economia e Direzione delle Aziende Pubbliche </h4> </a> 
                            </div>
                            <div class="panel-curriculum col-sm-4 text-center"> 
                                <a> <h4> Marketing e Comunicazione </h4>  </a> 
                            </div>
                            <div class="panel-curriculum col-sm-4 text-center"> 
                                <a> <h4> Informatica, Sistemi Informativi e Tecnologie del Software </h4>  </a> 
                            </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1> Avvisi </h1>
                            </div>
                            <div class="panel-body">
                                <p class="text-justify"> Bando dottorato 2015 </p>
                                <p class="text-justify"> Nuovo curriculum di dottorato istituito </p>
                                <p class="text-justify"> Seminario a perto a tutti ... </p>
                                <p class="text-justify"> Altre news tanto per... </p>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1> News </h1>
                            </div>
                            <div class="panel-body">
                                <p class="text-justify"> Bando dottorato 2015 </p>
                                <p class="text-justify"> Nuovo curriculum di dottorato istituito </p>
                                <p class="text-justify"> Seminario a perto a tutti ... </p>
                                <p class="text-justify"> Altre news tanto per... </p>
                            </div>
                        </div>
                    </div>
                </div>



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
