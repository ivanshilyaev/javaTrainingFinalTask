<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
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
<table class="table table-bordered">
    <c:if test="${requestScope.list.size() != 0}">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Login</th>
        <th scope="col">Surname</th>
        <th scope="col">Name</th>
        <th scope="col">Patronymic</th>
        <th scope="col">Course</th>
        <th scope="col">Group</th>
        <th scope="col">Subgroup</th>
        <th scope="col">Faculty</th>
    </tr>
    </thead>
    <tbody>
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
    <tr>
        <td colspan="9">
            <a href="index.jsp">Return to parsing page</a>
        </td>
    </tr>
    </tbody>
    </c:if>
    <c:if test="${requestScope.list.size() == 0}">
    <tbody>
    <tr>
        <td>
            No file chosen or nothing to parse!
        </td>
    </tr>
    <tr>
        <td>
            <a href="index.jsp">Return to parsing page</a>
        </td>
    </tr>
    </tbody>
    </c:if>
    <table/>
</body>
</html>
