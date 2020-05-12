<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ctg" uri="customTags" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/student.css"/>
    <title>Новый преподаватель</title>
</head>
<body>

<%@ include file="../header/adminHeader.jsp" %>

<div class="content">
    <form class="add-form" name="addTutorForm" method="POST" action="${editUrl}">
        <label>
            Фамилия <br>
            <input type="text" name="surname">
        </label> <br>
        <label>
            Имя <br>
            <input type="text" name="name">
        </label> <br>
        <label>
            Отчество <br>
            <input type="text" name="patronymic">
        </label> <br>
        <label>
            Должность <br>
            <select name="position">
                <option value="ассистент">ассистент</option>
                <option value="преподаватель">преподаватель</option>
                <option value="старший преподаватель">страший преподаватель</option>
                <option value="доцент">доцент</option>
                <option value="профессор">профессор</option>
                <option value="">другое</option>
            </select>
        </label> <br>
        <label>
            Учёная степень <br>
            <select name="degree">
                <option value="кандидат наук">кандидат наук</option>
                <option value="доктор наук">доктор наук</option>
                <option value="магистр">магистр</option>
                <option value="">другое</option>
            </select>
        </label> <br>
        <label>
            Логин <br>
            <input type="text" name="login">
        </label> <br>
        <input type="submit" value="Добавить">
    </form>
    ${requestScope.message}
</div>

<%@ include file="../footer/footer.jsp" %>

<%--<ctg:footer address="${sessionScope.address}"/>--%>
</body>
</html>
