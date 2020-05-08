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
<c:url value="/study/performance.html" var="performanceUrl"/>
<form name="schedule" method="POST" action="${performanceUrl}">
    <input type="hidden" name="semester" value="1">
    <input type="submit" value="Семестр 1">
</form>
<br>
<c:url value="/study/performance.html" var="performanceUrl"/>
<form name="schedule" method="POST" action="${performanceUrl}">
    <input type="hidden" name="semester" value="2">
    <input type="submit" value="Семестр 2">
</form>
<br>
<c:url value="/study/performance.html" var="performanceUrl"/>
<form name="schedule" method="POST" action="${performanceUrl}">
    <input type="hidden" name="semester" value="3">
    <input type="submit" value="Семестр 3">
</form>
<br>
<c:url value="/study/performance.html" var="performanceUrl"/>
<form name="schedule" method="POST" action="${performanceUrl}">
    <input type="hidden" name="semester" value="4">
    <input type="submit" value="Семестр 4">
</form>
<br>
</form>
<br>
<c:if test="${requestScope.performance == null}">
    <br>
</c:if>
<c:if test="${requestScope.performance != null}">
    <c:if test="${requestScope.performance.size() == 0}">
        Список пуст!<br>
    </c:if>
    <c:if test="${requestScope.performance.size() != 0}">
        <table class="table table-bordered">
            <thead>
            <c:set var="index" value="1"/>
            <tr>
                <th scope="col">№</th>
                <th scope="col">Предмет</th>
                <th scope="col">Зачёт</th>
                <th scope="col">Экзамен</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="performance" items="${requestScope.performance}">
                <tr>
                    <td><c:out value="${index}"/></td>
                    <td><c:out value="${ performance.subject.name }"/></td>
                    <td><c:out value="${ performance.credit }"/></td>
                    <td><c:out value="${ performance.exam }"/></td>
                </tr>
                <c:set var="index" value="${index + 1}"/>
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