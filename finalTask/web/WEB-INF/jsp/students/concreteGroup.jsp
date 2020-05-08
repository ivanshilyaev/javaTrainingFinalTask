<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="ctg" uri="customTags" %>
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
<c:url value="/students/edit.html" var="editUrl"/>
<form name="addNewStudent" method="POST" action="${editUrl}">
    <input type="hidden" name="groupNum" value="${requestScope.groupNum}">
    <input type="hidden" name="courseNum" value="${requestScope.courseNum}">
    <input type="submit" value="Добавить нового студента">
</form>
<br>
<c:url value="/students/delete.html" var="deleteUrl"/>
<form name="deleteStudent" method="POST" action="${deleteUrl}">
    <input type="hidden" name="groupNum" value="${requestScope.groupNum}">
    <input type="hidden" name="courseNum" value="${requestScope.courseNum}">
    <input type="submit" value="Удалить студента">
</form>
<br>
${requestScope.message}
<br>
<c:if test="${requestScope.groupList.size() != 0}">
    <table class="table table-bordered">
        <thead>
        <c:set var="index" value="1"/>
        <tr>
            <th scope="col">№</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Имя</th>
            <th scope="col">Отчество</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${requestScope.groupList}">
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
<c:if test="${requestScope.groupList.size() == 0}">
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
