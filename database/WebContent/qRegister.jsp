<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Get a Quote</title></head>
<body>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		
		
		<form action="qRegister" enctype="multipart/form-data" method="POST">
			<table border="1" cellpadding="5">

				
				
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
					<th>Note: </th>
					<td align="center" colspan="3">
						<input type="text" name="request_note" size="45"  value="xxx" onfocus="this.value=''">
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