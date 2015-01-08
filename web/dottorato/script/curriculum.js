

// servlet per avere le informazioni riguardanti un determinato curriculum
$.get("GetPhdCurriculumsNames", function (data) {
    parsedData = $.parseJSON(data);
    $.each(parsedData.curriculumNames, function (index, value) {
        var curriculumDiv = "<div class='panel-curriculum col-sm-4 text-center pointer' id='" + value + "'> <h4> " + value + " </h4> </div>";
        $("#curriculumList").append(curriculumDiv);
    });

    if ($("#curriculumParameter").val() !== "null") {

            $.getJSON("GetPhdCurriculum?phdCurriculumName=" + $("#curriculumParameter").val(), function (data) {

                // questi campi necessitano di essere cancellati prima della visualizzazione di un nuovo ciclo
                $("#phdCurriculumName").html("");
                $("#phdCurriculumProfessor").html("");
                $("#phdCurriculumDescription").html("");

                $("#phdCurriculumName").html(data.phdCurriculumName);

                $.getJSON("GetPerson?pSSN=" + data.FK_Professor, function (dataProfessor) {
                    $("#phdCurriculumProfessor").html("Coordinatore: " + dataProfessor.name + " " + dataProfessor.surname);
                });

                $("#phdCurriculumDescription").html(data.phdCurriculumDescription);
            });

            $("#curriculumPanel").slideDown();


    }



    $(".panel-curriculum").click(function () {
        $.getJSON("GetPhdCurriculum?phdCurriculumName=" + $(this).attr('id'), function (data) {

            // questi campi necessitano di essere cancellati prima della visualizzazione di un nuovo ciclo
            $("#phdCurriculumName").html("");
            $("#phdCurriculumProfessor").html("");
            $("#phdCurriculumDescription").html("");

            $("#phdCurriculumName").html(data.phdCurriculumName);

            $.getJSON("GetPerson?pSSN=" + data.FK_Professor, function (dataProfessor) {
                $("#phdCurriculumProfessor").html("Coordinatore: " + dataProfessor.name + " " + dataProfessor.surname);
            });

            $("#phdCurriculumDescription").html(data.phdCurriculumDescription);
        });

        $("#curriculumPanel").slideDown();

    });
});



