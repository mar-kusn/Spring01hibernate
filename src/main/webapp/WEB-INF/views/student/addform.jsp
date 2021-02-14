<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 31.01.2021
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add student form</title>
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

<h2>Add student</h2>

<form:form method="post" modelAttribute="student">
    <div>
        <form:label path="firstName">First name</form:label>
        <form:input path="firstName" id="firstName"></form:input>
    </div>
    <div>
        <form:label path="lastName">Last name</form:label>
        <form:input path="lastName" id="lastName"></form:input>
    </div>
    <div>
        <fieldset>
            <legend>
                Gender
            </legend>
                <%--                <form:label path="gender">Gender</form:label>--%>
            Male: <form:radiobutton path="gender" id="gender" value="M"></form:radiobutton>
            Female: <form:radiobutton path="gender" id="gender" value="F"></form:radiobutton>
        </fieldset>
    </div>
    <div>
        <form:label path="country">Country</form:label>
        <form:select path="country" items="${countries}" />
    </div>
    <div>
        <form:label path="notes">Notes</form:label>
        <form:textarea path="notes" id="notes"></form:textarea>
    </div>
    <div>
        <form:label path="mailingList">Mailing list</form:label>
        <form:checkbox path="mailingList" id="mailingList"></form:checkbox>
    </div>
    <div>
        <form:label path="programmingSkills">Programming skills</form:label>
        <form:select path="programmingSkills">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${programmingSkillsList}" multiple="true"/>
        </form:select>
    </div>
    <div>
        <fieldset>
            <legend>
                Hobbies
            </legend>
                <%--                <form:label path="hobbies">Hobbies</form:label>--%>
            <form:checkboxes path="hobbies" items="${hobbiesList}" />
        </fieldset>
    </div>
    <input type="submit">

</form:form>

</body>
</html>

