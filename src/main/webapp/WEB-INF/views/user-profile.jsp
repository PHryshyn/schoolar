<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<form:form class="form-horizontal" modelAttribute="user" method="get" action="${pageContext.request.contextPath}/user/profile/edit/${user.id}">

    <div class="form-group" >
        <label class="col-sm-2 control-label">Username:</label>
        <div class="col-sm-15">
            <p class="form-control-static">${user.username}</p>
        </div>
    </div>
    <div class="form-group" >
        <label class="col-sm-2 control-label">First name:</label>
        <div class="col-sm-15">
            <p class="form-control-static">${user.firstName}</p>
        </div>
    </div>
    <div class="form-group" >
        <label class="col-sm-2 control-label">Last name:</label>
        <div class="col-sm-15">
            <p class="form-control-static">${user.lastName}</p>
        </div>
    </div>
    <div class="form-group" >
        <label class="col-sm-2 control-label">Email:</label>
        <div class="col-sm-15">
            <p class="form-control-static">${user.email}</p>
        </div>
    </div>
    <div class="form-group" >
        <label class="col-sm-2 control-label">Adress:</label>
        <div class="col-sm-15">
            <p class="form-control-static">${user.adress}</p>
        </div>
    </div>
    <div class="form-group" >
        <label class="col-sm-2 control-label">Phone:</label>
        <div class="col-sm-15">
            <p class="form-control-static">${user.phone}</p>
        </div>
    </div>

    <div class="form-group" >
        <label class="col-sm-2 control-label">Parent 1:</label>
        <div class="col-sm-15">
            <p class="form-control-static">${user.fullNamePar1}</p>
        </div>
    </div>
    <div class="form-group" >
        <label class="col-sm-2 control-label">Parent 2:</label>
        <div class="col-sm-15">
            <p class="form-control-static">${user.fullNamePar2}</p>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" value="Edit profile" class="btn btn-primary "/>
        </div>
    </div>

</form:form>


