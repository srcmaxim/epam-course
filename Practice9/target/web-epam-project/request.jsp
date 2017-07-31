<%@ page import="java.net.URL" %>
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
        <div class="col-md-12"><h1 class="h-name">&#183;Your request&#183;</h1></div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <h1>GET:</h1>
            <form action='<%=session.getAttribute("url")%>' method='get'>
                <input type='text' placeholder='write your text here' name='text'>
                <input type='submit' value='GET'>
            </form>
        </div>
        <div class="col-md-6">
            <h1>POST:</h1>
            <form action='<%=session.getAttribute("url")%>' method='post'>
                <input type='text' placeholder='write your text here' name='text'>
                <input type='submit' value='POST'>
            </form>
        </div>
        <div class="col-md-12">
            <a href='<%=new URL(request.getScheme(), request.getServerName(),
        request.getServerPort(), request.getContextPath())%>'><h3>Go to home</h3></a>
        </div>
    </div>
    <br/>
</div>
</body>
</html>