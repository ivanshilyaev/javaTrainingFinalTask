<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="ctg" uri="customTags" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Список факультетов</title>
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
<c:if test="${requestScope.listFaculties.size() != 0}">
    <c:forEach var="faculty" items="${requestScope.listFaculties}">
        <c:url value="/students/listGroups.html" var="listGroupsUrl"/>
        <form name="findGroup" method="POST" action="${listGroupsUrl}">
            <input type="hidden" name="facultyId" value="${faculty.id}">
            <input type="submit" value="${faculty.name}">
        </form>
        <br>
    </c:forEach>
</c:if>
<c:if test="${requestScope.listFaculties.size() == 0}">
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
