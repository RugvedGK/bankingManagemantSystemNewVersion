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
<div class="card deposite-card">

          <form action="/transact/deposit" method="post" class="deposite-form">
            <div class="form-group mb-2">
              <label for="">Enter deposit Amount</label>
              <input type="text" name="deposite_amount" id="" class="form-control" placeholder="Enter deposite amount">
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
            
            

            <div class="form-group my-2">
              <button id="transact-btn" class="btn btn-md transact-btn">Deposite</button>
            </div>
          </div>
        </div>
          </form>

</body>
</html>