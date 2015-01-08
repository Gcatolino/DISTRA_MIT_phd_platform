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
                                <p class="admin_phdCycle_submenu" id="admin_menu_add_cycle"> Nuovo ciclo </p>
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
                            <div class="panel-heading pointer" id="admin_phd_user">
                                Gestione Utenti 
                            </div>
                            <div class="panel-body hidden_menu" id="admin_menu_phd_user">
                                <p class="admin_phd_user_submenu" id="admin_menu_add_phd_student"> Assegna classe </p>  
                                <p class="admin_phd_user_submenu" id="admin_menu_add_phd_tutor"> Assegna tutor </p> 
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-8 hidden_menu admin_panel" id="admin_add_cycle">

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
                                            <input list="professorCycleList" id="phdCycleProfessor" class="form-control" name="professor" placeholder="Inserisci il coordinatore del ciclo">
                                            <datalist id="professorCycleList">

                                            </datalist>

                                        </div>
                                    </div>

                                    <!-- Pulsanti di invio e reset del form -->
                                    <div class="form-group">
                                        <input type="button" id="submitPhdCycle" class="btn btn-blue" value="Invia"> 
                                        <input type="button" id="deleteCycleButton" class="btn btn-red" value="Elimina ciclo">
                                        <input type="reset" id="resetCycleButton" class="btn btn-white" value="Reset">
                                    </div>
                            </div>

                            <div class="page-body" style="margin-top: 50px;">

                                <div id="addCycleCurriculumDiv">
                                    <div class="panel-heading">
                                        <h2>Curriculum connessi al ciclo</h2> 
                                    </div>
                                    <div class="form-group">
                                        <h4 id="PhdCycleCurriculum"> </h4>
                                        <ul class="list-group" id="curriculumCycleList">           
                                        </ul>
                                    </div>

                                    <div class="form-group">
                                        <label> <h4> Aggiungi curriculum </h4> </label>
                                        <div class="input-group">
                                            <span class="input-group-addon"></span>
                                            <select class="form-control" id="phdDifferentCurriculumList">
                                            </select></div> <br>
                                        <input type="button" id="submitDifferentPhdCycle" class="btn btn-blue" value="Aggiungi curriculum"> 
                                    </div>
                                </div>
                                </form>
                            </div>

                            <div class="page-body" style="margin-top: 50px;">

                                <div id="addCycleProfessorDiv">
                                    <div class="panel-heading">
                                        <h2>Collegio docenti del ciclo</h2>
                                    </div>
                                    <div class="form-group">
                                        <h4 id="PhdCycleProfessor">  </h4>
                                        <ul class="list-group" id="professorConnectedCycleList">   
                                        </ul>
                                    </div>

                                    <div class="form-group">
                                        <label> <h4> Aggiungi docente </h4> </label>
                                        <div class="input-group">
                                            <span class="input-group-addon"></span>
                                            <select class="form-control" id="phdDifferentProfessorList">
                                            </select> </div> <br>
                                        <input type="button" id="submitDifferentProfessor" class="btn btn-blue" value="Aggiungi docente"> 
                                    </div>
                                </div>
                                </form>
                            </div>

                        </div>
                    </div>


                    <div class="col-sm-8 hidden_menu admin_panel" id="admin_add_curriculum">

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
                                            <input list="professorCurriculumList" id="phdCurriculumProfessor" class="form-control" name="professor" placeholder="Inserisci il coordinatore del curriculum">
                                            <datalist id="professorCurriculumList">

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
                            <div class="page-body" style="margin-top: 50px;">

                                <div id="addCurriculumProfessorDiv">
                                    <div class="panel-heading">
                                        <h2>Collegio docenti del curriculum</h2>
                                    </div>
                                    <div class="form-group">
                                        <h4 id="PhdCurriculumProfessor">  </h4>
                                        <ul class="list-group" id="professorConnectedCurriculumList">   
                                        </ul>
                                    </div>

                                    <div class="form-group">
                                        <label> <h4> Aggiungi docente </h4> </label>
                                        <div class="input-group">
                                            <span class="input-group-addon"></span>
                                            <select class="form-control" id="phdDifferentProfessorCurriculumList">
                                            </select> </div> <br>
                                        <input type="button" id="submitDifferentProfessorCurriculum" class="btn btn-blue" value="Aggiungi docente"> 
                                    </div>
                                </div>
                                </form>
                            </div>
                            
                        </div>
                    </div>

                    <div class="col-sm-8 hidden_menu admin_panel" id="admin_add_phd_student">

                        <!-- Pannello per creazione di un nuovo phdStudent o la modifica di un phdStudent selezionato --> 
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <button type="button" class="close" id="buttonClosePhdStudentDialog">&times;</button>
                                <h2 id="phdStudentTitle"></h2>
                            </div>
                            <div class="panel-body">

                                <!-- Form contenenti i campi dei phdStudent -->
                                <form id="phdUser_form">

                                    <!-- Campo di testo relativo al coordinatore di un curriculum -->
                                    <div class="form-group">
                                        <label>Nome e cognome:</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"></span>
                                            <input list="personList" id="phdUser" class="form-control" name="phdUser" placeholder="Inserisci dottorando">
                                            <datalist id="personList">
                                            </datalist>

                                        </div>
                                    </div>

                                    <!-- Pulsanti di invio e reset del form -->
                                    <div class="form-group">
                                        <input type="button" id="showPhdStudent" class="btn btn-white" value="Assegna classe"> 
                                    </div>
                                </form>
                            </div>

                            <div class="panel-body">

                                <div id="phdStudent" class="hidden_menu">
                                    <h2 id="phdStudentName"> </h2>
                                    <h3 id="phdStudentClass"> </h3>
                                    <form>
                                        <label> Classe: </label>
                                        <span class="input-group-addon"></span>
                                        <select class="form-control" id="phdClassList">
                                        </select>
                                        <br>
                                        <input type="button" id="insertStudentPhdClass" class="btn btn-blue" value="Inserisci"> 
                                        <input type="button" id="updateStudentPhdClass" class="btn btn-blue" value="Modifica"> 
                                        <input type="button" id="deleteStudentPhdClass" class="btn btn-red" value="Elimina">
                                    </form>


                                </div>

                            </div>
                            
                            
                        </div>
                    </div>
                    
                    <div class="col-sm-8 hidden_menu admin_panel" id="admin_add_phd_tutor">

                        <!-- Pannello per creazione di un nuovo phdStudent o la modifica di un phdStudent selezionato --> 
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <button type="button" class="close" id="buttonClosePhdTutorDialog">&times;</button>
                                <h2 id="phdTutorTitle"></h2>
                            </div>
                            <div class="panel-body">

                                <!-- Form contenenti i campi dei phdStudent -->
                                <form id="phdTutor_form">

                                    <!-- Campo di testo relativo al coordinatore di un curriculum -->
                                    <div class="form-group">
                                        <label>Nome e cognome:</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"></span>
                                            <input list="personTutorList" id="phdTutor" class="form-control" name="phdUser" placeholder="Inserisci dottorando">
                                            <datalist id="personTutorList">
                                            </datalist>

                                        </div>
                                    </div>

                                    <!-- Pulsanti di invio e reset del form -->
                                    <div class="form-group">
                                        <input type="button" id="showTutor" class="btn btn-white" value="Assegna tutor"> 
                                    </div>
                                </form>
                            </div>

                            <div class="panel-body">

                                <div id="phdTutorDiv" class="hidden_menu">
                                    <h2 id="studentTutorName"> </h2>
                                    <h4 id="professorTutorName"> </h4> <br>
                                    <form>
                                        <label> Tutor: </label>
                                        <span class="input-group-addon"></span>
                                        <select class="form-control" id="phdTutorList">
                                        </select>
                                        <br>
                                        <input type="button" id="insertStudentTutor" class="btn btn-blue" value="Inserisci"> 
                                        <input type="button" id="updateStudentTutor" class="btn btn-blue" value="Modifica"> 
                                        <input type="button" id="deleteStudentTutor" class="btn btn-red" value="Elimina">
                                    </form>


                                </div>

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
