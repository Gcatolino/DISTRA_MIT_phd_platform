// servlet per avere le informazioni riguardanti un determinato ciclo
$.getJSON("GetPhdCycle?phdCycleId=15", function (data) {
    $("#phdCycle").html(data.phdCycle);
    $("#phdYear").html(data.phdYear);
    $("#phdDescription").html(data.phdDescription);

    $.getJSON("GetPerson?pSSN=" + data.FK_Professor, function (dataProfessor) {
        $("#phdProfessor").html("Coordinatore: " + dataProfessor.name + " " + dataProfessor.surname);
    });
});

// servlet per avere le informazioni riguardanti un determinato curriculum
$.get("GetPhdCurriculumsNamesByPhdCycle?phdCycleId=15", function (data) {
    parsedData = $.parseJSON(data);
    $.each(parsedData.curriculumNames, function (index, value) {
        var curriculumDiv = "<div class='panel-curriculum col-sm-4 text-center pointer'> <a> <h4> " + value + " </h4>  </a> </div>";
        $("#curriculumList").append(curriculumDiv);
    });
});

// servlet per avere la lista dei cicli esistenti
$.get("GetPhdCyclesIds", function (data) {
    parsedData = $.parseJSON(data);
    $.each(parsedData.cyclesIds, function (index, value) {
        var cycleDiv = "<p class='phdCycle_submenu' id='" + value + "'> " + value + "° ciclo </p>";
        $("#cycleList").append(cycleDiv);
    });

    $(".phdCycle_submenu").click(function () {
        
        cSelected = $(this).attr('id');

        $.getJSON("GetPhdCycle?phdCycleId=" + cSelected, function (data) {
            $("#phdCycle").html(data.phdCycle);
            $("#phdYear").html(data.phdYear);
            $("#phdDescription").html(data.phdDescription);

            $.getJSON("GetPerson?pSSN=" + data.FK_Professor, function (dataProfessor) {
                $("#phdProfessor").html("Coordinatore: " + dataProfessor.name + " " + dataProfessor.surname);
            });
        });

        $(".panel-curriculum").remove();

        // servlet per avere le informazioni riguardanti un determinato curriculum
        $.get("GetPhdCurriculumsNamesByPhdCycle?phdCycleId=" + cSelected, function (data) {
            parsedData = $.parseJSON(data);
            $.each(parsedData.curriculumNames, function (index, value) {
                var curriculumDiv = "<div class='panel-curriculum col-sm-4 text-center pointer'> <a href='curriculum.jsp'> <h4> " + value + " </h4>  </a> </div>";
                $("#curriculumList").append(curriculumDiv);
            });
        });
    });



});