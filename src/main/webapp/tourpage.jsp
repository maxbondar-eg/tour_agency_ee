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
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Example of Project</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>
<body>
<c:set var="tour" scope="request" value="${tour}" />
<div class="container mt-3">
    <h1><c:out value="${tour.name}"/></h1>
    <img class="img-rounded mt-3" style="width: 50%;  height: auto; border-radius: 5%;" src="${pageContext.request.contextPath}/WEB-INF/images/${tour.img}">
    <div class="row mt-3 mb-3">
        <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="tour.price"/></label>
        <label class="col-sm-2 col-form-label"><c:out value="${tour.price}"/></label>
    </div>
    <div class="row mb-3">
        <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="tour.type"/></label>
        <label class="col-sm-2 col-form-label"><c:out value="${tour.tourType}"/></label>
    </div>
    <div class="row mb-3">
        <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="tour.stars"/></label>
        <label class="col-sm-2 col-form-label"><c:out value="${tour.stars}"/></label>
    </div>
    <div class="row mb-3">
        <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="tour.description"/></label>
        <label class="col-sm-2 col-form-label"><c:out value="${tour.description}"/></label>
    </div>
    <form th:action="@{/tour/buy}" method="post">
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="tour.buy.quantity"/></label>
            <div class="col-sm-1">
                <input class="form-control" type="text" name="quantity" required/>
            </div>
        </div>
        <input type="hidden" value="${tour.id}" name="tourId"/>
        <input class="btn btn-primary mb-8" type="submit" value="<fmt:message bundle="${msg}" key="tour.buy"/>"/>
    </form>
    <div class="row mb-3">
        <label class="col-sm-2 col-form-label" text=""></label>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>