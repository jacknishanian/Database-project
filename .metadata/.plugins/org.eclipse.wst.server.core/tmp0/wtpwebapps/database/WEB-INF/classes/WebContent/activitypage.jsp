<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activity page</title>
</head>

<center><h1>Welcome! You have been successfully logged in</h1> </center>

 
	<body>
	 <center>
		 <a href="login.jsp"target ="_self" > logout</a><br><br> 
		 <p> You can show all the transactions or other attributes here like balance, name of the user and others.</p>
		 
		 

            
            <table border="1" cellpadding="6">
            <caption><h2>List of Users</h2></caption>
            <tr>
				<th>User</th>
				<th>Phone_num</th>
				<th>Tree_pic1</th>
				<th>Tree_pic2</th>
				<th>Tree_pic3</th>
				<th>Quote_price</th>
				<th>Quote_time</th>
				<th>Quote_note</th>
				<th>Quote_response</th>
				<th>Quote_date</th>
				<th>Work_order_terms</th>
				<th>Work_order_status</th>
				<th>Bill_amount</th>
				<th>Bill_status</th>
            </tr>
            

            <tr style="text-align:center">

                    <td><c:out value="${user.firstName}" /> <c:out value="${' '}" /> <c:out value="${user.lastName}" /></td>
                    <td><c:out value="${user.phone_num}" /></td>
                    <td><c:out value="${user.tree_pic1}" /></td>
                    <td><c:out value="${user.tree_pic2}" /></td>
                    <td><c:out value="${user.tree_pic3}" /></td>
                    <td><c:out value="${'$'}" /> <c:out value="${user.quote_price}"/></td>
                    <td><c:out value="${user.quote_time}" /></td>
                    <td><c:out value="${user.quote_note}"/></td>
                    <td><c:out value="${user.quote_response}" /></td>
                    <td><c:out value="${user.quote_date}" /></td>
                    <td><c:out value="${user.work_order_terms}" /></td>
                    <td><c:out value="${user.work_order_status}"/></td>
                    <td><c:out value="${'$'}" /> <c:out value="${user.bill_amount}" /></td>
                    <td><c:out value="${user.bill_status}" /></td>
            
             
            
        </table>
            
		 </center>
	</body>
</html>