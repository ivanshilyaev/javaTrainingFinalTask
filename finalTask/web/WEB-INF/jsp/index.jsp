<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Index</title>
</head>
<body>
<!-- fix -->
<c:url value="/login.html" var="loginUrl"/>
<form method="post" action="${loginUrl}">
    <jsp:forward page="login.jsp"/>
</form>
</body>
</html>
