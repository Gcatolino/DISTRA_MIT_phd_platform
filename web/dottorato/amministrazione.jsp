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
        <script type="text/javascript" src="amministrazione.js"></script>

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

                    <div class="col-sm-4">

                        <!-- Menu per la gestione dei cicli di dottorato --> 
                        <div class="panel panel-default">
                            <div class="panel-heading pointer" id="admin_cycle">
                                Gestione cicli
                            </div>
                            <div class="panel-body hidden_menu" id="admin_menu_cycle">
                                <p class="admin_phdCycle_submenu" id="admin_menu_add_cycle"> Nuovo ciclo </p>
                            </div>
                        </div>

                        <!-- Menu per la gestione dei curriculum di dottorato --> 
                        <div class="panel panel-default">
                            <div class="panel-heading pointer" id="admin_curriculum">
                                Gestione curriculum  
                            </div>
                            <div class="panel-body hidden_menu" id="admin_menu_curriculum">
                                <p class="admin_phdCurriculum_submenu"> Nuovo curriculum </p>  
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-8 hidden_menu" id="admin_add_cycle">

                        <!-- Pannello per creazione di un nuovo ciclo o la modifica di un ciclo selezionato --> 
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h2 id="phdCycleTitle"></h2>
                            </div>
                            <div class="panel-body">

                                <!-- Form contenenti i campi dei cicli di dottorato -->
                                <form id="cycle_form" method="POST">

                                    <!-- Campo di testo relativo all'identificativo numerico di un ciclo -->
                                    <div class="form-group">
                                        <label>Identificativo numerico:</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"></span>
                                            <input type="text" id="phdCycleId" class="form-control" name="idPhdCycle" placeholder="Inserisci il numero del ciclo" required/>
                                        </div>
                                    </div>

                                    <!-- Campo di testo relativo all'anno di attivazione di un ciclo -->
                                    <div class="form-group">
                                        <label>Anno:</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"></span>
                                            <input type="text" id="phdCycleYear" class="form-control" name="year" placeholder="Inserisci l'anno di attivazione del ciclo" required/>
                                        </div>
                                    </div>

                                    <!-- Campo di testo relativo alla descrizione di un ciclo -->
                                    <div class="form-group">
                                        <label>Descrizione:</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"></span>
                                            <textarea id="phdCycleDescription" rows="10" class="form-control" name="description" placeholder="Inserisci la descrizione del ciclo"></textarea>
                                        </div>
                                    </div>

                                    <!-- Campo di testo relativo al coordinatore di un ciclo -->
                                    <div class="form-group">
                                        <label>Coordinatore:</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"></span>
                                            <input list="browsers" id="phdCycleProfessor" class="form-control" name="professor" placeholder="Inserisci il coordinatore del ciclo">
                                            <datalist id="browsers">
                                                <option value="Andrea De Lucia">
                                                <option value="Anna Forte">
                                                <option value="Amelia Nobile">
                                                <option value="Angelo Cassari">
                                            </datalist>

                                        </div>
                                    </div>

                                    <!-- Pannello di feedback dell'operazione -->
                                    <div class="col-sm-12">
                                        <div id="messageControl" align="center">
                                        </div>
                                    </div>

                                    <!-- Pulsanti di invio e reset del form -->
                                    <div class="form-group">
                                        <input type="submit" id="submitPhdCycle" class="btn btn-blue" value="Invia"> 
                                        <button type="reset"  id="resetPhdCycle"  class="btn btn-white">Reset</button>
                                    </div>
                                </form>
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