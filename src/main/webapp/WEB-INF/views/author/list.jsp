<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 31.01.2021
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Author all</title>
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

<h2>Author list</h2>
<a href="/authorform/add">Dodaj autora</a><br />
<table>
    <tr><th>id</th><th>First name</th><th>Last name</th><th>PESEL</th><th>Email</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>${author.pesel}</td>
            <td>${author.email}</td>
            <td><a href="/authorform/edit/${author.id}">Edit</a></td>
            <td><a href="/authorform/delete/${author.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
