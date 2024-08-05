let btn = document.getElementById('submit');

btn.addEventListener('click', () => {

	let fname = document.getElementById('firstname').value;
	   var reg = /^[A-Za-z]+$/;
	   if (fname === "") {
	       document.getElementById('Errorfname').innerHTML = 'input your first name';
	   } 
	   else if (!reg.test(fname)) {
	       document.getElementById('Errorfname').innerHTML = 'input only alphabet';
	   } 
	   
	   else {
	       document.getElementById('Errorfname').innerHTML = '';
	   }
	   
	   let lname = document.getElementById('lastname').value;
	   	   	   var reg = /^[A-Za-z]+$/;
	   	   	   if (lname ==="") {
	   	   	       document.getElementById('ErrorLname').innerHTML = 'input your Last name';
	   	   	   } 
	   	   	   else if (!reg.test(lname)) {
	   	   	       document.getElementById('ErrorLname').innerHTML = 'input only alphabet';
	   	   	   } 
	   	   	   
	   	   	   else {
	   	   	       document.getElementById('ErrorLname').innerHTML = '';
	   	   	   }
			   
			   let Email = document.getElementById('email').value;
			   		
			   		var rag =/^[A-Za-z0-9.-_]+@[A-Za-z]+\.[A-Za-z]+$/;
			   		
			   		if (Email ==="") {
			   			       document.getElementById('ErrorEmail').innerHTML = 'input your Email id ';
			   			   } 
			   			   else if (!rag.test(Email)) {
			   			       document.getElementById('ErrorEmail').innerHTML = 'invalid email';
			   			   } 
			   			   
			   			   else {
			   			       document.getElementById('ErrorEmail').innerHTML = '';
			   			   }
						  
						   let Mnumber = document.getElementById('mobile').value;
						   		
						   		var rag =/^\d{10}$/;	
						   		if (Mnumber ==="") {
						   			       document.getElementById('Errornumber').innerHTML = 'input your Mobile number';
						   			   } 
						   			   else if (!rag.test(Mnumber)) {
						   			       document.getElementById('Errornumber').innerHTML = 'Must be input 10 digit';
						   			   } 
						   			   
						   			   else {
						   			       document.getElementById('Errornumber').innerHTML = '';
						   			   }				    
						   
			let add = document.getElementById('address').value;

						   	       if (add === "") {
						   	           document.getElementById('Erroradd').innerHTML = 'input your address';
						   	       } else {
						   	           document.getElementById('Erroradd').innerHTML = '';
						   	       }
								   
								   let pass = document.getElementById('password').value;
								   	let confirmpass = document.getElementById('confirm_password').value;
								   	var regx =  /^[A-Za-z\d!@#$%^&*]+$/;
								   	
								   	if(pass === ""){
								   		document.getElementById('Errorpass').innerHTML = 'Enetr your password';
								   	}else if (!regx.test(pass)){
								   		document.getElementById('Errorpass').innerHTML = 'Must be Enter 8 digit';
								   		
								   	}else{
								   		
								   		document.getElementById('Errorpass').innerHTML = '';
								   	}
								   	
								   	if(pass !== confirmpass){
								   			document.getElementById('Errorconfirmpass').innerHTML = 'Passwords do not match';

								   		}else {
								   			document.getElementById('Errorconfirmpass').innerHTML =  '';
								   			
								   		}
										
				let gender = document.querySelector('input[name="gender"]:checked');
										if(!gender){
											
										document.getElementById('genderError').innerText = "Gender is required.";
											document.getElementById('genderError').style.display = "block";
										} else {
									document.getElementById('genderError').style.display = "none";
										}									
				let hobiies = document.querySelector('input[name="hobbies"]:checked');	
				
				if(!hobiies){
					document.getElementById('hobbiesError').innerText = 'any one mendeteriy';
					 documnet.getElementById('hobbiesError').style.display = "block";
				}else{
					document.getElementById('hobbiesError').style.display = "none";
				} 
				
				
		 let fileInput = document.getElementById('file').value;
		 
		 if(!fileInput){
			document.getElementById('resumeError').innerHTML = 'Choose your file';
			
		 }else{
			document.getElementById('resumeError').innerHTML = '';
		 }
		 
		
});



