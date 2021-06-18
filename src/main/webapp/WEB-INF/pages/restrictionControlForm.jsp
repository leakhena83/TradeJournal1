<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Restriction Control System</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
    
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>  
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>  
	
    
    <script>
        	function confirm_delete() {
        	  return confirm('Are you sure to delete this restrition control ?');
        	}
    </script>
    
   
</head>
<body>
	  <h2> Edit / Delete Order Restriction Control</h2>
       <form:form action="saveDeleteRestrictionControl"  method ="post" modelAttribute="restrictionControl">
    	
          <form:hidden path="rcs_id"/>
          <div class="restrictionControl container main">
          <div class= "restrictionControlColor container color">
    	    <div class = "restrictionControlFirst container first">
    	 
              <label for="rcs_oderentryname"> Order Entry Name:</label>
                <form:input path="rcs_oderentryname" /><br>
                
              <label for="rcs_actual"> Actual:</label>
                <form:input path="rcs_actual" /><br>
                
              <label for="rcs_min"> Min:</label>
                <form:input path="rcs_min" /><br>  
                
             <label for="rcs_neutral"> Neutral:</label>
                <form:input path="rcs_neutral" required="required" /><br>  
                
             <label for="rcs_max"> Max:</label>
                <form:input path="rcs_max" /><br>  
                    
             <label for="rcs_date"> Date :</label>
                <form:input path="rcs_date" value ="${date}"/><br> 
                
           </div>
           
           <div class=" restrictionControlThird container third">
              <input class ="button" type="submit" name="save" value="Save" >
              <input class ="button" type="submit" name="delete" value="Delete" Onclick="return confirm_delete()">
              <input class ="button" type="button" name="cancel" value="Cancel" onclick="location.href='/restrictionControl?i=0'" >	
          </div>
       </div>
       </div>
     </form:form>
</body>
</html>