<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/start.css"/>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Новый студент</title>
</head>

<body>
<c:url value="/login.html" var="loginUrl"/>
<form name="loginForm" method="POST" action="${loginUrl}">
    <input type="text" name="login" placeholder="Фамилия">
    <input type="text" name="password" placeholder="Имя">
    <input type="submit" class="fadeIn fourth" value="Добавить">
</form>
</body>
</html>
