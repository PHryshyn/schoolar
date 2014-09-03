<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



${message}<br/>
<a href="${pageContext.request.contextPath}/user/add">Add new team</a><br/>
<a href="${pageContext.request.contextPath}/admin/list">Team list</a><br/>

<c:if test="${!empty users}">

    <table>

        <tr>
            <th> Id</th>

            <th>Username</th>

            <th>First name</th>

            <th>Last name</th>


        </tr>

        <c:forEach items="${users}" var="user">

            <tr>
                <td><c:out value="${user.id}"/></td>

                <td><c:out value="${user.username}"/></td>


                <td>
                    <a href="${pageContext.request.contextPath}/users/delete/${user.id}">Delete</a><br>
                </td>




            </tr>

        </c:forEach>

    </table>

</c:if>

<p><a href="${pageContext.request.contextPath}/home">Home page</a></p>
