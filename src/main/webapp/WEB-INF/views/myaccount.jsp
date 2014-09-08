<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<form:form modelAttribute="userData" method="GET" action="/save">

    <form:label path="firstName">First name:</form:label>
    <form:input path="firstName" />
    <br>

    <form:label path="lastName">Last name</form:label>
    <form:input path="lastName" />
    <br>

    <form:label path="email">email:</form:label>
    <form:input path="email" />
    <br>

    <form:label path="adress">adress:</form:label>
    <form:input path="adress" />
    <br>

    <form:label path="fullNamePar1">Mother full name:</form:label>
    <form:input path="fullNamePar1" />
    <br>

    <form:label path="fullNamePar2">Father full name:</form:label>
    <form:input path="fullNamePar2" />
    <br>

    <form:label path="phone">phone:</form:label>
    <form:input path="phone" />
    <br>

    <input type="submit" value="Save Shedule" />

</form:form>
