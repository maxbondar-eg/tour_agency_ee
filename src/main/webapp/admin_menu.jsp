<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20.02.2021
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ADMIN</title>
</head>
<body>

<h1>Hello ADMIN!</h1>
<c:out value="${sessionScope.test}"/>
<a href="<c:url value='/logout' />">Logout</a>
</body>
</html>
