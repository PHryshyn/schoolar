<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div>
<form:form cssClass="form-horizontal" modelAttribute="homework" action="${pageContext.request.contextPath}/admin/homework/save">

    <c:if test="${!empty homework.homeworkId}" >
    <div class="form-group" >
        <label class="col-sm-3 control-label">ID:</label>
        <div class="col-sm-8">
            <form:input path="homeworkId" class="form-control" disabled="true"/>
        </div>
    </div>
    </c:if>

    <div class="form-group">
        <label class="col-sm-3 control-label">Date (mm.dd.yyyy):</label>
        <div class="col-sm-8">
            <form:input path="homeworkDate" class="form-control" placeholder="homeworkDate"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label">Homework:</label>
        <div class="col-sm-8">
            <form:input path="homework" class="form-control" placeholder="homework"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label">Choose discipline:</label>
        <div class="col-sm-8">
            <form:select class="form-control" path="discipline.disciplineId">
                <form:option value="0" label="Select" />
                <form:options items="${disciplineList}" itemValue="disciplineId" itemLabel="discipline" />
            </form:select>
        </div>
    </div>

    <c:if test="${empty homework.homeworkId}" >
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" value="Add Homework" class="btn btn-primary "/>
        </div>
    </div>
    </c:if>

    <c:if test="${!empty homework.homeworkId}" >
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="Edit Homework" class="btn btn-primary "/>
            </div>
        </div>
    </c:if>



    <c:if test="${!empty homeworkList}">
    <table class="table table-bordered">
        <h2>List of Homeworks</h2>
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Discipline</th>
            <th>Homework</th>
            <th>Action</th>
        </tr>

        <c:forEach items="${homeworkList}" var="homework">
            <tr>
                <td>${homework.homeworkId}</td>
                <td><c:out value="${homework.homeworkDate}"/></td>
                <td><c:out value="${homework.discipline.discipline}"/></td>
                <td><c:out value="${homework.homework}"/></td>
                <td><a href="<spring:url value='${pageContext.request.contextPath}/admin/homework/delete/${homework.homeworkId}' />" >Delete</a></td>
                <td><a href="<spring:url value='${pageContext.request.contextPath}/admin/homework/edit/${homework.homeworkId}' />" >Edit</a></td>
            </tr>
        </c:forEach>
    </table>
    </c:if>


</form:form>
    </div>
