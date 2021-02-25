<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21.02.2021
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" var="msg" />
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand" href="/controller"><fmt:message bundle="${msg}" key="navi.mainpage"/></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse mr-auto" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <c:if test="${sessionScope.role ne null}">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="controller/cabinet"><fmt:message bundle="${msg}" key="navi.cabinet"/></a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.role == 'ADMIN'}">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="controller/orders"><fmt:message bundle="${msg}" key="navi.orders"/></a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.role == 'ADMIN'}">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="controller/tourcontrol"><fmt:message bundle="${msg}" key="navi.tours"/></a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.role == 'ADMIN'}">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="controller/usercontrol"><fmt:message bundle="${msg}" key="navi.users"/></a>
                    </li>
                </c:if>
            </ul>
            <div class="navbar-text mx-auto">
                <fmt:message bundle="${msg}" key="greeting"/>
            </div>
        </div>
        <button class="btn btn-default ml-auto" type="button">
            <a href="?sessionLocale=us"><img src="${pageContext.request.contextPath}/images/uk.png"></a>
        </button>
        <button class="btn btn-default" type="button">
            <a href="?sessionLocale=ua"><img src="${pageContext.request.contextPath}/images/ua.png"></a>
        </button>
        <c:if test="${sessionScope.login eq null}">
            <a class="nav-link active" aria-current="page" href="controller/login"><fmt:message bundle="${msg}" key="main.login"/></a>
        </c:if>
        <c:if test="${sessionScope.login eq null}">
            <a class="nav-link active" aria-current="page" href="controller/registration"><fmt:message bundle="${msg}" key="main.registry"/></a>
        </c:if>
        <c:if test="${sessionScope.login ne null}">
        <a class="nav-link active" aria-current="page" href="controller/logout"><fmt:message bundle="${msg}" key="main.logout"/></a>
        </c:if>
    </div>
</nav>