<%@ page import="java.net.URL" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>Calculation</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.css">

</head>
<body>
<table>

    <% for (int i = 0; i < 10; i++) { %>
        <tr>
            <% for (int j = 0; j < 10; j++) { %>
            <% if (i == 0 && j == 0) { %>
            <th></th>
            <% } else if (i == 0) { %>
            <th><%=j%></th>
            <% } else  if (j == 0) { %>
            <th><%=i%></th>
            <% } else {%>
                <th><%=i*(j)%></th>
            <% } %>
            <% } %>
        </tr>
    <% } %>

</table>
</body>
</html>

