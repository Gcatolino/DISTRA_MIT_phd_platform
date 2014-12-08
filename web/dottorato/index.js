// servlet per avere le informazioni riguardanti un determinato ciclo
$.get("GetPhdCycle?phdCycleId=15", function (data) {
    parsedData = $.parseJSON(data);
    $("#phdCycle").html(parsedData.phdCycle);
    $("#phdYear").html(parsedData.phdYear);
    $("#phdDescription").html(parsedData.phdDescription);
    $("#phdProfessor").html("Coordinatore: " + parsedData.FK_Professor);
});

// servlet per avere le informazioni riguardanti un determinato curriculum
$.get("GetPhdCurriculumsNames?phdCycleId=15", function (data) {
    parsedData = $.parseJSON(data);
    $.each(parsedData.curriculumNames, function (index, value) {
        var curriculumDiv = "<div class='panel-curriculum col-sm-4 text-center pointer'> <a> <h4> " + value + " </h4>  </a> </div>";
        $("#curriculumList").append(curriculumDiv);
    });
});
