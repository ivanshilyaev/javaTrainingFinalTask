<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="ctg" uri="customTags" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/student.css"/>
    <title>Моя группа</title>
</head>
<body>

<header>
    <div class="container">
        <h1 class="BSU"><a href="https://www.bsu.by"><img src="${pageContext.request.contextPath}/img/bsu.png"
                                                          width="60" alt="bsu-logo"></a>БГУ</h1>
        <nav>
            <ul>
                <li>
                    <c:url value="/studentCabinet.html" var="cabinetUrl"/>
                    <form class="menu-form" name="findAllStudentsFromTheGroup" method="POST" action="${cabinetUrl}">
                        <input type="submit" value="Мой профиль">
                    </form>
                </li>
                <li>
                    <c:url value="/search/group.html" var="groupUrl"/>
                    <form class="menu-form" name="findAllStudentsFromTheGroup" method="POST" action="${groupUrl}">
                        <input type="submit" value="Моя группа">
                    </form>
                </li>
                <li>
                    <c:url value="/study/schedule.html" var="scheduleUrl"/>
                    <form class="menu-form" name="schedule" method="POST" action="${scheduleUrl}">
                        <input type="submit" value="Расписание">
                    </form>
                </li>
                <li>
                    <c:url value="/study/performance.html" var="performanceUrl"/>
                    <form class="menu-form" name="performance" method="POST" action="${performanceUrl}">
                        <input type="submit" value="Успеваемость">
                    </form>
                </li>
                <li>
                    <c:url value="/password.html" var="passwordUrl"/>
                    <form class="menu-form" name="changePasswordForm" method="POST" action="${passwordUrl}">
                        <input type="submit" value="Изменить пароль">
                    </form>
                </li>
                <li>
                    <c:url value="/logout.html" var="logoutUrl"/>
                    <form class="menu-form" name="logoutForm" method="POST" action="${logoutUrl}">
                        <input type="submit" value="Выйти">
                    </form>
                </li>
            </ul>
        </nav>
    </div>
</header>

<div class="schedule" id="schedule">
    <div class="container">
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
    </div>
</div>

<footer>
    <div class="wrapper">
        <span class="copyright">&copy; Copyright 2020</span>
        <div class="links">
            <a href="https://www.facebook.com/bsuby"><img src="${pageContext.request.contextPath}/img/facebook.svg"
                                                          alt="facebook"></a>
            <a href="https://twitter.com/BSU_official"><img src="${pageContext.request.contextPath}/img/twitter.svg"
                                                            alt="twitter"></a>
            <a href="https://www.linkedin.com/school/belarusian-state-university/"><img
                    src="${pageContext.request.contextPath}/img/linkedin.svg" alt="linked-in"></a>
        </div>
    </div>
</footer>
<%--    <ctg:footer address="${sessionScope.address}"/>--%>
</body>
</html>
