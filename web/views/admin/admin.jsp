<%--
  Created by IntelliJ IDEA.
  User: raz_p
  Date: 20-Oct-18
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Flights-Page-Admin</title>
    <meta charset="utf-8">
    <script type="text/javascript" src="../../assets/js/admin.js"></script>
    <link rel="stylesheet" type="text/css" href="../../assets/css/admin.css" media="screen"/>
</head>
<body>
<a id="logout" href="/logout">Logout</a>
<%--@elvariable id="flights" type="java.util.List"--%>
<div id="form">
    <h3>Flights</h3>
    <ul>
        <c:forEach var="flight" items="${flights}">
            <li>
                Departure City: <c:out value="${flight.departureCity}"/>
                <br>
                Arrival City: <c:out value="${flight.arrivalCity}"/>
                <br>
                Departure Time: <c:out value="${flight.departureTime}"/>
                <br>
                Arrival Time: <c:out value="${flight.arrivalTime}"/>
                <button id="delete"
                        type="submit"
                        value=<c:out value="${flight.id}"/>>
                    Delete Flight
                </button>
            </li>
        </c:forEach>
    </ul>

    <form id="addFlight" action="/addFlight" method="post">
        <input type="text" class="input" name="airplane" id="airplane" required="required"
               placeholder="Airplane Type">

        <input type="text" class="input" name="departureCity" id="departureCity" required="required"
               placeholder="Departure City">

        <input type="date" class="input" name="departureTime" id="departureTime" required="required"
               placeholder="Departure Time">

        <input type="text" class="input" name="arrivalCity" id="arrivalCity" required="required"
               placeholder="Arrival City">

        <input type="date" class="input" name="arrivalTime" id="arrivalTime" required="required"
               placeholder="Arrival Time">

        <input type="text" class="input" name="flightNr" id="flightNr" required="required"
               placeholder="Flight Nr">

        <input id="submit-button" type="submit" class="button" value="Add/Update flight">

    </form>
</div>
</body>
</html>
