<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ctg" uri="customTags" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <title>Новый студент</title>
</head>

<body>
<br>
${requestScope.message}
<br>
<form name="loginForm" method="POST" action="${editUrl}">
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
        Подгруппа <br>
        <input type="text" name="subgroup">
    </label> <br>
    <label>
        Логин <br>
        <input type="text" name="login">
    </label> <br>
    <input type="submit" value="Добавить">
</form>
<br>
<c:url value="/index.html" var="indexUrl"/>
<form name="findGroup" method="POST" action="${indexUrl}">
    <input type="hidden" name="groupNum" value="${requestScope.groupNum}">
    <input type="hidden" name="courseNum" value="${requestScope.courseNum}">
    <input type="submit" value="На главную">
</form>
<ctg:footer address="${sessionScope.address}"/>
</body>
</html>
