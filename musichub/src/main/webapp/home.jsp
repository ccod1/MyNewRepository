<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%  String im1=request.getParameter("im1");

	
%>
<% if(im1.equals("img1")){ %>
<center><div class=container>

	<div class="table table-responsive">
			<table class="table">
				<tr>
				<td>
				<img class="img-responsive" src="img1.jpg" style="width:200px;height:200px">
				</td>
				</tr>
			</table>
	</div>
	<br><br>
	<h2><a href="view.jsp">View Cart</a></h2><br>
	<h2><a href="order.jsp">Order Received</a></h2><br>
	<h2><a href="orderconfirm.jsp">Order Confirmation</a></h2><br>

</div></center>
<% }
else if(im1.equals("img2"))
{
%>
<center><div class=container>

	<div class="table table-responsive">
			<table class="table">
				<tr>
				<td>
				<img class="img-responsive" src="img2.jpg" style="width:200px;height:200px">
				</td>
				</tr>
			</table>
	</div>
	
	<br><br>
	<h2><a href="view.jsp">View Cart</a></h2><br>
	<h2><a href="order.jsp">Order Received</a></h2><br>
	<h2><a href="orderconfirm.jsp">Order Confirmation</a></h2><br>
	

</div></center>
<% }
else
{

%>
<center><div class=container>

	<div class="table table-responsive">
			<table class="table">
				<tr>
				<td>
				<img class="img-responsive" src="img3.jpg" style="width:200px;height:200px">
				</td>
				</tr>
			</table>
	</div>
	<br><br>
	<h2><a href="view.jsp">View Cart</a></h2><br>
	<h2><a href="order.jsp">Order Received</a></h2><br>
	<h2><a href="orderconfirm.jsp">Order Confirmation</a></h2><br>

</div></center>
<% } %>
</body>
</html>