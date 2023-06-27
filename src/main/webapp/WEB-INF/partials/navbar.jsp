<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">

        <ul class="navbar nav">
            <div class="navbar-header">
                <a href="/ads" class="navbar-brand">Adlister</a>
            </div>

            <div class="nav navbar-nav navbar-right">
                <li><form class="form-inline" action="/search_ads" method="POST">
                    <label for="searched_ads"></label>
                    <input type="text" name="searched_ads" id="searched_ads" placeholder="">
                    <button class="btn btn-info my-2 my-sm-0" type="submit">Find</button>
                </form></li>
                <div class="nav navbar-nav navbar-right">

                    <c:choose>

                    <c:when test="${sessionScope.user == null}">

                        <li><a href="/login">Login</a></li>
                        <li><a href="/register">Register</a></li>

                    </c:when>

                    <c:otherwise>
                    <li><a href="/ads/create">Create</a></li>
                    <li><a href="/profile">Profile</a></li>
                    <li><a href="/logout">Logout</a></li>

                </div>
                </c:otherwise>
                </c:choose>
        </ul>
    </div>

</nav>








