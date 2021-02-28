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
<div class="container mt-5">
        <div class="row mt-3 mb-3">
            <label class="col-sm-2 col-form-label" text="<fmt:message bundle="${msg}" key="user.login"/>"></label>
            <label class="col-sm-2 col-form-label" text="<fmt:message bundle="${msg}" key="user.roles"/>"></label>
        </div>
        <c:forEach items="${users}" var="user">
            <div class="row mb-3">
                <label class="col-sm-2 col-form-label" ><c:out value="${user.login}"/></label>
                <label class="col-sm-2 col-form-label" ><c:out value="${user.role}"/></label>
                <label class="col-sm-2 col-form-label">
                    <form action="controller/usercontrol/change_role" method="post">
                        <input type="hidden" value="${user.id}" name="userId"/>
                        <input type="hidden" value="${user.role}" name="userRole"/>
                        <input class="btn btn-primary" type="submit" value="<fmt:message bundle="${msg}" key="user.change_role"/>"/>
                    </form>
                </label>
            </div>
        </c:forEach>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>