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
		var email = document.forms["studentForm"]["email"].value;
		var password = document.forms["studentForm"]["password"].value;
		var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
		var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
		if (!emailPattern.test(email)) {
			alert("Invalid email format");
			return false;
		}
		if (!passwordPattern.test(password)) {
			alert("Password must contain at least 8 characters, including uppercase, lowercase, number, and special character");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div class="row mt-5">


		<div class="col-5 card p-5 shadow-lg m-auto">
			<h2 class="text-center text-success">Student Registration</h2>
			<form name="studentForm" action="StudentServlet" method="post"
				onsubmit="return validateForm()">
				<input type="hidden" name="action" value="INSERT">
				<div class="form-group">
				&#128102;	<label for="fname">First Name:</label> <input type="text"
						class="form-control" id="fname" placeholder="Enter first name"
						name="fname" required>
				</div>
				<div class="form-group">
				&#128102;	<label for="lname">Last Name:</label> <input type="text"
						class="form-control" id="lname" placeholder="Enter last name"
						name="lname" required>
				</div>
				<div class="form-group">
				&#128231;	<label for="email">Email:</label> <input type="email"
						class="form-control" id="email" placeholder="Enter email"
						name="email" required>
				</div>
				<div class="form-group">
				&#128241;	<label for="mobile">Mobile:</label> <input type="text"
						class="form-control" id="mobile" placeholder="Enter mobile number"
						name="mobile" required>
				</div>
				<div class="form-group">
					&#9893;<label for="gender">Gender:</label> <select class="form-control"
						id="gender" name="gender" required>
						<option value="">Select Gender</option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</div>
				<div class="form-group">
				&#128273;	<label for="password">Password:</label> <input type="password"
						class="form-control" id="password" placeholder="Enter password"
						name="password" required>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>
