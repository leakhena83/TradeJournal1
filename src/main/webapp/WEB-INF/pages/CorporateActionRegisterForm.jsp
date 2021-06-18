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
    <title>Corporate Action Register Form</title>
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
        	  return confirm('Are you sure to delete this corporate action register ?');
        	}
    </script>
    
</head>
<body>
   		
   	   <h2 class = "restrictionControlH2"> Edit / Delete Corporate Action Register</h2>
   		
       <form:form action="deleteCorporateActionRegister"  method ="post" modelAttribute="corporateActionRegister">
    	
          <form:hidden path="car_id"/>
         
          <div class="restrictionControl container main">
          <div class= "restrictionControlColor container color">
    	    <div class = "restrictionControlFirst container first">
    	 
              <label for="car_payment_devidend"> Payment Devidend:</label>
                <form:input path="car_payment_devidend" /><br>
                
              <label for="car_payment_coupon"> Payment Coupon:</label>
                <form:input path="car_payment_coupon" /><br>
             
             <label for="car_maturity_bound"> Maturity Bound:</label>
                <form:input path="car_maturity_bound" /><br>
                
             <label for="car_call_bound"> Call Bound:</label>
                <form:input path="car_call_bound" required="required" /><br>  
                
             <label for="car_exercise_option"> Exercise Option:</label>
                <form:input path="car_exercise_option" /><br>  
                
             <label for="car_stock_split"> Stock Split:</label>
                <form:input path="car_stock_split" /><br>  
                
             <label for="car_return_capital"> Return Capital:</label>
                <form:input path="car_return_capital" /><br>  
                
             <label for="car_increase_capital"> Increase Capital:</label>
                <form:input path="car_increase_capital" /><br>  
                
             <label for="car_delisting"> Delisting:</label>
                <form:input path="car_delisting" /><br>
                           
           </div>
           
           <div class=" restrictionControlThird container third">
              <input class ="button" type="submit" name="save" value="Save" >
              <input class ="button" type="submit" name="delete" value="Delete" Onclick="return confirm_delete()">
              <input class ="button" type="button" name="cancel" value="Cancel" onclick="location.href='/corporationActionRegister?i=0'" >	
          </div>
       </div>
       </div>
     </form:form>
</body>
</html>