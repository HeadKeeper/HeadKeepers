<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="/">
    <title>Angular</title>
    <script src="https://unpkg.com/systemjs@0.19.6/dist/system.src.js"></script>
    <script src="https://code.angularjs.org/tools/typescript.js"></script>
    <script src="static/system.config.js"></script>
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