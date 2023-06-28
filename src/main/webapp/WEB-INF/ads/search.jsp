<%--
  Created by IntelliJ IDEA.
  User: resz
  Date: 6/28/23
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Search Results</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" integrity="sha384-r67glSXeyys4Mu2J2GyLb2QJL+/cPZIwDL8y9f70wInq9CwdyST82bod9OHu3DDi" crossorigin="anonymous" />
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<h1>Search Results:</h1>
<div class="container">

<c:forEach var="ad" items="${searched_ads}">

    <div class="card col-10">
        <h2>${ad.title}</h2>
        <p>${ad.description}</p>
    </div>

</c:forEach>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>

