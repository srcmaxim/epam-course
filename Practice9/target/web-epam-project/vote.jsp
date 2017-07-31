<%@ page import="java.util.List" %>
<%@ page import="java.net.URL" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>Vote</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12"><h1 class="h-name">&#183;Your vote&#183;</h1></div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <form action="/vote" method="post">
                <tr>
                    <td>
                        <select name="sport">
                            <% for (String name : (List<String>) request.getAttribute("names")) { %>
                            <option name="<%=name%>"><%=name%>
                            </option>
                            <% } %>
                        </select>
                    </td>
                    <td>
                        <input name="name" type="text">
                    </td>
                </tr>
                <input type="submit" value="Vote">
            </form>
        </div>
        <div class="col-md-12">
            <a href='<%=new URL(request.getScheme(), request.getServerName(),
        request.getServerPort(), request.getContextPath())%>'><h3>Go to home</h3></a>
        </div>
    </div>
    <br>
</div>
</body>
</html>
