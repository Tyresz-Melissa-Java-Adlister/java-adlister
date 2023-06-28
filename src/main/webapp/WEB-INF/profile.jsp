<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" integrity="sha384-r67glSXeyys4Mu2J2GyLb2QJL+/cPZIwDL8y9f70wInq9CwdyST82bod9OHu3DDi" crossorigin="anonymous" />

</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1 class="text-capitalize">Welcome, ${sessionScope.user.username}!</h1>
</div>
<c:forEach var="ad" items="${ads}">
    <div class="col-1"></div>
    <div class="card col-10">
        <div class="card-header">
            <h2>${ad.title}</h2>
        </div>
        <div class="card-body">
            <p>${ad.description}</p>
        </div>
        <div class="card-footer">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#updateModal${ad.id}">
                Update
            </button>

            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal${ad.id}">
                Delete
            </button>
        </div>
    </div>
    <div class="col-1"></div>


    <div class="modal fade" id="updateModal${ad.id}" tabindex="-1" aria-labelledby="updateModalLabel${ad.id}" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="updateModalLabel${ad.id}">Update Ad: ${ad.title}</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="/ad/update" method="POST">
                        <input type="hidden" name="adId" value="${ad.id}" />
                        <div class="mb-3">
                            <label for="updateTitle" class="form-label">Title:</label>
                            <input type="text" class="form-control" id="updateTitle" name="updateTitle" value="${ad.title}" />
                        </div>
                        <div class="mb-3">
                            <label for="updateDescription" class="form-label">Description:</label>
                            <textarea class="form-control" id="updateDescription" name="updateDescription">${ad.description}</textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Save Changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <div class="modal fade" id="deleteModal${ad.id}" tabindex="-1" aria-labelledby="deleteModalLabel${ad.id}" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteModalLabel${ad.id}">Delete Ad: ${ad.title}</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete the ad: ${ad.title}?</p>
                    <form action="ad/delete" method="POST">
                        <input type="hidden" name="adId" value="${ad.id}" />
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
