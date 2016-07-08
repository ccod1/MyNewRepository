
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
<br><br><br><br>
<div class="container">

 <div class="row">
        <div class="col-md-20 col-md-offset-2">
            <div class="panel panel-default">
		<div class="panel-body">
		
		<h1>${blname}</h1>
                    <form:form class="form-horizontal" commandName="blog_content" method="post" action="insertPost" role="form">
                    
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Title</label>
                            <div class="col-sm-9">
                                <form:input  path="blog_title" class="form-control"  placeholder="Blog Title" required="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-3 control-label">Post What you feel</label>
                            <div class="col-sm-9">
                                <form:textarea path="content" rows="7" class="form-control" />
                                 <form:hidden path="cust_name" value="${name}" class="form-control" hidden="true" />
                                 <form:hidden path="blog_name" value="${blname}" class="form-control" hidden="true" />
                            </div>
                        </div>
                        <div class="form-group">
                           
                            <div class="col-sm-9">
                                <button type="submit"  class="btn btn-success btn-sm">Post</button>
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
