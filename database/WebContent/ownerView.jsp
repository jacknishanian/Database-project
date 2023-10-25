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
                <th>Email</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Phone Number</th>
                <th>Tree pictures</th>
                <th>Work Order status</th>
                <th>Edit Quote</th>

                
            </tr>
            <c:forEach var="users" items="${listUser}">
                <tr style="text-align:center">
                    <td><c:out value="${users.id}" /></td>
                    <td><c:out value="${users.firstName}" /></td>
                    <td><c:out value="${users.lastName}" /></td>
                    <td><c:out value="${users.phone_num}" /></td>
                    <td>
                    	<img src="data:image/jpg;base64, ${users.img_1}" width="200" height="200">
                    	<img src="data:image/jpg;base64, ${users.img_2}" width="200" height="200">
                    	<img src="data:image/jpg;base64, ${users.img_3}" width="200" height="200">
                    </td>
                    <td><c:out value="${users.work_order_status}" /></td>
                    <td align="center" colspan="5">
						<form action = "edit">
						<!-- Need to find a way to pass users.id via the onClick to redirect to the edit page for that id -->
							<input type = "submit" value = "Edit" onClick ="currentUser = ${users.id}"/>
						</form>
					</td>
                    

            </c:forEach>
        </table>
	</div>
	</div>

</body>
</html>