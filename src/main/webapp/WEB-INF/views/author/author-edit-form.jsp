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
    <title>Edit author</title>
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

<h2>Edit author</h2>
<form:form method="post" modelAttribute="author">
    <div>
        <label for="firstName">First Name</label>
        <form:input type="text" id="firstName" path="firstName"/>
        <form:errors path="firstName"/>
    </div>
    <div>
        <label for="lastName">Last Name</label>
        <form:input type="text" id="lastName" path="lastName"/>
        <form:errors path="lastName"/>
    </div>
    <div>
        <label for="books">Books</label>
        <form:select items="${books}" itemValue="id" itemLabel="title" id="books" path="books" multiple="true" disabled="true"/>
        <form:errors path="books"/>
    </div>
    <%--<div>
        <label for="pesel">PESEL</label>
        <form:input type="text" id="pesel" path="pesel" />
        <form:errors path="pesel"/>
    </div>
    <div>
        <label for="email">Email</label>
        <form:input type="email" id="email" path="email" />
        <form:errors path="email"/>
    </div>--%>
    <div>
        <form:hidden path="id" />
        <input type="submit"/>
    </div>
    <div>
        <form:errors path="*" element="p" cssClass="cssErrors"/>
    </div>
</form:form>

</body>
</html>
