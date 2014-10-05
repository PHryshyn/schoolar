<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h3>Welcome ${user} </h3>

<c:if test="${!empty homeworkList}">
    <table class="table table-bordered">
        <h2>List of Homeworks</h2>
        <tr>
            <th>Date</th>
            <th>Discipline</th>
            <th>Homework</th>
        </tr>

        <c:forEach items="${homeworkList}" var="homework">
            <tr>
                <td><c:out value="${homework.homeworkDate}"/></td>
                <td><c:out value="${homework.discipline.discipline}"/></td>
                <td><c:out value="${homework.homework}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

   