<!DOCTYPE html>
<html>
<head>
<meta charset=" ">
<title>Owner page</title>
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
<body>

<div align="center">
	<h1>Welcome! You have been logged in as Owner</h1>
	<a href="login.jsp" target="_self">Logout</a><br><br> 
    <div align="center">
        <table border="1" cellpadding="6">
            <!-- Table content -->
        </table>
        </br>
        </br>
        </br>
        <!-- where i add button -->
        <a href="davesClientStats.jsp" class="button">Dave's Client Statistics</a>
	</div>
</div>

</body>
</html>
