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
    <title>Edit Publisher</title>
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

<h2>Edit Publisher</h2>
<form:form method="post" modelAttribute="publisher">
    <div>
        <label for="name">Name</label>
        <form:input type="text" id="name" path="name"/>
        <form:errors path="name"/>
    </div>
    <div>
        <label for="books">Books</label>
        <form:select items="${books}" itemValue="id" itemLabel="title" id="books" path="books" multiple="true" disabled="true"/>
        <form:errors path="books"/>
    </div>
    <div>
        <label for="nip">nip</label>
        <form:input type="text" id="nip" path="nip" />
        <form:errors path="nip"/>
    </div>
    <div>
        <label for="email">regon</label>
        <form:input type="regon" id="regon" path="regon" />
        <form:errors path="regon"/>
    </div>
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
