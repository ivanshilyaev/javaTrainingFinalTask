<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>XML task</title>
</head>
<body>
<div class="container">
    <h2>XML Parser</h2>
    Select a file to upload <br/>
    <form name="Upload" action="parse" method="POST" enctype="multipart/form-data">
        <input type="file" name="file" size="50"/> <br><br>
        <select name="item">
            <option value="sax">SAX</option>
            <option value="dom">DOM</option>
            <option value="stax">StAX</option>
        </select> <br><br>
        <input type="submit" class="btn btn-primary" name="button" value="Parse"/>
    </form>
</div>
</body>
</html>
