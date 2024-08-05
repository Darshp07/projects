<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration from</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>


<script type="text/javascript">
	function validation() {
		var name = document.getElementById("uname").value;
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		var cpassword = document.getElementById("confirPassword3").value;

		var nameError = document.getElementById("unameError");
		var emailError = document.getElementById("emailError");
		var passError = document.getElementById("passError");
		var cpassError = document.getElementById("cPassError");

		var btn = document.getElementById("subButton");

		var isvalid = true;

		// **************** regex ******************

		var nameexp = /^[A-Za-z]+$/;
		var emailexp = /^[A-Za-z0-9]+@[A-Za-z]+\.[a-z]{2,4}$/;

		//***************name validation *****************
		if (name == null || name == "") {
			nameError.innerHTML = "Please enter your name";
			isvalid = false;
		} else if (!nameexp.test(name)) {
			nameError.innerHTML = "Invalid name";
			isvalid = false;
		} else {
			nameError.innerHTML = "";
		}

		//***************Email validation *****************
		if (email == null || email == "") {
			emailError.innerHTML = "Please enter your email";
			isvalid = false;
		} else if (!emailexp.test(email)) {
			emailError.innerHTML = "Invalid Email";
			isvalid = false;
		} else {
			emailError.innerHTML = "";
		}

		//***************password validation *****************
		if (password == null || password == "") {
			passError.innerHTML = "Please enter your password";
			isvalid = false;
		} else {
			passError.innerHTML = "";
		}

		btn.disabled = !isvalid;
	}
</script>
</head>
<body>

	<%
	HashMap<String, String> map = (HashMap<String, String>) request.getAttribute("data");
	if (map != null) {
	%>

	<div class="container">
		<nav class="navbar  navbar-dark bg-dark dropdown style="background-color:#e3f2fd">
			<div class="container-fluid">
				<button class="btn btn-secondary dropdown-toggle" type="button"
					id="dropdownMenu2" data-bs-toggle="dropdown" aria-expanded="false">
					Menu</button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
					<li><button class="dropdown-item" type="button">
							<a href="action">action</a>
						</button></li>
					<li><button class="dropdown-item" type="button">Another
							action</button></li>
					<li><button class="dropdown-item" type="button">Something
							else here</button></li>
				</ul>

				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-success " type="submit">Search</button>
				</form>

			</div>
		</nav>
		<div class="row mt-4">
			<div class="col-5 card p-5 shadow-lg m-auto">
				<h2 class="card-title text-success" align="center">Registration
					from</h2>

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


				<form action="update" method="post">
 

					<input type="hidden" value="<%=map.get("id")%>" name="id">

					<div class="form-group mb-3">
						<label for="uname" class="form-label">Name</label> <input
							type="text" class="form-control" id="uname" name="uname"
							onkeyup="validateForm();" value="<%=map.get("name")%>"> <span
							id="unameError" class="text-danger"></span>
					</div>



					<div class="row mb-3">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
						<input type="email" class="form-control" id="email" name="email"
							onblur="validation();" value="<%=map.get("email")%>"><span
							id="emailError" class="text-danger"></span>
					</div>
					<div class="row mb-3">
						<label for="inputPassword3" class="col-sm-3 col-form-label">Password</label>
						<input type="password" class="form-control" id="password"
							name="password" onblur="validation();"
							value="<%=map.get("password")%>"> <span id="passError"
							class="text-success"></span>
					</div>

					<button type="submit" class="btn btn-success m-auto" id="subButton">
						</a>update Student
					</button>


				</form>


			</div>

			<%
			} else {
				
		//		response.sendRedirect("update.jsp");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
				dispatcher.forward(request, response);
			
			%>


			<%
			}
			%>
		
</body>
</html>