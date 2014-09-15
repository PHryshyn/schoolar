<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../layout/taglib.jsp"%>



<div>
    <form:form cssClass="form-horizontal" modelAttribute="user" action="${pageContext.request.contextPath}/admin/user/save">

        <div class="form-group" >
            <label class="col-sm-2 control-label">Username:</label>
            <div class="col-sm-10">
                <form:input path="username" id="username" class="form-control" placeholder="Username"/>
            </div>
        </div>

        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password:</label>
            <div class="col-sm-10">
                <form:password path="password" id="password" class="form-control" placeholder="password"/>
            </div>
        </div>

        <div class="form-group" >
            <label class="col-sm-2 control-label">First Name:</label>
            <div class="col-sm-10">
                <form:input path="firstName" id="firstName" class="form-control" placeholder="First Name"/>
            </div>
        </div>

        <div class="form-group" >
            <label class="col-sm-2 control-label">Last Name:</label>
            <div class="col-sm-10">
                <form:input path="lastName" id="lastName" class="form-control" placeholder="Last Name"/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="Create User" class="btn btn-primary "/>
            </div>
        </div>

        <c:if test="${!empty userListByLastName}">
            <table>
                <h2>List of Users</h2>
                <tr>
                    <th>ID</th>
                    <th>Last Name</th>
                    <th>First Name</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>

                <c:forEach items="${userListByLastName}" var="user">
                    <tr>
                        <td><c:out value="${user.id}"/></td>
                        <td><c:out value="${user.lastName}"/></td>
                        <td><c:out value="${user.firstName}"/></td>
                        <td><c:out value="${user.username}"/></td>
                        <td><c:out value="${user.email}"/></td>
                        <td><a href="<spring:url value='${pageContext.request.contextPath}/admin/user/delete/${user.id}' />" >Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </form:form>
</div>