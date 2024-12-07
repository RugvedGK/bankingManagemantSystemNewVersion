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
<header class="main-page-header mb-3 bg-primary">
        <div class="container d-flex align-items-center">
            <div class="company-name">
                EASY-WAY-BANK
            </div>

            <nav class="navigation">
                <li><a href="">Dashboard</a></li>
                <li><a href="">Payment History</a></li>
                <li><a href="">Transaction History</a></li>
            </nav>

            <div class="display-name ms-auto text-white">
                <i class="fa fa-circle text-success me-2 shadow-sm sh"></i>Welcome: <span>${user.first_name} ${user.last_name}</span>
            </div>
            <a href="/logout" class="btn btn-sm text-white ms-2">
                <i class="fas fa-sign-out-alt" aria-hidden="true"></i>Sign Out
            </a>
        </div>
    </header>

</body>
</html>