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

            $(document).ready(function () {
                $("#admin_cycle").click(function () {
                    $("#admin_menu_cycle").slideToggle()();
                });

                $("#admin_curriculum").click(function () {
                    $("#admin_menu_curriculum").slideToggle()();
                });
                
                $("#menu_add_cycle").click(function () {
                    $("#admin_add_cycle").toggle();
                });
                
                $("#menu_modify_cycle").click(function () {
                    $("#admin_modify_cycle").toggle();
                });
                
                $("#menu_delete_cycle").click(function () {
                    $("#admin_delete_curriculum").toggle();
                });
                
                $("#menu_add_curriculum").click(function () {
                    $("#admin_add_curriculum").toggle();
                });
                
                $("#menu_modify_curriculum").click(function () {
                    $("#admin_modify_cycle").toggle();
                });
                
                $("#menu_delete_curriculum").click(function () {
                    $("#admin_delete_curriculum").toggle();
                });
            });

        </script>

        <style>
            .admin_submenu:hover{
                background-color: #e8eaf6;  
            }

            .admin_submenu{
                padding: 10px;
                margin-top: -18px;
            }

            .hidden_menu{
                display: none;
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

                    <div class="col-sm-4">
                        <div class="panel panel-default">
                            <div class="panel-heading" id="admin_cycle">
                                <h2> Gestione cicli </h2>
                            </div>
                            <div class="panel-body hidden_menu" id="admin_menu_cycle">
                                <p class="text-justify admin_submenu" id="menu_add_cycle"> Aggiungi ciclo </p> <br>
                                <p class="text-justify admin_submenu" id="menu_modify_cycle"> Modifica ciclo </p> <br>
                                <p class="text-justify admin_submenu" id="menu_delete_cycle"> Elimina ciclo </p> <br>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading" id="admin_curriculum">
                                <h2> Gestione curriculum </h2>
                            </div>
                            <div class="panel-body hidden_menu" id="admin_menu_curriculum">
                                <p class="text-justify admin_submenu" id="menu_add_curriculum"> Economia e Direzione delle Aziende Pubbliche  <br>
                                    <span style="padding: 0px 30px"> <img src=""> modifica </img> </span> 
                                <span style="padding: 0px 30px" class="linecons-eye"> elimina </span> </p>  <br>
                                <p class="text-justify admin_submenu" id="menu_add_curriculum"> Marketing e Comunicazione </p> <br>
                                <p class="text-justify admin_submenu" id="menu_add_curriculum"> Informatica, Sistemi Informativi e Tecnologie del Software </p> <br>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-8 hidden_menu" id="admin_add_cycle">
                        <div class="panel panel-default">
                            <div class="panel-heading" id="admin_cycle">
                                <h2> Aggiungi ciclo </h2>
                            </div>
                            <div class="panel-body" id="admin_menu_cycle">
                                <h3> Inserisci un nuovo ciclo di dottorato </h3> <br>
                                <label for="idCycle"> Identificativo numerico </label> <br>
                                <input type="text" id="idCycle" size="50" required /> <br>
                                Anno <br>
                                <input type="text" size="50" required /> <br>
                                Descrizione <br>
                                <textarea cols="50" rows="10"> </textarea> <br>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-sm-8 hidden_menu" id="admin_modify_cycle">
                        <div class="panel panel-default">
                            <div class="panel-heading" id="modify_cycle">
                                <h2> Aggiungi ciclo </h2>
                            </div>
                            <div class="panel-body" id="admin_menu_cycle">
                                <p class="text-justify" id=""> bla bla bla bla </p> <br>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-sm-8 hidden_menu" id="admin_delete_cycle">
                        <div class="panel panel-default">
                            <div class="panel-heading" id="delete_cycle">
                                <h2> Aggiungi ciclo </h2>
                            </div>
                            <div class="panel-body" id="admin_menu_cycle">
                                <p class="text-justify" id=""> bla bla bla bla </p> <br>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-sm-8 hidden_menu" id="admin_add_curriculum">
                        <div class="panel panel-default">
                            <div class="panel-heading" id="add_curriculum">
                                <h2> Aggiungi ciclo </h2>
                            </div>
                            <div class="panel-body" id="admin_menu_curriculum">
                                <p class="text-justify" id=""> bla bla bla bla </p> <br>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-sm-8 hidden_menu" id="admin_modify_curriculum">
                        <div class="panel panel-default">
                            <div class="panel-heading" id="modify_curriculum">
                                <h2> Aggiungi ciclo </h2>
                            </div>
                            <div class="panel-body" id="admin_menu_curriculum">
                                <p class="text-justify" id=""> bla bla bla bla </p> <br>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-sm-8 hidden_menu" id="admin_delete_curriculum">
                        <div class="panel panel-default">
                            <div class="panel-heading" id="delete_curriculum">
                                <h2> Aggiungi ciclo </h2>
                            </div>
                            <div class="panel-body" id="admin_menu_curriculum">
                                <p class="text-justify" id=""> bla bla bla bla </p> <br>
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