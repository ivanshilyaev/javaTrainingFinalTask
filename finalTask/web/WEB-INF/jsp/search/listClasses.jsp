<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="ctg" uri="customTags" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Список всех пар</title>
    <style>
        table {
            border-collapse: collapse;
        }

        table, tr, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<c:if test="${requestScope.listUsers.size() != 0}">
    <table class="table table-bordered">
        <thead>
        <c:set var="index" value="1"/>
        <tr>
            <th scope="col">№</th>
            <th scope="col">День</th>
            <th scope="col">Номер пары</th>
            <th scope="col">Предмет</th>
            <th scope="col">Тип</th>
            <th scope="col">Аудитория</th>
            <th scope="col">Группа</th>
            <th scope="col">Подгруппа</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${requestScope.listUsers}">
            <tr>
                <td><c:out value="${index}"/></td>
                <td><c:out value="${ user.id }"/></td>
                <td><c:out value="${ user.login }"/></td>
                <td><c:out value="${ user.surname }"/></td>
                <td><c:out value="${ user.name }"/></td>
                <td><c:out value="${ user.patronymic }"/></td>
                <td><c:out value="${ user.patronymic }"/></td
                <td><c:out value="${ user.patronymic }"/></td
            </tr>
            <c:set var="index" value="${index + 1}"/>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<c:if test="${requestScope.listUsers.size() == 0}">
    Список пуст!<br>
</c:if>
<hr>
<c:url value="/index.html" var="indexUrl"/>
<form name="mainPage" method="POST" action="${indexUrl}">
    <input type="submit" value="На главную">
</form>
<ctg:footer address="${sessionScope.address}"/>
</body>
</html>
