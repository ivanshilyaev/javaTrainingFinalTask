<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="ctg" uri="customTags" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Сменить пароль</title>
</head>
<body>
<c:url value="/password.html" var="passwordUrl"/>
<form name="updatePasswordForm" method="POST" action="${passwordUrl}" onsubmit="return validateChangePassword(this)">
    <input type="hidden" name="command" value="change_password">
    <input type="text" name="old_password" placeholder="old password">
    <br>
    <input type="text" name="new_password" placeholder="new password">
    <br>
    <input type="text" name="new_password_again" placeholder="new password again">
    <br>
    <input type="submit" class="fadeIn fifth" value="Submit">

    <br>
    ${sessionScope.passwordMessage}
    <br>

    <!-- Still doesn't work -->
    <input type="button" value="На главную"
           onclick="window.location='${pageContext.request.contextPath}/studentCabinet.jsp'">
</form>
<ctg:footer address="${sessionScope.address}"/>
</body>
</html>
