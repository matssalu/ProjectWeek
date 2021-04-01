<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Woord toevoegen</title>
    <link rel="stylesheet" type="text/css" href="style/style.css"/>
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="voegToe"/>
    </jsp:include>

    <main>
        <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <h2>Voeg een woord toe</h2>

        <form method="POST" action="Servlet?command=voegToe">

            <p class="form-group ${naamClass}">
                <label class="control-label" for="naam">Woord</label>
                <input id="naam" name="naam" type="text"
                       value="${naamPreviousValue}" >
            </p>

            <p class="form-group ${soortClass}">
                <label class="control-label" for="soort">Niveau (open laten, beginner of expert)</label>
                <input id="soort" name="soort" type="text"
                       value="${soortPreviousValue}" required>
            </p>


            <p>
                <input id="submit" type="submit" value="Verstuur">
            </p>
        </form>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>