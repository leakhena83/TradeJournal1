<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trade Journal Database Reconciliation</title>
</head>
<body>
	Welcome ${user}!! <br>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">
				<a href="orderentry?i=0">Order Entry System </a>
			</td>
		</tr>
		<tr>
			<td style="font-style: italic; color: red;">
				<a href="restrictionControl?i=0">Restriction Control System</a>
			</td>
		</tr>
		<tr>
			<td style="font-style: italic; color: red;">
				<a href="clientdata?i=0&user_name=${user_name}&user_id=${user_id}">Statistic Client Data </a>
			</td>
		</tr>
		<tr>
			<td style="font-style: italic; color: red;">
				<a  href="databaseReconciliation?i=0 ">Database Reconciliation System</a>
			</td>
		</tr>
		
		<tr>
			<td style="font-style: italic; color: red;">
				<a href="corporationActionRegister?i=0">Corporation Action Register</a>
			</td>
		</tr>
		
	</table>
</body>
</html>