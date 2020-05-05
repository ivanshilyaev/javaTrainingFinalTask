<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="ctg" uri="customTags" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Список всех пользователей</title>
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
<c:if test="${sessionScope.list.size() != 0}">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Login</th>
            <th scope="col">Surname</th>
            <th scope="col">Name</th>
            <th scope="col">Patronymic</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${sessionScope.list}">
            <tr>
                <td><c:out value="${ user.id }"/></td>
                <td><c:out value="${ user.login }"/></td>
                <td><c:out value="${ user.surname }"/></td>
                <td><c:out value="${ user.name }"/></td>
                <td><c:out value="${ user.patronymic }"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<c:if test="${sessionScope.list.size() == 0}">
    Список пуст!<br>
</c:if>
<hr>

<script>
    function goBack() {
        window.history.back();
    }
</script>

<button onclick="goBack()">Go Back</button>
<ctg:footer address="${sessionScope.address}"/>
</body>
</html>
