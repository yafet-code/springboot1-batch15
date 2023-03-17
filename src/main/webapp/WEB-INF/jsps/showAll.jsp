<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 <title>All Employees Data</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
<nav class="navbar navbar-expand-sm bg-light">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="FindAllEmployeeServlet">show all</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">LOGOUT</a>
    </li>
  </ul>
</nav>
${msg}
  <h2>Records of All employees</h2>
            
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>SALARY</th>
         <th>EMAIL</th>
        <th>PASSWORD</th>
         <th>ACTION</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${listOfEmployee}" var="employee">
      <tr>
       <td>${employee.employeeId}</td>
        <td>${employee.employeeName}</td>
        <td>${employee.salary}</td>
        <td>${employee.emailId}</td>
        <td>${employee.password}</td>
        
        <td>  <a href="deleteEmployee?employeeId=${employee.employeeId}"> <button type="button" class="btn btn-danger">D</button></a> </td>
        
         <td>  <a href="showEditForm?employeeId=${employee.employeeId}"> <button type="button" class="btn btn-danger">E</button></a> </td>
        
        
      </tr>
      </c:forEach>
      
    </tbody>
  </table>
</div>


</body>
</html>