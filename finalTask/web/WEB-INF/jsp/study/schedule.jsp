<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="ctg" uri="customTags" %>
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
<c:if test="${requestScope.schedule == null}">
    <br>
</c:if>
<c:if test="${requestScope.schedule != null}">
    <c:if test="${requestScope.schedule.size() == 0}">
        Список пуст!<br>
    </c:if>
    <c:if test="${requestScope.schedule.size() != 0}">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">№ пары</th>
                    <%-- Время! (начала и окончания пары) --%>
                <th scope="col">Диспиплина</th>
                <th scope="col">Тип</th>
                <th scope="col">Аудитория</th>
                <th scope="col">Преподаватель</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="timetable" items="${requestScope.schedule}">
                <tr>
                    <td><c:out value="${ timetable.pairNumber }"/></td>
                    <td><c:out value="${ timetable.subject.name }"/></td>
                    <td><c:out value="${ timetable.classType.getName() }"/></td>
                    <td><c:out value="${ timetable.classroom.number }"/></td>
                    <td><c:out value="${ timetable.tutor.user.surname }
                    ${fn:substring(timetable.tutor.user.name, 0, 1)}.${fn:substring(timetable.tutor.user.patronymic, 0, 1)}."/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</c:if>
<hr>
<c:url value="/index.html" var="indexUrl"/>
<form name="mainPage" method="POST" action="${indexUrl}">
    <input type="submit" value="На главную">
</form>
<ctg:footer address="${sessionScope.address}"/>
</body>
</html>