<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<div>
    <legend>Change profile</legend>
    <form:form cssClass="form-horizontal" modelAttribute="user" action="${pageContext.request.contextPath}/user/profile/update/${user.id}">

        <div class="form-group" >
            <label class="col-sm-2 control-label">Username:</label>
            <div class="col-sm-10">
                <form:input path="username" id="username" class="form-control" placeholder="username"/>
            </div>
        </div>

        <div class="form-group" >
            <label class="col-sm-2 control-label">First Name:</label>
            <div class="col-sm-10">
                <form:input path="firstName" id="firstName" class="form-control" placeholder="First name"/>
            </div>
        </div>

        <div class="form-group" >
            <label class="col-sm-2 control-label">Last Name:</label>
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
            <label for="email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <form:input path="email" id="email" class="form-control" placeholder="Email"/>

            </div>
        </div>

        <div class="form-group">
            <label for="adress" class="col-sm-2 control-label">Adress:</label>
            <div class="col-sm-10">
                <form:input path="adress" id="adress" class="form-control" placeholder="adress"/>

            </div>
        </div>

        <div class="form-group">
            <label for="fullNamePar1" class="col-sm-2 control-label">Full Name Parent 1</label>
            <div class="col-sm-10">
                <form:input path="fullNamePar1" id="fullNamePar1" class="form-control" placeholder="Full Name Parent 1"/>

            </div>
        </div>

        <div class="form-group">
            <label for="fullNamePar2" class="col-sm-2 control-label">Full Name Parent 2</label>
            <div class="col-sm-10">
                <form:input path="fullNamePar2" id="fullNamePar2" class="form-control" placeholder="Full Name Parent 2"/>

            </div>
        </div>

        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">Phone:</label>
            <div class="col-sm-10">
                <form:input path="phone" id="phone" class="form-control" placeholder="phone"/>

            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="Update profile" class="btn btn-primary "/>
            </div>
        </div>


    </form:form>

</div>