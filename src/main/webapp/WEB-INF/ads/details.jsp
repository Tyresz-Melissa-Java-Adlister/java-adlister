<%--
  Created by IntelliJ IDEA.
  User: resz
  Date: 6/28/23
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Ad Detail" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Ad Detail</h1>
    <div class="card">
        <div class="card-title">
            <h2>${ad.title}</h2>
        </div>
        <div class="card-text">
            <p>${ad.description}</p>
        </div>
    </div>
</div>

</body>
</html>
