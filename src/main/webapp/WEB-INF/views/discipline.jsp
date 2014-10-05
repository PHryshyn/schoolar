<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div>
<form:form cssClass="form-horizontal" modelAttribute="discipline" action="${pageContext.request.contextPath}/admin/discipline/save">

    <c:if test="${!empty discipline.disciplineId}" >
    <div class="form-group" >
        <label class="col-sm-2 control-label">Discipline:</label>
        <div class="col-sm-10">
            <form:input path="disciplineId" class="form-control" placeholder="disciplineId"/>
            <form:hidden path="disciplineId" disabled="true" />
        </div>
    </div>
    </c:if>

    <div class="form-group">
        <label class="col-sm-2 control-label">Discipline:</label>
        <div class="col-sm-10">
            <form:errors path="discipline" cssClass="error" />
            <form:input path="discipline" class="form-control" placeholder="discipline"/>
        </div>
    </div>

    <c:if test="${!empty discipline.disciplineId}" >
    <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="Edit Discipline" class="btn btn-primary "/>
            </div>
    </div>
    </c:if>

    <c:if test="${empty discipline.disciplineId}" >
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="Add Discipline" class="btn btn-primary "/>
            </div>
        </div>
    </c:if>



    <c:if test="${!empty disciplineList}">
    <table class="table table-bordered">
    <h2>List of Disciplines</h2>
    <tr>
    <th>Discipline</th>
    <th>Delete</th>
    <th>Edit</th>
    </tr>

    <c:forEach items="${disciplineList}" var="discipline">
        <tr>
            <td><c:out value="${discipline.discipline}"/></td>
            <td><a href="<spring:url value='${pageContext.request.contextPath}/admin/discipline/delete/${discipline.disciplineId}' />" >Delete</a></td>
            <td><a href="<spring:url value='${pageContext.request.contextPath}/admin/discipline/edit/${discipline.disciplineId}' />" >Edit</a></td>
        </tr>
    </c:forEach>
    </table>
  </c:if>
</div>

</form:form>
