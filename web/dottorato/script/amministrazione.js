// funzione per la gestione dei cicli
var initCycle = function () {
    $.get("GetPhdCyclesIds", function (data) {
        parsedData = $.parseJSON(data);

        // ogni ciclo viene aggiungo al menu di gestione ciclo
        var cycleDiv = '<p class="admin_phdCycle_submenu" id="admin_menu_add_cycle"> Nuovo ciclo </p>';
        $("#admin_menu_cycle").append(cycleDiv);
        $.each(parsedData.cyclesIds, function (index, value) {
            cycleDiv = "<p class='admin_phdCycle_submenu del' id='" + value + "'>" + value + "° ciclo </p>";
            $("#admin_menu_cycle").append(cycleDiv);
        });

        // azioni da compiere per ogni item del menù di gestione cicli
        $(".admin_phdCycle_submenu").click(function () {
            idCycle = $(this).attr('id');

            // Azioni da compiere se è stato selezionato un ciclo già esistente
            if (idCycle !== "admin_menu_add_cycle") {

                $("#phdCycleTitle").html($(this).attr("id") + "° ciclo di dottorato ");
                // Viene mostrato solo il pulsante di invio
                $("#deleteCycleButton").show();
                $("#resetCycleButton").hide();
                $("#addCycleCurriculumDiv").show();

                // Popolazione form con i dati del ciclo selezionato
                $("#cycle_form").get(0).reset();
                $("#curriculumCycleList").empty();
                $('#phdDifferentCurriculumList').find('option').remove();

                $.getJSON("GetPhdCycle?phdCycleId=" + $(this).attr('id'), function (data) {
                    $("#phdCycleId").val(data.phdCycle);
                    $("#phdCycleYear").val(data.phdYear);
                    $("#phdCycleDescription").val(data.phdDescription);

                    $.getJSON("GetPerson?pSSN=" + data.FK_Professor, function (dataProfessor) {
                        $("#phdCycleProfessor").val(dataProfessor.name + " " + dataProfessor.surname);
                    });

                    $.getJSON("GetPersonByTypeOfAccount",
                            {typeOfAccount: "professor"},
                    function (dataProfessor) {

                        $.each(dataProfessor.person, function (index, value) {
                            person = "<option label='" + value.ssn + "' name='" + value.name + " " + value.surname + "' value='" + value.name + " " + value.surname + "'>  ";
                            $("#professorCycleList").append(person);
                        });
                    });

                    $.getJSON("GetPhdCurriculumsNames",
                            function (dataDifferentCurriculum) {

                                $.each(dataDifferentCurriculum.curriculumNames, function (index, value) {
                                    curriculum = "<option id='" + value + "'>" + value + " </option>";
                                    $("#phdDifferentCurriculumList").append(curriculum);
                                });
                            });

                    $.getJSON("GetPhdCurriculumsNamesByPhdCycle", {
                        phdCycleId: data.phdCycle
                    },
                    function (dataCurriculum) {
                        $("#PhdCycleCurriculum").html("Curriculum attivi");
                        $.each(dataCurriculum.curriculumNames, function (index, value) {
                            curriculum = "<li class='list-group-item'>" + value + " </li>";
                            $("#curriculumCycleList").append(curriculum);
                        });
                    });

                });

                // Azione del pulsante per la modifica di un ciclo
                $("#submitDifferentPhdCycle").click(function () {

                    // Invio dati alla servlet per la modifica del ciclo
                    $.getJSON("InsertPhdClass",
                            {idPhdCycle: idCycle,
                                idPhdCurriculum: $("#phdDifferentCurriculumList").find(":selected").val()},
                    function (data) {

                        // Messaggio di inserimento riuscito
                        if (data.result === true) {
                            $("#InfoTitle").html("Curriculum inserito correttamente");
                            $("#InfoMessage").html("");
                            $("#InfoDialog").modal();
                            $("#InfoDialog").on('hidden.bs.modal', function () {
                                location.reload();
                            });
                        }
                        // Messaggio di inserimento non riuscito
                        else {
                            $("#InfoTitle").html("Errore nell'inserimento del curriculum");
                            $("#InfoMessage").html("Controlla i dati.");
                            $("#InfoDialog").modal();
                        }
                    }
                    );
                });
                // Azione del pulsante per la modifica di un ciclo
                $("#submitPhdCycle").click(function () {

                    // Invio dati alla servlet per la modifica del ciclo
                    $.getJSON("UpdatePhdCycle",
                            {oldIdPhdCycle: idCycle,
                                newIdPhdCycle: $("#phdCycleId").val(),
                                description: $("#phdCycleDescription").val(),
                                year: $("#phdCycleYear").val(),
                                professor: document.getElementsByName($("#phdCycleProfessor").val()).item(0).text},
                    function (data) {

                        // Messaggio di inserimento riuscito
                        if (data.result === true) {
                            $("#InfoTitle").html("Ciclo modificato correttamente");
                            $("#InfoMessage").html("");
                            $("#InfoDialog").modal();
                            $("#InfoDialog").on('hidden.bs.modal', function () {
                                location.reload();
                            });
                        }
                        // Messaggio di inserimento non riuscito
                        else {
                            $("#InfoTitle").html("Errore nella modifica del ciclo");
                            $("#InfoMessage").html("Controlla i dati.");
                            $("#InfoDialog").modal();
                        }
                    }
                    );
                });
                // Azione del pulsante per la cancellazione di un ciclo
                $("#deleteCycleButton").click(function () {

                    // Invio dati alla servlet per la modifica del ciclo
                    $.getJSON("DeletePhdCycle",
                            {idPhdCycle: idCycle},
                    function (data) {

                        // Messaggio di elimintazione riuscito
                        if (data.result === true) {
                            $("#InfoTitle").html("Ciclo cancellato correttamente");
                            $("#InfoMessage").html("");
                            $("#InfoDialog").modal();
                            $("#InfoDialog").on('hidden.bs.modal', function () {
                                location.reload();
                            });
                        }
                        // Messaggio di elimintazione non riuscito
                        else {
                            $("#InfoTitle").html("Errore nella cancellazione del ciclo");
                            $("#InfoMessage").html("");
                            $("#InfoDialog").modal();
                        }
                    }
                    );
                });
            }
            // Azioni da compiere se è stato selezionato "inserisci nuovo ciclo"
            else {

                $("#phdCycleTitle").html(" Nuovo ciclo di dottorato ");
                $("#cycle_form").get(0).reset();
                $("#curriculumCycleList").empty();
                $('#phdDifferentCurriculumList').find('option').remove();
                $("#addCycleCurriculumDiv").hide();
                

                $.getJSON("GetPersonByTypeOfAccount",
                        {typeOfAccount: "professor"},
                function (data) {

                    $.each(data.person, function (index, value) {
                        person = "<option label='" + value.ssn + "' name='" + value.name + " " + value.surname + "' value='" + value.name + " " + value.surname + "'>  ";
                        $("#professorCycleList").append(person);
                    });
                });

                // Vengono mostrati i pulsanti di invio ed reset
                $("#deleteCycleButton").hide();
                $("#resetCycleButton").show();

                // Azione del pulsante per l'inserimento di un nuovo ciclo
                $("#submitPhdCycle").click(function () {

                    // Invio dati alla servlet per l'inserimento del ciclo
                    $.getJSON("InsertPhdCycle",
                            {idPhdCycle: $("#phdCycleId").val(),
                                description: $("#phdCycleDescription").val(),
                                year: $("#phdCycleYear").val(),
                                professor: document.getElementsByName($("#phdCycleProfessor").val()).item(0).text},
                    function (data) {

                        // Messaggio di inserimento riuscito
                        if (data.result === true) {
                            $("#InfoTitle").html("Ciclo inserito correttamente");
                            $("#InfoMessage").html("");
                            $("#InfoDialog").modal();
                            $("#InfoDialog").on('hidden.bs.modal', function () {
                                location.reload();
                            });
                        }
                        // Messaggio di inserimento non riuscito
                        else {
                            $("#InfoTitle").html("Errore nell'inserimento del ciclo");
                            $("#InfoMessage").html("Controlla i dati.");
                            $("#InfoDialog").modal();
                        }
                    }
                    );
                });

            }

            $("#admin_add_cycle").show();
            $("#buttonCloseCycleDialog").click(function () {
                $("#admin_add_cycle").hide();
            });
        });
    });
};

