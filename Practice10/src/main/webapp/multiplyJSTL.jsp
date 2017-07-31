<%@ page import="java.net.URL" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>Calculation</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.css">

</head>
<body>
<table>

    <c:forEach var="i" begin="0" end="9">
        <tr>
        <c:forEach var="j" begin="0" end="9">
            <c:choose>
                <c:when test="${i == 0 && j == 0}"><th></th></c:when>
                <c:when test="${i == 0}"><th>${j}</th></c:when>
                <c:when test="${j == 0}"><th>${i}</th></c:when>
                <c:otherwise><th>${i * j}</th></c:otherwise>
            </c:choose>
            </c:forEach>
        </tr>
    </c:forEach>

</table>
</body>
</html>

