// servlet per avere le informazioni riguardanti un determinato curriculum
$.get("GetPhdCurriculumsNames", function (data) {
    parsedData = $.parseJSON(data);
    $.each(parsedData.curriculumNames, function (index, value) {
        var curriculumDiv = "<div class='panel-curriculum col-sm-4 text-center pointer'> <a> <h4> " + value + " </h4>  </a> </div>";
        $("#curriculumList").append(curriculumDiv);
    });
});
