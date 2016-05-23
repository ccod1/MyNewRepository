<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>***SIGN UP***</title>

</head>
<body>
<%@ include file="header.jsp" %>	
<div class="container">
		
	<center>	<form:form commandName="user" class="form-horizontal" action="signsuccess" method="post">
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label" > Name:</label>
					<div class="col-sm-5">
						<form:input path="username" placeholder="Name......" cssClass="form-control"/>
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
				
					<div class="col-sm-5">
						<form:hidden path="secretValue" />
					</div>
			</div>
			<div class="form-group">
				
					<div class="col-sm-5">
						<form:hidden path="roleid" />
					</div>
			</div>
			
		   <div class="form-group">
					<div class="col-sm-2">
						<input type="submit" name="add" value="SIGNUP" class="btn btn-success pull-right"/>
					</div>
					
			</div> 
			
			
		</form:form> 
	</center>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>