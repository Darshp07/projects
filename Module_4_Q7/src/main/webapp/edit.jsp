<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.bean.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
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

		// gender validation
		if (gender == "" || gender == null) {
			genderError.innerHTML = "Please select a gender";
		} else {
			genderError.innerHTML = "";
		}
	}
</script>
</head>
<body>

	<%
	Student std = (Student) request.getAttribute("Student");
	%>
	<div class="row mt-5">
		<div class="col-5 card p-5 shadow-lg m-auto">
			<h2 class="text-center text-success">Edit Student</h2>
			<form action="UpdateServlet" method="post">

				<input type="hidden" name="id" value="<%=std.getId()%>">

				<div class="form-group">
					<label for="fname">First Name:</label> <input type="text"
						class="form-control" id="fname" name="fname"
						onkeyup="validateForm();" value="<%=std.getFname()%>"><span
						id="fnameError" class="text-danger"></span>
				</div>
				<div class="form-group">
					<label for="lname">Last Name:</label> <input type="text"
						class="form-control" id="lname" name="lname"
						onkeyup="validateForm();" value="<%=std.getLname()%>" required><span
						id="lnameError" class="text-danger"></span>
				</div>
				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" id="email" name="email"
						onkeyup="validateForm();" value="<%=std.getEmail()%>" required>
					<span id="emailError" class="text-danger"></span>
				</div>
				<div class="form-group">
					<label for="mobile">Mobile:</label> <input type="text"
						class="form-control" id="mobile" name="mobile"
						onkeyup="validateForm();" value="<%=std.getMobile()%>" required><span
						id="mobileError" class="text-danger"></span>
				</div>
				<div class="form-group">
					<label for="gender">Gender:</label> <select class="form-control"
						id="gender" name="gender" required>
						<option value="Male"
							<%=std.getGender().equals("Male") ? "selected" : ""%>>Male</option>
						<option value="Female"
							<%=std.getGender().equals("Female") ? "selected" : ""%>>Female</option>
					</select>
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input type="password"
						class="form-control" id="password" name="password"
						onkeyup="validateForm();" value="<%=std.getPassword()%>" required><span
						id="passError" class="text-danger"></span>
				</div>
				<button type="submit" class="btn btn-primary">Update</button>
			</form>
		</div>
	</div>
</body>
</html>
