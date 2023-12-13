<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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

					<td align="center">
						<form action = "cutPage">
							<button type="submit" type="button" class="btn btn-warning shadow btn-lg">See Cut page</button>
						</form>
						<br>
						<form action = "quotePage">
							<button type="submit" type="button" class="btn btn-warning shadow btn-lg">See Quotes page</button>
						</form>
					</td>
			
         </br>
         </br>
       </table>
       
	</div>
	</div>

</body>
</html>