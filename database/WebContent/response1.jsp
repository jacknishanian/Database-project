<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Respond to quote</title></head>
<body>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		
		
		<form action="response1" enctype="multipart/form-data" method="POST">
			<table border="1" cellpadding="5">

				<tr>
					<th>Terms: </th>
					<td align="center" colspan="3">
						<input type="text" name="terms_agreed" size="45"  value="xxx" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Order of Work Status: </th>
					<td align="center" colspan="3">
						<input type="text" name="oow_status" size="45"  value="xxx" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Amount due: </th>
					<td align="center" colspan="3">
						<input type="text" name="amount_due" size="45"  value="xxx" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Bill Status: </th>
					<td align="center" colspan="3">
						<input type="text" name="bill_status" size="45"  value="xxx" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Bill Note: </th>
					<td align="center" colspan="3">
						<input type="text" name="bill_note" size="45"  value="xxx" onfocus="this.value=''">
					</td>
				</tr>
								<tr>
					<th>Quote Note: </th>
					<td align="center" colspan="3">
						<input type="text" name="quote_response_note" size="45"  value="xxx" onfocus="this.value=''">
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