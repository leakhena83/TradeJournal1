<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OrderEntry Management</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
</head>
<body>
	
		<h2>Statistic Client Data List</h2>
		<a href="newClientData?param=st&user_id=${user_id}&user_name=${user_name}" class = "button link">Add New</a>
		<table>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Address</th>
			<th>Business Phone</th>
			<th>Mobile Phone</th>
			<th>Email</th>
			<th>Account Number</th>
			<th>Custodian Bank</th>
			<th>Action</th>
			
			<c:forEach var="clientdata" items="${listClientData}">
				<tr>
					<td>${clientdata.scd_firstname}</td>
					<td>${clientdata.scd_lastname}</td>
					<td>${clientdata.scd_address}</td>
					<td>${clientdata.scd_business_phone}</td>
					<td>${clientdata.scd_mobilephone}</td>
					<td>${clientdata.scd_email}</td>
					<td>${clientdata.scd_accountnumber}</td>
					<td>${clientdata.scd_custodianbank}</td>
					
					<td><a href="editClientData?id=${clientdata.scd_id}&user_id=${user_id}">Edit |</a>
						&nbsp;<a
						href="deleteClientData?id=${clientdata.scd_id}&user_id=${user_id}">Delete</a></td>
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
								<p class="page" > << Previous | <a href="clientdata?i=${indexNext}"> Next >></a></p>
    						</c:when> 
    						<c:when test="${(n >= rn)}">
								<td><p class="page" ><a href="clientdata?i=${indexPrevious}">   << Previous | </a> Next >></p></td>
    						</c:when> 
    						<c:otherwise>
        				  		<td><p class="page" ><a href="clientdata?i=${indexPrevious}"> << Previous | </a><a href="clientdata?i=${indexNext}">Next >> </a></p></td>
    						</c:otherwise>
    					</c:choose>
					</c:otherwise>
				</c:choose>	
	
</body>
</html>