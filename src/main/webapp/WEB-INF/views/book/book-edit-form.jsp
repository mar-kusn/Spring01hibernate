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
    <title>Edit book</title>
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

<h2>Edit book</h2>
<form:form method="post" modelAttribute="book">
    <div>
        <label for="title">title</label>
        <form:input type="text" id="title" path="title"/>
        <form:errors path="title"/>
    </div>
    <div>
        <label for="rating">rating</label>
        <form:input type="number" id="rating" path="rating" />
        <form:errors path="rating"/>
    </div>
    <div>
        <label for="description">description</label>
        <form:textarea type="text" id="description" path="description" />
        <form:errors path="description"/>
    </div>
    <div>
        <label for="publisher">publisher</label>
        <form:select items="${publishers}" itemValue="id" itemLabel="name" id="publisher" path="publisher.id" />
        <form:errors path="publisher"/>
    </div>
    <div>
        <label for="authors">authors</label>
        <form:select items="${authors}" itemValue="id" itemLabel="fullName" id="authors" path="authors" multiple="true"/>
        <form:errors path="authors"/>
    </div>
    <div>
        <label for="pages">pages</label>
        <form:input type="number" id="pages" path="pages" />
        <form:errors path="pages"/>
    </div>
    <div>
        <form:hidden path="id" />
        <form:hidden path="category.id" />
        <input type="submit"/>
    </div>
    <div>
        <form:errors path="*" element="p" cssClass="cssErrors"/>
    </div>
</form:form>

</body>
</html>
