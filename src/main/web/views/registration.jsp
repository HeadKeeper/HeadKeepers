<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.03.2017
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/script/send_userdata.js"></script>
</head>
<body>
    <h1>USER REGISTRATION</h1>
    <form>
        EMAIL:<input type="text" name="user-email">
        PASSWORD:<input type="text" name="user-password">
        NICKNAME:<input type="text" name="user-nickname">
    </form>
    <button name="send-info" onclick="sendDataToServer('registration')">Send</button>

</body>
</html>
