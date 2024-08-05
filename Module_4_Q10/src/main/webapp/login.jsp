<%@page import="java.util.ArrayList"%>

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

		<div class="row mt-5">
			<div class="col-5 card p-5 shadow-lg m-auto">

				<h3 class="text-center text-success">Log-in Form</h3>

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

				
				<form action="login" method="post">

					<div class="form-group mt-3 ">
				 &#128231; <label for="email" class="form-label">Email Address</label> <input
							type="email" class="form-control" id="email" name="email"
							value="<%if (request.getParameter("email") != null) {%><%=request.getParameter("email")%><%}%>">
						<span id="emailError" class="text-danger">${emailErr}</span>
					</div>

					<div class="form-group mb-3">
					&#128273;	<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control" id="password"
							name="password"
							value="<%if (request.getParameter("password") != null) {%><%=request.getParameter("password")%><%}%>">
						<span id="passError" class="text-danger">${passwordErr}</span>
					</div>

					<p>
							&#128515;  <a href="newaccount">create a new account</a>
					<p>
					<div class="d-flex">
						<input type="submit" class="btn btn-success mt-4 w-100"
							id="submitButton" value="lOGIN">
					</div>

				</form>
			</div>
		</div>
	
</body>
<script type="text/javascript" src="validation.js"></script>
</html>