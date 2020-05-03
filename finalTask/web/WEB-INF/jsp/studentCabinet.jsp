<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Кабинет студента</title>
</head>
<body>
<h2>Account</h2>
<hr>
Добро пожаловать, ${sessionScope.username}!
<hr>
<c:url value="/search/group.html" var="groupUrl"/>
<form name="findAllStudentsFromTheGroup" method="POST" action="${groupUrl}">
    <input type="submit" value="Моя группа">
</form>
<br>
<c:url value="/password.html" var="passwordUrl"/>
<form name="changePasswordForm" method="POST" action="${passwordUrl}">
    <input type="submit" value="Изменить пароль">
</form>
<br>
<c:url value="/study/schedule.html" var="scheduleUrl"/>
<form name="schedule" method="POST" action="${scheduleUrl}">
    <input type="submit" value="Расписание">
</form>
<hr>
<c:url value="/logout.html" var="logoutUrl"/>
<form name="logoutForm" method="POST" action="${logoutUrl}">
    <input type="submit" value="Выйти">
</form>
</html>
