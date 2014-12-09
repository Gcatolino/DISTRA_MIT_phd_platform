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
                // Popolazione form con i dati del ciclo selezionato
                $.getJSON("GetPhdCycle?phdCycleId=" + $(this).attr('id'), function (data) {
                    $("#phdCycleId").val(data.phdCycle);
                    $("#phdCycleYear").val(data.phdYear);
                    $("#phdCycleDescription").val(data.phdDescription);
                    $("#phdCyleProfessor").val(data.FK_Professor);
                });
                // Azione del pulsante per la modifica di un ciclo
                $("#submitPhdCycle").click(function () {

                    // Invio dati alla servlet per la modifica del ciclo
                    $.getJSON("UpdatePhdCycle",
                            {oldIdPhdCycle: idCycle,
                                newIdPhdCycle: $("#phdCycleId").val(),
                                description: $("#phdCycleDescription").val(),
                                year: $("#phdCycleYear").val(),
                                professor: $("#phdCycleProfessor").val()},
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
                                professor: $("#phdCycleProfessor").val()},
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
                    $("#phdCurriculumProfessor").val(data.FK_Professor);
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

                // Vengono mostrati i pulsanti di invio ed reset
                $("#deleteCurriculumButton").hide();
                $("#resetCurriculumButton").show();

                // Azione del pulsante per l'inserimento di un nuovo curriculum
                $("#submitPhdCurriculum").click(function () {

                    // Invio dati alla servlet per l'inserimento del curriculum
                    $.getJSON("InsertPhdCurriculum",
                            {name: $("#phdCurriculumName").val(),
                                description: $("#phdCurriculumDescription").val(),
                                professor: $("#phdCurriculumProfessor").val()},
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
            $("#buttonCloseCycleDialog").click(function () {
                $("#admin_add_curriculum").hide();
            });
        });
    });
};

// Funzione per la gestione del menù
$(document).ready(function () {

    initCycle();
    initCurriculum();

    $("#admin_cycle").click(function () {
        $("#admin_menu_curriculum").slideUp();
        $("#admin_menu_cycle").slideToggle();
    });
    $("#admin_curriculum").click(function () {
        $("#admin_menu_cycle").slideUp();
        $("#admin_menu_curriculum").slideToggle();
    });

});

