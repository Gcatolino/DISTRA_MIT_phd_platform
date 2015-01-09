<%-- 
    Document   : profile
    Created on : 25-dic-2014, 11.54.56
    Author     : gemmacatolino
--%>

<%@page import="it.unisa.dottorato.phdCurriculum.PhdCurriculumManager"%>
<%@page import="it.unisa.dottorato.phdCurriculum.PhdCurriculum"%>
<%@page import="it.unisa.dottorato.phdCycle.PhdCycleManager"%>
<%@page import="it.unisa.dottorato.phdCycle.PhdCycle"%>
<%@page import="it.unisa.dottorato.phdClass.PhdClass"%>
<%@page import="it.unisa.dottorato.phdClass.PhdClassManager"%>
<%@page import="it.unisa.integrazione.database.PersonManager"%>
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
        <meta name="author" content="" />

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
        <script type="text/javascript" src="script/index.js"></script>

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
                    
                    <div class="col-sm-1"></div>
                    
                    <div class="col-sm-10">
                        <!--Qui chiama servlet update che prende infomazioni person--> 
                        <% Person loggedPerson = ((Person) session.getAttribute("person"));
                            PhdClass phdClass = PhdClassManager.getInstance().getPhdClassBySSN(loggedPerson.getSsn());
                        %>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1> <%= loggedPerson.getName()%> <%= loggedPerson.getSurname()%>  <span class="glyphicon glyphicon-cog pointer" aria-hidden="true" onclick="location.href = 'editProfile.jsp'" style="float: right; display: inline;"></span></h1>
                                    <% if (phdClass != null) {%>
                                <h4> <%= PhdCycleManager.getInstance().getPhdCycleById(phdClass.getFK_PhdCycle()).getIdPhdCycle()%>° ciclo di dottorato in <%= PhdCurriculumManager.getInstance().getPhdCurriculumById(phdClass.getFK_PhdCurriculum()).getName()%></h4>
                                <% }%>
                            </div>
                            <div class="panel-body">
                                <table width="97%" align="center">
                                    <tr>
                                        <td width="180px" >
                                            <img class="img-polaroid" style='width: 150px ; height: 150px ;' src="../Immagini/scam_facebook_fake_tutela_amici.jpg" alt="nome immagine" >
                                        </td>
                                        <td>
                                            <h3 > Contatti </h3>
                                            <p > 
                                                Telefono: <%= loggedPerson.getPhone()%> <br>
                                                E-mail: <%= loggedPerson.getAccount().getEmail()%> <br>
                                                <% if (loggedPerson.getWebPage() != null) {%>
                                                Sito web: <a href="<%= loggedPerson.getWebPage()%>" target="_blank"><%= loggedPerson.getWebPage()%></a> <br>
                                                <%}
                                                    if (loggedPerson.getDepartment() != null) {%>
                                                <%= loggedPerson.getDepartment().getAbbreviation() %> <br>
                                                <% }%>

                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <br>
                                            <h3> Interessi di ricerca </h3> <br>
                                            <p class="text-justify" > 
                                                <%= loggedPerson.getCoverLetter()%> <br> <br>

                                            </p>

                                            <p class="text-justify"> 
                                            <h3>Registro attività: <span class="glyphicon glyphicon-eye-open pointer" aria-hidden="true" onclick="location.href = 'publicationActivity.jsp'"></span></h3>
                                            </p>
                                        </td>
                                    </tr>
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