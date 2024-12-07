<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
      <div class="card no-account-card">
        <div class="card-body">
          <h1 class="card-title">
            <i class="fas fa-ban text-danger"></i>NO Registered Accounts
          </h1>
          <hr>

          <div class="card-text">
            You currently do not have any registered accounts. <br>
            Please click below to register / add a new account.
          </div>
          <br>
          <button id="" class="btn btn-primary btn-lg" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
            <i class="fa fa-credit-card"></i> Add New Account</button>
        </div>
      </div>
    </div>
</body>
</html>