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

    <c:forEach var="ad" items="${ads}">
        <div class="card col-10 mb-3">
            <div class="card-title">
                <h2><a href="/ad/details?id=${ad.id}">${ad.title}</a></h2>
            </div>
            <div class="card-text">
                <p>${ad.description}</p>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
