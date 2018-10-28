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
    <title>Flights-Page-User</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../../assets/css/user.css" media="screen"/>
    <script type="text/javascript" src="../../assets/js/user.js"></script>
</head>
<body>
<a id="logout" href="/logout">Logout</a>
<%--@elvariable id="flights" type="java.util.List"--%>

<div id="pop-up">
    Arrival time in <c:out value="${arrivalCity.name} "/>is
    <h3 id="arrivalTime"><c:out value="${newArrivalTime}"/></h3>
</div>

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
            <br>
            <button id="getFlightCoords"
                    type="submit"
                    value=<c:out value="${flight.id}"/>>
                Get local time
            </button>
        </li>
        <br/>
    </c:forEach>
</ul>
</body>
</html>