// servlet per avere la lista dei curriculum 
var initCurriculum = function () {
    $.getJSON("GetPhdCurriculumsNames", function (data) {

        // ogni curriculum viene aggiungo al menu di gestione curriculum
        $.each(data.curriculumNames, function (index, value) {
            var cycleDiv = "<p class='admin_phdCurriculum_submenu' id='" + value + "'>" + value + " </p>";
            $("#admin_menu_curriculum").append(cycleDiv);
        });

        // azioni da compiere per ogni item del menù di gestione curriculum
        $(".admin_phdCurriculum_submenu").click(function () {
            nameCurriculum = $(this).attr('id');

            // Azioni da compiere se è stato selezionato un curriculum già esistente
            if (nameCurriculum !== "admin_menu_add_curriculum") {

                $("#phdCurriculumTitle").html("Dottorato in " + $(this).attr("id"));
                // Viene mostrato solo il pulsante di invio
                $("#deleteCurriculumButton").show();
                $("#resetCurriculumButton").hide();
                // Popolazione form con i dati del curriculum selezionato
                $.getJSON("GetPhdCurriculum?phdCurriculumName=" + $(this).attr('id'), function (data) {
                    $("#phdCurriculumName").val(data.phdCurriculumName);
                    $("#phdCurriculumDescription").val(data.phdCurriculumDescription);

                    $.getJSON("GetPerson?pSSN=" + data.FK_Professor, function (dataProfessor) {
                        $("#phdCurriculumProfessor").val(dataProfessor.name + " " + dataProfessor.surname);
                    });

                    $.getJSON("GetPersonByTypeOfAccount",
                            {typeOfAccount: "professor"},
                    function (data) {

                        $.each(data.person, function (index, value) {
                            person = "<option label='" + value.ssn + "' name='" + value.name + " " + value.surname + "' value='" + value.name + " " + value.surname + "'>  ";
                            $("#professorCurriculumList").append(person);
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

                        // Messaggio di inserimento riuscito
                        if (data.result === true) {
                            $("#InfoTitle").html("Curriculum modificato correttamente");
                            $("#InfoMessage").html("");
                            $("#InfoDialog").modal();
                            $("#InfoDialog").on('hidden.bs.modal', function () {
                                location.reload();
                            });
                        }
                        // Messaggio di inserimento non riuscito
                        else {
                            $("#InfoTitle").html("Errore nella modifica del curriculum");
                            $("#InfoMessage").html("Controlla i dati.");
                            $("#InfoDialog").modal();
                        }
                    }
                    );
                });
                // Azione del pulsante per la cancellazione di un curriculum
                $("#deleteCurriculumButton").click(function () {

                    // Invio dati alla servlet per la modifica del curriculum
                    $.getJSON("DeletePhdCurriculum",
                            {namePhdCurriculum: nameCurriculum},
                    function (data) {

                        // Messaggio di inserimento riuscito
                        if (data.result === true) {
                            $("#InfoTitle").html("Curriculum cancellato correttamente");
                            $("#InfoMessage").html("");
                            $("#InfoDialog").modal();
                            $("#InfoDialog").on('hidden.bs.modal', function () {
                                location.reload();
                            });
                        }
                        // Messaggio di inserimento non riuscito
                        else {
                            $("#InfoTitle").html("Errore nella cancellazione del ciclo");
                            $("#InfoMessage").html("");
                            $("#InfoDialog").modal();
                        }
                    }
                    );
                });
            }
            // Azioni da compiere se è stato selezionato "inserisci nuovo curriculum"
            else {

                $("#phdCurriculumTitle").html(" Nuovo curriculum di dottorato ");
                $("#curriculum_form").get(0).reset();

                $.getJSON("GetPersonByTypeOfAccount",
                        {typeOfAccount: "professor"},
                function (data) {

                    $.each(data.person, function (index, value) {
                        person = "<option label='" + value.ssn + "' name='" + value.name + " " + value.surname + "' value='" + value.name + " " + value.surname + "'>  ";
                        $("#professorCurriculumList").append(person);
                    });
                });

                // Vengono mostrati i pulsanti di invio ed reset
                $("#deleteCurriculumButton").hide();
                $("#resetCurriculumButton").show();

                // Azione del pulsante per l'inserimento di un nuovo curriculum
                $("#submitPhdCurriculum").click(function () {

                    // Invio dati alla servlet per l'inserimento del curriculum
                    $.getJSON("InsertPhdCurriculum",
                            {name: $("#phdCurriculumName").val(),
                                description: $("#phdCurriculumDescription").val(),
                                professor: document.getElementsByName($("#phdCurriculumProfessor").val()).item(0).text},
                    function (data) {

                        // Messaggio di inserimento riuscito
                        if (data.result === true) {
                            $("#InfoTitle").html("Curriculum inserito correttamente");
                            $("#InfoMessage").html("");
                            $("#InfoDialog").modal();
                            $("#InfoDialog").on('hidden.bs.modal', function () {
                                location.reload();
                            });
                        }
                        // Messaggio di inserimento non riuscito
                        else {
                            $("#InfoTitle").html("Errore nell'inserimento del curriculum");
                            $("#InfoMessage").html("Controlla i dati.");
                            $("#InfoDialog").modal();
                        }
                    }
                    );
                });
            }

            $("#admin_add_curriculum").show();
            $("#buttonCloseCurriculumDialog").click(function () {
                $("#admin_add_curriculum").hide();
            });
        });
    });
};


// servlet per avere la lista dei curriculum 
var initPhdUser = function () {


// azioni da compiere per ogni item del menù di gestione curriculum
    $(".admin_phd_user_submenu").click(function () {
        user = $(this).attr('id');

        // Azioni da compiere se è stato selezionato un curriculum già esistente
        if (user == "admin_menu_add_phd_student") {

            $("#phdStudentTitle").html("Gestione dottorandi");



            $.getJSON("GetPersonByTypeOfAccount",
                    {typeOfAccount: "phd"},
            function (data) {

                $.each(data.person, function (index, value) {
                    person = "<option label='" + value.ssn + "' name='" + value.name + " " + value.surname + "' value='" + value.name + " " + value.surname + "'>  ";
                    $("#personList").append(person);
                });


                var ssn;
                $("#showPhdStudent").click(function () {
                    var name = $("#phdUser").val();

                    ssn = document.getElementsByName(name).item(0).text;

                    $("#phdStudentName").html(name);

                    $("#updateStudentPhdClass").hide();
                    $("#deleteStudentPhdClass").hide();
                    $("#insertStudentPhdClass").show();

                    $.getJSON("GetPhdClassBySSN", {SSN: ssn}, function (data) {
                        var classe = data.FK_PhdCycle + "° ciclo - Dottorato in " + data.FK_PhdCurriculum;
                        $("#phdStudentClass").html(classe);


                        $("#updateStudentPhdClass").show();
                        $("#deleteStudentPhdClass").show();
                        $("#insertStudentPhdClass").hide();

                    }
                    );

                    $.getJSON("GetPhdClassList", function (classdata) {
                        $("#phdClassList option").remove();

                        $.each(classdata.phdClassList, function (index, value) {
                            phdclass = "<option class='optionItem' id='" + value.idClass + "'> " + value.FK_PhdCycle + "° ciclo - curriculum in " + value.FK_PhdCurriculum + " </option> ";
                            $("#phdClassList").append(phdclass);
                        });

                    }
                    );
                    $("#phdStudent").show();

                });

                $("#insertStudentPhdClass").click(function () {

                    $.getJSON("InsertStudentPhdClass", {idCycle: $("#phdClassList").find(":selected").attr("id"), SSN: ssn}, function (data) {
                        // Messaggio di inserimento riuscito
                        if (data.result === true) {
                            $("#InfoTitle").html("Classe assegnata con successo");
                            $("#InfoMessage").html("");
                            $("#InfoDialog").modal();
                            $("#InfoDialog").on('hidden.bs.modal', function () {
                                $("#phdStudent").hide();
                                $("#phdUser").val("");
                            });
                        }
                        // Messaggio di inserimento non riuscito
                        else {
                            $("#InfoTitle").html("Errore nell'assegnazione della classe");
                            $("#InfoMessage").html("Controlla i dati.");
                            $("#InfoDialog").modal();
                        }
                    }
                    );

                });

                $("#updateStudentPhdClass").click(function () {
                    $.getJSON("UpdateStudentPhdClass", {idCycle: $("#phdClassList").find(":selected").attr("id"), SSN: ssn}, function (data) {
                        // Messaggio di inserimento riuscito
                        if (data.result === true) {
                            $("#InfoTitle").html("Classe assegnata con successo");
                            $("#InfoMessage").html("");
                            $("#InfoDialog").modal();
                            $("#InfoDialog").on('hidden.bs.modal', function () {
                                $("#phdStudent").hide();
                                $("#phdUser").val("");
                            });
                        }
                        // Messaggio di inserimento non riuscito
                        else {
                            $("#InfoTitle").html("Errore nell'assegnazione della classe");
                            $("#InfoMessage").html("Controlla i dati.");
                            $("#InfoDialog").modal();
                        }
                    }
                    );

                });


                $("#deleteStudentPhdClass").click(function () {

                    $.getJSON("DeleteStudentPhdClass", {SSN: ssn}, function (data) {

                        $("#phdStudentClass").html("");

                        // Messaggio di inserimento riuscito
                        if (data.result === true) {
                            $("#InfoTitle").html("Classe eliminata con successo");
                            $("#InfoMessage").html("");
                            $("#InfoDialog").modal();
                            $("#InfoDialog").on('hidden.bs.modal', function () {
                                $("#phdStudent").hide();
                                $("#phdUser").val("");
                            });
                        }
                        // Messaggio di inserimento non riuscito
                        else {
                            $("#InfoTitle").html("Errore nella cancellazione della classe");
                            $("#InfoMessage").html("Controlla i dati.");
                            $("#InfoDialog").modal();
                        }
                    }
                    );

                });
            }
            );

        }

        $("#admin_add_phd_student").show();
        $("#buttonClosePhdStudentDialog").click(function () {
            $("#admin_add_phd_student").hide();
        });

    });

};



// Funzione per la gestione del menù
$(document).ready(function () {

    initCycle();
    initCurriculum();
    initPhdUser();

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

