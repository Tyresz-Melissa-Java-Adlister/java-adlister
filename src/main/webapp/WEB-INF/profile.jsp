<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1 class="text-capitalize">Welcome, ${sessionScope.user.username}!</h1>
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

</body>
</html>
