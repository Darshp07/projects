<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products list</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<%
	ArrayList<Product> productlist = (ArrayList<Product>) request.getAttribute("data");

	
	%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-success">
		<a class="navbar-brand ms-3 " href="#">Tops shoope</a>
		<div class="collapse navbar-collapse" id="navbarNav"></div>

		<form class="d-flex">
			<input class="form-control me-2" type="search" placeholder="Search"
				aria-label="Search">
			<button class="btn btn-dark me-3" type="submit">Search</button>
		</form>
	</nav>
	<div class="col card card p-5 shadow-lg m-auto mt-4">

		<h2 class="text-center text-success mb-4">PRODUCT LIST</h2>

		<table class="table table-striped table-info border border-dark table-hover">
			<thead class="table-dark">
				<tr>
					<th style="width: 10%">ID</th>
					<th style="width: 15%">P-NAME</th>
					<th style="width: 15%">p_category</th>
					<th style="width: 10%">p_model</th>
					<th style="width: 10%">p_price</th>
					<th style="width: 40%">p_description</th>
					<th style="width: 10%">UPDATE</th>
					<th style="width: 10%">DELETE</th>
				</tr>
			</thead>
			<%
			for (Product pr : productlist) {
			%>


			<tbody>
				<tr>
					<td><%=pr.getId()%></td>
					<td><%=pr.getProductName()%></td>
					<td><%=pr.getCategory()%></td>
					<td><%=pr.getModel()%></td>
					<td>$ <%=pr.getPrice()%></td>
					<td><%=pr.getDescription()%></td>
					<td><a href="Edit?p_id=<%=pr.getId()%>"
						class="btn btn-primary">Update</a></td>
					<td><a href="delete?p_id=<%=pr.getId()%>" class="btn btn-danger">DELETE</a></td>

				</tr>

			</tbody>
			<%
			}
			%>
		</table>

	</div>

</body>
</html>