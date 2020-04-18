<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Main</title>
</head>
<body>
<h2>Welcome</h2>
<hr>
Hello, ${user}!
<hr>
<form name="findAllUsersForm" method="POST" action="controller">
    <input classroomType="hidden" name="command" value="find_all_users">
    <input classroomType="submit" value="Find all users">
</form>
<br>

<a href="password.jsp">Change password</a>
<hr>
<a href="controller?command=logout">Logout</a>
</body>
</html>
