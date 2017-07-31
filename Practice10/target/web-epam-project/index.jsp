<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12"><h1 class="h-name">&#183;Practice 9 HOME&#183;</h1></div>
    </div>
    <% request.getSession().invalidate();%>
    <div class="row">
        <div class="col-md-4"><a href="/multiplicationScriplet"><h3>Multiplication</h3></a></div>
        <div class="col-md-4"><a href="/multiplicationJSTL"><h3>Multiplication</h3></a></div>
        <div class="col-md-4"><a href="/inputName"><h3>Input name</h3></a></div>
        <div class="col-md-4"><a href="/vote"><h3>Vote</h3></a></div>
    </div>
    <br/>
</div>
</body>
</html>