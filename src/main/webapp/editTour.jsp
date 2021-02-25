<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.lang}"/>
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
<c:import url="/header.jsp" />
<fmt:message bundle="${msg}" key="greeting"/>
<c:set var="tour" scope="request" value="${tour}" />
<div align="center">
    <form method="post">
        <div class="row mb-3 mt-5 align-items-center">
            <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="tour.name"/></label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="name" value="<c:out value="${tour.name}"/>" required/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="tour.description"/></label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="description" value="<c:out value="${tour.description}"/>" required/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="tour.price"/></label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="price" value="<c:out value="${tour.price}"/>" required/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="tour.type"/></label>
            <div class="col-sm-5">
                <select class="form-select" name="tourType">
                    <c:forEach items="${tourTypes}" var="type">
                        <option value="${type}"><c:out value="${type}"/></option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="tour.amount"/></label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="peopleAmount" value="<c:out value="${tour.peopleAmount}"/>" required/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="tour.stars"/></label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="stars" value="<c:out value="${tour.stars}"/>" required/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="tour.isHot"/></label>
            <div class="col-sm-5">
                <select class="form-select" name="isHot">
                    <option value="1"><fmt:message bundle="${msg}" key="tour.hot"/></option>
                    <option value="0"><fmt:message bundle="${msg}" key="tour.notHot"/></option>
                </select>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label"><fmt:message bundle="${msg}" key="tour.img"/></label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="img" value="<c:out value="${tour.img}"/>" required/>
            </div>
        </div>
        <div>
            <input type="hidden" value="${tour.id}" name="tourId"/>
            <button class="btn btn-primary" type="submit"><fmt:message bundle="${msg}" key="tour.edit"/></button>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>
