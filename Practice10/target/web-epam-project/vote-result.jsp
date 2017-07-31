<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>Voting results</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12"><h1 class="h-name">&#183;Result of vote&#183;</h1></div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table border="1">
                <tr>
                    <th>sport</th>
                    <th>voted</th>
                    <th>examined</th>
                </tr>
                <% for (Map.Entry<String, List<String>> sports :
                        ((Map<String, List<String>>) request.getAttribute("sports")).entrySet()) { %>
                <tr>
                    <td><%=sports.getKey()%>
                    </td>
                    <td><%=sports.getValue().size()%>
                    </td>
                    <td>
                        <% for (String sport : sports.getValue()) { %>
                        <%=sport%>
                        <% } %>
                    </td>
                </tr>
                <% } %>
            </table>
        </div>
        <div class="col-md-12">
            <a href='<%=session.getAttribute("url")%>'><h3>Back</h3></a>
        </div>
    </div>
    <br>
</div>
</body>
</html>