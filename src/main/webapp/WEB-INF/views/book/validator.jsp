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
    <title>Book validate</title>
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

<h2>Book validate</h2>
<c:if test="${not empty validateok}">${validateok}</c:if>
<c:if test="${not empty violations}">
<table>
    <tr><th>Path</th><th>Message</th></tr>
    <c:forEach items="${violations}" var="violation">
        <tr>
            <td>${violation.propertyPath}</td>
            <td>${violation.message}</td>
        </tr>
    </c:forEach>
</table>
</c:if>

</body>
</html>
