<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Table</title>
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
<table>
    <tr>
        <td>ID</td>
        <td>Login</td>
        <td>Surname</td>
        <td>Name</td>
        <td>Patronymic</td>
        <td>Course</td>
        <td>Group</td>
        <td>Subgroup</td>
        <td>Faculty</td>
    </tr>
    <c:forEach var="student" items="${requestScope.list}">
        <tr>
            <td><c:out value="${ student.id }"/></td>
            <td><c:out value="${ student.user.login }"/></td>
            <td><c:out value="${ student.user.surname }"/></td>
            <td><c:out value="${ student.user.name }"/></td>
            <td><c:out value="${ student.user.patronymic }"/></td>
            <td><c:out value="${ student.subgroup.group.courseNumber }"/></td>
            <td><c:out value="${ student.subgroup.group.groupNumber }"/></td>
            <td><c:out value="${ student.subgroup.subgroupNumber }"/></td>
            <td><c:out value="${ student.subgroup.group.faculty.name }"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
