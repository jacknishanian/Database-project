<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Owner page</title>
<style>
/* css style for button */
.button {
  display: inline-block;
  padding: 10px 20px;
  font-size: 14px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #4CAF50;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
</style>
</head>
<body>

<div align = "center">
	

<h1>Welcome! You have been logged in as Owner</h1>
<a href="login.jsp"target ="_self" > logout</a><br><br>

        <a href="davesClientStats.jsp" class="button">Dave's Client Statistics</a> 
        </br>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Quotes</h2></caption>
            <tr>
				<th>User id</th>
				<th>Tree Size</th>
				<th>Tree Location</th>
				<th>Distance from house</th>
				<th>Order Of Work</th>
                <th>Response initial</th>
                <th>Final response</th>

                

                
            </tr>
            <c:forEach var="quotes" items="${listQuote}">
                <tr style="text-align:center">
                	<td><c:out value="${quotes.id}" /></td>
                	<td><c:out value="${quotes.size}" /></td>
					<td><c:out value="${quotes.location}" /></td>
					<td><c:out value="${quotes.house_dist}" /></td>
					<td><c:out value="${quotes.oow_status}" /></td>
					
                  
	
					<td align="center">
						<form action = "responsePage1">
							<input type="hidden" name="userID" value="${quotes.id}">
							<input type="submit" value="Offer Quote"/>
						</form>
					</td>

							
					<td align="center">
						<form action = "responsePage3">
							<input type="hidden" name="userID" value="${quotes.id}">
							<input type="submit" value="Confirm  Quote"/>
						</form>
					</td>
			
            </c:forEach>
        </table>
       
        <div align="center">
    <table border="1" cellpadding="6">
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
        	<td><c:out value="${otq.id}" /></td>
        	<td><c:out value="${otq.id}" /></td>
         </c:forEach>
         
         </br>
         </br>
       </table>
        
	</div>
	</div>
     
     
</body>
</html>