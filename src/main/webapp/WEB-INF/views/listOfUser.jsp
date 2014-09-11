<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<c:if test="${!empty user}">
<table border="1px" cellpadding="0" cellspacing="0" >
    <thead>
    <tr>
        <th width="10%">id</th><th width="15%">username</th><th width="10%">First Name</th><th width="10%">actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${user}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.firstName}</td>
            <td>
                <a href="${pageContext.request.contextPath}/team/edit/${user.id}.html">Edit</a><br/>
                <a href="${pageContext.request.contextPath}/team/delete/${user.id}.html">Delete</a><br/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    </c:if>