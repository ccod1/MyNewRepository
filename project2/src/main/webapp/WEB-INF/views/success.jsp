<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<h2>
			Welcome : ${pageContext.request.userPrincipal.name}
		</h2>
		 <ul class="nav pull-right">
							   <li class="divider-vertical"></li>
							   <c:if test="${pageContext.request.userPrincipal.name != null}">
								<%-- <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
									<li><a href="<c:url value="/user/cart" />">Cart</a></li>
								</c:if> --%>
								<%-- <c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
									 <li><a href="<c:url value="/admin/furnitureinventory" />">View Inventory</a></li>
									 <li><a href="<c:url value="/admin/user" />">View Customer</a></li>
								</c:if> --%>
								
								<li>Welcome, ${pageContext.request.userPrincipal.name}</li>
									<li><a href="<c:url value="/j_spring_security_logout" />">Sign Out</a></li>
								</c:if>
								 <c:if test="${pageContext.request.userPrincipal.name  == null}">
									<li><a href="<c:url value="/login/" />">Login</a></li>
									<li><a href="<c:url value="/Register" />">Sign Up</a></li>
								</c:if>
								
							 </ul>
				
<nav class="navbar navbar-default">
  <div class="container-fluid">
   <!--  <div class="navbar-header">
      <a class="navbar-brand" href="#">NIIT</a>
    </div> -->
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      <li><a href="Blog">BLOG</a></li>
      <li><a href="Group">GROUP</a></li>
      <li><a href="Chat">CHAT</a></li>
    </ul>
    <ul class="nav pull-right">
     <li class="divider-vertical"></li>
							   <c:if test="${pageContext.request.userPrincipal.name != null}">
								<%-- <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
									<li><a href="<c:url value="/user/cart" />">Cart</a></li>
								</c:if> --%>
								<%-- <c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
									 <li><a href="<c:url value="/admin/furnitureinventory" />">View Inventory</a></li>
									 <li><a href="<c:url value="/admin/user" />">View Customer</a></li>
								</c:if> --%>
								
								<li>Welcome, ${pageContext.request.userPrincipal.name}</li>
									<li><a href="<c:url value="/j_spring_security_logout" />">Sign Out</a></li>
								</c:if>
								 <c:if test="${pageContext.request.userPrincipal.name  == null}">
									<li><a href="<c:url value="/login/" />">Login</a></li>
									<li><a href="<c:url value="/Register" />">Sign Up</a></li>
								</c:if>
								
    </ul>
  </div>
</nav>			 
							 
</body>
</html>