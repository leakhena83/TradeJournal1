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
	
		<h2>Restriction Control List</h2> 
		<table>
			<th>Date</th>
			<th>Order Entry Name</th>
			<th>Actual</th>
			<th>Min</th>
			<th>Netural</th>
			<th>Max</th>
			<th>Vs Neutral</th>
			<th>Vs Min</th>
			<th>Vs Max</th>
			<th>Message</th>
			<th>Action</th>
			
			<c:forEach var="restrictionControl" items="${listRestrictionControl}">
				<tr>
					<td>${restrictionControl.date}</td>
					<td>${restrictionControl.rcs_oderentryname}</td>
					<td>${restrictionControl.rcs_actual}</td>
					<td>${restrictionControl.rcs_min}</td>
					<td>${restrictionControl.rcs_neutral}</td>
					<td>${restrictionControl.rcs_max}</td>
					<td>${restrictionControl.rcs_vsneutral}</td>
					<td>${restrictionControl.rcs_vsmin}</td>
					<td>${restrictionControl.rcs_vsmax}</td>
					<td>${restrictionControl.rcs_message}</td>
					<td><a href="editRestrictionControl?id=${restrictionControl.rcs_id}">Edit |</a>
						&nbsp;<a
						href="deleteRestrictionControl?id=${restrictionControl.rcs_id}">Delete</a></td>
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
								<p class="page" > << Previous | <a href="restrictionControl?i=${indexNext}"> Next >></a></p>
    						</c:when> 
    						<c:when test="${(n >= rn)}">
								<td><p class="page" ><a href="restrictionControl?i=${indexPrevious}">   << Previous | </a> Next >></p></td>
    						</c:when> 
    						<c:otherwise>
        				  		<td><p class="page" ><a href="restrictionControl?i=${indexPrevious}"> << Previous | </a><a href="restrictionControl?i=${indexNext}">Next >> </a></p></td>
    						</c:otherwise>
    					</c:choose>
					</c:otherwise>
				</c:choose>	
	
</body>
</html>