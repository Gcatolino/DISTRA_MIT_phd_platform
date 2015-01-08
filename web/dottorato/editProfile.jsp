<%--
    Document   : profile
    Created on : 25-dic-2014, 11.54.56
    Author     : gemmacatolino
--%>

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
            <% Person loggedPerson = ((Person) session.getAttribute("person"));
            %>

            <div class="main-content" id="content">

                <div class="row">

                    <div class="col-sm-1"></div>

                    <div class="col-sm-10">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1> Modifica profilo</h1>
                            </div>
                            <div class="panel-body">
                                <form class="form-horizontal" method="POST" action="UpdateProfileServlet">
                                    <div class="form-group">
                                        <table width="90%" align="center">
                                            <tr><td>
                                                    <p>Nome:</p>
                                                    <div class="input-group">
                                                        <span class="input-group-addon"></span>
                                                        <input class="form-control" name="name" type="text" value="<%= loggedPerson.getName()%>" required>
                                                    </div>
                                                    <br>
                                                    <br>
                                                    <p>Cognome:</p>
                                                    <div class="input-group">
                                                        <span class="input-group-addon"></span>
                                                        <input class="form-control" name="surname" type="text" value="<%= loggedPerson.getSurname()%>" required>
                                                    </div>
                                                    <br>
                                                    <br>
                                                    <p >Telefono:</p>
                                                    <div class="input-group">
                                                        <span class="input-group-addon"></span>
                                                        <input class="form-control" name="phone" type="text" value="<%= loggedPerson.getPhone()%>" required>
                                                    </div>
                                                    <br>
                                                    <br>
                                                    <p>Email:</p>
                                                    <div class="input-group">
                                                        <span class="input-group-addon"></span>
                                                        <input class="form-control" name="email" type="text" value="<%= loggedPerson.getAccount().getEmail()%>" required>
                                                    </div>
                                                    <br>
                                                    <br>
                                                    <p>Web Page:</p>
                                                    <div class="input-group">
                                                        <span class="input-group-addon"></span>
                                                        <input class="form-control" name="webPage" type="text" value="<%= loggedPerson.getWebPage()%>" >
                                                    </div>
                                                    <br>
                                                    <br>
                                                    <p>Interessi di Ricerca:</p>
                                                    <div class="input-group">
                                                        <span class="input-group-addon"></span>
                                                        <textarea class="form-control" name="coverLetter" rows="5" cols="40"> <%= loggedPerson.getCoverLetter()%> </textarea>
                                                    </div>
                                                    <br>
                                                    <br>

                                                    <div>
                                                        <input type="submit"class="btn btn-blue" value="Modifica">
                                                        <br>
                                                        <br>

                                                    </div>
                                                </td></tr>
                                        </table>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-1"></div>

                </div>
            </div>



    </body>
</html>
