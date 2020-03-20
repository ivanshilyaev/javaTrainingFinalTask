<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>XML task</title>
</head>
<br>
<h2>XML Parser</h2>
Select a file to upload <br/>
<form name="Upload" action="parse" method="POST" enctype="multipart/form-data">
  <input type="file" name="file" size="50"/> <br><br>
  <input type="submit" name="button" value="SAX"/>
  <input type="submit" name="button" value="DOM"/>
  <input type="submit" name="button" value="StAX"/>
</form>
</body>
</html>
