<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<c:if test="${!empty ratingList}">
    <table class="table table-bordered">
        <h2>List of Ratings</h2>
        <tr>
            <th>Date</th>
            <th>Username</th>
            <th>Discipline</th>
            <th>User</th>
            <th>Rating</th>
        </tr>

        <c:forEach items="${ratingList}" var="rating">
            <tr>
                <td><c:out value="${rating.user.username}"/></td>
                <td><c:out value="${rating.ratingDate}"/></td>
                <td><c:out value="${rating.discipline.discipline}"/></td>
                <td><c:out value="${rating.user.lastName}"/></td>
                <td><c:out value="${rating.rating}"/></td>
                <td><a href="<spring:url value='${pageContext.request.contextPath}/admin/rating/delete/${rating.ratingId}' />" >Delete</a></td>
                <td><a href="<spring:url value='${pageContext.request.contextPath}/admin/rating/edit/${rating.ratingId}' />" >Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
