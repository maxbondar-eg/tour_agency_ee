<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" var="msg" />
<html lang="${sessionScope.lang}">
<head>
    <title>TourAgency</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>
<body>
<c:import url="/header.jsp" />
<div class="container mt-5">
    <div class="row row-cols-3 row-cols-md-3 g-4">
        <c:forEach items="${tours}" var="tour">
            <div class="col">
                <div class="card text-center border-primary mb-3 h-100" style="width: 18rem;">
                    <div class="card-header">
                        <h4><c:out value="${tour.name}"/></h4>
                    </div>
                    <img src="${pageContext.request.contextPath}/images/${tour.img}">
                    <div class="card-body">
                        <h5><c:out value="${tour.price}"/></h5>
                        <p><c:out value="${tour.description}"/></p>
                    </div>
                    <div class="card-footer">
                        <form action="controller/tourpage" method="get">
                            <input type="hidden" value="${tour.id}" name="tourId"/>
                            <input class="btn btn-primary" type="submit" value="<fmt:message bundle="${msg}" key="tour.details"/>">
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>