<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bekijk alle dieren</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="Overzicht"/>
    </jsp:include>
    <main>
        <c:choose>
            <c:when test="${not empty alleDieren}">
                <h2>Woordenlijst</h2>

                <table>
                    <thead>
                    <tr>
                        <th>Woord</th>
                        <th>Niveau</th>

                    </thead>
                    <tbody>
                        <c:if test="$not empty alleDieren"></c:if>
                    <c:forEach var="dier" items="${alleDieren}">
                        <tr>
                            <td>${dier.naam}
                            </td>
                            <td>${dier.soort}
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <h3><a href="Servlet?command=download">Download
                    woordenlijst</a></h3>

            </c:when>
            <c:otherwise>
                <p>Er zijn geen dieren </p>
            </c:otherwise>
        </c:choose>


    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>