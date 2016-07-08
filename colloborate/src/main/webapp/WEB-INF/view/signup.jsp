<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css"/>" >
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="<c:url value="/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js" />"></script>
</head>
<body><br><br><br>
	<div class="container">
    <div class="row">
        <div class="col-md-7 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Register</strong>

                </div>
                <div class="panel-body">
                    <form:form commandName="cust" class="form-horizontal" role="form" action="signsuccess" method="post" >
                    <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">Name</label>
                            <div class="col-sm-9">
                                <form:input path="username"  class="form-control" required="true" placeholder="Name" />
                            </div>
                            </div>
                             <div class="form-group">
                            <label for="pass" class="col-sm-3 control-label">Password</label>
                            <div class="col-sm-9">
                                <form:password  class="form-control" path="password" required="true" placeholder="Password" />
                            </div>
                        </div>
                            
                            <div class="form-group">
                            <label for="number" class="col-sm-3 control-label">Mobile</label>
                            <div class="col-sm-9">
                                <form:input  class="form-control" path="number" required="true" placeholder="Number" />
                            </div>
                            </div>
                            <div class="form-group">
                            <label for="dob" class="col-sm-3 control-label">DOB</label>
                            <div class="col-sm-9">
                                <form:input  class="form-control" path="dob" required="true" placeholder="DOB" />
                            </div>
                            </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Email</label>
                            <div class="col-sm-9">
                                <form:input  class="form-control" path="email" required="true" placeholder="Email" />
                            </div>
                        </div>
                      
                        
                        <div class="form-group last">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-success btn-sm">Sign up</button>
                                <button type="reset" class="btn btn-default btn-sm">Reset</button>
                            </div>
                        </div>
                    </form:form>
                </div>
                
            </div>
        </div>
    </div>
  </div>
</body>
</html>