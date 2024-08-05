<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Module_4_Q7.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Student List</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Mobile</th>
                    <th>Gender</th>
                    <th>Password</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Student> students = (List<Student>) request.getAttribute("students");
                    for (Student student : students) {
                %>
                <tr>
                    <td><%= student.getId() %></td>
                    <td><%= student.getFname() %></td>
                    <td><%= student.getLname() %></td>
                    <td><%= student.getEmail() %></td>
                    <td><%= student.getMobile() %></td>
                    <td><%= student.getGender() %></td>
                    <td><%= student.getPassword() %></td>
                    <td>
                        <a href="StudentServlet?action=EDIT&id=<%= student.getId() %>" class="btn btn-warning">Edit</a>
                        <a href="StudentServlet?action=DELETE&id=<%= student.getId() %>" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
