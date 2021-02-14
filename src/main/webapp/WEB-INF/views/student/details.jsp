<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 31.01.2021
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student details</title>
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

<h2>Student details</h2>

<table>
    <thead>
    <th>First name</th>
    <th>Last name</th>
    <th>Gender</th>
    <th>Country</th>
    <th>Notes</th>
    <th>Mailint list</th>
    <th>Programming skills</th>
    <th>Hobbies</th>
    </thead>
    <tbody>
    <tr>
        <td>${student.firstName}</td>
        <td>${student.lastName}</td>
        <td>${student.gender}</td>
        <td>${student.country}</td>
        <td>${student.notes}</td>
        <td>${student.mailingList}</td>
        <td>
            <c:forEach items="${student.programmingSkills}" var="skill">
                ${skill}<br>
            </c:forEach>
        </td>
        <td>
            <c:forEach items="${student.hobbies}" var="hobby">
                ${hobby}<br>
            </c:forEach>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
