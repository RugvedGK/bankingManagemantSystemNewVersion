<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- <link rel="stylesheet" href="./css/style.css"> -->
    <link rel="stylesheet" href="./css/fontawesome-free-6.7.1-web/fontawesome-free-6.7.1-web/css/all.css">
    <style>
*{
    box-sizing: border-box;
    font-family: confortaa;
}

    body{
    height: 100vh;
    background: url(../images/frontimage.jpg);
    background-position: center center;
    background-repeat: no-repeat;
    background-size: cover;
}

.main{
    margin: 0 200px;
}

.card .card-text{
    font-size: 16px;
}

.card{
    box-shadow: 0px 3px 6px rgb(0, 14, 53);
}
    </style>
    <title>Document</title>
</head>
<body class="d-flex align-items-center main">
    <div class="card col-6 alert alert-danger border border-danger text-danger">
        <h3 class="card-title">
            <i class="fa fa-window-close me-2"></i>Errors:
        </h3>
        <hr>
            <div class="card-body">
                <c:if test="${requestScope.error != null}">
        <div class="alert aler-danger text-center text-black border border-danger">
        <b>${requestScope.error}</b>
        </div>
        </c:if>
                    <hr>
                    <a href="/login" class="btn btn-sm btn-danger">
                        <i class="fa fa-arrow-alt-circle-left me-1"></i>Back
                    </a>
            </div>
    </div>
</body>
</html>