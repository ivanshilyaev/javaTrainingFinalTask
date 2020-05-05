<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="ctg" uri="customTags" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Error page</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty error}">
        ${error}
    </c:when>
    <c:when test="${not empty pageContext.errorData.requestURI}">
        Request from ${pageContext.errorData.requestURI} is failed <br/>
        Servlet name or type: ${pageContext.errorData.servletName} <br/>
        Status code: ${pageContext.errorData.statusCode} <br/>
        Exception: ${pageContext.errorData.throwable}
    </c:when>
    <c:otherwise>Unknown error</c:otherwise>
</c:choose>
<ctg:footer address="${sessionScope.address}"/>
</body>
</html>
