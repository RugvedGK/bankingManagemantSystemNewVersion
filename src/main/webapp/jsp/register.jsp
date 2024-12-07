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
    <div class="card registration-form-card col-6 bg-transparent border-0">
        <div class="card-body">
            <h1 class="form-header card-title mb-3">
            <i class="fa fa-edit"></i>Register
        </h1>
        
        <!-- Display Message -->
        <c:if test="${requestScope.passwordMisMatch != null}">
        <div class="alert aler-danger text-center text-white border border-danger">
        <b>${requestScope.passwordMisMatch}</b>
        </div>
        </c:if>
        
        <!-- End of Display Message -->
        
        <!-- Display Message -->
        <c:if test="${requestScope.success != null}">
        <div class="alert aler-success text-center text-white border border-success">
        <b>${requestScope.success}</b>
        </div>
        </c:if>
        <!-- End of Display Message -->
        
        <mvc:form action="" class="reg-form" modelAttribute="registerUser" >
            <div class="row">
                <div class="form-group col">
                    <mvc:input type="text" path="first_name" class="form-control from-control-lg" placeholder="Enter First Name"/>
                    <mvc:errors path="first_name" class="text-white bg-danger"/>
                </div>
                <div class="form-group col">
                    <mvc:input type="text" path="last_name" class="form-control from-control-lg" placeholder="Enter Last Name"/>
                    <mvc:errors path="last_name" class="text-white bg-danger"/>
                </div>
                <div>
                    <div class="form-group col">
                    <mvc:input type="email" path="email" class="form-control from-control-lg" placeholder="Enter Email"/>
                    <mvc:errors path="email" class="text-white bg-danger"/>
                </div>
                <div class="row">
                    <div class="form-group col">
                        <mvc:input type="password" path="password" class="form-control from-control-lg" placeholder="Enter Password"/>
                        <mvc:errors path="password" class="text-white bg-danger"/>
                    </div>
                    <div class="form-group col">
                        <input type="password" name="confirm_password" class="form-control from-control-lg" placeholder="Confirm Password"/>
                        <small class="text-white bg-danger">${confirm_pass }</small>
                    </div>
               </div>
            </div>
            <div class="form-group col">
                <button class="btn btn-lg register">Register</button>
            </div>
        </mvc:form>
        <p class="card-text text-white my-2">Already Have an account?<span class="ms-2"><a href="/login" class="btn btn-sm  text-warning">Sign In</a></span></p>

        <small class="">
            <i class="fa fa-arrow-alt-circle-left"></i><a href="/" class="btn btn-sm text-warning">Back</a>
        </small>
        </div>
    </div>
</body>
</html>