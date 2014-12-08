// servlet per avere la lista dei cicli 
$.get("GetPhdCyclesIds", function (data) {
    parsedData = $.parseJSON(data);

    // ogni ciclo viene aggiungo al menu di gestione ciclo
    $.each(parsedData.cyclesIds, function (index, value) {
        var cycleDiv = "<p class='admin_phdCycle_submenu' id='" + value + "'>" + value + "° ciclo </p>";
        $("#admin_menu_cycle").append(cycleDiv);
    });

    // azioni da compiere per ogni item del menù di gestione cicli
    $(".admin_phdCycle_submenu").click(function () {
        $("#admin_add_cycle").hide();

        // Controllo sull'esistenza del ciclo selezionato
        if ($(this).attr('id') !== "admin_menu_add_cycle") {
            $.get("GetPhdCycle?phdCycleId=" + $(this).attr('id'), function (data) {
                parsedData = $.parseJSON(data);
                $("#phdCycleId").val(parsedData.phdCycle);
                $("#phdCycleYear").val(parsedData.phdYear);
                $("#phdCycleDescription").val(parsedData.phdDescription);
                $("#phdCyleProfessor").val(parsedData.FK_Professor);
            });
            $("#cycle_form").attr("action", "UpdatePhdCycle");
            $("#phdCycleTitle").html($(this).attr("id") + "° ciclo di dottorato ");
        } else {
            $("#cycle_form").attr("action", "InsertPhdCycle");
            $("#cycle_form").get(0).reset();
            $("#phdCycleTitle").html(" Nuovo ciclo di dottorato ");
        }

        $("#admin_add_cycle").show();
    });
});

// servlet per avere la lista dei curriculum 
$.get("GetPhdCurriculumNames", function (data) {
    parsedData = $.parseJSON(data);
    $.each(parsedData.curriculumNames, function (index, value) {
        var curriculumDiv = "<p class='admin_phdCurriculum_submenu'>" + value + "</p>";
        $("#admin_menu_curriculum").append(curriculumDiv);
    });
});

// gestione del movimento dei menù
$(document).ready(function () {
    
    $("#admin_cycle").click(function () {
        $("#admin_menu_curriculum").slideUp();
        $("#admin_menu_cycle").slideToggle();
    });

    $("#admin_curriculum").click(function () {
        $("#admin_menu_cycle").slideUp();
        $("#admin_menu_curriculum").slideToggle();
    });
    
});

