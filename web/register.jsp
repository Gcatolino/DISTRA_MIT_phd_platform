<%-- 
    Document   : register
    Created on : 4-dic-2014, 11.33.49
    Author     : gemmacatolino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="Xenon Boostrap Admin Panel" />
        <meta name="author" content="" />

        <title>DISTRA-MIT</title>

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Arimo:400,700,400italic">
        <link rel="stylesheet" href="assets/css/fonts/linecons/css/linecons.css">
        <link rel="stylesheet" href="assets/css/fonts/fontawesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/bootstrap.css">
        <link rel="stylesheet" href="assets/css/xenon-core.css">
        <link rel="stylesheet" href="assets/css/xenon-forms.css">
        <link rel="stylesheet" href="assets/css/xenon-components.css">
        <link rel="stylesheet" href="assets/css/xenon-skins.css">
        <link rel="stylesheet" href="assets/css/custom.css">

        <script src="assets/js/jquery-1.11.1.min.js"></script>


        <script type="text/javascript">

            $(function () {
                $("#all-form").hide()
            });

            function doSomething() {
                if ($("#select-account").val() === 'Bstudent') {
                    $(".form-control").prop('required', false);
                    $(".student-required").prop('required', true);
                    $("#all-form").show();
                } else if ($("#select-account").val() === 'Mstudent') {
                    $(".form-control").prop('required', false);
                    $(".student-required").prop('required', true);
                    $("#all-form").show();
                } else if ($("#select-account").val() === 'professor') {
                    $(".form-control").prop('required', false);
                    $(".professor-required").prop('required', true);
                    $("#all-form").show();
                } else if ($("#select-account").val() === 'phd') {
                    $("#all-form").show();
                    $(".form-control").prop('required', false);
                    $(".phd-required").prop('required', true);
                } else if ($("#select-account").val() === 'company') {
                    $("#all-form").show();
                     $(".form-control").prop('required', false);
                    $(".company-required").prop('required', true);
                } else if ($("#select-account").val() === '') {
                    $("#all-form").hide();
                }
            }
            ;
        </script>

        <script language="Javascript" type="text/javascript">
            function testpass(modulo) {
                // Verifico che il campo password sia valorizzato in caso contrario
                // avverto dell'errore tramite un Alert
                if (modulo.password.value === "") {
                    alert("Errore: inserire una password!");
                    modulo.password.focus();
                    return false;
                }
                // Verifico che le due password siano uguali, in caso contrario avverto
                // dell'errore con un Alert
                if (modulo.password.value !== modulo.password_2.value) {
                    alert("La password inserita non coincide con la prima!");
                    modulo.password.focus();
                    modulo.password.select();
                    return false;
                }

                var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                var patt = new RegExp(re);

                if (patt.test(modulo.email.value) === false) {
                    alert("L'e-mail inserita non è corretta!");
                    modulo.email.focus();
                    return false;
                }

                return true;
            }
        </script>

    </head>
    <body class="page-body">

        <nav class="navbar horizontal-menu navbar-fixed-top"><!-- set fixed position by adding class "navbar-fixed-top" -->

            <div class="navbar-inner">

                <!-- Navbar Brand -->
                <div class="navbar-brand">
                    <a href="index.jsp" class="logo">
                        <img src="assets/images/mitforsite.png" width="80" alt="" class="hidden-xs" />
                        <img src="assets/images/mitforsitemini.png" width="80" alt="" class="visible-xs" />
                    </a>
                </div>

                <!-- Mobile Toggles Links -->
                <div class="nav navbar-mobile">

                    <!-- This will toggle the mobile menu and will be visible only on mobile devices -->
                    <div class="mobile-menu-toggle">

                        <a href="#" data-toggle="user-info-menu-horizontal">
                            <i class="fa-key"></i>
                        </a>

                        <a href="#" data-toggle="mobile-menu-horizontal">
                            <i class="fa-bars"></i>
                        </a>
                    </div>
                </div>

                <div class="navbar-mobile-clear"></div>

                <!-- main menu -->

                <ul class="navbar-nav">
                    <li>
                        <a href="index.jsp">
                            <i class="fa fa-home"></i>
                            <span class="title">Home</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="linecons-desktop"></i>
                            <span class="title">Offerta Formativa</span>
                        </a>		
                    </li>
                    <li>
                        <a href="#">
                            <i class="linecons-graduation-cap"></i>
                            <span class="title">Gestione Tesi</span>
                        </a>
                    </li>
                    <li>
                        <a href="gestioneTirocinio.html">
                            <i class="linecons-megaphone"></i>
                            <span class="title">Gestione Tirocinio</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="linecons-lightbulb"></i>
                            <span class="title">Dottorato</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="linecons-globe"></i>
                            <span class="title">Links</span>
                        </a>
                        <ul>
                            <li>
                                <a href="http://www.magistralemit.unisa.it/" target="_blank">
                                    <span class="title">DISTRA-MIT</span>
                                </a>
                            </li>
                            <li>
                                <a href="https://esse3web.unisa.it/unisa/Start.do" target="_blank">
                                    <span class="title">Esse3</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>



                <!-- notifications and other links -->
                <ul class="nav nav-userinfo navbar-right">
                    <li class="active">
                        <a href="register.jsp">
                            <i class="fa-pencil"></i>
                            <span class="title">Registrazione</span>
                        </a>
                    </li>
                    <li>
                        <a href="login.jsp">
                            <i class="fa-user"></i>
                            <span class="title">Login</span>
                        </a>
                    </li>
                </ul>

            </div>

        </nav>
        <!--BODY-->

        <div class="page-container">
            <div class="main-content">
                <div class="row">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-8">
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">Registrati a MITPlatform</h3>
                            </div>



                            <form id="registrationForm" class="form-horizontal" method="POST" action="registration" onsubmit="return testpass(this)"/>
                            <div class="form-group">

                                <label class="col-sm-2 control-label">Tipo di account: </label>
                                <div class="col-sm-10">
                                    <select class="form-control" name="typeOfAccount" id="select-account" onchange="doSomething()">
                                        <option value="">Seleziona il tuo account</option>
                                        <option value="Bstudent">Studente Triennale</option>
                                        <option value="Mstudent">Studente Magistrale</option>
                                        <option value="phd">PhD Student</option>
                                        <option value="professor">Docente</option>
                                        <option value="company">Rappresentante Azienda</option>
                                    </select>
                                </div>

                            </div>

                            <div id="all-form">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Nome: </label>
                                    <div class="col-sm-10">
                                        <input type="text" name="name" class="form-control company-required phd-required student-required professor-required" id="name" style="width: 75%"/>
                                        <span id="name" style="color:#cc3f44"></span>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Cognome: </label>
                                    <div class="col-sm-10">
                                        <input type="text" name="surname"class="form-control company-required phd-required student-required professor-required" id="surname" style="width: 75%"/>
                                        <span id="surname" style="color:#cc3f44"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Telefono: </label>
                                    <div class="col-sm-10">
                                        <input type="text" name="phone"class="form-control company-required phd-required student-required professor-required" id="phone" style="width: 75%"/>
                                        <span id="phone" style="color:#cc3f44"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Codice Fiscale: </label>
                                    <div class="col-sm-10">
                                        <input type="text" name="ssn" class="form-control company-required phd-required student-required professor-required" id="SSN" style="width: 75%"/>
                                        <span id="SSN" style="color:#cc3f44"></span>
                                    </div>
                                </div>
                                <div class="form-group" >
                                    <label class="col-sm-2 control-label">Sesso: </label>
                                    <div class="col-sm-10">
                                        <select name="gender" class="form-control company-required phd-required student-required professor-required" id="select-gender" style="width: 25%"/>
                                        <option value=""></option>
                                        <option value="F">F</option>
                                        <option value="M">M</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Indirizzo: </label>
                                    <div class="col-sm-10">
                                        <input type="text" name="address" class="form-control company-required phd-required student-required professor-required" id="address" style="width: 75%"/>
                                        <span id="address" style="color:#cc3f44"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Citt&agrave;: </label>
                                    <div class="col-sm-10">
                                        <input type="text" name="city" class="form-control company-required phd-required student-required professor-required" id="city" style="width: 75%"/>
                                        <span id="city" style="color:#cc3f44"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">C.A.P.: </label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control company-required phd-required student-required professor-required" id="zipCode" name="zipCode" style="width: 25%"/>
                                        <span id="zipCode" style="color:#cc3f44"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Cittadinanza: </label>
                                    <div class="col-sm-10">
                                        <input type="text" name="citizenship" class="form-control company-required phd-required student professor-required" id="cityzenship" style="width: 75%"/>
                                        <span id="cityzenship" style="color:#cc3f44"></span>
                                    </div>
                                </div>
                                <br>
                                <div class="form-group-separator"></div>
                                <br>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Matricola </label>
                                    <div class="col-sm-10">
                                        <input type="text" name="matricula" class="form-control student-required" id="matricula" style="width: 25%"/>
                                        <span id="matricula" style="color:#cc3f44"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Università </label>
                                    <div class="col-sm-10">
                                        <input type="text" name="university" class="form-control phd-required student-required professor-required" id="university" style="width: 75%"/>
                                        <span id="university" style="color:#cc3f44"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Corso di laurea: </label>
                                    <div class="col-sm-10">
                                        <select class="form-control phd-required student-required" name="degree" id="select-cdL" style="width: 75%"/>
                                        <optgroup label="">
                                            <option value=""></option>
                                        </optgroup>
                                        <optgroup label="Triennale">
                                            <option value="EM">Corso di Laurea in Economia e Management</option>
                                        </optgroup>
                                        <optgroup label="Magistrale">
                                            <option value="CMA">Corso di Laurea in Consulenza e Management Aziendale</option>
                                            <option value="MIT">Corso di Laurea in Tecnologie Informatiche e Management</option>
                                        </optgroup>
                                        <optgroup label="Dottorato">
                                            <option value="DMIT">Corso di Dottorato in Management & Information Technology</option>
                                        </optgroup>
                                        </select>


                                    </div>

                                </div>

                                <div class="form-group">

                                    <label class="col-sm-2 control-label">Dipartimento: </label>
                                    <div class="col-sm-10">
                                        <select class="form-control student-required phd-required professor-required" name="department" id="select-departement" style="width: 30%"/>
                                        <option value=""></option>
                                        <option value="distra">Distra</option> 
                                        </select>
                                    </div>

                                </div>

                                <br>
                                <div class="form-group-separator"></div>
                                <br>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Pagina Web </label>
                                    <div class="col-sm-10">
                                        <input type="text" name="webPage" class="form-control company-required professor-required" id="webPage" style="width: 75%">
                                        <span id="webPage" style="color:#cc3f44"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Posizione </label>
                                    <div class="col-sm-10">
                                        <input type="text" NAME="position" class="form-control professor-required" id="position" placeholder="Es. Ricercatore, Associato ecc.." style="width: 75%">
                                        <span id="position" style="color:#cc3f44"></span>
                                    </div>
                                </div>
                                <br>
                                <div class="form-group-separator"></div>
                                <br>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">E-mail: </label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control phd-required company-required student-required professor-required" id="email" name="email" placeholder="@unisa, @studenti.unisa, mail azienda" style="width: 75%"/>
                                        <span id="email" style="color:#cc3f44"></span>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Password: </label>
                                    <div class="col-sm-10">
                                        <input type='password' name="password" class="form-control company-required phd-required student-required professor-required" name="password" id='password' style="width: 75%" />
                                        <span id="password" style="color:#cc3f44"></span>

                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Ripeti Password: </label>
                                    <div class="col-sm-10">
                                        <input type="password" class="form-control phd-required company-required student-required professor-required" id="repeatPassword" name="password_2" style="width: 75%">
                                        <span id="repeatPassword" style="color:#cc3f44"></span>
                                    </div>
                                </div>

                                <div align="center">
                                    <input type="submit" id="register" class="btn btn-red" value="Registrati"> 

                                </div>
                            </div>

                            </form>
                        
                    </div>
                </div>
                <div class="col-sm-2"></div>
            </div>
            <footer class="main-footer sticky footer-type-1">
                <div class="footer-inner">
                    <!-- Add your copyright text here -->
                    <div class="footer-text">
                        &copy;
                        <a href="http://www.unisa.it" target="_blank"><strong>Unisa</strong> </a>
                    </div>
                    <!-- Go to Top Link, just add rel="go-top" to any link to add this functionality -->
                    <div class="go-up">
                        <a href="#" rel="go-top">
                            <i class="fa-angle-up"></i>
                        </a>
                    </div>
                </div>
            </footer>
        </div>
    </div>


    <!-- Bottom Scripts -->
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/TweenMax.min.js"></script>
    <script src="assets/js/resizeable.js"></script>
    <script src="assets/js/joinable.js"></script>
    <script src="assets/js/xenon-api.js"></script>
    <script src="assets/js/xenon-toggles.js"></script>
    <script src="assets/js/jquery-ui/jquery-ui.min.js"></script>

    <!-- JavaScripts initializations and stuff -->
    <script src="assets/js/xenon-custom.js"></script>

</body>
</html>