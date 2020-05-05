<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ctg" uri="customTags" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Кабинет преподавателя</title>
</head>
<body>
<h2>Account</h2>
<hr>
Добро пожаловать, ${sessionScope.username}!
<hr>
<c:url value="/password.html" var="passwordUrl"/>
<form name="changePasswordForm" method="POST" action="${passwordUrl}">
    <input type="submit" value="Изменить пароль">
</form>
<hr>
<c:url value="/logout.html" var="logoutUrl"/>
<form name="logoutForm" method="POST" action="${logoutUrl}">
    <input type="submit" value="Выйти">
</form>
<ctg:footer address="${sessionScope.address}"/>
</body>
</html>
