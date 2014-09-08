<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../layout/taglib.jsp"%>

<form:form modelAttribute="user" method="GET" action="/save">

    <form:label path="username">Username:</form:label>

    <form:input path="username" />


    <form:label path="password">Password:</form:label>

    <form:password path="password" />


    <input type="submit" value="Save Pupil" />

</div>
</form:form>
