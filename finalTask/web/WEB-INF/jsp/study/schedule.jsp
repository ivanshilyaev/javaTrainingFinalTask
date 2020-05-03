<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Расписание</title>
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
<c:url value="/study/schedule.html" var="scheduleUrl"/>
<form name="schedule" method="POST" action="${scheduleUrl}">
    <input type="hidden" name="day" value="0">
    <input type="submit" value="Понедельник">
</form>
<br>
<c:url value="/study/schedule.html" var="scheduleUrl"/>
<form name="schedule" method="POST" action="${scheduleUrl}">
    <input type="hidden" name="day" value="1">
    <input type="submit" value="Вторник">
</form>
<br>
<c:url value="/study/schedule.html" var="scheduleUrl"/>
<form name="schedule" method="POST" action="${scheduleUrl}">
    <input type="hidden" name="day" value="2">
    <input type="submit" value="Среда">
</form>
<br>
<c:url value="/study/schedule.html" var="scheduleUrl"/>
<form name="schedule" method="POST" action="${scheduleUrl}">
    <input type="hidden" name="day" value="3">
    <input type="submit" value="Четверг">
</form>
<br>
<c:url value="/study/schedule.html" var="scheduleUrl"/>
<form name="schedule" method="POST" action="${scheduleUrl}">
    <input type="hidden" name="day" value="4">
    <input type="submit" value="Пятница">
</form>
<br>
<c:url value="/study/schedule.html" var="scheduleUrl"/>
<form name="schedule" method="POST" action="${scheduleUrl}">
    <input type="hidden" name="day" value="5">
    <input type="submit" value="Суббота">
</form>
<br>
<c:if test="${sessionScope.schedule == null}">
    <br>
</c:if>
<c:if test="${sessionScope.schedule != null}">
    <c:if test="${sessionScope.schedule.size() == 0}">
        List is empty!<br>
    </c:if>
    <c:if test="${sessionScope.schedule.size() != 0}">
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
            <c:forEach var="student" items="${sessionScope.schedule}">
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
</c:if>
<hr>

<script>
    function goBack() {
        window.history.back();
    }
</script>

<button onclick="goBack()">Go Back</button>
</body>
</html>