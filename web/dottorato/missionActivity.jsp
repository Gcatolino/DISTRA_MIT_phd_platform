<%-- 
    Document   : missionActivity
    Created on : 26-dic-2014, 17.33.00
    Author     : gemmacatolino
--%>
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
        <![endif]-->2
    </head>
    <body class="page-body">

        <!-- Inclusione della pagina contenente il menù superiore --> 
        <jsp:include page="topMenu.jsp" flush="true"/> 
        <div class="page-container">

            <!-- Inclusione della pagina contenente il menù laterale --> 
            <jsp:include page="lateralMenu.jsp"/> 

            <ul class="nav nav-tabs" style='margin-left: 3%'>
                <li role="presentation"><a href="publicationActivity.jsp">Pubblicazioni</a></li>
                <li role="presentation"><a href="collaborationActivity.jsp">Collaborazioni</a></li>
                <li role="presentation" class="active"><a href="missionActivity.jsp">Mission</a></li>
            </ul>
            <br>
            <button type="button" class="btn btn-xs" aria-label="Left Align" style="margin-left: 3%">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true" onclick="location.href = 'addMission.jsp'"></span>
                        </button>
            <br>
            <table style="width:100% ;margin-left: 3%">
                <tr>
                    <th>Luogo &nbsp;&nbsp;&nbsp;</th>
                    <th>Descrizione &nbsp;&nbsp;&nbsp;</th>		
                    <th>Data Di Inizio &nbsp;&nbsp;&nbsp;</th>
                    <th>Data Di Fine&nbsp;&nbsp;&nbsp;</th>
                </tr>
                <tr>
                    <td>-</td>
                    <td>-</td>		
                    <td>-</td>
                    <td>-</td>
                    <td><button type="button" class="btn btn-xs" title="modifica">
                            <span class="glyphicon glyphicon-cog" aria-hidden="true"onclick="location.href = 'editMission.jsp'" ></span>
                        </button></td>
                    <td><button type="button" class="btn btn-xs"title="delete">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                        </button></td>
                </tr>
            </table>







        </div>













    </body>
</html>

