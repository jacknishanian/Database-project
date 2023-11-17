<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Response to Quote offer</title></head>
<body>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		
		
		<form action="response2" enctype="multipart/form-data" method="POST">
			<table border="1" cellpadding="5">

				<tr>
					<th>Bill Response Note: </th>
					<td align="center" colspan="3">
						<input type="text" name="bill_response_note" size="45"  value="xxx" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Bill Response Date: </th>
					<td align="center" colspan="3">
						<input type="text" name="bill_response_date" size="45"  value="xxx" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Dispute Note: </th>
					<td align="center" colspan="3">
						<input type="text" name="dispute_note" size="45"  value="xxx" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Date of dispute: </th>
					<td align="center" colspan="3">
						<input type="text" name="dispute_date" size="45"  value="xxx" onfocus="this.value=''">
					</td>
				</tr>
				
				<tr>
				<tr>
					<td align="center" colspan="5">
						<input type="hidden" name="userID" value="${user.email}">
						<input type="submit" value="Send Response"/>
					</td>
				</tr>
			</table>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	</div>
</body>