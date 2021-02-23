<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="UA"/>
<fmt:setBundle basename="messages" var="msg" />
<html>
<head>
    <title>TourAgency</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>
<body>
<c:import url="/WEB-INF/header.jsp" />
<fmt:message bundle="${msg}" key="greeting"/>
<div align="center">
    <form action="registration" method="post">
        <div class="row mb-3 mt-5 align-items-center">
            <label class="col-sm-2 col-form-label" ><fmt:message bundle="${msg}" key="user.login"/></label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="login" required/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="user.password"/></label>
            <div class="col-sm-5">
                <input class="form-control" type="password" name="password" required/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="user.firstname"/></label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="firstName" required/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="user.lastname"/></label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="lastName" required/>
            </div>
        </div>
        <div><button class="btn btn-primary" type="submit"><fmt:message bundle="${msg}" key="main.registry"/></button></div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>