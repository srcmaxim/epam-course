<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>Request</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12"><h1 class="h-name">&#183;Result&#183;</h1></div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h3>Your params: x=<%=session.getAttribute("x")%>, y=<%=session.getAttribute("y")%>
            </h3>
            <% if (session.getAttribute("r") != null) { %>
            <h3>Result: <%=session.getAttribute("r")%>
            </h3>
            <% } else { %>
            <h3>Result: <%=session.getAttribute("e")%>
            </h3>
            <% } %>
        </div>
        <div class="col-md-12">
            <a href="<%=session.getAttribute("url")%>"><h3>Go to calculation</h3></a>
        </div>
    </div>
    <br>
</div>
</body>
</html>