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


			<div class="container">
				<c:if test="${requestScope.payment_history != null}">
				        <table class="table text-center">
				            <tr>
				                <th>Record Number</th>
				                <th>Beneficiary</th>
				                <th>Beneficiary Account Number</th>
				                <th>Amount</th>
				                <th>Status</th>
				                <th>Reference</th>
				                <th>Reason Code</th>
				                <th>Created at</th>
				            </tr>
				
				            <c:forEach items="${requestScope.payment_history}" var="payment">
				                <tr>
				                    <td>${payment.payment_id}</td>
				                    <td>${payment.beneficiary}</td>
				                    <td>${payment.beneficiary_acc_no}</td>
				                    <td>${payment.amount}</td>
				                    <td>${payment.status}</td>
				                    <td>${payment.reference_no}</td>
				                    <td>${payment.reason_code}</td>
				                    <td>${payment.create_at}</td>
				                </tr>
				            </c:forEach>
				        </table>
				    </c:if>
			</div>



<c:import url="components/incl/footer.jsp"/>

</body>
</html>