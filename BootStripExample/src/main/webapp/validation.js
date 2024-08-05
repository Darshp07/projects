function validateForm() {

		var name = document.getElementById("uname").value;
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		var cPassword = document.getElementById("cpassword").value;

		var nameError = document.getElementById("unameError");
		var emailError = document.getElementById("emailError");
		var passwordError = document.getElementById("passError");
		var cPasswordError = document.getElementById("cPassError");

		var btnSubmit = document.getElementById("submitButton");

		var nameExp = /^[a-zA-Z]+$/
		var emailExp = /^[a-zA-Z0-9]+@[a-zA-Z]+\.[a-z]{1,4}$/

		var isValid = true;

		// name validation 
		if (name == "" || name == null) {
			// show error
			nameError.innerHTML = "Username should not be blank";
			isValid = false;
		} else if (!nameExp.test(name)) {
			nameError.innerHTML = "Only alphabets (a-z, A-Z) are allowed";
			isValid = false;
		} else {
			nameError.innerHTML = "";
		}

		// email validation
		if (email == "" || email == null) {
			// show error
			emailError.innerHTML = "Email should not be blank";
			isValid = false;
		} else if (!emailExp.test(email)) {
			emailError.innerHTML = "Invalid email address";
			isValid = false;
		} else {
			emailError.innerHTML = "";
		}

		// password validation
		if (password == "" || password == null) {
			// show error
			passwordError.innerHTML = "Password should not be blank";
			isValid = false;
		} else {
			passwordError.innerHTML = "";
		}

		// confirm password validation 
		if (cPassword == "" || cPassword == null) {
			// show error
			cPasswordError.innerHTML = "Password should not be blank";
			isValid = false;
		} else if (cPassword != password) {
			cPasswordError.innerHTML = "Password mismatch";
			isValid = false;
		} else {
			cPasswordError.innerHTML = "";
		}

		btnSubmit.disabled = !isValid;

	}