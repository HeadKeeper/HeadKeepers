<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.03.2017
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <script src="/resources/script/send_userdata.js"></script>
</head>
<body>
    <form>
        <input type="text" name="userBase-email">
        <input type="text" name="userBase-password">
        <input type="text" name="userBase-nickname">
    </form>
    <button name="send-info" onclick="sendDataToServer('profile/2')">Send</button>
</body>
</html>
