<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner page</title>
</head>
<body>

<div align = "center">
	

<h1>Welcome! You have been logged in as Owner</h1>
<a href="login.jsp"target ="_self" > logout</a><br><br> 
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Quotes</h2></caption>
            <tr>
				<th>User id</th>
				<th>Tree Size</th>
				<th>Tree Location</th>
				<th>Distance from house</th>
				<th>Order Of Work</th>
                <th>Tree pictures</th>
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
					
                    <td>
                    	<img src="data:image/jpg;base64, ${quotes.img_1}" width="200" height="200">
                    	<img src="data:image/jpg;base64, ${quotes.img_2}" width="200" height="200">
                    	<img src="data:image/jpg;base64, ${quotes.img_3}" width="200" height="200">
                    </td>
	
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
	</div>
	</div>

</body>
</html>