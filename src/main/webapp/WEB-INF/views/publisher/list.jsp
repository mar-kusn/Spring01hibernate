<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 31.01.2021
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Publisher list</title>
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

<h2>Publisher list</h2>
<table>
    <tr><th>id</th><th>Name</th></tr>
    <c:forEach items="${publishers}" var="publisher">
        <tr>
            <td>${publisher.id}</td>
            <td>${publisher.name}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
