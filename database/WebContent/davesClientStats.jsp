<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Client Statistics</title>
    <style>
/* button style */
.button {
  display: inline-block;
  padding: 10px 20px;
  font-size: 14px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #4CAF50;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
</style>
</head>
<div align="center">
<body>

    <h2>Client Statistics Table</h2>
    
    <a href="clientRanking.jsp" class="button">Client's Ranking</a>
    </br>
    </br>
    <table border="1">
        <thead>
            <tr>
                <th>Client Name</th>
                <th>Total Number of Trees</th>
                <th>Total Due Amount</th>
                <th>Total Paid Amount</th>
                <th>Date Work Done(Only cut tree included)</th>
            </tr>
        </thead>
        <tbody>
            <!-- one client info -->
            <tr>
                <td>Client 1 Name</td>
                <td>Number of Trees</td>
                <td>Due Amount</td>
                <td>Paid Amount</td>
                <td>Work Done Date</td>
            </tr>
            <!-- more client data -->
        </tbody>
    </table>
    
    <div align="center">
</body>

</html>
