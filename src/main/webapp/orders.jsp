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
<c:set var="user" scope="request" value="${user}" />
<div class="container mt-5">
    <div class="row row-cols-3 row-cols-md-3 g-4">
        <c:forEach items="${orders}" var="order">
            <div class="col">
                <div class="card text-center border-primary mb-3 h-100" style="width: 18rem;">
                    <div class="card-header">
                        <h6><span><fmt:message bundle="${msg}" key="tour.order.id"/>: </span><span><c:out value="${order.id}"/></span></h6>
                    </div>
                    <div class="card-body">
                        <p><span><fmt:message bundle="${msg}" key="tour.order.name"/>: </span><span><c:out value="${order.tourName}"/></span></p>
                        <p><span><fmt:message bundle="${msg}" key="tour.order.customer"/>: </span><span><c:out value="${order.customerLogin}"/></span></p>
                        <p><span><fmt:message bundle="${msg}" key="tour.order.quantity"/>: </span><span><c:out value="${order.ticketsQuantity}"/></span></p>
                    </div>
                    <form action="controller/orders/canceled" method="post">
                        <input type="hidden" value="${order.id}" name="orderId"/>
                        <input class="btn btn-primary mb-1" type="submit" value="<fmt:message bundle="${msg}" key="order.canceled"/>"/>
                    </form>
                    <form action="controller/orders/paid" method="post">
                        <input type="hidden" value="${order.id}" name="userId"/>
                        <input class="btn btn-primary" type="submit" value="<fmt:message bundle="${msg}" key="user.change_role"/>"/>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>
