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
        <style>
            hr { 
                display: block;
                margin-top: 0.5em;
                margin-bottom: 0.5em;
                margin-right: auto;
                border-style: inset;
                color: #305b90;
                background-color: #305b90;
                height: 3px;
            } 
        </style>
    </head>
    <body class="page-body">

        <!-- Inclusione della pagina contenente il menù superiore --> 
        <jsp:include page="topMenu.jsp" flush="true"/> 
        <div class="page-container">

            <!-- Inclusione della pagina contenente il menù laterale --> 
            <jsp:include page="lateralMenu.jsp"/> 

            <!-- Contenuto della pagina --> 


            <% Person loggedPerson = ((Person) session.getAttribute("person")); 
               PhdClass phdClass = PhdClassManager.getInstance().getPhdClassBySSN(loggedPerson.getSsn());
            %>
            <!--Qui chiama servlet update che prende infomazioni person-->
            <form id="#" class="form-horizontal" method="POST" action="#" style='color: #000;font-size:medium ; margin-left: 3%' />
            <div class="form-group">
                <hr>
                <p style="font-size: x-large ; color: #000">Profilo <button type="button" class="btn btn-xs" style="float:right; margin: 7px 880px 7px 7px" >    
                        <span class="glyphicon glyphicon-cog" aria-hidden="true" onclick="location.href = 'editProfile.jsp'"></span> </button> </p>
                <hr>
                <br>
                <img  class="img-polaroid" style='width: 100 px ; height: 100px ; margin-left: 3%' src="../Immagini/scam_facebook_fake_tutela_amici.jpg" alt="nome immagine" >
                <br>
                <br>
                <p style='color: #000;font-size:medium ; margin-left: 3%'><b>Nome:</b></p>
                <input size="30" style=' color: #000;font-size:medium ; margin-left: 3%' type="text" value="<%= loggedPerson.getName() %>" class="field left" readonly>
                <br>
                <br>
                <p style='color: #000;font-size:medium ; margin-left: 3%'><b>Cognome:</b></p>
                <input size="30" style='color: #000;font-size:medium ; margin-left: 3%' type="text" value="<%= loggedPerson.getSurname()%>" class="field left" readonly>
                <br>
                <br>
                <p style='color: #000;font-size:medium ; margin-left: 3%'><b>Telefono:</b></p>
                <input size="30" style='color: #000;font-size:medium ; margin-left: 3%' type="text" value="<%= loggedPerson.getPhone()%>" class="field left" readonly>
                <br>
                <br>
                <p style='color: #000;font-size:medium ; margin-left: 3%'><b>Email:</b></p>
                <input size="30" style='color: #000;font-size:medium ; margin-left: 3%' type="text" value="<%= loggedPerson.getAccount().getEmail() %>" class="field left" readonly>
                <br>
                <br>
                <p style='color: #000;font-size:medium ; margin-left: 3%'><b>Dipartimento:</b></p>
                <% if(loggedPerson.getDepartment()!= null) { %>
                <input size="30" style='color: #000;font-size:medium ; margin-left: 3%' type="text" value="<%= loggedPerson.getDepartment().getAbbreviation() %>" class="field left" readonly>
                <%} else { %>
                <input size="30" style='color: #000;font-size:medium ; margin-left: 3%' type="text" value="nessun dip" class="field left" readonly>
                <% } %>
                <br>
                <br>
                <p style='color: #000;font-size:medium ; margin-left: 3%'><b>Web Page:</b></p>
                <% if(loggedPerson.getWebPage() != null) { %>
                <input size="30" style='color: #000;font-size:medium ; margin-left: 3%' type="text" value="<%= loggedPerson.getWebPage() %>" class="field left" readonly>
                <%} else { %>
                <input size="30" style='color: #000;font-size:medium ; margin-left: 3%' type="text" value="" class="field left" readonly>
                <%}%>
                <br>
                <br>
                <p style='color: #000;font-size:medium ; margin-left: 3%'><b>Ciclo di Appartenenza:</b></p>
                <% if(phdClass != null) { %>
                <input size="30" style='color: #000;font-size:medium ; margin-left: 3%' type="text" value="<%= PhdCycleManager.getInstance().getPhdCycleById(phdClass.getFK_PhdCycle()).getIdPhdCycle() %>" class="field left" readonly>
                <%} else { %>
                <input size="30" style='color: #000;font-size:medium ; margin-left: 3%' type="text" value="" class="field left" readonly>
                <%}%>
                <br>
                <br>
                <p style='color: #000;font-size:medium ; margin-left: 3%'><b>Curriculum:</b></p>
                <% if(phdClass != null) { %>
                <input size="30" style='color: #000;font-size:medium ; margin-left: 3%' type="text" value="<%= PhdCurriculumManager.getInstance().getPhdCurriculumById(phdClass.getFK_PhdCurriculum()).getName() %>" class="field left" readonly>
                <%} else { %>
                <input size="30" style='color: #000;font-size:medium ; margin-left: 3%' type="text" value="" class="field left" readonly>
                <%}%>
                <br>
                <br>
                <p style='color: #000;font-size:medium ; margin-left: 3%'><b>Interessi di Ricerca:</b></p>
                <textarea name="coverLetter" rows="5" cols="40"  style='color: #000;font-size:medium ; margin-left: 3%'> <%= loggedPerson.getCoverLetter()%> </textarea>
                <br>

            </div>
        </form>

        <form id="#" class="form-horizontal" method="POST" action="#" style='color: #000;font-size:medium ; margin-left: 3%'/>
        <div class="form-group">
            <hr>
            <p style="font-size: x-large ; color: #000"onclick="location.href = 'publicationActivity.jsp'" >Registro Attività <button type="button" class="btn btn-xs" style="float:right; margin: 7px 780px 7px 7px" >    
                    <span class="glyphicon glyphicon-eye-open" aria-hidden="true" onclick="location.href = 'publicationActivity.jsp'"></span> </button>
                
            <hr>
            
        </div>
    </form>









</div>





</body>
</html>