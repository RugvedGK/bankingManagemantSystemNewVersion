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
<div class="offcanvas offcanvas-start text-white" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
        <div class="offcanvas-header">
          <h5 class="offcanvas-title" id="offcanvasExampleLabel">Transact</h5>
          <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>

        <div class="offcanvas-body">
          <small class="card-text text-white">
             Choose an option below to perform a transaction
          </small>

          <select name="transact-type" class="form-control  my-3" id="transact-type">
            <option value="">-- Select Transaction Type --</option>
            <option value="payment">-- Payment --</option>
            <option value="transfer">-- Transfer --</option>
            <option value="deposite">-- Deposite --</option>
            <option value="withdraw">-- Withdraw --</option>
          </select>

          <c:import url="components/transact_forms/payment_form.jsp"/>
          
          <c:import url="components/transact_forms/transfer_form.jsp"/>
          
          <c:import url="components/transact_forms/deposite_form.jsp"/>
          
          <c:import url="components/transact_forms/withdraw_form.jsp"/>
          
        </div>
        </div>
</body>
</html>