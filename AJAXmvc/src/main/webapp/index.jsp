<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<script type="text/javascript">
$(document).ready(function() {
    userlist();
});

function insertUser() {
    var name = $("#name").val();
    var email = $("#email").val();
    var password = $("#password").val();

    $.post("insert", {
        name : name,
        email : email,
        password : password
    }, function(res) {
        $("#name").val("");
        $("#email").val("");
        $("#password").val("");
        userlist();
    });
}

function userlist() {
    $
            .get(
                    "users",
                    {},
                    function(res) {
                        var row = "";
                        for (var i = 0; i < res.length; i++) {
                            row += "<tr><td>"
                                    + res[i].id
                                    + "</td><td>"
                                    + res[i].name
                                    + "</td><td>"
                                    + res[i].email
                                    + "</td><td><button class='btn btn-primary' onclick='editUser("
                                    + res[i].id
                                    + ")'>Edit</button></td><td><button class='btn btn-danger' onclick='deleteUser("
                                    + res[i].id
                                    + ")'>Delete</button></td></tr>";
                        }
                        $("#tdata").html(row);
                    });
}

function editUser(id) {
    $.post("edit", {
        id : id
    }, function(res) {
        $("#id").val(res.id);
        $("#name").val(res.name);
        $("#email").val(res.email);
        $("#password").val(res.password);
        $("#btnSubmit").hide();
        $("#btnUpdate").show();
    });
}

function deleteUser(id) {
    $.post("delete", {
        id : id
    }, function(res) {
        userlist();
    });
}

function updateUser() {
    var id = $("#id").val();
    var name = $("#name").val();
    var email = $("#email").val();
    var password = $("#password").val();

    $.post("update", {
        id : id,
        name : name,
        email : email,
        password : password
    }, function(res) {
        $("#id").val("");
        $("#name").val("");
        $("#email").val("");
        $("#password").val("");
        $("#btnUpdate").hide();
        $("#btnSubmit").show();
        userlist();
    });
}

function search(value) {
    $.post("search", { value: value }, function(res) {
        var row = "";
        for (var i = 0; i < res.length; i++) {
            row += "<tr><td>"
                + res[i].id
                + "</td><td>"
                + res[i].name
                + "</td><td>"
                + res[i].email
                + "</td><td><button class='btn btn-primary' onclick='editUser("
                + res[i].id
                + ")'>Edit</button></td><td><button class='btn btn-danger' onclick='deleteUser("
                + res[i].id
                + ")'>Delete</button></td></tr>";
        }
        $("#tdata").html(row);
    });
}
</script>
</head>
<body>
	<div class="container">
		<div class="row mt-3">
			<div class="col-5 card p-5 shadow-lg">
				<h3 class="card-title text-success" align="center">Registration</h3>
				<input type="hidden" id="id">
				<div class="form-group mt-4">
					<label>User Name</label> <input type="text" name="name" id="name"
						class="form-control" />
				</div>
				<div class="form-group">
					<label>Email Address</label> <input type="email" name="email"
						id="email" class="form-control" />
				</div>
				<div class="form-group">
					<label>Password</label> <input type="password" name="password"
						id="password" class="form-control" />
				</div>
				<button class="btn btn-success" onclick="insertUser()"
					id="btnSubmit">Submit</button>
				<button class="btn btn-info" onclick="updateUser();" id="btnUpdate"
					style="display: none;">Update</button>
			</div>
			<div class="col-7 card p-6 shadow-lg">
				<h3 class="card-title text-success mt-5" align="center">User
					Information</h3>
				 <form class="form-inline ml-auto">
                    <input class="form-control mr-sm-2" type="search"
                        placeholder="Search" aria-label="Search" >
                        <button class="btn btn-outline-secondary" type="submit" onclick="search(value)">Search</button>
                </form>



				<table class="table mt-5 shadow-lg">
					<thead class="table-dark mt-3">
						<tr>
							<td width="10%">ID</td>
							<td width="20%">NAME</td>
							<td width="30%">EMAIL</td>
							<td width="30%" align="center" colspan=2>ACTION</td>
						</tr>
					</thead>
					<tbody id="tdata"></tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
