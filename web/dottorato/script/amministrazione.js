// Funzione per la gestione del menù
$(document).ready(function () {

    initCycle();
    initCurriculum();
    initPhdStudent();

    $("#admin_cycle").click(function () {
        $("#admin_menu_curriculum").slideUp();
        $("#admin_menu_phd_user").slideUp();
        $("#admin_menu_cycle").slideToggle();
    });
    $("#admin_curriculum").click(function () {
        $("#admin_menu_cycle").slideUp();
        $("#admin_menu_phd_user").slideUp();
        $("#admin_menu_curriculum").slideToggle();
    });
    $("#admin_phd_user").click(function () {
        $("#admin_menu_cycle").slideUp();
        $("#admin_menu_curriculum").slideUp();
        $("#admin_menu_phd_user").slideToggle();
    });



});

// funzione per la gestione dei cicli
function initCycle() {
    $.getJSON("GetPhdCyclesIds", function (data) {

        // ogni ciclo viene aggiungo al menu di gestione ciclo
        $.each(data.cyclesIds, function (index, value) {
            cycleItem = "<p class='admin_phdCycle_submenu' id='" + value + "'>" + value + "° ciclo </p>";
            $("#admin_menu_cycle").append(cycleItem);
        });
        // azioni da compiere per ogni item del menù di gestione cicli
        $(".admin_phdCycle_submenu").click(function () {
            idCycle = $(this).attr('id');
            $(".admin_panel").hide();
            // Azioni da compiere se è stato selezionato un ciclo già esistente
            if (idCycle !== "admin_menu_add_cycle") {

                // Viene mostrato il numero del ciclo selezionato
                $("#phdCycleTitle").html($(this).attr("id") + "° ciclo di dottorato ");
                // Reset form dati ciclo
                $("#cycle_form").get(0).reset();
                $("#curriculumCycleList").empty();
                $('#phdDifferentCurriculumList').find('option').remove();
                $("#professorConnectedCycleList li").remove();
                // Viene mostrati i pulsanti di invio e cancellazione ciclo
                $("#resetCycleButton").hide();
                $("#deleteCycleButton").show();
                $("#addCycleCurriculumDiv").show();
                $("#addCycleProfessorDiv").show();
                // Popolazione form con i dati del ciclo selezionato
                $.getJSON("GetPhdCycle", {phdCycleId: $(this).attr('id')}, function (data) {
                    $("#phdCycleId").val(data.phdCycle);
                    $("#phdCycleYear").val(data.phdYear);
                    $("#phdCycleDescription").val(data.phdDescription);
                    $.getJSON("GetPerson?pSSN=" + data.FK_Professor, function (dataProfessor) {
                        $("#phdCycleProfessor").val(dataProfessor.name + " " + dataProfessor.surname);
                    });
                    // Popolazione dataset con i docenti che possono essere scelti come coorinatori                
                    getPersonList("professor", "#professorCycleList");
                    // Popolazione lista dei curriculum attivi per il ciclo selezionato
                    $.getJSON("GetPhdCurriculumsNamesByPhdCycle", {
                        phdCycleId: data.phdCycle
                    },
                    function (dataCurriculum) {
                        $("#PhdCycleCurriculum").html("Curriculum attivi");
                        $.each(dataCurriculum.curriculumNames, function (index, value) {
                            curriculum = "<li class='list-group-item'>" + value + " <span id='" + value + "' class='pointer deleteCurriculumFromCycle'>Elimina</span></li>";
                            $("#curriculumCycleList").append(curriculum);
                        });
                    });
                    // Popolazione lista di curriculum da aggiungere al ciclo selezionato
                    $.getJSON("GetPhdCurriculumsNamesByDifferentPhdCycle", {phdCycleId: data.phdCycle}, function (dataDifferentCurriculum) {
                        $.each(dataDifferentCurriculum.curriculumNames, function (index, value) {
                            curriculum = "<option id='" + value + "'>" + value + " </option>";
                            $("#phdDifferentCurriculumList").append(curriculum);
                        });
                    });
                    // Popolazione lista dei docenti connessi al ciclo selezionato
                    $.getJSON("GetProfessorByCycle", {
                        phdCycleId: data.phdCycle
                    },
                    function (dataProfessor) {
                        $("#PhdCycleProfessor").html("Professori inseriti");
                        $.each(dataProfessor.professors, function (index, value) {
                            professor = "<li class='list-group-item'>" + value.name + " " + value.surname + " <span id='" + value.ssn + "' class='pointer deleteProfessorFromCycle'>Elimina</span></li>";
                            $("#professorConnectedCycleList").append(professor);
                        });
                    });
                    // Popolazione lista di curriculum da aggiungere al ciclo selezionato
                    $.getJSON("GetPhdProfessorByDifferentCycle", {phdCycleId: data.phdCycle}, function (dataDifferentCurriculum) {
                        $.each(dataDifferentCurriculum.professors, function (index, value) {
                            professor = "<option id='" + value.ssn + "'>" + value.name + " " + value.surname + " </option>";
                            $("#phdDifferentProfessorList").append(professor);
                        });
                    });
                });
                // Azione del pulsante per la modifica di un ciclo
                $("#submitPhdCycle").click(function () {
                    // Invio dati alla servlet per la modifica del ciclo
                    $.getJSON("UpdatePhdCycle",
                            {oldIdPhdCycle: idCycle,
                                newIdPhdCycle: $("#phdCycleId").val(),
                                description: $("#phdCycleDescription").val(),
                                year: $("#phdCycleYear").val(),
                                professor: document.getElementsByName($("#phdCycleProfessor").val()).item(0).getAttribute('id')},
                    function (data) {
                        messageDialog(data.result, "Ciclo modificato correttamente", "Errore nella modifica del ciclo");
                    });
                });
                // Azione del pulsante per la cancellazione di un ciclo
                $("#deleteCycleButton").click(function () {
                    // Invio dati alla servlet per la cancellazione del ciclo
                    $.getJSON("DeletePhdCycle",
                            {idPhdCycle: idCycle},
                    function (data) {
                        messageDialog(data.result, "Ciclo cancellato correttamente", "Errore nella cancellazione del ciclo");
                    });
                });
                // Azione del pulsante per l'inserimento di una classe che collega un ciclo ad un curriculum
                $("#submitDifferentPhdCycle").click(function () {
                    // Invio dati alla servlet per l'inserimento della classe
                    $.getJSON("InsertPhdClass", {
                        idPhdCycle: idCycle,
                        idPhdCurriculum: $("#phdDifferentCurriculumList").find(":selected").val()
                    },
                    function (data) {
                        messageDialog(data.result, "Curriculum inserito correttamente", "Errore nell'inserimento del curriculum");
                    });
                });
                // Azione del pulsante per l'inserimento di una classe che collega un ciclo ad un curriculum
                $("#submitDifferentProfessor").click(function () {
                    // Invio dati alla servlet per l'inserimento della classe
                    $.getJSON("InsertProfessorPhdCycle", {
                        idPhdCycle: idCycle,
                        idProfessor: $("#phdDifferentProfessorList").find(":selected").attr('id')
                    },
                    function (data) {
                        messageDialog(data.result, "Professore inserito correttamente", "Errore nell'inserimento del professore");
                    });
                });
                // Azione del pulsante per la cancellazione di una classe
                $(document).on('click', '.deleteCurriculumFromCycle', function () {
                    // Invio dati alla servlet per la cancellazione della classe
                    $.getJSON("DeletePhdClass", {
                        idPhdCycle: idCycle,
                        idPhdCurriculum: $(this).attr('id')
                    },
                    function (data) {
                        messageDialog(data.result, "Classe cancellata correttamente", "Errore nella cancellazione della classem");
                    });
                });
                // Azione del pulsante per la cancellazione di una classe
                $(document).on('click', '.deleteProfessorFromCycle', function () {
                    // Invio dati alla servlet per la cancellazione della classe
                    $.getJSON("DeleteProfessorFromCycle", {
                        idPhdCycle: idCycle,
                        idProfessor: $(this).attr('id')
                    },
                    function (data) {
                        messageDialog(data.result, "Professore eliminato correttamente", "Errore nella cancellazione professore");
                    });
                });
            }
            // Azioni da compiere se è stato selezionato "inserisci nuovo ciclo"
            else {

                // Viene mostrato il titolo di inserimento ciclo
                $("#phdCycleTitle").html("Nuovo ciclo di dottorato");
                // Reset form dati ciclo
                $("#cycle_form").get(0).reset();
                $("#curriculumCycleList").empty();
                $('#phdDifferentCurriculumList').find('option').remove();
                // Viene nascosto il form per la gestione delle classi e dei docenti
                $("#addCycleCurriculumDiv").hide();
                // Vengono mostrati i pulsanti di invio ed reset
                $("#deleteCycleButton").hide();
                $("#addCycleProfessorDiv").hide();
                $("#resetCycleButton").show();
                // Popolazione dataset con i docenti che possono essere scelti come coorinatori
                getPersonList("professor", "#professorCycleList");
                // Azione del pulsante per l'inserimento di un nuovo ciclo
                $("#submitPhdCycle").click(function () {
                    // Invio dati alla servlet per l'inserimento del ciclo
                    $.getJSON("InsertPhdCycle",
                            {idPhdCycle: $("#phdCycleId").val(),
                                description: $("#phdCycleDescription").val(),
                                year: $("#phdCycleYear").val(),
                                professor: document.getElementsByName($("#phdCycleProfessor").val()).item(0).getAttribute('id')},
                    function (data) {
                        messageDialog(data.result, "Ciclo inserito correttamente", "Errore inserito correttamente");
                    });
                });
            }

            // Visualizzazione del pannello per l'inserimento / la visualizzazione di un ciclo
            $("#admin_add_cycle").show();
            // Azione da compiere per la chiusura del pannello
            $("#buttonCloseCycleDialog").click(function () {
                $("#admin_add_cycle").hide();
            });
        });
    });
}
;
// funzione per la gestione dei curriculum
function initCurriculum() {
    $.getJSON("GetPhdCurriculumsNames", function (data) {

        // ogni curriculum viene aggiungo al menu di gestione curriculum
        $.each(data.curriculumNames, function (index, value) {
            curriculumItem = "<p class='admin_phdCurriculum_submenu' id='" + value + "'>" + value + " </p>";
            $("#admin_menu_curriculum").append(curriculumItem);
        });
        // azioni da compiere per ogni item del menù di gestione curriculum
        $(".admin_phdCurriculum_submenu").click(function () {
            nameCurriculum = $(this).attr('id');
            $(".admin_panel").hide();
            // Azioni da compiere se è stato selezionato un curriculum già esistente
            if (nameCurriculum !== "admin_menu_add_curriculum") {


                // Viene mostrato il nome del curriculum selezionato
                $("#phdCurriculumTitle").html("Dottorato in " + $(this).attr("id"));
                // Viene mostrato solo il pulsante di invio
                $("#resetCurriculumButton").hide();
                $("#deleteCurriculumButton").show();
                $("#addCurriculumProfessorDiv").show();

                $("#professorConnectedCurriculumList li").remove();

                // Popolazione form con i dati del curriculum selezionato
                $.getJSON("GetPhdCurriculum", {phdCurriculumName: $(this).attr('id')}, function (data) {
                    $("#phdCurriculumName").val(data.phdCurriculumName);
                    $("#phdCurriculumDescription").val(data.phdCurriculumDescription);
                    $.getJSON("GetPerson", {pSSN: data.FK_Professor}, function (dataProfessor) {
                        $("#phdCurriculumProfessor").val(dataProfessor.name + " " + dataProfessor.surname);
                    });
                    // Popolazione dataset con i docenti che possono essere scelti come coorinatori
                    getPersonList("professor", "#professorCurriculumList");
                    // Popolazione lista dei docenti connessi al ciclo selezionato

                    $.getJSON("GetProfessorByCurriculum", {
                        phdCurriculumName: nameCurriculum
                    },
                    function (dataProfessor) {
                        $("#PhdCurriculumProfessor").html("Professori inseriti");
                        $.each(dataProfessor.professors, function (index, value) {
                            professor = "<li class='list-group-item'>" + value.name + " " + value.surname + " <span id='" + value.ssn + "' class='pointer deleteProfessorFromCurriculum'>Elimina</span></li>";
                            $("#professorConnectedCurriculumList").append(professor);
                        });
                    });

                    // Popolazione lista di curriculum da aggiungere al ciclo selezionato
                    $.getJSON("getPhdProfessorByDifferentCurriculum", {phdCurriculumName: nameCurriculum}, function (dataDifferentCurriculum) {
                        $.each(dataDifferentCurriculum.professors, function (index, value) {
                            professor = "<option id='" + value.ssn + "'>" + value.name + " " + value.surname + " </option>";
                            $("#phdDifferentProfessorCurriculumList").append(professor);
                        });
                    });
                });
                // Azione del pulsante per la modifica di un curriculum
                $("#submitPhdCurriculum").click(function () {
                    // Invio dati alla servlet per la modifica del curriculum
                    $.getJSON("UpdatePhdCurriculum",
                            {oldNamePhdCurriculum: nameCurriculum,
                                newNamePhdCurriculum: $("#phdCurriculumName").val(),
                                description: $("#phdCurriculumDescription").val(),
                                professor: $("#phdCurriculumProfessor").val()},
                    function (data) {
                        messageDialog(data.result, "Curriculum modificato correttamente", "Errore nella modifica del curriculum");
                    });
                });
                // Azione del pulsante per la cancellazione di un curriculum
                $("#deleteCurriculumButton").click(function () {
                    // Invio dati alla servlet per la modifica del curriculum
                    $.getJSON("DeletePhdCurriculum",
                            {namePhdCurriculum: nameCurriculum},
                    function (data) {
                        messageDialog(data.result, "Curriculum cancellato correttamente", "Errore nella cancellazione del curriculum");
                    });
                });

                // Azione del pulsante per l'inserimento di una classe che collega un ciclo ad un curriculum
                $("#submitDifferentProfessorCurriculum").click(function () {
                    // Invio dati alla servlet per l'inserimento della classe
                    $.getJSON("InsertProfessorPhdCurriculum", {
                        idCurriculum: nameCurriculum,
                        idProfessor: $("#phdDifferentProfessorCurriculumList").find(":selected").attr('id')
                    },
                    function (data) {
                        messageDialog(data.result, "Professore inserito correttamente", "Errore nell'inserimento del professore");
                    });
                });

                // Azione del pulsante per la cancellazione di una classe
                $(document).on('click', '.deleteProfessorFromCurriculum', function () {
                    // Invio dati alla servlet per la cancellazione della classe 
                    $.getJSON("DeleteProfessorFromCurriculum", {
                        idPhdCurriculum: nameCurriculum,
                        idProfessor: $(this).attr('id')
                    },
                    function (data) {
                        messageDialog(data.result, "Professore eliminato correttamente", "Errore nella cancellazione professore");
                    });
                });
            }
            // Azioni da compiere se è stato selezionato "inserisci nuovo curriculum"
            else {

                // Viene mostrato il titolo di inserimento curriculum
                $("#phdCurriculumTitle").html(" Nuovo curriculum di dottorato ");
                // Reset form del curriculum
                $("#curriculum_form").get(0).reset();
                // Viene nascosto il form per la gestione dei docenti
                $("#addCurriculumProfessorDiv").hide();
                // Vengono mostrati i pulsanti di invio ed reset
                $("#deleteCurriculumButton").hide();
                $("#resetCurriculumButton").show();
                // Popolazione dataset con i docenti che possono essere scelti come coorinatori
                getPersonList("professor", "#professorCurriculumList");
                // Azione del pulsante per l'inserimento di un nuovo curriculum
                $("#submitPhdCurriculum").click(function () {
                    // Invio dati alla servlet per l'inserimento del curriculum
                    $.getJSON("InsertPhdCurriculum",
                            {name: $("#phdCurriculumName").val(),
                                description: $("#phdCurriculumDescription").val(),
                                professor: document.getElementsByName($("#phdCurriculumProfessor").val()).item(0).getAttribute('id')},
                    function (data) {
                        messageDialog(data.result, "Curriculum inserito correttamente", "Errore nell'inserimento del curriculum");
                    });
                });
            }

            // Visualizzazione del pannello per l'inserimento / la visualizzazione di un curriculum
            $("#admin_add_curriculum").show();
            // Azione da compiere per la chiusura del pannello
            $("#buttonCloseCurriculumDialog").click(function () {
                $("#admin_add_curriculum").hide();
            });
        });
    });
}
;
// funzione per la gestione dei dottorandi
function initPhdStudent() {

    // azioni da compiere per la gestione dei dottorandi
    $("#admin_menu_add_phd_student").click(function () {

        $(".admin_panel").hide();
        // Viene mostrato il titolo di gestione dottorandi
        $("#phdStudentTitle").html("Assegna classe");
        // Popolazione dataset con i dottorandi a cui sono associate le classi
        getPersonList("phd", "#personList");
        var ssn;
        // Azione da compiere per la visualizzazione del pannello della classe dello studente selezionato
        $("#showPhdStudent").click(function () {

            // Visualizzazione del nome dell'utente selezionato
            name = $("#phdUser").val();
            $("#phdStudentName").html(name);
            // Viene preso il campo SSN dell'utente selezionato
            ssn = document.getElementsByName(name).item(0).text;
            // Viene mostrato il pulsante di inserimento
            $("#updateStudentPhdClass").hide();
            $("#deleteStudentPhdClass").hide();
            $("#insertStudentPhdClass").show();
            // Visualizzazione della classe di appartenenza del dottorando selezionato
            $.getJSON("GetPhdClassBySSN", {SSN: ssn}, function (data) {
                classe = data.FK_PhdCycle + "° ciclo - Dottorato in " + data.FK_PhdCurriculum;
                $("#phdStudentClass").html(classe);
                // Vengono mostrati i pulsanti di modifica e cancellazione classe
                $("#updateStudentPhdClass").show();
                $("#deleteStudentPhdClass").show();
                $("#insertStudentPhdClass").hide();
            });
            // Popolazione della select contenente le classi esitenti
            $.getJSON("GetPhdClassList", function (classdata) {
                $("#phdClassList option").remove();
                $.each(classdata.phdClassList, function (index, value) {
                    phdclass = "<option class='optionItem' id='" + value.idClass + "'> " + value.FK_PhdCycle + "° ciclo - curriculum in " + value.FK_PhdCurriculum + " </option> ";
                    $("#phdClassList").append(phdclass);
                });
            });
            // Visualizzazione del pannello per la gestione della classe
            $("#phdStudent").show();
        });
        // Azione da compiere per l'inserimento di uno studente in una classe
        $("#insertStudentPhdClass").click(function () {
            $.getJSON("InsertStudentPhdClass", {idCycle: $("#phdClassList").find(":selected").attr("id"), SSN: ssn}, function (data) {
                messageDialog(data.result, "Classe assegnata con successo", "Errore nell'assegnazione della classe");
            });
        });
        // Azione da compiere per la modifica di uno studente in una classe
        $("#updateStudentPhdClass").click(function () {
            $.getJSON("UpdateStudentPhdClass", {idCycle: $("#phdClassList").find(":selected").attr("id"), SSN: ssn}, function (data) {
                messageDialog(data.result, "Classe assegnata con successo", "Errore nell'assegnazione della classe");
            });
        });
        // Azione da compiere per la cancellazione di uno studente in una classe
        $("#deleteStudentPhdClass").click(function () {
            $.getJSON("DeleteStudentPhdClass", {SSN: ssn}, function (data) {
                $("#phdStudentClass").html("");
                messageDialog(data.result, "Classe eliminata con successo", "Errore nella cancellazione della classe");
            });
        });
        // Visualizzazione del pannello per l'inserimento / la visualizzazione di uno studente in una classe
        $("#admin_add_phd_student").show();
        // Azione da compiere per la chiusura del pannello
        $("#buttonClosePhdStudentDialog").click(function () {
            $("#admin_add_phd_student").hide();
        });
    });

    // azioni da compiere per la gestione dei dottorandi
    $("#admin_menu_add_phd_tutor").click(function () {
        $(".admin_panel").hide();

// Viene mostrato il titolo di gestione dottorandi
        $("#phdTutorTitle").html("Assegna tutor");
        // Popolazione dataset con i dottorandi a cui sono associate le classi
        getPersonList("phd", "#personTutorList");
        var ssn;
        // Azione da compiere per la visualizzazione del pannello della classe dello studente selezionato
        $("#showTutor").click(function () {

            // Visualizzazione del nome dell'utente selezionato
            name = $("#phdTutor").val();
            $("#studentTutorName").html(name);
            // Viene preso il campo SSN dell'utente selezionato
            ssn = document.getElementsByName(name).item(0).text;
            // Viene mostrato il pulsante di inserimento
            $("#updateStudentTutor").hide();
            $("#deleteStudentTutor").hide();
            $("#insertStudentTutor").show();
            // Visualizzazione della classe di appartenenza del dottorando selezionato
            $.getJSON("GetTutor", {SSN: ssn}, function (data) {
                tutor = "Tutor: " + data.name + " " + data.surname;
                $("#professorTutorName").html(tutor);
                // Vengono mostrati i pulsanti di modifica e cancellazione classe
                $("#updateStudentTutor").show();
                $("#deleteStudentTutor").show();
                $("#insertStudentTutor").hide();
            });

            // Popolazione dataset con i dottorandi a cui sono associate le classi
            $.getJSON("GetPersonByTypeOfAccount",
                    {typeOfAccount: 'professor'},
            function (data) {
                $.each(data.person, function (index, value) {
                    person = "<option class='optionItem' id='" + value.ssn + "' name='" + value.name + " " + value.surname + "' > " + value.name + " " + value.surname + "</option>";
                    $("#phdTutorList").append(person);
                });
            });

            // Visualizzazione del pannello per la gestione della classe
            $("#phdTutorDiv").show();
        });

        // Azione da compiere per l'inserimento di uno studente in una classe
        $("#insertStudentTutor").click(function () {
            $.getJSON("InsertStudentTutor", {idProfessor: $("#phdTutorList").find(":selected").attr("id"), idStudent: ssn}, function (data) {
                messageDialog(data.result, "Tutor assegnato con successo", "Errore nell'assegnazione del tutor");
            });
        });

        // Azione da compiere per la modifica di uno studente in una classe
        $("#updateStudentTutor").click(function () {
            $.getJSON("UpdateStudentTutor", {idProfessor: $("#phdTutorList").find(":selected").attr("id"), idStudent: ssn}, function (data) {
                messageDialog(data.result, "Tutor assegnato con successo", "Errore nell'assegnazione del tutor");
            });
        });

        // Azione da compiere per la cancellazione di uno studente in una classe
        $("#deleteStudentTutor").click(function () {
            $.getJSON("DeleteStudentTutor", {idStudent: ssn}, function (data) {
                $("#professorTutorName").html("");
                messageDialog(data.result, "Tutor eliminato con successo", "Errore nella cancellazione del tutor");
            });
        });

        // Visualizzazione del pannello per l'inserimento / la visualizzazione di uno studente in una classe
        $("#admin_add_phd_tutor").show();
        // Azione da compiere per la chiusura del pannello
        $("#buttonClosePhdTutorDialog").click(function () {
            $("#admin_add_phd_tutor").hide();
        });


    });
}
;
function messageDialog(result, trueMEssage, falseMessage) {
    // Messaggio di inserimento riuscito
    if (result === true) {
        $("#InfoTitle").html(trueMEssage);
        $("#InfoMessage").html("");
        $("#InfoDialog").modal();
        $("#InfoDialog").on('hidden.bs.modal', function () {
            location.reload();
        });
    }
    // Messaggio di inserimento non riuscito
    else {
        $("#InfoTitle").html(falseMessage);
        $("#InfoMessage").html("Controlla i dati.");
        $("#InfoDialog").modal();
    }
}
;
function getPersonList(type, appendTo) {
    // Popolazione dataset con i dottorandi a cui sono associate le classi
    $.getJSON("GetPersonByTypeOfAccount",
            {typeOfAccount: type},
    function (data) {
        $.each(data.person, function (index, value) {
            person = "<option id='" + value.ssn + "' name='" + value.name + " " + value.surname + "' value='" + value.name + " " + value.surname + "'>  ";
            $(appendTo).append(person);
        });
    });
}
;