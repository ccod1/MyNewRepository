<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<div class="container">
			<h1>${addmess}</h1>
		<form:form commandName="nblg" action="create">			 
 			 <div class="form-group">
   				<label for="pwd">Blog Name</label>
    			<form:input path="blog_name" class="form-control" id="blgn"/>
  			</div>
  			 <div class="form-group">
   				
    			<form:hidden path="cust_name" value="${name}" class="form-control" hidden="true" id="blgn"/>
  			</div>
  			 <div class="form-group">
  			<button type="submit" class="btn btn-default">Create Blog</button>
  			</div>
		</form:form>
		
		
		
	</div>	
</body>
</html>