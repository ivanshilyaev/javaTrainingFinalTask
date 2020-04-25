<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Main</title>
</head>
<body>
<h2>Welcome</h2>
<hr>
Hello, ${user}!
<hr>
<c:url value="/list.html" var="listUrl"/>
<form name="findAllUsersForm" method="POST" action="${listUrl}">
    <input type="hidden" name="command" value="find_all_users">
    <input type="submit" value="Find all users">
</form>
<br>
<c:url value="/password.html" var="passwordUrl"/>
<form name="findAllUsersForm" method="POST" action="${passwordUrl}">
    <input type="hidden" name="command" value="main">
    <input type="submit" value="Change password">
</form>
<hr>
<a href="controller?command=logout">Logout</a>
</body>
</html>
