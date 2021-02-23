<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20.02.2021
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="UA"/>
<fmt:setBundle basename="messages" var="msg" />
<html>
<head>
    <title>USER</title>

</head>
<body>
<fmt:message bundle="${msg}" key="greeting"/>
<h1>Hello USER!</h1>
<a href="<c:url value="/logout"/>">Logout</a>
</body>
</html>