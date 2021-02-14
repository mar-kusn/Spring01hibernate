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

<h2>Are you sure to delete publisher?</h2>
<form:form method="post" modelAttribute="publisher">
    <table>
        <tr><th>id</th><th>Name</th></tr>
        <tr>
            <td>${author.id}</td>
            <td>${author.name}</td>
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
