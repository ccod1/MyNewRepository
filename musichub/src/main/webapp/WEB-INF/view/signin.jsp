<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>***Login***</title>

</head>
<body>
<%@include file="header.jsp" %>




<div class="container-fluid">
		<center> <form name="loginForm" class="form-horizontal" action="<c:url value='process_login' />" method="post">
               <c:if test="${not empty error}">
                   <div class="error" style="color: #ff0000 ;">${error}</div>
               </c:if>
               <div class="form-group">
				<label for="username" class="col-sm-2 control-label" > Name:</label>
					<div class="col-sm-5">
						<input type="text" id="username" name="username" placeholder="Name......" cssClass="form-control"/>
					</div>
               </div>
               <div class="form-group">
				
					<div class="col-sm-5">
						 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
					</div>
               </div>
                <div class="form-group">
					<label for="password" class="col-sm-2 control-label" > Name:</label>
					<div class="col-sm-5">
						<input type="password" id="password" name="password" placeholder="Password......" cssClass="form-control"/>
					</div>
               </div>

            &nbsp;&nbsp;&nbsp;   <input type="submit" value="Submit" class="btn btn-success pull-center">

           
           </form>
		
		</center>
		
	</div><br><br><br><br>
	
	
	<%@include file="footer.jsp" %>
</body>
</html>