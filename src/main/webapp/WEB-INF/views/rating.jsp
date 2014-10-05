<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<div>
    <form:form cssClass="form-horizontal" modelAttribute="rating" action="${pageContext.request.contextPath}/admin/rating/save">

        <c:if test="${!empty rating.ratingId}" >
            <div class="form-group" >
                <label class="col-sm-3 control-label">ID:</label>
                <div class="col-sm-8">
                    <form:input path="ratingId" class="form-control" disabled="true"/>
                </div>
            </div>
        </c:if>

        <div class="form-group">
            <label class="col-sm-3 control-label">Date (e.g. 27/05/2014):</label>
            <div class="col-sm-8">
                <form:errors path="ratingDate" cssClass="error" />
                <form:input path="ratingDate" class="form-control" placeholder="ratingDate"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">Choose discipline:</label>
            <div class="col-sm-8">
                <form:select class="form-control" path="discipline.disciplineId">
                    <form:options items="${disciplineList}" itemValue="disciplineId" itemLabel="discipline" />
                </form:select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">Choose user:</label>
            <div class="col-sm-8">
                <form:select class="form-control" path="user.id">
                    <form:options items="${userList}" itemValue="id" itemLabel="lastName" />
                </form:select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">Rating</label>
            <div class="col-sm-8">
                <form:errors path="rating" cssClass="error" />
                <form:input path="rating" class="form-control" placeholder="rating"/>
            </div>
        </div>

        <c:if test="${empty rating.ratingId}" >
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" value="Add Rating" class="btn btn-primary "/>
                </div>
            </div>
        </c:if>

        <c:if test="${!empty rating.ratingId}" >
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" value="Edit Rating" class="btn btn-primary "/>
                </div>
            </div>
        </c:if>



        <c:if test="${!empty ratingList}">
            <table class="table table-bordered">
                <h2>List of Ratings</h2>
                <tr>
                    <th>Date</th>
                    <th>Discipline</th>
                    <th>User</th>
                    <th>Rating</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>

                <c:forEach items="${ratingList}" var="rating">
                    <tr>
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


    </form:form>
</div>
