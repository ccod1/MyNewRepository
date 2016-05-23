<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>

	
	<div class="container">
		
	<center>	<form:form commandName="product" class="form-horizontal" action="update"  method="post">
			<div class="form-group">
				
					<div class="col-sm-5">
						<form:errors path="*"  cssStyle="color:red;"/>
					</div>
				</div>
				<div class="form-group">
				<label for="code" class="col-sm-2 control-label" > Product Code:</label>
					<div class="col-sm-5">
						<form:input path="code"  value="${pi.getCode()}" readonly="true" cssClass="form-control"/>
					</div>
				</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label" > Product Name:</label>
					<div class="col-sm-5">
						<form:input path="name"  value="${pi.getName()}" cssClass="form-control"/>
					</div>
				</div>
			<div class="form-group">
				<label for="desc" class="col-sm-2 control-label">Description :</label>
					<div class="col-sm-5">
						<form:input path="desc" value="${pi.getDesc()}" cssClass="form-control"/>
					</div>
			</div>
			<div class="form-group">
				<label for="manufact" class="col-sm-2 control-label">Manufacture:</label>
					<div class="col-sm-5">
						<form:input path="manufact" value="${pi.getManufact()}" cssClass="form-control"/>
					</div>
			</div>  
			<div class="form-group">
				<label for="price" class="col-sm-2 control-label"> Price :</label>
					<div class="col-sm-5">
						<form:input path="price" value="${pi.getPrice()}" cssClass="form-control"/>
					</div>
			</div>
			
			<div class="form-group">
				<label for="type" class="col-sm-2 control-label"> Price :</label>
					<div class="col-sm-5">
						<form:input path="type" value="${pi.getType() }" cssClass="form-control"/>
					</div>
			</div>
			
			
		   <div class="form-group">
					
				<div class="col-sm-2">
						<input type="submit" name="edit"  value="UPDATE" class="btn btn-primary pull-right"/>
				</div>
				
		</div>
			
		</form:form> 
	</center>
	</div>

<%@ include file="footer.jsp" %>

	
</body>
</html>