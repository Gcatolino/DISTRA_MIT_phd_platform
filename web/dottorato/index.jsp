<%@page import="it.unisa.dottorato.phdCycle.PhdCycleManager"%>
<%@page import="it.unisa.dottorato.phdClass.PhdClass"%>
<%@page import="it.unisa.dottorato.phdClass.PhdClassManager"%>
<%@page import="it.unisa.integrazione.model.Person"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="Xenon Boostrap Admin Panel" />
        <meta name="author" content="Elisa D'Eugenio" />

        <title>DISTRA-MIT Dottorato</title>

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Arimo:400,700,400italic">
        <link rel="stylesheet" href="../assets/css/fonts/linecons/css/linecons.css">
        <link rel="stylesheet" href="../assets/css/fonts/fontawesome/css/font-awesome.css">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../assets/css/xenon-core.css">
        <link rel="stylesheet" href="../assets/css/xenon-forms.css">
        <link rel="stylesheet" href="../assets/css/xenon-components.css">
        <link rel="stylesheet" href="../assets/css/xenon-skins.css">
        <link rel="stylesheet" href="../assets/css/custom.css">  
        <link rel="stylesheet" href="style/dottorato.css">

        <script src="../assets/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="script/index.js" async ></script>


        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
                <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body class="page-body">

        <!-- Inclusione della pagina contenente il menù superiore --> 
        <jsp:include page="topMenu.jsp" flush="true"/> 
        <div class="page-container">

            <!-- Inclusione della pagina contenente il menù laterale --> 
            <jsp:include page="lateralMenu.jsp"/> 

            <!-- Contenuto della pagina --> 
            <div class="main-content" id="content">

                <div class="row">

                    <div class="col-sm-8">

                        <% int cycle=0;
                            Person loggedPerson = ((Person) session.getAttribute("person"));
                            if (loggedPerson != null) {
                                PhdClass phdClass = PhdClassManager.getInstance().getPhdClassBySSN(loggedPerson.getSsn());

                                if (phdClass != null) {
                                    cycle = phdClass.getFK_PhdCycle();
                                }else{
                                    cycle = Integer.parseInt(PhdCycleManager.getInstance().getPhdCyclesIds().get(0));
                                }
                            }else{
                                cycle = Integer.parseInt(PhdCycleManager.getInstance().getPhdCyclesIds().get(0));
                            }
                        %>
                        <input type="hidden" id="personCycle" value="<%= cycle%>">



                        <!-- Descrizione del ciclo di dottorato --> 
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1> Dottorato di Ricerca in Management & IT </h1>
                                <h3> <span id="phdCycle"> </span>° ciclo - Anno <span id="phdYear"> </span> </h3>
                            </div>
                            <div class="panel-body">
                                <p class="text-justify" id="phdDescription"></p>
                                <p class="text-justify" id="phdProfessor"></p>
                            </div>
                        </div>

                        <!-- Elenco dei curriculum attivi nel ciclo --> 
                        <div class="panel panel-default">
                            <div class="panel-heading"> <h1> Curriculum attivi </h1> </div>
                            <div class="panel-body row" id="curriculumList"> </div>
                        </div>
                    </div>

                    <div class="col-sm-4">

                        <!-- Lista dei cicli --> 
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1> Cicli </h1>
                            </div>
                            <div class="panel-body homeList" id="cycleList">
                            </div>
                        </div>

                        <!-- Lista degli avvisi --> 
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1> Avvisi </h1>
                            </div>
                            <div class="panel-body">
                                <p class="text-justify"> Avviso 1 </p>
                                <p class="text-justify"> Avviso 2 </p>
                                <p class="text-justify"> Avviso 3 </p>
                                <p class="text-justify"> Avviso 4 </p>
                            </div>
                        </div>

                        <!-- Lista delle news --> 
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1> News </h1>
                            </div>
                            <div class="panel-body">
                                <p class="text-justify"> News 1 </p>
                                <p class="text-justify"> News 2 </p>
                                <p class="text-justify"> News 3 </p>
                                <p class="text-justify"> News 4 </p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <!-- Bottom Scripts -->
            <script src="../assets/js/bootstrap.min.js"></script>
            <script src="../assets/js/TweenMax.min.js"></script>
            <script src="../assets/js/resizeable.js"></script>
            <script src="../assets/js/joinable.js"></script>
            <script src="../assets/js/xenon-api.js"></script>
            <script src="../assets/js/xenon-toggles.js"></script>

            <!-- JavaScripts initializations and stuff -->
            <script src="../assets/js/xenon-custom.js"></script>

        </div>
    </body>
</html>
