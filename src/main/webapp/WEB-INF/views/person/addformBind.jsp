<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 31.01.2021
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add person</title>
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

<h2>Add person</h2>
    <form:form method="post" modelAttribute="person">
        <div>
            <label for="login">login</label>
            <form:input type="text" id="login" path="login"/>
        </div>
        <div>
            <label for="password">password</label>
            <form:password id="password" path="password" />
        </div>
        <div>
            <label for="email">email</label>
            <form:input type="text" id="email" path="email" />
        </div>
        <div>
            <input type="submit"/>
        </div>
    </form:form>

</body>
</html>
