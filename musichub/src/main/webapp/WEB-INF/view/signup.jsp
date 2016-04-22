<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>***SIGN UP***</title>

<style>
	.container
	{
		margin-top:10%;
		width:30%;
		height:40%;
		background-color: #d9bc5c;
		padding: 5%;
		border-radius: 15%;
		border-width: 2%;
	}
	
</style>
</head>
<body>
<br><br><br>	
<div class="container">
		
	<center>	<form:form commandName="user" class="form-horizontal" action="signsuccess" method="post">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label" > Name:</label>
					<div class="col-sm-5">
						<form:input path="name" placeholder="Name......" cssClass="form-control"/>
					</div>
				</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> Password:</label>
					<div class="col-sm-5">
						<form:password path="password" placeholder="Password....." cssClass="form-control"/>
					</div>
			</div>
			<div class="form-group">
				<label for="number" class="col-sm-2 control-label"> Number:</label>
					<div class="col-sm-5">
						<form:input path="number" placeholder="Number......" cssClass="form-control"/>
					</div>
			</div>  
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label"> Email:</label>
					<div class="col-sm-5">
						<form:input path="email" placeholder="Email...." cssClass="form-control"/>
					</div>
			</div>
		   <div class="form-group">
					<div class="col-sm-2">
						<input type="submit" name="add" value="SIGNUP" class="btn btn-success pull-right"/>
					</div>
					<div class="col-sm-2">
						<input type="submit" name="edit"  value="UPDATE" class="btn btn-primary pull-right"/>
					</div>
					<div class="col-sm-2">
						<input type="submit" name="delete"  value="DELETE" class="btn btn-danger pull-right"/>
					</div>
			</div> 
			
			
		</form:form> 
	</center>
	</div>
</body>
</html>