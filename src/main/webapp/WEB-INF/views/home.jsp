<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h3>${msg}</h3>
<h3>Welcome ${user}</h3>

<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>

</body>
</html>