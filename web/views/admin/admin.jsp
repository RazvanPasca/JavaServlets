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
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../../assets/css/admin.css" media="screen"/>
</head>
<body>
ADMIN LANDING PAGE
<a href="/logout">Logout</a>
<%--@elvariable id="flights" type="java.util.List"--%>
<ul>
    <h3>Flights</h3>
    <c:forEach var="flight" items="${flights}">
        <li>
            Departure City: <c:out value="${flight}"/>
            <br>
            Arrival City: <c:out value="${flight}"/>
        </li>
        <br/>
    </c:forEach>

    <h3>Users</h3>
    <c:forEach var="user" items="${users}">
        <li>
            User: <c:out value="${user}"/>
        </li>
        <br/>
    </c:forEach>
</ul>
</body>
</html>
