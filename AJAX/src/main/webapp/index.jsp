<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
function test(value){

	$.get("server1", {value}, function(res){
	
		$("#data").html(res);
	});
}
</script>
</head>
<body>
	<input type="text" name="uname" id="uname" onkeyup="test(value);">
	<span id="data"></span>
</body>
</html>
