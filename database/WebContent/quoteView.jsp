<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Quote Root page</title>
</head>
<body>

<div align = "center">
	
	<a href="login.jsp"target ="_self" > logout</a><br><br> 

<h1>Quote Page</h1>

					<td align="center">
						<form action = "root">
							<button type="submit" type="button" class="btn btn-primary shadow btn-lg">Back to Root</button>
						</form>
						<br>
						<form action = "cutPage">
							<button type="submit" type="button" class="btn btn-warning shadow">See Cut page</button>
						</form>
						<br>

					</td>

    <div align="center">
       
    <table class="table caption-top table-striped"   border="1" cellpadding="6">
        <caption><h2>One Tree Quotes</h2></caption>
        
        	<tr>
            	<th>Quote ID</th>
            	<th>User ID</th>
            	<th>Tree Height</th>
            	<th>Tree Location</th>
            	<th>Status</th>
            	<th>Action</th>
        	</tr>
        	
        <c:forEach var="otq" items="${oneTreeQuotes}">
        <tr style="text-align:center">
        	<td><c:out value="${otq.id}" /></td>
        	<td><c:out value="${otq.id}" /></td>
        	<td><c:out value="${otq.height}" /></td>
        	<td><c:out value="${otq.location}" /></td>
        	<td><c:out value="${otq.request_status}" /></td>
        	<td><c:out value="${otq.oow_status}" /></td>
         </c:forEach>
         
         </br>
         </br>
       </table>
  
    <table class="table caption-top table-striped"   border="1" cellpadding="6">
        <caption><h2>Big Clients (Quotes)</h2></caption>
        
        	<tr>
            	<th>User ID</th>
            	<th>Amount of trees</th>
        	</tr>
        	
        <c:forEach var="bc" items="${bigCli}">
        <tr style="text-align:center">
        	<td><c:out value="${bc.id}" /></td>
        	<td><c:out value="${bc.num_trees}" /></td>
         </c:forEach>
         </br>
         </br>
       </table>
       
                          <div align="center">
    <table class="table caption-top table-striped"   border="1" cellpadding="6">
        <caption><h2>Easy Clients (Quotes)</h2></caption>
        
        	<tr>
            	<th>User ID</th>
        	</tr>
        	
        <c:forEach var="easy" items="${easyCli}">
        <tr style="text-align:center">
        	<td><c:out value="${easy.size}" /></td>
         </c:forEach>
         </br>
         </br>
       </table>
           <table class="table caption-top table-striped"   border="1" cellpadding="6">
        <caption><h2>Prospective Clients (Quotes)</h2></caption>
        
        	<tr>
            	<th>User ID</th>
        	</tr>
        	
        <c:forEach var="prosp" items="${prospCli}">
        <tr style="text-align:center">
        	<td><c:out value="${prosp.size}" /></td>
         </c:forEach>
         </br>
         </br>
       </table>
          </div>
          
       
	</div>
	</div>

</body>
</html>