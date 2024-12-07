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
<div class="card transfer-card">
            <div class="card-body">
              <div class="form-group">
                <label for="">Select Account</label>
                <select name="account-id" class="form-control" id="">
                  <option value="">-- Select Account --</option>
                </select>
              </div>

              <div class="form-group">
                <label for="">Select Account</label>
                <select name="account-id" class="form-control" id="">
                  <option value="">-- Select Account --</option>
                </select>
              </div>
              
              <div class="form-group mb-2">
                <label for="">Enter transfer Amount</label>
                <input type="text" name="transfer_amount" id="" class="form-control" placeholder="Enter transfer Account">
              </div>

              <div class="form-group mb-2">
                <button id="transact-btn" class="btn btn-md transact-btn">Transfer</button>
              </div>
            </div>
          </div>
</body>
</html>