<%@ page contentType="text/html; charset=UTF-8" %>

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
<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
        <div class="offcanvas-header">
          <h5 class="text-white" id="offcanvasRightLabel">Create / Add an Account</h5>
          <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
          <div class="card">
            <div class="card-body">
              <form action="" class="add-account-from">
                <div class="form-group mb-3">
                  <label for="">Enter Account Name</label>
                  <input type="text" name="account_name" class="form-control" placeholder="Enter Account name...">
                </div>

                <div class="form-group mb-3">
                  <label for="">Select Account Type</label><br>
                  <select name="account-type" class="form-control" id="">
                    <option value="">-- Select Account Type --</option>
                    <option value="check">-- Check --</option>
                    <option value="saving">-- Savings --</option>
                    <option value="business">-- Business --</option>
                  </select>
                  </div>

                  <!-- <div class="form-group mb-3">
                    <input type="text" name="account_name" class="form-control" placeholder="Enter Account name...">
                  </div> -->

                  <div class="form-group my-2">
                    <button id="transact-btn" class="btn btn-md transact-btn">Add Account</button>
                  </div>
                  
              </form>
            </div>
          </div>
        </div>
      </div>
</body>
</html>