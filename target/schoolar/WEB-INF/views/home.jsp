<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>${msg}</h3>
<h3>Welcome ${user}</h3>

<a href="<c:url value="/j_spring_security_logout" />" >  Logout</a>

${message}<br/>
<a href="${pageContext.request.contextPath}/admin/add">Add new team</a><br/>
<a href="${pageContext.request.contextPath}/admin/list">Team list</a><br/>