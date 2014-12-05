<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form per il controllo delle funzionalità implementate!</h1>
        <h2>[Curriculum di dottorato]</h2>
        
        <form method="post" action="../ServletInsertPhdCurriculum">
            Form di prova per l'inserimento di un curriculum <br>
            Nome <input type="text" name="name"> <br>
            Descrizione <input type="text" name="description"> <br>
            Professore (id) <input type="text" name="professor"> <br>
            <input type="submit" value="Inserisci">
        </form>
        
        <br> <br>
         
        <form method="post" action="../ServletUpdatePhdCurriculum">
            Form di prova per la modifica di un curriculum <br>
            Id <input type="text" name="idPhdCurriculum"> <br>
            Nome <input type="text" name="name"> <br>
            Descrizione <input type="text" name="description"> <br>
            Professore (id) <input type="text" name="professor"> <br>
            <input type="submit" value="Inserisci">
        </form>
        
        <br> <br>
        
        <form method="post" action="../ServletDeletePhdCurriculum">
            Form di prova per la cancellazione di un curriculum <br>
            Id <input type="text" name="idPhdCurriculum"> <br>
            <input type="submit" value="Cancella">
        </form>
        
    </body>
</html>
