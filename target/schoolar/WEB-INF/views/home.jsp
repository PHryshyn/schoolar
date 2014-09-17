<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/WEB-INF/layout/taglib.jsp"%>

<%@include file="/WEB-INF/layout/footer.jsp"%>




<h3>${msg}</h3>
<h3>Welcome ${user} ${id}</h3>

<a href="<c:url value="/j_spring_security_logout" />" >  Logout</a>

${message}<br/>
<a href="${pageContext.request.contextPath}/home/create">Add new team</a><br/>
<a href="${pageContext.request.contextPath}/admin/list">Team list</a><br/>


   