<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Restriction Control Management</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
</head>
<body>
	
		<h2>Database Reconciliation List</h2>
		
		<table>
			<th>ISIN</th>
			<th>Amount</th>
			<th>Trade Date</th>
			<th>Value Date</th>
			<th>Client ID</th>
			<th>Message</th>
			<th>Action</th>
			
			<c:forEach var="dataReconciliation" items="${listCustodianBankControl}">
			
				<tr>
					<td>${dataReconciliation.cbd_isin}</td>
					<td>${dataReconciliation.cbd_amount}</td>
					<td>${dataReconciliation.cbd_tradDate}</td>
					<td>${dataReconciliation.cbd_valueDate}</td>
					<td>${dataReconciliation.cbd_clientID}</td>
					<td>${dataReconciliation.cbd_message}</td>
					<td><a href="deleteRestrictionControl?id=${dataReconciliation.cbd_id}">Delete</a></td>
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
								<p class="page" > << Previous | <a href="databaseReconciliation?i=${indexNext}"> Next >></a></p>
    						</c:when> 
    						<c:when test="${(n >= rn)}">
								<td><p class="page" ><a href="databaseReconciliation?i=${indexPrevious}">   << Previous | </a> Next >></p></td>
    						</c:when> 
    						<c:otherwise>
        				  		<td><p class="page" ><a href="databaseReconciliation?i=${indexPrevious}"> << Previous | </a><a href="restrictionControl?i=${indexNext}">Next >> </a></p></td>
    						</c:otherwise>
    					</c:choose>
					</c:otherwise>
				</c:choose>	
	
</body>
</html>