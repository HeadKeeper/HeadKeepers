<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="/">
    <title>Welcome</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="/node_modules/core-js/client/shim.min.js"></script>
    <script src="/node_modules/zone.js/dist/zone.js"></script>
    <script src="/node_modules/systemjs/dist/system.src.js"></script>
    <script src="/systemjs.config.js"></script>
    <script>
        System.import('app')
            .catch(console.error.bind(console));
    </script>
</head>

<body>
    <application>
        Loading...
    </application>
</body>
</html>
