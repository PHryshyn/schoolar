<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head><title>Add Pupil</title></head>

<body>

<h1>Add Pupil</h1>


<h1>Add team page</h1>
<p>Here you can add a new team.</p>
<form:form method="POST" commandName="admin" action="${pageContext.request.contextPath}/add">
    <table>
        <tbody>
        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
        </tr>

        <tr>
            <td><input type="submit" value="Add" /></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>

<c:if  test="${!empty userList}">
    <table class="data">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Telephone</th>

        </tr>
        <c:forEach items="${userList}" var="contact">
            <tr>
                <td>${user.username}, ${user.password} </td>

                <td><a href="delete/${user.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<p><a href="${pageContext.request.contextPath}/home">Home page</a></p>

</body>

</html>