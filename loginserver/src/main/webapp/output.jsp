
<%@page import="com.bean.user"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body>

	<%
	ArrayList<user> users = (ArrayList<user>) request.getAttribute("data");
	%>
	<div class="container">

		<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Navbar</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Dropdown </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
							</ul></li>
						<li class="nav-item"><a class="nav-link disabled" href="#"
							tabindex="-1" aria-disabled="true">Disabled</a></li>
					</ul>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</nav>



		<div class="col-7 card card p-5 shadow-lg m-auto mt-4">

			<h3 class="text-center text-success">User Details</h3>

			<table class="table table-striped table-dark">
				<thead>
					<tr>
						<th style="width: 10%">ID</th>
						<th style="width: 30%">NAME</th>
						<th style="width: 40%">EMAIL</th>
						<th style="width: 10%">delete</th>
						<th style="width: 10%">update</th>
					</tr>
				</thead>
				<%
				for (user us : users) {
				%>

				<tbody>

					<tr>
						<td><%=us.getId()%></td>
						<td><%=us.getName()%></td>
						<td><%=us.getEmail()%></td>
						<td><a href="delete?id=<%=us.getId()%>"
							class="btn btn-danger">Delete</a></td>
						<td><a href="update?id=<%=us.getId()%>"
							class="btn btn-primary">Update</a></td>
					</tr>
				</tbody>

				<%
				}
				%>

			</table>

		</div>

	</div>



</body>
<script type="text/javascript" src="validation.js"></script>
</html>