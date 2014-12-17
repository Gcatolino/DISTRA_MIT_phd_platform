

// servlet per avere le informazioni riguardanti un determinato curriculum
    $.get("GetPhdCurriculumsNames", function (data) {
        parsedData = $.parseJSON(data);
        $.each(parsedData.curriculumNames, function (index, value) {
            var curriculumDiv = "<div class='panel-curriculum col-sm-4 text-center pointer' id='" + value + "'> <h4> " + value + " </h4> </div>";
            $("#curriculumList").append(curriculumDiv);
        });

        $(".panel-curriculum").click(function () {
            $.getJSON("GetPhdCurriculum?phdCurriculumName=" + $(this).attr('id'), function (data) {
                $("#phdCurriculumName").html(data.phdCurriculumName);
                
                $.getJSON("GetPerson?pSSN=" + data.FK_Professor, function (dataProfessor) {
                    $("#phdCurriculumProfessor").html("Coordinatore: " + dataProfessor.name + " " + dataProfessor.surname);
                });
                
                $("#phdCurriculumDescription").html(data.phdCurriculumDescription);
            });
            
            $("#curriculumPanel").slideDown();

        });
    });



