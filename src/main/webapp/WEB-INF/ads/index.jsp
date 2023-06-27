<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>
    <div class="col-12">
        <input class="form-control me-2" type="search" placeholder="Your Ad search starts here!" aria-label="Search">
    </div>

    <c:forEach var="ad" items="${ads}">
        <div class="card">
            <div class="card-title">
                <h2>${ad.title}</h2>
            </div>
            <div class="card-text">
                <p>${ad.description}</p>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
