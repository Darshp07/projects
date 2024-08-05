let btnSubmit = document.getElementById("btnSubmit");

btnSubmit.addEventListener('click', function(event) {
	//alert("Button Clicked");

	var isValid = true;

	// Name Validation
	var fName = document.getElementById("name").value;

	var namePattern = /^[A-Za-z]+$/;

	if (fName == "") {
		isValid = false;
		document.getElementById("nameError").innerText = "Please enter name";
		document.getElementById('nameError').style.display = "block";
	} else if (!namePattern.test(fName)) {
		isValid = false;
		document.getElementById("nameError").innerText = "Only alphabets are allowed";
		document.getElementById('nameError').style.display = "block";
	} else {
		document.getElementById('nameError').style.display = "none";
	}

	// Gender validation
	const gender = document.querySelector('input[name="gender"]:checked');
	if (!gender) {
		
		valid = false;
		document.getElementById('genderError').innerText = "Gender is required.";
		document.getElementById('genderError').style.display = "block";
	} else {
		document.getElementById('genderError').style.display = "none";
	}

});

// Prevent form submission if validation fails
if (!valid) {
	event.preventDefault();
}