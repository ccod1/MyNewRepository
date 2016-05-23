<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>

<div class="container">
 
  <div class="row" >
    <div class="col-sm-3 col-md-3"> <img class="img-responsive" src="<c:url value='${proinf.img}'/>" /> </div>
    <div class="col-sm-3 col-sm-offset-2 col-md-6 col-md-offset-0" ><h3>Product Code : &nbsp;&nbsp;&nbsp;&nbsp; ${proinf.code }<h3>
    <br><br></h3><h3>Product Name : &nbsp;&nbsp;&nbsp;&nbsp; ${proinf.name }<h3><br><br></h3><h3>Product Price : &nbsp;&nbsp;&nbsp;&nbsp; ${proinf.price }<h3>
    <br><br></h3>
    	 <form name="loginFor" action="shop?shop=shop&abc=abc" method="post">             
               <input type="submit" value="Submit" class="btn btn-success">
               	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
  	</div>
</div>

<br><br><br>
<%@include file="footer.jsp" %>


</body>
</html>