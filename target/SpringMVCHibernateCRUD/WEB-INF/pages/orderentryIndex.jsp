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
	
		<h2>OrderEntry List</h2>
		<a href="newOrderEntry?param=st" class = "button link">Add New</a>
		<table>
			<th>ID</th>
			<th>ISIN</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>User ID</th>
			<th>Bank</th>
			<th>Trade Date</th>
			<th>Action</th>
			<th>Amount</th>
			<th>Action</th>
			
			<c:forEach var="orderentry" items="${listOrderentry}">
				<tr>
					<td>${orderentry.ode_id}</td>
					<td>${orderentry.isn_isin}</td>
					<td>${orderentry.ode_firstname}</td>
					<td>${orderentry.ode_lastname}</td>
					<td>${orderentry.ode_userid}</td>
					<td>${orderentry.ode_bank}</td>
					<td>${orderentry.ode_traddate}</td>
					<td>${orderentry.ode_action}</td>
					<td>${orderentry.ode_amount}</td>
					<td><a href="editOrderEntry?id=${orderentry.ode_id}&isin=${orderentry.isn_isin}">Edit |</a>
						&nbsp;<a
						href="deleteOrderEntry?id=${orderentry.ode_id}&isin=${orderentry.isn_isin}">Delete</a></td>
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
								<p class="page" > << Previous | <a href="orderentry?i=${indexNext}"> Next >></a></p>
    						</c:when> 
    						<c:when test="${(n >= rn)}">
								<td><p class="page" ><a href="orderentry?i=${indexPrevious}">   << Previous | </a> Next >></p></td>
    						</c:when> 
    						<c:otherwise>
        				  		<td><p class="page" ><a href="orderentry?i=${indexPrevious}"> << Previous | </a><a href="orderentry?i=${indexNext}">Next >> </a></p></td>
    						</c:otherwise>
    					</c:choose>
					</c:otherwise>
				</c:choose>	
	
</body>
</html>