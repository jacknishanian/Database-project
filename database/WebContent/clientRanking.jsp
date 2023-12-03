<!DOCTYPE html>
<html>
<head>
<div align="center">
    <title>Client Rankings</title>
    <!-- Add any CSS or JS links here -->
    <style>
/* css style for button */
.button {
  display: inline-block;
  padding: 10px 20px;
  font-size: 14px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #E1745C;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button:hover {background-color: #E1745C}

.button:active {
  background-color: #E1745C;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
</style>
</head>
<body>

<h1>Client Rankings</h1>

<!-- Easy Clients Table -->
<h2>Easy Clients</h2>
<table border="1">
    <tr>
        <th>Client ID</th>
        <th>Client Name</th>
        <th>Other Details</th>
    </tr>
    <!-- Data rows will be inserted here -->
</table>

<!-- Prospective Clients Table -->
<h2>Prospective Clients</h2>
<table border="1">
    <tr>
        <th>Client ID</th>
        <th>Client Name</th>
        <th>Other Details</th>
    </tr>
    <!-- Data rows will be inserted here -->
</table>

<!-- Bad Clients Table -->
<h2>Bad Clients</h2>

 <a href="OverDueBills.jsp" class="button">Over Due Bills</a>
</br>
</br>
<table border="1">
    <tr>
        <th>Client ID</th>
        <th>Client Name</th>
        <th>Other Details</th>
    </tr>
    <!-- Data rows will be inserted here -->
</table>

<!-- Good Clients Table -->
<h2>Good Clients</h2>
<table border="1">
    <tr>
        <th>Client ID</th>
        <th>Client Name</th>
        <th>Other Details</th>
    </tr>
    <!-- Data rows will be inserted here -->
</table>
</div>
</body>
</html>
