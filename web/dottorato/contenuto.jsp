<script type="text/javascript">
    $.get("GetPhdCycleInfo?phdCycleId=15", function(data){
        parsedData = $.parseJSON(data);
        $("#phdCycle").html(parsedData.phdCycle);
        $("#phdYear").html(parsedData.phdYear);
        $("#phdDescription").html(parsedData.phdDescription);
    });
</script>
<div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-10">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h1> Dottorato di Ricerca in Management & IT </h1>

                <h3><span id="phdCycle"></span>° ciclo - Anno <span id="phdYear"></span></c:out></h3>
            </div>
            <div class="panel-body">
                <p class="text-justify" id="phdDescription"></c:out></p>
            </div>
        </div>
    </div>
    <div class="col-sm-1"></div>
</div>