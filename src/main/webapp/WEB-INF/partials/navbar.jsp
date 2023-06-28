<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
<div class="container-fluid">
<a class="navbar-brand" href="/ads">Adlister</a>
<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarSupportedContent">
<ul class="navbar-nav me-auto mb-2 mb-lg-0">
<c:choose>
    <c:when test="${sessionScope.user == null}">
        <li class="nav-item">
            <a class="nav-link" aria-current="page" href="/login">Login</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/register">Register</a>
        </li>
    </c:when>
    <c:otherwise>
        <li class="nav-item">
            <a class="nav-link" href="/ads/create" tabindex="-1" aria-disabled="true">Create</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/profile" tabindex="-1" aria-disabled="true">Profile</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/logout" tabindex="-1" aria-disabled="true">Logout</a>
        </li>
        </ul>
        <div class="nav navbar-nav navbar-right">
            <li>
                <form class="form-inline" action="/search" method="POST">
                    <label for="search"></label>
                    <input type="text" name="search" id="search" placeholder="">
                    <button class="btn btn-info my-2 my-sm-0" type="submit">Find</button>
                </form>
            </li>
            <div class="nav navbar-nav navbar-right">
            </div>
        </div>
        </div>



    </c:otherwise>
</c:choose>
</ul>
</div>

</nav>








