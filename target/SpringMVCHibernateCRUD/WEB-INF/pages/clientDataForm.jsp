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
            $(function () {
                $("#datepicker").datepicker();
            });
    </script>
	
    <script>
        	function confirm_delete() {
        	  return confirm('Are you sure to delete this client data ?');
        	}
    </script>
    
</head>
<body>
   		
   	  <c:choose>
			<c:when test="${id == 0}">
				 <h2> New Client Data</h2>
			</c:when>
			<c:otherwise>
				 <h2> Edit / Delete Client Data</h2>
			</c:otherwise>
	   </c:choose>
       <form:form action="saveDeleteClientData"  method ="post" modelAttribute="clientData">
    	
          <form:hidden path="scd_id"/>
          <input type = "hidden" name = "user_name"  value ="${user_name}"/>
          <input type = "hidden" name = "usr_id"  value ="${user_id}"/>
          
          <div class="restrictionControl container main">
          <div class= "restrictionControlColor container color">
    	    <div class = "restrictionControlFirst container first">
    	 
              <label for="scd_firstname"> First Name:</label>
                <form:input path="scd_firstname" /><br>
                
              <label for="scd_lastname"> Last Name:</label>
                <form:input path="scd_lastname" /><br>
             
             <label for="scd_birthday"> Birthday:</label>
             <c:set var="id" value="${id}"/>
             <c:choose>
					<c:when test="${id != 0}">
						<input type = "text" name = "scd_birthday" value ="${birthDate}" id="datepicker" >
    				</c:when>    
    				<c:otherwise>
        				<form:input path="scd_birthday"  id="datepicker" required="required"/>
    				</c:otherwise>
			 </c:choose> <br>
             
             <label for="scd_nationality"> Nationality:</label>
                <form:input path="scd_nationality" required="required" /><br>  
                
             <label for="scd_country_domicile"> Country Domicile:</label>
                <form:input path="scd_country_domicile" /><br>  
                
             <label for="scd_address"> Address:</label>
                <form:input path="scd_address" /><br>  
                
             <label for="scd_business_phone"> Business Phone:</label>
                <form:input path="scd_business_phone" /><br>  
                
             <label for="scd_mobilephone"> Mobile Phone:</label>
                <form:input path="scd_mobilephone" /><br>  
                
             <label for="scd_homephone"> Home Phone:</label>
                <form:input path="scd_homephone" /><br>
                
             <label for="scd_email"> Email:</label>
                <form:input path="scd_email" /><br>
             
             <label for="scd_accountnumber"> Accountnumber:</label>
                <form:input path="scd_accountnumber" /><br>
             
             <label for="scd_custodianbank"> Custodian Bank:</label>
                <form:input path="scd_custodianbank" /><br>
                    
             <label for="scd_others"> Others:</label>
                <form:input path="scd_others" /><br>                
           </div>
           
           <div class=" restrictionControlThird container third">
              <c:choose>
           		  <c:when test="${id == 0}">
           			<input class ="button" type="submit" name="save" value="Save" >	
           			<input class ="button" type="button" name="cancel" value="Cancel" onclick="location.href='/orderentry?i=0'" >	
           		  </c:when>
                  <c:otherwise>
                  	 <input class ="button" type="submit" name="save" value="Save" >
                	 <input class ="button" type="submit" name="delete" value="Delete" Onclick="return confirm_delete()">
                	 <input class ="button" type="button" name="cancel" value="Cancel" onclick="location.href='/orderentry?i=0'" >	

                  </c:otherwise>
               </c:choose>
          </div>
       </div>
       </div>
     </form:form>
</body>
</html>