<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/fontawesome-free-6.7.1-web/fontawesome-free-6.7.1-web/css/all.css">
    <script src="../js/bootstrap.bundle.js"></script>
    <title>Document</title>
</head>
<body>


<c:import url="components/incl/header.jsp"/>


<c:import url="components/transact_offcanvas.jsp"/>


<c:import url="components/add_account_offcanvas.jsp"/>

<div class="container">
		<c:if test="${success != null}">
        <div class="alert alert-info text-center text-black border border-info">
        <b><c:out value="${success}" /></b>
        </div>
        </c:if>
        
        <c:if test="${error != null}">
        <div class="alert alert-danger text-center text-black border border-danger">
        <b><c:out value="${error}" /></b>
        </div>
        </c:if> 
</div>

<c:choose>
<c:when test="${fn:length(userAccounts) > 0 }">
<c:import url="components/accounts_display.jsp"/>
</c:when>
<c:otherwise>
<c:import url="components/no_accounts_display.jsp"/>
</c:otherwise>
</c:choose>


    

<c:import url="components/incl/footer.jsp"/>


 
    