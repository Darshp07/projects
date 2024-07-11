<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="img/favicon.ico" rel="icon">


<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">


<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">


<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">


<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script>
	src = "https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity = "sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin = "anonymous" >
</script>

</head>
<!-----  Heder start-------->
<body
	style="background-image: url('https://scontent.famd1-1.fna.fbcdn.net/v/t39.30808-6/359810648_677965541010744_1523034720616807478_n.png?_nc_cat=110&ccb=1-7&_nc_sid=6ee11a&_nc_ohc=Jl_5BmpR-tUQ7kNvgGogZg3&_nc_ht=scontent.famd1-1.fna&oh=00_AYDT6wzb04omDEBZ6sWWfye8ZDZc888BceDSm5V6NVPCKA&oe=668C661E'); background-size: cover; background-position: center;">
	<nav class="navbar navbar-expand-lg navbar-dark bg-success">
		<a class="navbar-brand " href="#">Tops shoope</a>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
		<!-- <li class="nav-item active"><a class="nav-link"
					href="addProduct.jsp">Add Product</a></li> -->		
				<li class="nav-item"><a class="nav-link"
					href="viewproduct">View Products</a></li>
			</ul>

		</div>
		<h4 class="me-2">cart</h4>
		<i class="fa fa-shopping-cart me-3"
			style="font-size: 36px; color: gold"></i>

		<form class="d-flex">
			<input class="form-control me-2" type="search" placeholder="Search"
				aria-label="Search">
			<button class="btn btn-dark" type="submit">Search</button>
		</form>
	</nav>
	<!-----  Heder end-------->

	<div class="col-5 card p-5 shadow-lg m-auto mt-3 " >
		<h2 class="text-center text-success font-weight-bold ">Add Product</h2>
		
		
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
		
		<form action="AddProductServlet" method="post">
			<div class="form-group mb-4">
				<label for="productName">Product Name:</label> <input type="text"
					class="form-control" id="productName" name="productName"
					onblur="validation();" required> <span id="nameerror"
					class="text-danger"></span>
			</div>
			<div class="form-group">
				<label for="category">Product Category:</label> <input type="text"
					class="form-control" id="category" name="category"
					onblur="validation();" required> <span id="categoryerror"
					class="text-danger"></span>
			</div>
			<div class="form-group">
				<label for="model">Product Model:</label> <input type="text"
					class="form-control" id="model" name="model" onblur="validation();"
					required> <span id="modelerror" class="text-danger"></span>
			</div>
			<div class="form-group">
				<label for="price">Price:</label> <input type="number"
					class="form-control" id="price" name="price" onblur="validation();"
					required> <span id="priceerror" class="text-danger"></span>
			</div>
			<div class="form-group">
				<label for="description">Product Description:</label>
				<textarea class="form-control" id="description" name="description"
					onblur="validation();" rows="4" required></textarea>
				<span id="deserror" class="text-danger"></span>
			</div>

			<button type="submit" class="btn btn-success " value="Add Product">Add Product</button>
			<button type="reset" class="btn btn-warning " value="reset">Reset</button>
			
		</form>
	</div>

</body>
</body>
</html>