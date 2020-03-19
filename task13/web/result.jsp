<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table</title>
</head>
<body>
<table>
    <c:forEach var="student" items="${requestScope.list}" varStatus="status">
        <tr>
            <td>${ student }</td>
            <td>${ student.id }</td>
        </tr>
    </c:forEach>
    <tr>
        <p>hello world</p>
    </tr>
</table>
</body>
</html>
