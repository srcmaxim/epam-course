<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12"><h1 class="h-name">&#183;Exception&#183;</h1></div>
    </div>
    <div class="row">
        <div class="col-md-4"><p>You already voted!</p></div>
    </div>
    <div class="col-md-12">
        <a href='<%=new URL(request.getScheme(), request.getServerName(),
        request.getServerPort(), request.getContextPath())%>'><h3>Go to home</h3></a>
    </div>
    <br/>
</div>
</body>
</html>