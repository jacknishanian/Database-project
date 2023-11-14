<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Registration</title></head>
<body>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		
		
		<form action="register" enctype="multipart/form-data" method="POST">
			<table border="1" cellpadding="5">
				<tr>
					<th>Email: </th>
					<td align="center" colspan="3">
						<input type="text" name="email" size="45"  value="example@gmail.com" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>First Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="firstName" size="45" value="FirstName" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Last Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="lastName" size="45" value="LastName" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Password: </th>
					<td align="center" colspan="3"> 
						<input type="password" name="password" size="45" value="password" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Password Confirmation: </th>
					<td align="center" colspan="3">
						<input type="password" name="confirmation" size="45" value="password" onfocus="this.value=''">
					</td>
				
				</tr>
				<tr>
					<th>address: </th>
					<td align="center" colspan="3">
						<input type="text" name="address" size="45"  value="1234 st name, city, state" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Phone Number: </th>
					<td align="center" colspan="3">
						<input type="text" name="phone_num" size="45"  value="(xxx)-xxx-xxxx" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Credit card Number: </th>
					<td align="center" colspan="3">
						<input type="text" name="card_num" size="45"  value="xxxx-xxxx-xxxx-xxxx" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Credit card exp date: </th>
					<td align="center" colspan="3">
						<input type="text" name="card_date" size="45"  value="xx/xx" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Credit card CVC: </th>
					<td align="center" colspan="3">
						<input type="text" name="card_cvc" size="45"  value="xxx" onfocus="this.value=''">
					</td>
				</tr>
				
				
				
				
				<tr>
					<th>Tree size: </th>
					<td align="center" colspan="3">
						<input type="text" name="size" size="45"  value="xxx" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Tree height: </th>
					<td align="center" colspan="3">
						<input type="text" name="height" size="45"  value="xxx" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Tree location: </th>
					<td align="center" colspan="3">
						<input type="text" name="location" size="45"  value="xxx" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Tree distance from house: </th>
					<td align="center" colspan="3">
						<input type="text" name="house_dist" size="45"  value="xxx" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Picture 1: </th>
					<td align="center" colspan="3">
						<input type="file" name="tree_pic1" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Picture 2: </th>
					<td align="center" colspan="3">
						<input type="file" name="tree_pic2" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Picture 3: </th>
					<td align="center" colspan="3">
						<input type="file" name="tree_pic3" onfocus="this.value=''">
					</td>
				</tr>
				
				
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Register"/>
					</td>
				</tr>
			</table>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	</div>
</body>