<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Corporate Action Register Management</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
</head>
<body>
	
		<h2>Corporate Action Register List</h2>
		
		<table>
			<th>Payment Devidend</th>
			<th>Payment Coupon</th>
			<th>Maturity Bound</th>
			<th>Call Bound</th>
			<th>Exercise Option</th>
			<th>Expiry Option</th>
			<th>Action</th>
			
			<c:forEach var="listCorporateActionRegister" items="${listCorporateActionRegister}">
			
				<tr>
					<td>${listCorporateActionRegister.car_payment_devidend}</td>
					<td>${listCorporateActionRegister.car_payment_coupon}</td>
					<td>${listCorporateActionRegister.car_maturity_bound}</td>
					<td>${listCorporateActionRegister.car_call_bound}</td>
					<td>${listCorporateActionRegister.car_exercise_option}</td>
					<td>${listCorporateActionRegister.car_expiry_option}</td>
					
					<td><a href="deleteCorporateActionRegister?id=${listCorporateActionRegister.car_id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:set var="p" value="${indexPrevious}"/>
		<c:set var="n" value="${indexNext}"/>
		<c:set var="rn" value="${rowNumber}"/>
				<c:choose>
					<c:when test="${rn<=14}" > 
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${(p < 0)}">
								<p class="page" > << Previous | <a href="corporationActionRegister?i=${indexNext}"> Next >></a></p>
    						</c:when> 
    						<c:when test="${(n >= rn)}">
								<td><p class="page" ><a href="corporationActionRegister?i=${indexPrevious}">   << Previous | </a> Next >></p></td>
    						</c:when> 
    						<c:otherwise>
        				  		<td><p class="page" ><a href="corporationActionRegister?i=${indexPrevious}"> << Previous | </a><a href="corporationActionRegister?i=${indexNext}">Next >> </a></p></td>
    						</c:otherwise>
    					</c:choose>
					</c:otherwise>
				</c:choose>	
	
</body>
</html>