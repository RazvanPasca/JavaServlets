<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: raz_p
  Date: 20-Oct-18
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
USER LANDING PAGE
<a href="/logout">Logout</a>
<ul>
    <c:forEach items="${flights}" var="flight">
        <li>
            Departure City: <c:out value="${flight.departureCity}"/>
        </li>
    </c:forEach>
</ul>
</body>
</html>
