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

<h1>Root Page</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>Client stats (Cut)</h2></caption>
            <tr>
                <th>Email</th>
                <th>Num of trees</th>
                <th>Amount $ due</th>
                <th>Amount $ paid</th>
                <th>Date Cut</th>

            </tr>
            <c:forEach var="stats" items="${cliStats}">
                <tr style="text-align:center">
                    <td><c:out value="${stats.id}" /></td>
                    <td><c:out value="${stats.num_trees}" /></td>
                    <td><c:out value="${stats.amount_due}" /></td>
                    <td><c:out value="${stats.amount_paid}" /></td>
                    <td><c:out value="${stats.work_date}" /></td>
                    

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
        	<td><c:out value="${otq.request_status}" /></td>
        	<td><c:out value="${otq.oow_status}" /></td>
         </c:forEach>
         
         </br>
         </br>
       </table>
       
                       <div align="center">
    <table border="1" cellpadding="6">
        <caption><h2>Highest Trees (Cut)</h2></caption>
        
        	<tr>
            	<th>User ID</th>
            	<th>Tree Height</th>
        	</tr>
        	
        <c:forEach var="highTrees" items="${highTreesItem}">
        <tr style="text-align:center">
        	<td><c:out value="${highTrees.id}" /></td>
        	<td><c:out value="${highTrees.height}" /></td>
         </c:forEach>
         </br>
         </br>
       </table>
       
                              <div align="center">
    <table border="1" cellpadding="6">
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
    <table border="1" cellpadding="6">
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
           <table border="1" cellpadding="6">
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
                  <table border="1" cellpadding="6">
        <caption><h2>Bad Clients (cut)</h2></caption>
        
        	<tr>
            	<th>User ID</th>
        	</tr>
        	<c:forEach var="bad" items="${badCli}">
        <tr style="text-align:center">
        	<td><c:out value="${bad.id}" /></td>
         </c:forEach>
         </br>
         </br>
       </table>

       <table border="1" cellpadding="6">
        <caption><h2>Overdue (cut)</h2></caption>
        
        	<tr>
            	<th>User ID</th>
            	<th>Bill Gen date</th>
            	<th>Bill Pay date</th>
            	<th>Amount paid</th>
        	</tr>
        	<c:forEach var="bill" items="${overdue}">
        <tr style="text-align:center">
        	<td><c:out value="${bill.id}" /></td>
        	<td><c:out value="${bill.bill_response_date}" /></td>
        	<td><c:out value="${bill.payment_date}" /></td>
        	<td><c:out value="${bill.amount_paid}" /></td>
         </c:forEach>
         </table>
<table border="1" cellpadding="6">
        <caption><h2>Good Clients (cut)</h2></caption>
        
        	<tr>
            	<th>User ID</th>
            	<th>Bill Gen date</th>
            	<th>Bill Pay date</th>
            	<th>Amount paid</th>
        	</tr>
        	<c:forEach var="good" items="${goodCli}">
        <tr style="text-align:center">
        	<td><c:out value="${good.id}" /></td>
        	<td><c:out value="${good.bill_response_date}" /></td>
        	<td><c:out value="${good.payment_date}" /></td>
        	<td><c:out value="${good.amount_paid}" /></td>
         </c:forEach>
         </table>
         </br>
         </br>
       </table>
       
	</div>
	</div>

</body>
</html>