<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@include file="../layout/taglib.jsp"%>

<div>
    <legend>Change profile</legend>
    <form:form method="get" cssClass="form-horizontal" modelAttribute="user">
        <form:hidden path="id" disabled="true" />
        <div class="form-group">
            <label class="col-sm-2 control-label">Username</label>
            <div class="col-sm-10">
                <form:input path="username" id="username" class="form-control" placeholder="username"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">First Name:</label>
            <div class="col-sm-10">
                <form:input path="firstName" id="firstName" class="form-control" placeholder="First Name"/>
            </div>
        </div>

        <div class="form-group">
            <label for="lastName" class="col-sm-2 control-label">Last name:</label>
            <div class="col-sm-10">
                <form:input path="lastName" id="lastName" class="form-control" placeholder="Last Name"/>

            </div>
        </div>

        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">password</label>
            <div class="col-sm-10">
                <form:password path="password" id="password" class="form-control" placeholder="password"/>

            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="save" class="btn btn-primary "/>
            </div>
        </div>
    </form:form>
    </form>
</div>

