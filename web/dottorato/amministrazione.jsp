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
        <link rel="stylesheet" href="style/dottorato.css">

        <script src="../assets/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="script/amministrazione.js"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
                <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <!-- Finestra di dialogo per il feedback --> 
    <div id="InfoDialog" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" id="InfoTitle"></h4>
                </div>
                <div class="modal-body" id="InfoMessage">
                </div>
            </div>
        </div>
    </div>

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

                            </div>
                        </div>

                        <!-- Menu per la gestione dei curriculum di dottorato --> 
                        <div class="panel panel-default">
                            <div class="panel-heading pointer" id="admin_curriculum">
                                Gestione curriculum  
                            </div>
                            <div class="panel-body hidden_menu" id="admin_menu_curriculum">
                                <p class="admin_phdCurriculum_submenu" id="admin_menu_add_curriculum"> Nuovo curriculum </p>  
                            </div>
                        </div>

                        <!-- Menu per la gestione dei dottorandi --> 
                        <div class="panel panel-default">
                            <div class="panel-heading pointer" id="admin_phd_student">
                                Gestione Dottorandi 
                            </div>
                            <div class="panel-body hidden_menu" id="admin_menu_phd_student">
                                <p class="admin_phd_student_submenu" id="admin_menu_add_phd_student"> Nuovo dottorando </p>  
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-8 hidden_menu" id="admin_add_cycle">

                        <!-- Pannello per creazione di un nuovo ciclo o la modifica di un ciclo selezionato --> 
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <button type="button" class="close" id="buttonCloseCycleDialog">&times;</button>
                                <h2 id="phdCycleTitle"></h2>
                            </div>
                            <div class="panel-body">

                                <!-- Form contenenti i campi dei cicli di dottorato -->
                                <form id="cycle_form">

                                    <!-- Campo di testo relativo all'identificativo numerico di un ciclo -->
                                    <div class="form-group">
                                        <label>Identificativo numerico:</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"></span>
                                            <input type="text" id="phdCycleId" class="form-control" name="idPhdCycle" placeholder="Inserisci il numero del ciclo" pattern="[0-9]{2}" required/>
                                        </div>
                                    </div>

                                    <!-- Campo di testo relativo all'anno di attivazione di un ciclo -->
                                    <div class="form-group">
                                        <label>Anno:</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"></span>
                                            <input type="text" id="phdCycleYear" class="form-control" name="year" placeholder="Inserisci l'anno di attivazione del ciclo" pattern="[0-9]{4}" required/>
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

                                    <!-- Pulsanti di invio e reset del form -->
                                    <div class="form-group">
                                        <input type="button" id="submitPhdCycle" class="btn btn-blue" value="Invia"> 
                                        <input type="button" id="deleteCycleButton" class="btn btn-red" value="Elimina ciclo">
                                        <input type="reset" id="resetCycleButton" class="btn btn-white" value="Reset">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>


                    <div class="col-sm-8 hidden_menu" id="admin_add_curriculum">

                        <!-- Pannello per creazione di un nuovo curriculum o la modifica di un curriculum selezionato --> 
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <button type="button" class="close" id="buttonCloseCurriculumDialog">&times;</button>
                                <h2 id="phdCurriculumTitle"></h2>
                            </div>
                            <div class="panel-body">

                                <!-- Form contenenti i campi dei curriculum di dottorato -->
                                <form id="curriculum_form">

                                    <!-- Campo di testo relativo al nome di un curriculum -->
                                    <div class="form-group">
                                        <label>Nome:</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"></span>
                                            <input type="text" id="phdCurriculumName" class="form-control" name="name" placeholder="Inserisci il nome del curriculum" pattern="[a-z]+" required/>
                                        </div>
                                    </div>

                                    <!-- Campo di testo relativo alla descrizione di un curriculum -->
                                    <div class="form-group">
                                        <label>Descrizione:</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"></span>
                                            <textarea id="phdCurriculumDescription" rows="10" class="form-control" name="description" placeholder="Inserisci la descrizione del curriculum"></textarea>
                                        </div>
                                    </div>

                                    <!-- Campo di testo relativo al coordinatore di un curriculum -->
                                    <div class="form-group">
                                        <label>Coordinatore:</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"></span>
                                            <input list="browsers" id="phdCurriculumProfessor" class="form-control" name="professor" placeholder="Inserisci il coordinatore del curriculum">
                                            <datalist id="browsers">
                                                <option value="Andrea De Lucia">
                                                <option value="Anna Forte">
                                                <option value="Amelia Nobile">
                                                <option value="Angelo Cassari">
                                            </datalist>

                                        </div>
                                    </div>

                                    <!-- Pulsanti di invio e reset del form -->
                                    <div class="form-group">
                                        <input type="button" id="submitPhdCurriculum" class="btn btn-blue" value="Invia"> 
                                        <input type="button" id="deleteCurriculumButton" class="btn btn-red" value="Elimina curriculum">
                                        <input type="reset" id="resetCurriculumButton" class="btn btn-white" value="Reset">
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