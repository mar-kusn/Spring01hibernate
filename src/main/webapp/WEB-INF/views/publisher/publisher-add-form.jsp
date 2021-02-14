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
    <title>Add Publisher</title>
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

<h2>Add Publisher</h2>
<form:form method="post" modelAttribute="publisher">
    <div>
        <label for="name">firstName</label>
        <form:input type="text" id="name" path="name"/>
        <form:errors path="name"/>
    </div>
    <div>
        <label for="books">books</label>
        <form:select items="${books}" itemValue="id" itemLabel="title" id="books" path="books" multiple="true"/>
        <form:errors path="books"/>
    </div>
    <%--<div>
        <label for="pesel">pesel</label>
        <form:input type="text" id="pesel" path="pesel" />
        <form:errors path="pesel"/>
    </div>
    <div>
        <label for="email">email</label>
        <form:input type="email" id="pesel" path="email" />
        <form:errors path="email"/>
    </div>--%>
    <div>
        <input type="submit"/>
    </div>
    <div>
        <form:errors path="*" element="p" cssClass="cssErrors"/>
    </div>
</form:form>

</body>
</html>
