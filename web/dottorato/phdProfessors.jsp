<%@page import="it.unisa.dottorato.phdClass.PhdClassManager"%>
<%@page import="it.unisa.dottorato.phdClass.PhdClass"%>
<%@page import="it.unisa.dottorato.phdPeople.PhdPeopleManager"%>
<%@page import="it.unisa.dottorato.phdProfile.collaborations.CollaborationManager"%>
<%@page import="java.util.ArrayList"%>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.5.0/bootstrap-table.min.css">

        <script src="../assets/js/jquery-1.11.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.5.0/bootstrap-table.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.5.0/locale/bootstrap-table-it-IT.min.js"></script>

        <script>
            $(document).ready(function () {
                $("tr").click(function () {
                    if ($(this).attr('id') !== 'null')
                        window.open($(this).attr('id'), "_target");
                });
            });
        </script>

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

            <% ArrayList<Person> professors = PhdPeopleManager.getInstance().getPhdProfessors();
                String cycles = null;
                String curriculums = null;
            %>

            <div class="main-content" id="content">

                <div class="row">

                    <div class="col-sm-1"></div>

                    <div class="col-sm-10">
                        <!--Qui chiama servlet update che prende infomazioni person--> 

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1>Collegio docenti</h1>
                            </div>
                            <div class="panel-body">
                                <table data-toggle="table" class="table table-hover" align="center" data-pagination="true" data-search="true">
                                    <thead> 
                                        <tr id="null">
                                            <th data-field="surname" data-sortable="true">Cognome</th>
                                            <th data-field="name" data-sortable="true">Nome</th>		
                                            <th data-field="cycle" data-sortable="true">Ciclo</th>
                                            <th data-field="curriculum" data-sortable="true">Curriculum</th>
                                        </tr> 
                                    </thead>

                                    <% for (Person professor : professors) {%>
                                    <tr id="<%= professor.getWebPage()%>" <% if(professor.getWebPage() != null){ %>class="pointer" <%}%>>
                                        <td><%= professor.getName()%></td>
                                        <td><%= professor.getSurname()%></td>	

                                        <% cycles = PhdPeopleManager.getInstance().getPhdProfessorCycle(professor.getSsn()).toString();%>

                                        <td><%= cycles.replace("[", "").replace("]", "")%></td>

                                        <% curriculums = PhdPeopleManager.getInstance().getPhdProfessorCurriculum(professor.getSsn()).toString();%>

                                        <td><%= curriculums.replace("[", "").replace("]", "")%></td>
                                    </tr>
                                    <% }%>
                                </table>

                            </div>
                        </div>
                    </div>

                    <div class="col-sm-1"></div>

                </div>
            </div>

        </div>

    </body>
</html>