<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">

<nav class="navbar navbar-expand-sm bg-light">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="login">LOGIN</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="showEmployees">Show Employees </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="employeeRegistration">Employee Registration</a>
    </li>
  </ul>
</nav>



${msg}
  <h2>registration form</h2>
  <form action="registration" method="post">
   
     <div class="form-group">
      <label>employeeName:</label>
      <input type="text" class="form-control"  name="employeeName">
    </div>
     <div class="form-group">
      <label>emailId:</label>
      <input type="email" class="form-control"  name="emailId">
    </div>
  
    <div class="form-group">
      <label>password:</label>
      <input type="password" class="form-control"  name="password">
    </div>
    <div class="form-group">
      <label>salary:</label>
      <input type="number" class="form-control"  name="salary">
    </div>
    
    <button type="submit" class="btn btn-primary">Register</button>
    
   
  </form>
</div>

</body>
</html>