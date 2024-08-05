<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Module_4_Q7.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Edit Student</h2>
        <form action="StudentServlet" method="post">
            <input type="hidden" name="action" value="UPDATE">
            <input type="hidden" name="id" value="<%= ((Student) request.getAttribute("student")).getId() %>">
            <div class="form-group">
                <label for="fname">First Name:</label>
                <input type="text" class="form-control" id="fname" name="fname" value="<%= ((Student) request.getAttribute("student")).getFname() %>" required>
            </div>
            <div class="form-group">
                <label for="lname">Last Name:</label>
                <input type="text" class="form-control" id="lname" name="lname" value="<%= ((Student) request.getAttribute("student")).getLname() %>" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="<%= ((Student) request.getAttribute("student")).getEmail() %>" required>
            </div>
            <div class="form-group">
                <label for="mobile">Mobile:</label>
                <input type="text" class="form-control" id="mobile" name="mobile" value="<%= ((Student) request.getAttribute("student")).getMobile() %>" required>
            </div>
            <div class="form-group">
                <label for="gender">Gender:</label>
                <select class="form-control" id="gender" name="gender" required>
                    <option value="Male" <%= ((Student) request.getAttribute("student")).getGender().equals("Male") ? "selected" : "" %>>Male</option>
                    <option value="Female" <%= ((Student) request.getAttribute("student")).getGender().equals("Female") ? "selected" : "" %>>Female</option>
                </select>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" value="<%= ((Student) request.getAttribute("student")).getPassword() %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </div>
</body>
</html>
