<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form per il controllo delle funzionalità implementate!</h1>
        <h2>[Cicli di dottorato]</h2>
        
        <form method="post" action="../ServletInsertPhdCycle">
            Form di prova per l'inserimento di un ciclo <br>
            Id <input type="text" name="idPhdCycle"> <br>
            Descrizione <input type="text" name="description"> <br>
            Anno <input type="text" name="year"> <br>
            Professore (id) <input type="text" name="professor"> <br>
            <input type="submit" value="Inserisci">
        </form>
        
        <br> <br>
        
        <form method="post" action="../ServletUpdatePhdCycle">
            Form di prova per la modifica di un ciclo <br>
            Id <input type="text" name="idPhdCycle"> <br>
            Descrizione <input type="text" name="description"> <br>
            Anno <input type="text" name="year"> <br>
            Professore (id) <input type="text" name="professor"> <br>
            <input type="submit" value="Modifica">
        </form>
        
        <br> <br>
        
        <form method="post" action="../ServletDeletePhdCycle">
            Form di prova per la cancellazione di un ciclo <br>
            Id <input type="text" name="idPhdCycle"> <br>
            <input type="submit" value="Cancella">
        </form>
        
    </body>
</html>
