<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Beheerapplicatie woordenlijst</title>
    <link type="text/css" href="style/style.css" rel="stylesheet"/>
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="Home"/>
    </jsp:include>
        <main>
        <h2>Hangmangame</h2>
        <p> Met deze applicatie kan je de woordenlijst beheren om in het spelletje
            Hangman te gebruiken. </p>
        <p> Klik op "Toon woordenlijst" om de huidige woordenlijst weer te geven. Hier kun je ook
        de woordenlijst downloaden in de vorm van een txt bestand.</p>

        <p> Klik op "Nieuw woord" om een woord toe te voegen aan de woordenlijst, vergeet hierbij geen
        moeilijkheidsgraad te schrijven.</p>


    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>