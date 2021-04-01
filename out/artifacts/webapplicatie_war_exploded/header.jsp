<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <h1>Woordenlijst</h1>
    <nav>
        <ul>
            <li ${param.actual eq 'Home'?"id = actual":""}>
                <a href="Servlet?command=home">Beheerapplicatie woordenlijst</a></li>
            <li ${param.actual eq 'Overzicht'?"id = actual":""}>
                <a href="Servlet?command=overzicht">Toon woordenlijst</a></li>
            <li ${param.actual eq 'voegToe'?"id = actual":""}>
                <a href="Servlet?command=voegToeForm">Nieuw woord</a></li>
          
        </ul>
    </nav>
</header>