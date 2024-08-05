<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.bean.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="row mt-5">
		<div class="col-12 card p-5 shadow-lg m-auto">
			<h2 class="text-center text-success">Student List</h2>
			<table  class="table table-striped table-dark">
				<thead>
					<tr>
						<th style="width: 5%">ID</th>
						<th style="width: 12%">First Name</th>
						<th style="width: 12%">Last Name</th>
						<th style="width: 25%">Email</th>
						<th style="width: 10%">Mobile</th>
						<th style="width: 10%">Gender</th>
						<th style="width: 15%">Password</th>
						<th style="width: 25%">Actions</th>
					</tr>
				</thead>
				<tbody>
					<%
					ArrayList<Student> studentlist = (ArrayList<Student>) request.getAttribute("data");
					for (Student student : studentlist) {
					%>
					<tr>
						<td><%=student.getId()%></td>
						<td><%=student.getFname()%></td>
						<td><%=student.getLname()%></td>
						<td><%=student.getEmail()%></td>
						<td><%=student.getMobile()%></td>
						<td><%=student.getGender()%></td>
						<td><%=student.getPassword()%></td>
						<td><a
							href="EDIT?id=<%=student.getId()%>"
							class="btn btn-warning">Edit</a> <a
							href="DELETE?id=<%=student.getId()%>"
							class="btn btn-danger">Delete</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
