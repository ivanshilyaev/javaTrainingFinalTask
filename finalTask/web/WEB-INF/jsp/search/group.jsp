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

<header id="appHeader">
    <div class="navbar">
        <a href="https://bsu.by/">БГУ</a>
        <c:url value="/studentCabinet.html" var="cabinetUrl"/>
        <form style="margin-left: auto" class="menu-form" name="findAllStudentsFromTheGroup" method="POST"
              action="${cabinetUrl}">
            <input type="submit" value="Мой профиль">
        </form>
        <c:url value="/search/group.html" var="groupUrl"/>
        <form class="menu-form" name="findAllStudentsFromTheGroup" method="POST" action="${groupUrl}">
            <input type="submit" value="Моя группа">
        </form>
        <c:url value="/study/schedule.html" var="scheduleUrl"/>
        <form class="menu-form" name="schedule" method="POST" action="${scheduleUrl}">
            <input type="submit" value="Расписание">
        </form>
        <c:url value="/study/performance.html" var="performanceUrl"/>
        <form class="menu-form" name="performance" method="POST" action="${performanceUrl}">
            <input type="submit" value="Успеваемость">
        </form>
        <c:url value="/password.html" var="passwordUrl"/>
        <form class="menu-form" name="changePasswordForm" method="POST" action="${passwordUrl}">
            <input type="submit" value="Изменить пароль">
        </form>
        <c:url value="/logout.html" var="logoutUrl"/>
        <form class="menu-form" name="logoutForm" method="POST" action="${logoutUrl}">
            <input type="submit" value="Выйти">
        </form>
    </div>
</header>

<div class="content">
    <c:if test="${requestScope.groupList.size() != 0}">
        <table>
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

<div class="links">
    <a href="https://vk.com/bsu_by">VK</a>
    <a href="https://www.instagram.com/official.bsu/?hl=ru">Instagram</a>
    <a href="https://www.facebook.com/bsuby">Facebook</a>
    <a href="https://twitter.com/BSU_official">Twitter</a>
    <a href="https://www.linkedin.com/school/belarusian-state-university/">Linked-in</a>
</div>

<div class="footer">
    <span class="copyright">&copy; Copyright 2020</span>
    <p>Адрес: ул. Октябрьская, 10, 220030, г. Минск, Республика Беларусь</p>
</div>
<%--    <ctg:footer address="${sessionScope.address}"/>--%>

<script>
    window.onscroll = function () {
        myFunction()
    };

    var header = document.getElementById("appHeader");
    var sticky = header.offsetTop;

    function myFunction() {
        if (window.pageYOffset > sticky) {
            header.classList.add("sticky");
        } else {
            header.classList.remove("sticky");
        }
    }
</script>

</body>
</html>
