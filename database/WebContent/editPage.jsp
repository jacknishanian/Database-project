<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit quote</title>
</head>
<body>
	
<h1>Welcome! to the Quote Editor</h1>
<a href="ownerPage.jsp"target ="_self" > back</a><br><br> 
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Quotes</h2></caption>
         
         <tr>
                
                <th>Date of quote</th>
                <th>Time of quote</th>
                <th>Quote Note</th>
                <th>Quote Price</th>
                <th>Quote Response</th>
                
                <th>Workorder Terms</th>
                <th>Workorder Status</th>
                
                <th>Bill Amount</th>
                <th>Bill Status</th>
                
                <th>Tree Pictures</th>
            </tr>
            
            <tr style="text-align:center">
                    
                    <td><input type="text" name="quote_date" size="45" value="${user.quote_date}" /></td>
                    <td><input type="text" name="quote_time" size="45" value="${users.quote_time}" /></td>
                    <td><input type="text" name="quote_note" size="45" value="${client.quote_note}" /></td>
                    <td><input type="text" name="quote_price" size="45" value="${client.quote_price}" /></td>
                    <td><input type="text" name="quote_response" size="45" value="${client.quote_response}" /></td>
                    
                    <td><input type="text" name="work_order_terms" size="45" value="${client.work_order_terms}" /></td>
                    <td><input type="text" name="work_order_status" size="45" value="${client.work_order_status}" /></td>
                    
                    <td><input type="text" name="bill_amount" size="45" value="${client.bill_amount}" /></td>
                    <td><input type="text" name="bill_status" size="45" value="${client.bill_status}" /></td>
                    
         			<td>
                    	<img src="data:image/jpg;base64, ${client.img_1}" width="200" height="200">
                    	<img src="data:image/jpg;base64, ${client.img_2}" width="200" height="200">
                    	<img src="data:image/jpg;base64, ${client.img_3}" width="200" height="200">
                    </td>
         </table>
         <form action = "save">
         	<input type="submit" value="Save"/>
         </form>
	</div>
</body>
</html>