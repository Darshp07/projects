<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>

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

		<div class="row mt-5">


			<div class="col-5 card p-5 shadow-lg m-auto">

				<h3 class="text-center text-success">Registration Form</h3>

				<%
				String msg = (String) request.getAttribute("msg");
				if (msg != null) {
				%>
				<div class="alert alert-success alert-dismissible fade show"
					role="alert">
					<%=msg%>
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
				<%
				}
				%>

				<%
				String error = (String) request.getAttribute("error");
				if (error != null) {
				%>
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					<%=error%>
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
				<%
				}
				%>


				<form action="register" method="post">

					<div class="form-group mb-3">
						<label for="uname" class="form-label">User Name</label> <input
							type="text" class="form-control" id="uname" name="uname"
							onkeyup="validateForm();"> <span id="unameError"
							class="text-danger"></span>
					</div>

					<div class="form-group mb-3">
						<label for="email" class="form-label">Email Address</label> <input
							type="email" class="form-control" id="email" name="email"
							onkeyup="validateForm();"> <span id="emailError"
							class="text-danger"></span>
					</div>

					<div class="form-group mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control" id="password"
							name="password" onkeyup="validateForm();"> <span
							id="passError" class="text-danger"></span>
					</div>

					<div class="form-group mb-3">
						<label for="cpassword" class="form-label">Confirm Password</label>
						<input type="password" class="form-control" id="cpassword"
							name="cpassword" onkeyup="validateForm();"> <span
							id="cPassError" class="text-danger"></span>
					</div>
					<div class="d-flex">
						<input type="submit" class="btn btn-success me-2"
							id="submitButton" value="Submit"> <input type="reset"
							class="btn btn-primary" id="resetButton" value="Reset">
							 <a href="users" class="btn btn-warning ms-2">View Users</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="validation.js"></script>
</html>