<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 31.01.2021
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All books</title>
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">

</head>
<body>
<h2>Book list</h2>
<a href="/bookform/add">Dodaj książkę</a><br />
<table>
    <tr><th>id</th><th>title</th><th>rating</th><th>publisher</th><th>description</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.publisher}</td>
            <td>${book.description}</td>
            <td><a href="/bookform/edit/${book.id}">Edit</a></td>
            <td><a href="/bookform/delete/${book.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
