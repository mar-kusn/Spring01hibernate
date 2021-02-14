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
    <title>Delete book</title>
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

<h2>Are you sure to delete book?</h2>
<form:form method="post" modelAttribute="book">
    <table>
        <tr><th>id</th><th>title</th><th>rating</th><th>publisher</th><th>description</th><th>authors</th></tr>
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.publisher.name}</td>
            <td>${book.description}</td>
            <td>
                <c:forEach items="${book.authors}" var="author">
                    ${author.fullName}<br>
                </c:forEach>
            </td>
        </tr>
    </table>

    <form:hidden path="id"/>
    <div>
        <input type="submit" name="deleteBtn" value="no" >No</input>
        <input type="submit" name="deleteBtn" value="yes" >Yes</input>
    </div>
</form:form>

</body>
</html>
