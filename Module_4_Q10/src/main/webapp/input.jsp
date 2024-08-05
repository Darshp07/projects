<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
	function validateForm() {
		var fname = document.getElementById("fname").value;
		var lname = document.getElementById("lname").value;
		var email = document.getElementById("email").value;
		var mobile = document.getElementById("mobile").value;
		var gender = document.getElementById("gender").value;
		var password = document.getElementById("password").value;

		var fnameError = document.getElementById("fnameError");
		var lnameError = document.getElementById("lnameError");
		var emailError = document.getElementById("emailError");
		var mobileError = document.getElementById("mobileError");
		var genderError = document.getElementById("genderError");
		var passwordError = document.getElementById("passError");

		var nameExp = /^[a-zA-Z]+$/;
		var emailExp = /^[a-zA-Z0-9]+@[a-zA-Z]+\.[a-z]{1,4}$/;
		var mobileExp = /^[0-9]{10}$/;
		var passExp = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@#$%^&+=]).{8,}$/;

		// First name validation
		if (fname == "" || fname == null) {
			fnameError.innerHTML = "First name should not be blank";
		} else if (!nameExp.test(fname)) {
			fnameError.innerHTML = "Only alphabets (a-z, A-Z) are allowed";
		} else {
			fnameError.innerHTML = "";
		}

		// Last name validation
		if (lname == "" || lname == null) {
			lnameError.innerHTML = "Last name should not be blank";
		} else if (!nameExp.test(lname)) {
			lnameError.innerHTML = "Only alphabets (a-z, A-Z) are allowed";
		} else {
			lnameError.innerHTML = "";
		}

		// email validation
		if (email == "" || email == null) {
			emailError.innerHTML = "Email should not be blank";
		} else if (!emailExp.test(email)) {
			emailError.innerHTML = "Invalid email address";
		} else {
			emailError.innerHTML = "";
		}

		// password validation
		if (password == "" || password == null) {
			passwordError.innerHTML = "Password should not be blank";
		} else if (!passExp.test(password)) {
			passwordError.innerHTML = "Invalid password. Must contain at least 8 characters, including upper/lowercase, digit, and special character.";
		} else {
			passwordError.innerHTML = "";
		}

		// mobile validation
		if (mobile == "" || mobile == null) {
			mobileError.innerHTML = "Mobile number should not be blank";
		} else if (!mobileExp.test(mobile)) {
			mobileError.innerHTML = "Mobile number should be 10 digits";
		} else {
			mobileError.innerHTML = "";
		}

		// gender validation (optional, not handled in original code)
		if (gender == "" || gender == null) {
			genderError.innerHTML = "Please select a gender";
		} else {
			genderError.innerHTML = "";
		}
	}
</script>
</head>
<body>
	<div class="row mt-5">
		<div class="col-5 card p-5 shadow-lg m-auto">
			<h2 class="text-center text-success">Student Registration</h2>
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
			<form action="UserServlet" method="post">
				<div class="form-group">
					&#128102; <label for="fname">First Name:</label> <input type="text"
						class="form-control" id="fname" placeholder="Enter first name"
						name="fname" onkeyup="validateForm();"
						value="<%if (request.getParameter("fnameErr") != null) {%><%=request.getParameter("fnameErr")%><%}%>">
					<span id="fnameError" class="text-danger">${fnameErr}</span>
				</div>
				<div class="form-group">
					&#128102; <label for="lname">Last Name:</label> <input type="text"
						class="form-control" id="lname" placeholder="Enter last name"
						name="lname" onkeyup="validateForm();"
						value="<%if (request.getParameter("lnameErr") != null) {%><%=request.getParameter("lnameErr")%><%}%>">
					<span id="lnameError" class="text-danger">${lnameErr}</span>
				</div>
				<div class="form-group">
					&#128231; <label for="email">Email:</label> <input type="email"
						class="form-control" id="email" placeholder="Enter email"
						name="email" onkeyup="validateForm();"
						value="<%if (request.getParameter("emailErr") != null) {%><%=request.getParameter("emailErr")%><%}%>">
					<span id="emailError" class="text-danger">${emailErr}</span>
				</div>
				<div class="form-group">
					&#128241; <label for="mobile">Mobile:</label> <input type="text"
						class="form-control" id="mobile" placeholder="Enter mobile number"
						name="mobile" onkeyup="validateForm();"
						value="<%if (request.getParameter("mobileErr") != null) {%><%=request.getParameter("mobileErr")%><%}%>">
					<span id="mobileError" class="text-danger">${mobileErr}</span>
				</div>
				<div class="form-group">
					&#9893; <label for="gender">Gender:</label> <select
						class="form-control" id="gender" name="gender"
						onchange="validateForm();">
						<option value="">Select Gender</option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select> <span id="genderError" class="text-danger"></span>
				</div>
				<div class="form-group">
					&#128273; <label for="password">Password:</label> <input
						type="password" class="form-control" id="password"
						placeholder="Enter password" name="password"
						onkeyup="validateForm();"
						value="<%if (request.getParameter("passwordErr") != null) {%><%=request.getParameter("passwordErr")%><%}%>">
					<span id="passError" class="text-danger">${passwordErr}</span>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
				<button type="reset" class="btn btn-warning" value="reset">Reset</button>
				
				
			</form>

		</div>
	</div>
</body>
</html>
