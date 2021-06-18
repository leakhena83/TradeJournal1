<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In</title>
</head>
<body>
    <div align="center">
        <h1> Log In </h1>
        <form:form action="logIn" method="post" modelAttribute="user">
        <table>
        	<form:hidden path="usr_id"/>
            <tr>
                <td>User Name:</td>
                <td><form:input path="usr_username" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:password path="usr_password" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Log In"></td>
            </tr>
        </table>
        </form:form>
        <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
    </div>
</body>
</html>