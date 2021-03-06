<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

    <title><tiles:getAsString name="title"/> </title>

</head>
<body>


<div class="container">
    <!-- Static navbar -->
    <div class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href='<spring:url value="/home"/>'>Scholar</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
            <security:authorize access="hasAnyRole('ROLE_USER, ROLE_ADMIN')">
                    <li><a href='<spring:url value="/user/profile"/>'>Profile</a></li>
            </security:authorize>
            <security:authorize access="hasRole('ROLE_USER')">
                    <li><a href='<spring:url value="/user/rating"/>'>Rating</a></li>
            </security:authorize>
                </ul>

                <ul class="nav navbar-nav navbar-right">
            <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href='<spring:url value="/admin/disciplines"/>'>Discipline</a></li>
                    <li><a href='<spring:url value="/admin/users"/>'>Create User  </a></li>
                    <li><a href='<spring:url value="/admin/homeworks"/>'>Homework</a></li>
                    <li><a href='<spring:url value="/admin/rating"/>'>Rating</a></li>
            </security:authorize>
<security:authorize access="hasAnyRole('ROLE_USER, ROLE_ADMIN')">
                    <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
    </security:authorize>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </div>


<tiles:insertAttribute name="body"/>

<br><br>
<center>
<tiles:insertAttribute name="footer"/>
</center>
    </div>
</body>
</html>
