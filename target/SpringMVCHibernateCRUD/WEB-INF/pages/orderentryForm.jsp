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
                $("#datepicker1").datepicker();
                $("#datepicker2").datepicker();
            });
    </script>
     
    <script>
        	function confirm_delete() {
        	  return confirm('Are you sure to delete this order entry ?');
        	}
    </script>
    
    <script>
		function repopulate(){
			var isin = document.getElementById('isin').value;
			var id = document.getElementById('index').value;
			if (id == 0)
				var url = 'http://localhost:8080/newOrderEntry' + '?param='+ isin;
			else var url = 'http://localhost:8080/editOrderEntry' + '?id='+ id + '&isin=' + isin ;
				
			window.location.href = url;
		}
	</script>
</head>
<body>  
		<c:choose>
			<c:when test="${id == 0}">
				 <h2> New Order Entry</h2>
			</c:when>
			<c:otherwise>
				 <h2> Edit / Delete Order Entry</h2>
			</c:otherwise>
		</c:choose>
        <form:form action="saveDeleteOrderEntry"  method ="post" modelAttribute="orderentry">
    	
          <form:hidden path="ode_id" id="index"/>
          <div class="orderEntry container main">
          <div class= "orderEntryColor container color">
    	    <div class = "orderEntryFirst container first">
    	      <div class="require"><font color="red" >Required Field * </font></div>
    	      ISIN: <select  name="isn_isin" id="isin" onChange="repopulate()">
    	      <c:set var = "isin" value ="${isin}" /> 
    	      	<c:choose>
    	      		<c:when test="${id != 0}">
    	      			<option value = "${isin}">${isin}</option>
    	      		</c:when>
    	      		<c:otherwise>
    	      			<c:choose>
    	      				
    	         	       <c:when test ="${isin != 'null'}">
    	         		       <option value="${isin}">${isin}</option>
    	         	       </c:when>
    	         	       <c:otherwise>
    	         		       <option value="0">--Select ISIN--</option>
    	         	       </c:otherwise>
    	               </c:choose>
    	      		</c:otherwise>
    	      	</c:choose>
			   <c:forEach var="listIsin" items="${listIsin}">
				  <option value="${listIsin.isn_isin}">${listIsin.isn_isin}</option>
			   </c:forEach>  
			   </select><br>
              <label for="ode_securityname"> Security Name:</label>
                <input type ="text" name ="ode_securityname" value="${securityName}" /><br>
              <label for="de_currency"> Currency:</label>
                <input type = "text" name ="ode_currency" value = "${currency}" /><br>
              <label for="ode_firstname" >First Name: </label> 
              <form:input path ="ode_firstname" required="required" /><font color="red"> *</font><br>
         	  <label for="ode_lastname">Last Name: </label>
              <form:input path="ode_lastname" required="required" /><font color="red"> *</font><br>
          
              <label for="ode_userid">User ID:</label>
              <form:input path="ode_userid" required="required" value ="${userId}" /><font color="red"> *</font><br>
            
               <label for="ode_bank">Bank: </label>
               <form:input path="ode_bank" required="required"  /><font color="red"> *</font><br>
            
               <label for="ode_traddate">Trade Date: </label>
				<c:choose>
					<c:when test="${id != 0}">
						<td><input type = "text" name = "ode_traddate" value ="${tradDate}"></td>
    				</c:when>    
    				<c:otherwise>
        				   <td><input type = "text" name = "ode_traddate"  value ="${traDate}"/></td>
    				</c:otherwise>
				</c:choose><br>
               
               <label for="ode_action"> Action:</label>
                <form:input path="ode_action" required="required" /><font color="red"> *</font><br>
           	   <label for="ode_amount"> Amount:</label>
                <form:input path="ode_amount" required="required" /><font color="red"> *</font><br>
               <label for="ode_valuedate"> Value Date: </label>
                <c:set var="id" value="${id}"/>
				<c:choose>
					<c:when test="${id != 0}">
						<td><input type = "text" name = "ode_valuedate" value ="${vlueDate}"></td>
    				</c:when>    
    				<c:otherwise>
        				  <td><input type = "text" name = "ode_valuedate"  value ="${valueDate}"/></td>
    				</c:otherwise>
				</c:choose><br>
            
               <label for="ode_limit"> Limit: </label>
                <form:input path="ode_limit" required="required" /><font color="red"> *</font><br>
            
               <label for="ode_stoploss"> Stop Loss: </label>
                <form:input path="ode_stoploss" required="required" /><font color="red"> *</font><br>
                
               <label for="ode_validdate"> Valid Until: </label>
            
                <c:set var="id" value="${id}"/>
				<c:choose>
					<c:when test="${id != 0}">
						<td><input type = "text" name = "ode_validdate" value ="${vlidDate}" required="required"  id="datepicker1" ></td>
    				</c:when>    
    				<c:otherwise>
        				 <td><form:input path="ode_validdate" id="datepicker1" required="required"  /></td>
    				</c:otherwise>
				</c:choose><font color="red" > *</font><br>
           </div>
           <div class="container second">
                <label for="ode_clientinstruction">Client Instruction:</label>
                <form:input path="ode_clientinstruction" /><br>
            
            	<label for="ode_clientdetailmedium">Client Details Medium:</label>
                <form:input path="ode_clientdetailmedium" /><br>
           
                <label for="ode_callbacktel">Call Back Tel:</label>
                <form:input path="ode_callbacktel" /><br>
           
                <label for="ode_callbacktime">Call Back Time:</label>
                <form:input path="ode_callbacktime" /><br>
           
           		<label for="ode_mediumbank"> Medium Bank:</label>
                <form:input path="ode_mediumbank" /><br>
           
                <label for="ode_bankdetailmedium">  Bank Detail Medium:</label>
                <form:input path="ode_bankdetailmedium" /><br>
                
                <label for="ode_rational">  Rationale:</label>
                <form:input path="ode_rational" required="required"  /><font color="red"> *</font><br>
          
                <label for="ode_remark"> Remark:</label>
                <form:input path="ode_remark" /><br>
                
               <label for="ode_dateexecution">  Date Execution:</label>
				<c:set var="id" value="${id}"/>
				<c:choose>
					<c:when test="${id != 0}">
						<td><input type = "text" name = "ode_dateexecution" value ="${executeDate}" id="datepicker2" required="required"></td>
    				</c:when>    
    				<c:otherwise>
        				<td><form:input path="ode_dateexecution"  id="datepicker2" required="required"/></td>
    				</c:otherwise>
				</c:choose><font color="red"> *</font><br>
				
                <label for="ode_quantity">  Quantity:</label>
                <form:input path="ode_quantity" /><br>
                
               <label for="ode_price">  Price:</label>
                <form:input path="ode_price" /><br>
            
               <label for="ode_totalcurrency"> Total Currency:</label>
               <form:input path="ode_totalcurrency" /><br>
           
               <label for="ode_checked"> Checked:</label>
                <form:input path="ode_checked" /><br>
           </div>
           <div class="orderEntryThrid container third">
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