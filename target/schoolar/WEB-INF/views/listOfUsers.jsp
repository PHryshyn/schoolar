<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>

    <title>All Shedules</title>

</head>

<body>

<table border="1px" cellpadding="0" cellspacing="0" >
    <thead>
    <tr>
        <th width="10%">id</th><th width="15%">name</th><th width="10%">rating</th><th width="10%">actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>

            <td>
                <a href="${pageContext.request.contextPath}/user/edit/${user.id}">Edit</a><br/>
                <a href="${pageContext.request.contextPath}/user/delete/${user.id}">Delete</a><br/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p><a href="${pageContext.request.contextPath}/home">Home page</a></p>


</body>

</html>
