<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="ctg" uri="customTags" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/student.css"/>
</head>
<body>

<%@ include file="../header/adminHeader.jsp" %>

<div class="content">
    <div class="button-group-horizontal">
        <c:url value="/tutors/addTutor.html" var="addUrl"/>
        <form class="content-form" name="addTutor" method="POST" action="${addUrl}">
            <input type="submit" value="Добавить преподавателя">
        </form>
        <c:url value="/tutors/deleteTutor.html" var="deleteUrl"/>
        <form class="content-form" name="deleteTutor" method="POST" action="${deleteUrl}">
            <input type="submit" value="Удалить преподавателя">
        </form>
    </div>
    <br>
    ${requestScope.message}
    <br>
    <c:if test="${requestScope.listTutors.size() != 0}">
        <table>
            <thead>
            <c:set var="index" value="1"/>
            <tr>
                <th scope="col">№</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Имя</th>
                <th scope="col">Отчество</th>
                <th scope="col">Должность</th>
                <th scope="col">Степень</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="tutor" items="${requestScope.listTutors}">
                <tr>
                    <td><c:out value="${ index}"/></td>
                    <td><c:out value="${ tutor.user.surname }"/></td>
                    <td><c:out value="${ tutor.user.name }"/></td>
                    <td><c:out value="${ tutor.user.patronymic }"/></td>
                    <td><c:out value="${ tutor.position }"/></td>
                    <td><c:out value="${ tutor.degree }"/></td>
                </tr>
                <c:set var="index" value="${index + 1}"/>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${requestScope.listTutors.size() == 0}">
        Список пуст!<br>
    </c:if>
</div>

<%@ include file="../footer/footer.jsp" %>

<%--<ctg:footer address="${sessionScope.address}"/>--%>
</body>
</html>
