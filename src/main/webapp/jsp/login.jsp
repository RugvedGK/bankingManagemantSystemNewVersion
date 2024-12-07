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
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/fontawesome-free-6.7.1-web/fontawesome-free-6.7.1-web/css/all.css">
    <title>Document</title>
</head>
<body class="d-flex align-items-center main">
    <div class="card login-form-card col-3 bg-transparent border-0">
        <div class="card-body">
            <h1 class="form-header card-title mb-3">
            <i class="fa fa-user-circle"></i>Login
        </h1>
        
        <c:if test="${requestScope.success != null}">
        <div class="alert aler-success text-center text-white border border-success">
        <b>${requestScope.success}</b>
        </div>
        </c:if>
        
        <c:if test="${requestScope.error != null}">
        <div class="alert aler-danger text-center text-white border border-danger">
        <b>${requestScope.error}</b>
        </div>
        </c:if>
        
        <c:if test="${logged_out != null}">
        <div class="alert aler-info text-center text-white border border-info">
        <b>${logged_out}</b>
        </div>
        </c:if>
        
        
        <form action="/login" method="post" class="login-form">
                    <div class="form-group col">
                    <input type="email" name="email" class="form-control from-control-lg" placeholder="Enter Email"/>
                </div>
                    <div class="form-group col">
                        <input type="password" name="password" class="form-control from-control-lg" placeholder="Enter Password"/>
                    </div>  
                    <div class="form-group col">
                        <input type="hidden" name="_token" value="${token}"/>
                    </div>
            </div>
            <div class="form-group col">
                <button class="btn btn-lg login">Login</button>
            </div>
        </form>
        <p class="card-text text-white my-2 you">Don't Have an account?<span class="ms-2"><a href="/register" class="btn btn-sm  text-warning">Sign Up</a></span></p>

        <small class="">
            <i class="fa fa-arrow-alt-circle-left back"></i><a href="/" class="btn btn-sm text-warning">Back</a>
        </small>
        </div>
    </div>
</body>
</html>