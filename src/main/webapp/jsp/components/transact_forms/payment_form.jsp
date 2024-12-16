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
	<div class="card payment-card">
            <div class="card-body">
            	<form action="/transact/payment" method="post">
            		  <div class="form-group mb-2">
                <label for="">Account Holder / Beneficiary</label>
                <input type="text" name="beneficiary" id="" class="form-control" placeholder="Enter Account Holder / Beneficiary name">
              </div>
              <div class="form-group mb-2">
                <label for="">Beneficiary Account No</label>
                <input type="text" name="beneficiary_acc_no" id="" class="form-control" placeholder="Enter Beneficiary Account No">
              </div>
              <div class="form-group">
              <label for="">Select Account</label>
              <select name="account_id" class="form-control" id="">
                <option value="">-- Select Account --</option>
                <c:if test="${userAccounts != null}">
            	<c:forEach items="${userAccounts}" var="selectAccount">
            		<option value="${selectAccount.account_id }">${selectAccount.account_name}</option>
            	</c:forEach>
            </c:if>
              </select>
            </div>
            
              <div class="form-group mb-2">
                <label for="">Reference</label>
                <input type="text" name="reference" id="" class="form-control" placeholder="Enter Reference">
              </div>
              <div class="form-group mb-2">
                <label for="">Enter Payment Account</label>
                <input type="text" name="payment_amount" id="" class="form-control" placeholder="Enter Payment Account">
              </div>

              <div class="form-group mb-2">
                <button id="transact-btn" class="btn btn-md transact-btn">Pay</button>
              </div>
            	</form>
            </div>
          </div>
</body>
</html>