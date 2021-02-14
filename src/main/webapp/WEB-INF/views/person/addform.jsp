<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 31.01.2021
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add person</title>
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

<h2>Add person</h2>
<form method="post">
    <div>
        <label for="login">login</label>
        <input type="text" id="login" name="login" />
    </div>
    <div>
        <label for="password">password</label>
        <input type="password" id="password" name="password" />
    </div>
    <div>
        <label for="email">email</label>
        <input type="text" id="email" name="email" />
    </div>
    <div>
        <input type="submit"/>
    </div>
</form>

</body>
</html>
