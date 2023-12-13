<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Root Cut page</title>
</head>
<body>

<div align = "center">

	<a href="login.jsp"target ="_self" > logout</a><br><br> 

<h1>Cut Page</h1>

					<td align="center">
						<form action = "root">
							<button type="submit" type="button" class="btn btn-primary shadow btn-lg">Back to Root</button>
						</form>
						<br>
						<form action = "quotePage">
							<button type="submit" type="button" class="btn btn-warning shadow">See Quotes page</button>
						</form>
					</td>
<br><br>
    <div align="center">
        <table class="table caption-top table-striped"  border="1" cellpadding="6">
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
       
       </br>
         </br>
         </br>
         </br>
                       
    <table class="table caption-top table-striped"  border="1" cellpadding="6">
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

       </table>
       
       </br>
         </br>
                  <table class="table caption-top table-striped"  border="1" cellpadding="6">
        <caption><h2>BadClients (cut)</h2></caption>
        
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

         </br>
         </br>
         </br>
       <table class="table caption-top table-striped"  border="1" cellpadding="6">
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
         </br>
         </br>
         </br>
         </br>

		<table class="table caption-top table-striped"  border="1" cellpadding="6">
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