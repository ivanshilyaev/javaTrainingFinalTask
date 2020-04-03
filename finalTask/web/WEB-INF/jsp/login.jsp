<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Login</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="login">
    Login:<br>
    <input type="text" name="login" value="">
    <br>Password:<br>
    <input type="text" name="password" value="">
    <br>
    ${errorLoginPasswordMessage}<br>
    ${wrongAction}<br>
    ${nullPage}<br>
    <input type="submit" value="Log in">
</form>
<hr>
</body>
</html>
