<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Update password</title>
</head>
<body>
<form name="updatePasswordForm" method="POST" action="controller">
    <input type="hidden" name="command" value="change_password">
    <input type="text" name="old_password" placeholder="old password">
    <br>
    <input type="text" name="new_password" placeholder="new password">
    <br>
    <input type="text" name="new_password_again" placeholder="new password again">
    <br>
    <input type="submit" class="fadeIn fifth" value="Submit">

    <br>
    ${invalidOldPassword}<br>
    ${passwordRepeatedIncorrectly}<br>
    ${samePassword}<br>
</form>
</body>
</html>