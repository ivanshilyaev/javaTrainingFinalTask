<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Группа</title>
    <style>
        table {
            border-collapse: collapse;
        }

        table, tr, td {
            border: 1px solid rgb(0, 0, 0);
        }
    </style>
</head>
<body>
<c:if test="${sessionScope.groupList.size() != 0}">
    <table class="table table-bordered">
        <thead>
        <c:set var="index" value="1"/>
        <tr>
            <th scope="col">Number</th>
            <th scope="col">Surname</th>
            <th scope="col">Name</th>
            <th scope="col">Patronymic</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${sessionScope.groupList}">
            <tr>
                <td><c:out value="${index}"/></td>
                <td><c:out value="${ student.user.surname }"/></td>
                <td><c:out value="${ student.user.name }"/></td>
                <td><c:out value="${ student.user.patronymic }"/></td>
            </tr>
            <c:set var="index" value="${index + 1}"/>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<c:if test="${sessionScope.groupList.size() == 0}">
    Список пуст!<br>
</c:if>
<hr>

<c:url value="/students/edit.html" var="editUrl"/>
<form name="addNewUser" method="POST" action="${editUrl}">
    <input type="submit" value="Добавить нового студента">
</form>

<script>
    function goBack() {
        window.history.back();
    }
</script>

<button onclick="goBack()">Go Back</button>
</body>
</html>
