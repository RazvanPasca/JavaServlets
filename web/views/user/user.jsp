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
    <title>Flights-Page</title>
</head>
<body>
USER LANDING PAGE
<a href="/logout">Logout</a>
<%--@elvariable id="flights" type="java.util.List"--%>
<ul>
    <c:forEach var="flight" items="${flights}">
        <li>
            Departure City: <c:out value="${flight}"/>
            <br>
            Arrival City: <c:out value="${flight}"/>
        </li>
        <br/>
    </c:forEach>
</ul>
</body>
</html>
