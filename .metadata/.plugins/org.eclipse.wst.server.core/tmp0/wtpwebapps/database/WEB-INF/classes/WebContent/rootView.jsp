<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Root page</title>
</head>
<body>

<div align = "center">
	
	<form action = "initialize">
		<input type = "submit" value = "Initialize the Database"/>
	</form>
	<a href="login.jsp"target ="_self" > logout</a><br><br> 

<h1>List all users</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>Email</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Password</th>
                <th>Credit Card#</th>
                <th>Credit Card Date</th>
                <th>Credit Card CVC</th>
                <th>User role</th>
                <th>Quote content</th>
                <th>Quote Response</th>
                <th>Quote status</th>
                <th>Work Order Content</th>
                <th>Work Order Status</th>
                <th>Bill Content</th>
                <th>Bill Status</th>
                
            </tr>
            <c:forEach var="users" items="${listUser}">
                <tr style="text-align:center">
                    <td><c:out value="${users.email}" /></td>
                    <td><c:out value="${users.firstName}" /></td>
                    <td><c:out value="${users.lastName}" /></td>
                    <td><c:out value="${users.password}" /></td>
                    <td><c:out value="${users.card_num}" /></td>
                    <td><c:out value="${users.card_date}" /></td>
                    <td><c:out value="${users.card_cvc}" /></td>
                    <td><c:out value="${users.role}" /></td>
                    <td><c:out value="${users.quotes_content}" /></td>
                    <td><c:out value="${users.quotes_response}"/></td>
                    <td><c:out value="${users.quotes_status}" /></td>
                    <td><c:out value="${users.work_order_content}" /></td>
                    <td><c:out value="${users.work_order_status}" /></td>
                    <td><c:out value="${users.bill_of_work_content}"/></td>
                    <td><c:out value="${users.bill_of_work_status}" /></td>
                    
            </c:forEach>
        </table>
	</div>
	</div>

</body>
</html>