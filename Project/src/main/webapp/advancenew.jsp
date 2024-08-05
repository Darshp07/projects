
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Form</title>
<link rel="stylesheet" href="regestrationfrom.css">
</head>

<body>

	<form action="Userinput" method="post">
		<table>
			<tr>
				<td><label for="firstname">First Name</label></td>
				<td><input type="text" id="firstname" name="firstname" required
					onblur="Fname();"><small id="Errorfname"
					style="color: green;"></small></td>

			</tr>
			<tr>
				<td><label for="lastname">Last Name</label></td>
				<td><input type="text" id="lastname" name="lastname" required
					onblur="Lname();"> <small id="ErrorLname"
					style="color: green;"></small></td>
			</tr>
			<tr>
				<td><label for="email">Email ID</label></td>
				<td><input type="email" id="email" name="email" required
					onblur="validationemail();"> <small id="ErrorEmail"
					style="color: green;"></small></td>
			</tr>
			<tr>
				<td><label for="mobile">Mobile Number</label></td>
				<td><input type="text" id="mobile" name="mobile" required
					onblur="validnumber();"> <small id="Errornumber"
					style="color: green;"></small></td>
			</tr>
			<tr>
                 <td><label for="DOB">DOB</label></td>
                 <td> <input type="date" id="DOB" name ="dob"></td>
                 
                 
            
			</tr>
			<tr>
				<td><label for="address">Address</label></td>
				<td><textarea id="address" name="address" rows="4" required
						onblur="validadd();"></textarea> <small id="Erroradd"
					style="color: green;"></small></td>
			</tr>
			<tr>
				<td><label>Gender</label></td>
				<td><input type="radio" id="male" name="gender" value="male"
					required> <label for="male">Male</label> <input
					type="radio" id="female" name="gender" value="female" required>
					<label for="female">Female</label> <small class="error"
					id="genderError" style="color: green;"></small></td>
			</tr>
			<tr>
				<td><label>Hobbies</label></td>
				<td><input type="checkbox" id="cricket" name="hobbies"
					value="cricket"> <label for="cricket">Cricket</label><br>
					<input type="checkbox" id="reading" name="hobbies" value="reading">
					<label for="reading">Reading</label><br> <input
					type="checkbox" id="gyming" name="hobbies" value="gyming">
					<label for="gyming">gymming</label><br> <input type="checkbox"
					id="traveling" name="hobbies" value="traveling"> <label
					for="traveling">Traveling</label> <small class="error"
					id="hobbiesError" style="color: green;"></small></td>
			</tr>
			<tr>
				<td><label for="education">Education</label></td>
				<td><select id="education" name="education" required>
						<option>---select----</option>
						<option value="secondryschool">10th</option>
						<option value="highschool">12th</option>
						<option value="bachelors">Bachelor's</option>
						<option value="masters">Master's</option>
						<option value="phd">PhD</option>
						<option value="other">other</option>
				</select></td>
			</tr>
			<tr>
				<td><label for="Resume">Resume</label></td>
				<td><input type="file" id="file" name="Resume"required">
					<small class="error" id="resumeError" style="color: green;"></small></td>
			</tr>
			<tr>
				<td><label for="password">Password</label></td>
				<td><input type="password" id="password" name="password"
					autocomplete="password" required onblur="validationpass();">
					<span id="Errorpass" style="color: red;"></span></td>
			</tr>
			<tr>
				<td><label for="confirm_password">Confirm Password</label></td>
				<td><input type="password" id="confirm_password"
					autocomplete="confirm_password" name="confirm_password" required
					onblur="validationpass();"> <span id="Errorconfirmpass"
					style="color: red;"></span></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="action" value="insert" id="submit"></td>
			</tr>
		</table>
	</form>
	
</body>
<script type="text/javascript" src="regestrationfrom.js"></script>
</html>

