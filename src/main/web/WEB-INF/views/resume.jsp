<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.03.2017
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resume</title>
    <script src="/resources/script/send_resumedata.js"></script>
</head>
<body>
    <h1>RESUME</h1>
    <form>
        First Name:<input type="text" name="first-name">
        <br>
        Last Name:<input type="text" name="last-name">
        <br>
        Middle Name:<input type="text" name="middle-name">
        <br>
        Birthdat date:<input type="text" name="birthday-date">
        <br>
        Address:<input type="text" name="address">
        <br>
        Martial Status:<input type="text" name="martial-status">
        <br>
        Rederences:<input type="text" name="references">
        <br>
        Additional information<input type="text" name="additional-information">
    </form>
    <button name="send-info" onclick="sendDataToServer('resume')">Send</button>
</body>
</html>
