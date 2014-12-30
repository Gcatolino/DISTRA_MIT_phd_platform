<%-- 
    Document   : profile
    Created on : 25-dic-2014, 11.54.56
    Author     : gemmacatolino
--%>


<%@page import="it.unisa.dottorato.phdProfile.publications.Publication"%>
<%@page import="java.util.List"%>
<%@page import="it.unisa.dottorato.phdProfile.publications.PublicationManager"%>
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
        <![endif]-->2
    </head>
    <body class="page-body">

        <!-- Inclusione della pagina contenente il menù superiore --> 
        <jsp:include page="topMenu.jsp" flush="true"/> 
        <div class="page-container">

            <!-- Inclusione della pagina contenente il menù laterale --> 
            <jsp:include page="lateralMenu.jsp"/> 

            <% Person loggedPerson = ((Person) session.getAttribute("person"));
                List<Publication> publications = PublicationManager.getInstance().getAllPublicationsOf(loggedPerson);

            %>



            <div class="main-content" id="content">

                <div class="row">

                    <div class="col-sm-1"></div>

                    <div class="col-sm-10">
                        <!--Qui chiama servlet update che prende infomazioni person--> 

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <ul class="nav nav-tabs" >
                                    <li role="presentation" class="active"><a href="publicationActivity.jsp">Pubblicazioni</a></li>
                                    <li role="presentation"><a href="collaborationActivity.jsp">Collaborazioni</a></li>
                                    <li role="presentation"><a href="missionActivity.jsp">Mission</a></li>
                                </ul>
                                <br>
                                <button type="button" class="btn btn-xs" aria-label="Left Align" onclick="location.href = 'addPublication.jsp'">
                                    <span class="glyphicon glyphicon-plus" aria-hidden="true"> </span> Aggiungi pubblicazione
                                </button>


                            </div>
                            <div class="panel-body">
                                <table class="table table-hover" width="98%" align="center" >
                                    <thead>
                                    <th width="15%">Titolo</th>
                                    <th width="15%">Autori</th>		
                                    <th width="30%">Abstract</th>
                                    <th width="10%">Anno</th>
                                    <th width="10%">Type</th>
                                    <th width="10%">Pubblication Issue</th>
                                    <th width="10%">Numero Pagine</th>
                                    </thead>

                                    <% for (Publication publication : publications) {%>
                                    <tr>
                                        <td><%= publication.getTitle()%></td>
                                        <td><%= publication.getAuthors()%> </td>		
                                        <td><%= publication.getAbstractText()%></td>
                                        <td><%= publication.getYear()%></td>
                                        <td><%= publication.getType()%></td>
                                        <td><%= publication.getPublicationIssue()%></td>		
                                        <td><%= publication.getNumberPages()%></td>

                                        <% session.setAttribute("idPublication", publication.getIdPublication());%>

                                        <td width="20px"> <button type="button" class="btn btn-white" title="modifica">
                                                <span class="glyphicon glyphicon-cog" aria-hidden="true" onclick="location.href = 'editPublication.jsp'" ></span>
                                            </button>
                                        </td>
                                        <td width="20px">
                                            <button type="button" class="btn btn-white"title="delete">
                                                <span class="glyphicon glyphicon-remove" aria-hidden="true" onclick="location.href = '<%= "DeletePublicationServlet?id=" + publication.getIdPublication()%>'" ></span>
                                            </button>
                                        </td>
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
