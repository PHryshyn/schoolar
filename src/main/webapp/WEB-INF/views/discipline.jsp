<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div>
<form:form cssClass="form-horizontal" modelAttribute="discipline" action="${pageContext.request.contextPath}/admin/discipline/save">

    <div class="form-group" >
        <label class="col-sm-2 control-label">Discipline:</label>
        <div class="col-sm-10">
            <form:input path="disciplineId" class="form-control" placeholder="disciplineId"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">Discipline:</label>
        <div class="col-sm-10">
            <form:input path="discipline" class="form-control" placeholder="discipline"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" value="Add Discipline" class="btn btn-primary "/>
        </div>
    </div>

  <c:if test="${!empty disciplineList}">
    <table>
    <h2>List of Disciplines</h2>
    <tr>
    <th>ID</th>
    <th>Discipline</th>
    <th>Action</th>
    </tr>

    <c:forEach items="${disciplineList}" var="discipline">
        <tr>
            <td><c:out value="${discipline.disciplineId}"/></td>
            <td><c:out value="${discipline.discipline}"/></td>
            <td><a href="<spring:url value='${pageContext.request.contextPath}/admin/discipline/delete/${discipline.disciplineId}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
  </c:if>
</div>

</form:form>
