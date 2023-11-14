<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activity page</title>
</head>

<center><h1>Welcome! <c:out value="${user.firstName}" /> <c:out value="${' '}" /> <c:out value="${user.lastName}" /> You have been logged in</h1> </center>
 
	<body>
	 <center>
		 <a href="login.jsp"target ="_self" > logout</a>
		 <br>
		 <br> 
            <table border="1" cellpadding="6">
            <caption><h2>Quote Info</h2></caption>
            <tr>
            	<th>Bill Nnfo</th>
            	<th>Bill Response Date</th>
				<th>Bill Amount Paid</th>
				<th>Payment date</th>
				<th>Dispute Note</th>
				<th>Dispute Date</th>
				<th>Terms</th>
				<th>Order Of Work Status</th>
				<th>Quote Note</th>
				<th>Quote Status</th>
				
				
				<th>Tree_pic1</th>
				<th>Tree_pic2</th>
				<th>Tree_pic3</th>

            </tr>
            

            <tr style="text-align:center">
                    <td><c:out value="${user.bill_response_note}" /></td>
                    <td><c:out value="${user.bill_response_date}"/></td>
                    <td><c:out value="${'$'}" /> <c:out value="${user.amount_paid}" /></td>
                    <td><c:out value="${user.payment_date}"/></td>
                    <td><c:out value="${user.dispute_note}" /></td>
                    <td><c:out value="${user.dispute_date}"/></td>
                    <td><c:out value="${user.terms_agreed}" /></td>
                    <td><c:out value="${user.oow_status}"/></td>
                    <td><c:out value="${user.quote_response_note}" /></td>
                    <td><c:out value="${user.quote_response_status}"/></td>
                    
                    <td><img src="data:image/jpg;base64, ${user.img_1}" width="200" height="200"></td>
                    <td><img src="data:image/jpg;base64, ${user.img_2}" width="200" height="200"></td>
                    <td><img src="data:image/jpg;base64, ${user.img_3}" width="200" height="200"></td>


			</tr>
            
        </table>
            
		 </center>
	</body>
</html>